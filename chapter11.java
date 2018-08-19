// Read an array of bytes from the keyboard.

import java.io.*;

class ReadBytes {
  public static void main(String[] args)
    throws IOException {
      byte[] data = new byte[10];

      System.out.println("Enter some characters.");
      int numRead = System.in.read(data);
      System.out.print("You entered: ");
      for(int i=0; i < numRead; i++)
        System.out.print((char) data[i]);
  }
}

// -----------------------------------------

// Demonstrate System.out.write().
class WriteDemo {
  public static void main(String[] args) {
    int b;

    b = 'X';
    System.out.write(b);
    System.out.write('\n');
  }
}

// -----------------------------------------

/* Display a text file.

   To use this program, specify the name
   of the file that you want to see.
   For example, to see a file called TEST.TXT,
   use the following command line.

   java ShowFile TEST.TXT
*/

import java.io.*;

class ShowFile {
  public static void main(String[] args)
  {
    int i;
    FileInputStream fin;

    // First make sure that a file has been specified.
    if(args.length != 1) {
      System.out.println("Usage: ShowFile File");
      return;
    }

    try {
      fin = new FileInputStream(args[0]);
    } catch(FileNotFoundException exc) {
      System.out.println("File Not Found");
      return;
    }

    try {
      // read bytes until EOF is encountered
      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);
    } catch(IOException exc) {
      System.out.println("Error reading file.");
    }

    try {
      fin.close();
    } catch(IOException exc) {
      System.out.println("Error closing file.");
    }
  }
}

// -----------------------------------------

/* This variation wraps the code that opens and
   accesses the file within a single try block.
   The file is closed by the finally block.
*/

import java.io.*;

class ShowFile {
  public static void main(String[] args)
  {
    int i;
    FileInputStream fin = null;

    // First, confirm that a file name has been specified.
    if(args.length != 1) {
      System.out.println("Usage: ShowFile filename");
      return;
    }

    // The following code opens a file, reads characters until EOF
    // is encountered, and then closes the file via a finally block.
    try {
      fin = new FileInputStream(args[0]);

      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);

    } catch(FileNotFoundException exc) {
      System.out.println("File Not Found.");
    } catch(IOException exc) {
      System.out.println("An I/O Error Occurred");
    } finally {
      // Close file in all cases.
      try {
        if(fin != null) fin.close();
      } catch(IOException exc) {
        System.out.println("Error Closing File");
      }
    }
  }
}

// -----------------------------------------

/* Copy a text file.
   To use this program, specify the name
   of the source file and the destination file.
   For example, to copy a file called FIRST.TXT
   to a file called SECOND.TXT, use the following
   command line.

   java CopyFile FIRST.TXT SECOND.TXT
*/

import java.io.*;

class CopyFile {
  public static void main(String[] args)
  {
    int i;
    FileInputStream fin = null;
    FileOutputStream fout = null;

    // First, make sure that both files has been specified.
    if(args.length != 2) {
      System.out.println("Usage: CopyFile from to");
      return;
    }

    // Copy a File.
    try {
      // Attempt to open the files.
      fin = new FileInputStream(args[0]);
      fout = new FileOutputStream(args[1]);

      do {
        i = fin.read();
        if(i != -1) fout.write(i);
      } while(i != -1);

    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    } finally {
      try {
        if(fin != null) fin.close();
      } catch(IOException exc) {
        System.out.println("Error Closing Input File");
      }
      try {
        if(fout != null) fout.close();
      } catch(IOException exc) {
        System.out.println("Error Closing Output File");
      }
    }
  }
}

// -----------------------------------------

/* This version of the ShowFile program uses a try-with-resources
   statement to automatically close a file when it is no longer needed.

   Note: This code requires JDK 7 or later.
*/

import java.io.*;

class ShowFile {
  public static void main(String[] args)
  {
    int i;

    // First, make sure that a file name has been specified.
    if(args.length != 1) {
      System.out.println("Usage: ShowFile filename");
      return;
    }

    // The following code uses try-with-resources to open a file
    // and then automatically close it when the try block is left.
    try(FileInputStream fin = new FileInputStream(args[0])) {

      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);

    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    }
  }
}

// -----------------------------------------

/* A version of CopyFile that uses try-with-resources.
   It demonstrates two resources (in this case files) being
   managed by a single try statement.

   Note: This code requires JDK 7 or later.
*/

