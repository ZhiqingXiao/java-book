class DoubleDemo {
  public static void main(String[] args) {
    Double d1 = new Double(3.14159);
    Double d2 = new Double("314159E-5");

    System.out.println(d1 + " " + d2);
  }
}

// -----------------------------------------

// Demonstrate isInfinite() and isNaN()
class InfNaN {
  public static void main(String[] args) {
     Double d1 = new Double(1/0.0);
     Double d2 = new Double(0/0.0);

     System.out.println(d1 + ": " + d1.isInfinite() + ", " + d1.isNaN());
     System.out.println(d2 + ": " + d2.isInfinite() + ", " + d2.isNaN());
  }
}

// -----------------------------------------

// Demonstrate parseInt().

class ParseBinary {
  public static void main(String[] args) {
    int num;
    String str = "10011101";

    num = Integer.parseInt(str, 2);

    System.out.println("Here is " + str + " in decimal: " + num);
  }
}

// -----------------------------------------

// Convert an integer into binary, hexadecimal,
// and octal.

class StringConversions {
  public static void main(String[] args) {
    int num = 19648;

    System.out.println(num + " in binary: " +
                       Integer.toBinaryString(num));

    System.out.println(num + " in octal: " +
                       Integer.toOctalString(num));

    System.out.println(num + " in hexadecimal: " +
                       Integer.toHexString(num));
  }
}

// -----------------------------------------

// Demonstrate rotateLeft() and rotateRight()

class Rotations {
  public static void main(String[] args) {
    int num = -3356756;

    System.out.println(Integer.toBinaryString(num));

    num = Integer.rotateLeft(num, 2);
    System.out.println(Integer.toBinaryString(num));


    num = Integer.rotateRight(num, 2);
    System.out.println(Integer.toBinaryString(num));
  }
}

// -----------------------------------------

// Demonstrate several is... methods.

class IsDemo {
  public static void main(String[] args) {
    char[] a = {'a', 'b', '5', '?', 'A', ' ', '\t', '\n'};

    for(int i=0; i<a.length; i++) {
      if(Character.isDigit(a[i]))
        System.out.println(a[i] + " is a digit.");

      if(Character.isLetter(a[i]))
        System.out.println(a[i] + " is a letter.");

      if(Character.isLetterOrDigit(a[i]))
        System.out.println(a[i] + " is a letter or digit.");

      if(Character.isWhitespace(a[i])) {
        String chStr = "";
        if(a[i] == ' ') chStr = "<space>";
        else if(a[i] == '\t') chStr = "<tab>";
        else if(a[i] == '\n') chStr = "<newline>";
        System.out.println(chStr + " is whitespace.");
      }

      if(Character.isSpaceChar(a[i])) {
        String chStr = "";
        if(a[i] == ' ') chStr = "<space>";
        else if(a[i] == '\t') chStr = "<tab>";
        else if(a[i] == '\n') chStr = "<newline>";
        System.out.println(chStr + " is space.");
      }

      if(Character.isUpperCase(a[i]))
        System.out.println(a[i] + " is uppercase.");

      if(Character.isLowerCase(a[i]))
        System.out.println(a[i] + " is lowercase.");

      System.out.println();
    }
  }
}

// -----------------------------------------

// Demonstrate several Math functions.

class MathDemo {
  public static void main(String[] args) {

    // convert between radians and degrees
    double theta = 120.0;

    System.out.println(theta + " degrees is " +
                       Math.toRadians(theta) + " radians.");

    theta = 1.312;
    System.out.println(theta + " radians is " +
                       Math.toDegrees(theta) + " degrees\n");

    // demonstrate sin() and asin()
    theta = 1.0;
    double sine = Math.sin(theta);
    double asine = Math.asin(sine);
    System.out.println("Sine of " + theta + " is " + sine);
    System.out.println("Arc sine of " + sine + " is " + asine + "\n");

    // find the hypotenuse of a right triangle
    double h = Math.hypot(3.0, 4.0);
    System.out.println("Hypotenuse is " + h + "\n");

    // compute a power
    double p = Math.pow(3.0, 3.0);
    System.out.println("pow(3.0, 3.0) is " + p + "\n");

    // use log10()
    double lg = Math.log10(100.0);
    System.out.println("log10(100.0) is " + lg + "\n");

    // display E and PI
    System.out.println("PI: " + Math.PI + "\n E: " + Math.E);
  }
}

// -----------------------------------------

// Demonstrate ProcessBuilder.

import java.io.IOException;

class PBDemo {
  public static void main(String[] args) {

    try {
      ProcessBuilder procBldr =
        new ProcessBuilder("notepad", "testfile");
      procBldr.start();
    } catch (IOException exc) {
      System.out.println("Error executing notepad.\n" + exc);
    }
  }
}

// -----------------------------------------

// Wait until the process is terminated.

import java.io.IOException;

class PBDemo2 {
  public static void main(String[] args) {
    try {
      ProcessBuilder procBldr =
        new ProcessBuilder("notepad", "testfile");

      Process p = procBldr.start();
      p.waitFor();
      System.out.println("Notepad returned " + p.exitValue());
    } catch (IOException exc) {
      System.out.println("Error executing notepad.\n" + exc);
    } catch (InterruptedException exc) {
      System.out.println("Wait interrupted\n" + exc);
    }

  }
}

