# jr-search
This is the repository for the jr-search question.

After you have cloned the repository, you should be able to navigate to the directory containing the build.gradle file. There, you can build the project by running the command:

gradle build

Next to run the project, use the below command : 

LINUX
gradle run --args='[path-to-file] [searchkey]'

WINDOWS
gradle run --args="[path-to-file] [searchkey]"


The problem statement can be found in this link - https://osl.sh/jr-search


APPROACHES CONSIDERED

1 - Scanner class and FileInputStream - > This is the simplest approach, which also allows for customizable delimiters. However, it is a very slow approach when dealing with large files(for the given 100 mb unstructured text file, it took more than a second). Hence, this approach is discarded.

2 - BufferedReader and FileReader - > The currently used implementation. This approach is faster due to BufferedReader class. BufferedReader reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines, and it is wrapped around the FileReader method, which is the actual method reading the specified text file. This method provides search across a 100mb unstructured text file in ~500ms. One drawback is the default delimiter used, which is carriage return. Hence the return of a sentence, from one full stop to other is not possible.

3 - Unix4j - > This is a library which replicates unix functions for Java. One function that is synonymous with file search is grep. This requires adding an additional dependency to the build.gradle file. This is yet to be implemented due to Time constraints.

4 - Multithreaded Approach with BufferedReader - > Yet to implement this approach as well. However, as per some reading, Reading time from Disk does not provide much performance improvement in multithreaded over single thread mode. Processing tasks on the read line will improve the time if done in multiple threads. However, as there isn't much processing involved, not going with that.

5 - Elastisearch API - > This approach seems to be the best, as it uses indexing of full files and search times that are better. However, will have to research more in order to implement this.

FUTURE IMPROVEMENTS

 - > We can allow reading of files from various data sources.
 - > We can write Unit tests with small sample files and arguments.