import java.io.*;

class CopyFile {
  public static void main(String[] args)
  {
    int i;

    // First, confirm that both files have been specified.
    if(args.length != 2) {
      System.out.println("Usage: CopyFile from to");
      return;
    }

    // Open and manage two files via the try statement.
    try (FileInputStream fin = new FileInputStream(args[0]);
         FileOutputStream fout = new FileOutputStream(args[1]))
    {

      do {
        i = fin.read();
        if(i != -1) fout.write(i);
      } while(i != -1);

    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    }
  }
}

// -----------------------------------------

// Write and then read back binary data.

// This code requires JDK 7 or later.

import java.io.*;

class RWData {
  public static void main(String[] args)
  {
    int i = 10;
    double d = 1023.56;
    boolean b = true;

    // Write some values.
    try (DataOutputStream dataOut =
             new DataOutputStream(new FileOutputStream("testdata")))
    {
      System.out.println("Writing " + i);
      dataOut.writeInt(i);

      System.out.println("Writing " + d);
      dataOut.writeDouble(d);

      System.out.println("Writing " + b);
      dataOut.writeBoolean(b);

      System.out.println("Writing " + 12.2 * 7.4);
      dataOut.writeDouble(12.2 * 7.4);
    }
    catch(IOException exc) {
      System.out.println("Write error.");
      return;
    }

    System.out.println();

    // Now, read them back.
    try (DataInputStream dataIn =
             new DataInputStream(new FileInputStream("testdata")))
    {
      i = dataIn.readInt();
      System.out.println("Reading " + i);

      d = dataIn.readDouble();
      System.out.println("Reading " + d);

      b = dataIn.readBoolean();
      System.out.println("Reading " + b);

      d = dataIn.readDouble();
      System.out.println("Reading " + d);
    }
    catch(IOException exc) {
      System.out.println("Read error.");
    }
  }
}

// -----------------------------------------

/*
   Try This 11-1

   Compare two files.

   To use this program, specify the names
   of the files to be compared on the command line.

   java CompFiles FIRST.TXT SECOND.TXT

   This code requires JDK 7 or later.
*/

import java.io.*;

class CompFiles {
  public static void main(String[] args)
  {
    int i=0, j=0;

    // First make sure that both files have been specified.
    if(args.length !=2 ) {
      System.out.println("Usage: CompFiles f1 f2");
      return;
    }

    // Compare the files.
    try (FileInputStream f1 = new FileInputStream(args[0]);
         FileInputStream f2 = new FileInputStream(args[1]))
    {
      // Check the contents of each file.
      do {
        i = f1.read();
        j = f2.read();
        if(i != j) break;
      } while(i != -1 && j != -1);

      if(i != j)
        System.out.println("Files differ.");
      else
        System.out.println("Files are the same.");
    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    }
  }
}

// -----------------------------------------

// Demonstrate random access files.
// This code requires JDK 7 or later.

import java.io.*;

class RandomAccessDemo {
  public static void main(String[] args)
  {
    double[] data = { 19.4, 10.1, 123.54, 33.0, 87.9, 74.25 };
    double d;

    // Open and use a random access file.
    try (RandomAccessFile raf = new RandomAccessFile("random.dat", "rw"))
    {
      // Write values to the file.
      for(int i=0; i < data.length; i++) {
        raf.writeDouble(data[i]);
      }

      // Now, read back specific values
      raf.seek(0); // seek to first double
      d = raf.readDouble();
      System.out.println("First value is " + d);

      raf.seek(8); // seek to second double
      d = raf.readDouble();
      System.out.println("Second value is " + d);

      raf.seek(8 * 3); // seek to fourth double
      d = raf.readDouble();
      System.out.println("Fourth value is " + d);

      System.out.println();

      // Now, read every other value.
      System.out.println("Here is every other value: ");
      for(int i=0; i < data.length; i+=2) {
        raf.seek(8 * i); // seek to ith double
        d = raf.readDouble();
        System.out.print(d + " ");
      }
    }
    catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    }
  }
}

// -----------------------------------------

// Use a BufferedReader to read characters from the console.
import java.io.*;