// -----------------------------------------

// Demonstrate destroy().

import java.io.IOException;

class PBDemo3 {
  public static void main(String[] args) {
    try {
      ProcessBuilder procBldr =
        new ProcessBuilder("notepad", "testfile");

      Process p = procBldr.start();

      try {
        Thread.sleep(2000);
      } catch (InterruptedException exc) {
        System.out.println("Sleep interrupted\n" + exc);
      }

      // terminate the process.
      p.destroy();

    } catch (IOException exc) {
      System.out.println("Error executing notepad.\n" + exc);
    }
  }
}

// -----------------------------------------

// Demonstrate totalMemory(), freeMemory() and gc().

class MemoryDemo {
  public static void main(String[] args) {
    Runtime r = Runtime.getRuntime();
    long mem1, mem2;
    Integer[] someints = new Integer[1000];

    System.out.println("Total memory is: " +
                       r.totalMemory());
    mem1 = r.freeMemory();
    System.out.println("Initial free memory: " + mem1);
    r.gc();
    mem1 = r.freeMemory();
    System.out.println("Free memory after garbage collection: "
                       + mem1);

    for(int i=0; i<1000; i++)
      someints[i] = new Integer(i); // allocate integers

    mem2 = r.freeMemory();
    System.out.println("Free memory after allocation: "
                       + mem2);
    System.out.println("Memory used by allocation: "
                       + (mem1-mem2));

    // discard Integers
    for(int i=0; i<1000; i++) someints[i] = null;

    r.gc(); // request garbage collection

    mem2 = r.freeMemory();
    System.out.println("Free memory after collecting" +
                       " discarded Integers: " + mem2);
  }
}

// -----------------------------------------

// Timing program execution.

class Elapsed {
  public static void main(String[] args) {
    long start, end;

    System.out.println("Timing a for loop from 0 to 100,000,000");

    // time a for loop from 0 to 100,000,000

    start = System.currentTimeMillis(); // get starting time
    for(long i=0; i < 100000000L; i++) ;
    end = System.currentTimeMillis(); // get ending time

    System.out.println("Elapsed time: " + (end-start));
  }
}

// -----------------------------------------

// Using arraycopy().

class ACDemo {
  static byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74 };
  static byte[] b = { 77, 77, 77, 77, 77, 77, 77, 77, 77, 77 };

  public static void main(String[] args) {
    System.out.println("a = " + new String(a));
    System.out.println("b = " + new String(b));
    System.arraycopy(a, 0, b, 0, a.length);
    System.out.println("a = " + new String(a));
    System.out.println("b = " + new String(b));
    System.arraycopy(a, 0, a, 1, a.length - 1);
    System.arraycopy(b, 1, b, 0, b.length - 1);
    System.out.println("a = " + new String(a));
    System.out.println("b = " + new String(b));
  }
}

// -----------------------------------------

class ShowProperties {
  public static void main(String[] args) {
    System.out.println(System.getProperty("user.dir"));
    System.out.println(System.getProperty("java.version"));
    System.out.println(System.getProperty("os.name"));
    System.out.println(System.getProperty("file.separator"));
  }
}

// -----------------------------------------

// Redirect System.out to a file.

import java.io.*;

class RedirectOut {
  public static void main(String[] args) throws IOException
  {

    // First, confirm that a file has been specified.
    if(args.length != 1) {
      System.out.println("RedirectOut: to");
      return;
    }

    // Create a Printstream linked to the specified file.
    try (PrintStream fout = new PrintStream(args[0]))
    {
      // save original System.out
      PrintStream orgOut = System.out;

      // redirect System.out to the file.
      System.setOut(fout);

      // notice that System.out is used here
      System.out.println("This goes in the file.");

      // restore original System.out
      System.setOut(orgOut);

      System.out.println("This is shown on the screen.");

    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    }
  }
}

// -----------------------------------------

// Demonstrate Run-Time Type Information.

class X {
  int a;
  float b;
}

class Y extends X {
  double c;
}

class RTTI {
  public static void main(String[] args) {
    X x = new X();
    Y y = new Y();
    Class<?> clObj;

    clObj = x.getClass(); // get Class reference
    System.out.println("x is object of type: " +
                       clObj.getName());

    clObj = y.getClass(); // get Class reference
    System.out.println("y is object of type: " +
                       clObj.getName());
    clObj = clObj.getSuperclass();
    System.out.println("y's superclass is " +
                       clObj.getName());
  }
}

// -----------------------------------------

class Finder {

  public static <T extends Comparable<T>> T minElement(T[] data) {
    T currMin = data[0];

    for(T x : data) {
      if (x.compareTo(currMin) < 0)
        currMin = x;
    }
    return currMin;
  }
}

class MinElementDemo {
  public static void main(String[] args) {
    Integer[] intArray = { 3, 1, 4, 3, 6, 5};
    int intMin = Finder.minElement(intArray);
    System.out.println(intMin);

    String[] strArray = {"every", "good", "boy", "does", "fine"};
    String strMin = Finder.minElement(strArray);
    System.out.println(strMin);

    Double[] doubleArray = {3.14, 2.8, 6.023, 1.414};
    Double doubleMin = Finder.minElement(doubleArray);
    System.out.println(doubleMin);
  }
}
