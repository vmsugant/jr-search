package jrsearch;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Greeter {
  private static final String defaultFilePath = "src/resources/enwik8";
  private static final String defaultSearchKey = "Harsh";

  public String sayHello() {
    return "Hello world!";
  }

  public static String getPathToTargetFile(String[] args) {
    if (args.length >= 1) {
      return args[0];
    }
    // Return placeholder file path if none exists.
    return defaultFilePath;
  }

  public static void doBasicFilePathValidationChecks(File logFile) throws Exception {
    if (logFile.isDirectory()) {
      throw new Exception("Specified Path Leads to a directory.");
    }
    if (!logFile.exists()) {
      throw new Exception("File does not Exist.");
    }
    if (!logFile.canRead()) {
      throw new Exception("Read Access Not Available.");
    }
  }

  public static String getDefaultFilePath() {
    return defaultFilePath;
  }

  public static String getSearchKey(String[] args) {
    if (args.length > 1) {
      return args[1];
    }
    return defaultSearchKey;
  }

  public static void doSearchKeyValidation(String searchKey) throws Exception {
    Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(searchKey);
    boolean b = m.find();
    if(b){
      throw new Exception("Invalid Search Key. Contains special characters.");
    }
  }
}