class ReadChars {
  public static void main(String[] args)
    throws IOException
  {
    char c;
    BufferedReader br = new
            BufferedReader(new
                    InputStreamReader(System.in));

    System.out.println("Enter characters, period to quit.");

    // read characters
    do {
      c = (char) br.read();
      System.out.println(c);
    } while(c != '.');
  }
}

// -----------------------------------------

// Read a string from console using a BufferedReader.
import java.io.*;

class ReadLines {
  public static void main(String[] args)
    throws IOException
  {
    // create a BufferedReader using System.in
    BufferedReader br = new BufferedReader(new
                            InputStreamReader(System.in));
    String str;

    System.out.println("Enter lines of text.");
    System.out.println("Enter 'stop' to quit.");
    do {
      str = br.readLine();
      System.out.println(str);
    } while(!str.equals("stop"));
  }
}

// -----------------------------------------

// Demonstrate PrintWriter.
import java.io.*;

public class PrintWriterDemo {
  public static void main(String[] args) {
    PrintWriter pw = new PrintWriter(System.out, true);
    int i = 10;
    double d = 123.65;

    pw.println("Using a PrintWriter.");
    pw.println(i);
    pw.println(d);

    pw.println(i + " + " + d + " is " + (i+d));
  }
}

// -----------------------------------------

// A simple key-to-disk utility that demonstrates a FileWriter.
// This code requires JDK 7 or later.

import java.io.*;

class KtoD {
  public static void main(String[] args)
  {

    String str;
    BufferedReader br =
            new BufferedReader(
                  new InputStreamReader(System.in));

    System.out.println("Enter text ('stop' to quit).");

    try (FileWriter fw = new FileWriter("test.txt"))
    {
      do {
        System.out.print(": ");
        str = br.readLine();

        if(str.compareTo("stop") == 0) break;

        str = str + "\r\n"; // add newline
        fw.write(str);
      } while(str.compareTo("stop") != 0);
    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    }
  }
}

// -----------------------------------------

// A simple disk-to-screen utility that demonstrates a FileReader.
// This code requires JDK 7 or later.

import java.io.*;

class DtoS {
  public static void main(String[] args) {
    String s;

    // Create and use a FileReader wrapped in a BufferedReader.
    try (BufferedReader br = new BufferedReader(new FileReader("test.txt")))
    {
      while((s = br.readLine()) != null) {
        System.out.println(s);
      }
    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    }
  }
}

// -----------------------------------------

// Obtain information about a file.
import java.io.*;

class FileDemo {
  public static void main(String[] args) {
    File myFile = new File("/javafiles/MyClass.java");

    System.out.println("File Name: " + myFile.getName());
    System.out.println("Path: " + myFile.getPath());
    System.out.println("Abs Path: " + myFile.getAbsolutePath());
    System.out.println("Parent: " + myFile.getParent());
    System.out.println(myFile.exists() ? "exists" : "does not exist");
    System.out.println(myFile.isHidden() ? "is hidden" :
                       "is not hidden");
    System.out.println(myFile.canWrite() ? "is writeable" :
                       "is not writeable");
    System.out.println(myFile.canRead() ? "is readable" :
                       "is not readable");
    System.out.println("is " + (myFile.isDirectory() ? "" :
                       "not" + " a directory"));
    System.out.println(myFile.isFile() ? "is normal file" :
                       "might be a named pipe");
    System.out.println(myFile.isAbsolute() ? "is absolute" :
                       "is not absolute");
    System.out.println("File size: " + myFile.length() + " Bytes");
  }
}

// -----------------------------------------

// Using directories.
import java.io.*;

class DirList {
  public static void main(String[] args) {
    String dirname = "/javafiles";
    File myDir = new File(dirname);

    if (myDir.isDirectory()) {
      System.out.println("Directory of " + dirname);
      String[] s = myDir.list();

      for (int i=0; i < s.length; i++) {
        File f = new File(dirname + "/" + s[i]);
        if (f.isDirectory()) {
          System.out.println(s[i] + " is a directory");
        } else {
          System.out.println(s[i] + " is a file");
        }
      }
    } else {
      System.out.println(dirname + " is not a directory");
    }
  }
}

// -----------------------------------------

import java.io.*;

public class FilterExt implements FilenameFilter {
  String ext;

  public FilterExt(String ext) {
    this.ext = "." + ext;
  }

