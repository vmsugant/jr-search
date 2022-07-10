package jrsearch;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class HelloWorld {
  public static void main(String[] args) {
    // Need to validate the arguments.
    // First we will validate the filepath argument

    File logFile = new File(Greeter.getPathToTargetFile(args));
    try {
      Greeter.doBasicFilePathValidationChecks(logFile);
    } catch (Exception e) {
      System.out.println("Exception While Reading file. Going ahead with default file");
      logFile = new File(Greeter.getDefaultFilePath());
    }
    String searchKey = Greeter.getSearchKey(args);
    // Next we need to validate the Keyword Argument
    try {
      Greeter.doSearchKeyValidation(searchKey);
    } catch (Exception e) {
      System.out.println("Exception While Reading search Keyword. Going ahead with default keyword");
    }

    System.out.println(searchKey);
    List<String> matchedLines = new ArrayList<String>();
    try (BufferedReader b = new BufferedReader(new FileReader(logFile))) {
      String readLine = "";
      int lineCount = 0;
      Instant searchStart = Instant.now();
      while ((readLine = b.readLine()) != null) {
        lineCount++;
        if (readLine.contains(searchKey)) {
          matchedLines.add(readLine);
          System.out.println("Key found at line - " + readLine + " In line number " + lineCount);
        }
      }
      Instant searchEnd = Instant.now();
      long timeElapsedNames = Duration.between(searchStart, searchEnd).toMillis();
      System.out.println("Search time: " + timeElapsedNames + "ms");
      System.out.println("Line Count: " + lineCount);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}