  public boolean accept(File dir, String name) {
    return name.endsWith(ext);
  }
}

// -----------------------------------------

// Directory of .java files.
import java.io.*;

class DirListFiltered {
  public static void main(String[] args) {
    FilenameFilter only = new FilterExt("java");
    String dirname = "/javafiles";
    File myDir = new File(dirname);


    if (myDir.isDirectory()) {
      System.out.println("Java source files in " + dirname);

      String[] s = myDir.list(only);

      for (int i=0; i < s.length; i++) {
        System.out.println(s[i]);
      }
    }
  }
}

// -----------------------------------------

// Show the free space on the current drive partition.
import java.io.*;

class FreeSpace {
  public static void main(String[] args) {
    File myFile = new File("\\");

    System.out.println("Free Space: " + myFile.getFreeSpace());
  }
}

// -----------------------------------------

// This program averages a list of numbers entered by the user.

import java.io.*;

class AvgNums {
  public static void main(String[] args)
    throws IOException
  {
    // create a BufferedReader using System.in
    BufferedReader br = new
      BufferedReader(new InputStreamReader(System.in));
    String str;
    int n;
    double sum = 0.0;
    double avg, t;

    System.out.print("How many numbers will you enter: ");
    str = br.readLine();
    try {
      n = Integer.parseInt(str);
    }
    catch(NumberFormatException exc) {
      System.out.println("Invalid format");
      n = 0;
    }

    System.out.println("Enter " + n + " values.");
    for(int i=0; i < n ; i++) {
      System.out.print(": ");
      str = br.readLine();
      try {
        t = Double.parseDouble(str);
      } catch(NumberFormatException exc) {
        System.out.println("Invalid format");
        t = 0.0;
      }
      sum += t;
    }
    avg = sum / n;
    System.out.println("Average is " + avg);
  }
}

// -----------------------------------------
Contents of helpfile.txt:

#if
if(condition) statement;
else statement;

#switch
switch(expression) {
  case constant:
    statement sequence
    break;
    // ...
  }

#for
for(init; condition; iteration) statement;

#while
while(condition) statement;

#do
do {
  statement;
} while (condition);

#break
break; or break label;

#continue
continue; or continue label;

// -----------------------------------------

/*
   Try This 11-2

   A help program that uses a disk file
   to store help information.

   This code requires JDK 7 or later.
*/

import java.io.*;

/* The Help class opens a help file,
   searches for a topic, and then displays
   the information associated with that topic.
   Notice that it handles all I/O exceptions
   itself, avoiding the need for calling
   code to do so. */
class Help {
  String helpfile; // name of help file

  Help(String fname) {
    helpfile = fname;
  }

  // Display help on a topic.
  boolean helpOn(String what) {
    int ch;
    String topic, info;

    // Open the help file.
    try (BufferedReader helpRdr =
            new BufferedReader(new FileReader(helpfile)))
    {
      do {
        // read characters until a # is found
        ch = helpRdr.read();

        // now, see if topics match
        if(ch == '#') {
          topic = helpRdr.readLine();
          topic = topic.trim(); // remove leading and trailing
                                // whitespace

          if(what.compareTo(topic) == 0) { // found topic
            do {
              info = helpRdr.readLine();
              if(info != null) System.out.println(info);
            } while((info != null) &&
                    (info.trim().compareTo("") != 0));
            return true;
          }
        }
      } while(ch != -1);
    }
    catch(IOException exc) {
      System.out.println("Error accessing help file.");
      return false;
    }
    return false; // topic not found
  }

  // Get a Help topic.
  String getSelection() {
    String topic = "";

    BufferedReader br = new BufferedReader(
              new InputStreamReader(System.in));

    System.out.print("Enter topic: ");
    try {
      topic = br.readLine();
    }
    catch(IOException exc) {
      System.out.println("Error reading console.");
    }
    return topic;
  }
}

// Demonstrate the file-based Help system.
class FileHelp {
  public static void main(String[] args) {
    Help hlpobj = new Help("helpfile.txt");
    String topic;

    System.out.println("Try the help system. " +
                       "Enter 'stop' to end.");
    do {
      topic = hlpobj.getSelection();

      if(!hlpobj.helpOn(topic))
        System.out.println("Topic not found.\n");

    } while(topic.compareTo("stop") != 0);
  }
}
