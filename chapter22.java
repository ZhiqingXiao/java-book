// Demonstrate several String constructors.

class StringConsDemo {

  public static void main(String[] args) {

    char[] digits = new char[16];

    // Create an array that contains the digits 0 through 9
    // plus the hexadecimal values A through F.
     for(int i=0; i < 16; i++) {
      if(i < 10) digits[i] = (char) ('0'+i);
      else digits[i] = (char) ('A' + i - 10);
    }

    // Create a string that contains all of the array.
    String digitsStr = new String(digits);
    System.out.println(digitsStr);

    // Create a string the contains a portion of the array.
    String nineToTwelve = new String(digits, 9, 4);
    System.out.println(nineToTwelve);

    // Construct a string from a string.
    String digitsStr2 = new String(digitsStr);
    System.out.println(digitsStr2);

    // Now, create an empty string.
    String empty = new String();

    // This will display nothing:
    System.out.println("Empty string: " + empty);
  }
}

// -----------------------------------------

// Using concatenation to prevent long lines.
class ConCat {
  public static void main(String[] args) {
    String longStr = "This could have been " +
      "a very long line that would have " +
      "wrapped around.  But string concatenation " +
      "prevents this.";

    System.out.println(longStr);
  }
}

// -----------------------------------------

// Override toString() for Box class.
class Box {
  double width;
  double height;
  double depth;

  Box(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }

  // Provide string representation of Box.
  public String toString() {
    return "Dimensions are " + width + " by " +
            depth + " by " + height + ".";
  }
}

class OverrideToString {
  public static void main(String[] args) {
    Box b = new Box(10, 12, 14);
    String str = "Box b: " + b; // toString() called here

    System.out.println(b); // toString() called here.

    System.out.println(str);
  }
}

// -----------------------------------------

class GenStackToStringDemo {
  public static void main(String[] args)
      throws StackFullException, StackEmptyException {
    Integer iStore[] = new Integer[10];
    GenSimpleStack<Integer> stack =
             new GenSimpleStack<Integer>(iStore);

    System.out.println("Empty stack: " + stack);

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.pop();

    System.out.println("Non-empty stack: " + stack);
  }
}

class GenSimpleStack<T> implements IGenSimpleStack<T> {
  private T[] data; // this array holds the stack
  private int tos; // index of top of stack

  // Construct an empty stack with the given array as storage.
  GenSimpleStack(T[] arrayRef) {
    data = arrayRef;
    tos = 0;
  }

  // Push an item onto the stack.
  public void push(T obj) throws StackFullException {
    if (isFull())
      throw new StackFullException(data.length);

    data[tos] = obj;
    tos++;
  }

  // Pop an item from the stack.
  public T pop() throws StackEmptyException {
    if (isEmpty())
      throw new StackEmptyException();

    tos--;
    return data[tos];

  }

  // Override toString() for GenSimpleStack.
  public String toString() {
    String result = "(";

    // Add the string representations of all the
    // items in the stack, separated by commas.
    for (int i = 0; i < tos; i++) {
      result += data[i];
      if (i < tos - 1) // if not the last item,
        // add a comma and space
        result += ", ";
    }

    // Add the right parenthesis and return it.
    result += ")";
    return result;
  }


  // Return true if the stack is empty.
  public boolean isEmpty() {
    return tos == 0;
  }

  // Return true if the stack is full.
  public boolean isFull() {
    return tos == data.length;
  }
}

// -----------------------------------------

// Demonstrate charAt() and length().

class CharAtAndLength {
  public static void main(String[] args) {
    String str = "Programming is both art and science.";

    // Cycle through all characters in the string.
    for(int i=0; i < str.length(); i++)
      System.out.print(str.charAt(i) + " ");

    System.out.println();
  }
}

// -----------------------------------------

class GetCharsDemo {
  public static void main(String[] args) {
    String str = "Programming is both art and science.";
    int start = 15;
    int end = 23;
    char[] buf = new char[end - start];

    str.getChars(start, end, buf, 0);
    System.out.println(buf);
  }
}

// -----------------------------------------

// Demonstrate equals() and equalsIgnoreCase().

class EqualityDemo {
  public static void main(String[] args) {
    String str1 = "table";
    String str2 = "table";
    String str3 = "chair";
    String str4 = "TABLE";

    if(str1.equals(str2))
      System.out.println(str1 + " equals " + str2);
    else
      System.out.println(str1 + " does not equal " + str2);

    if(str1.equals(str3))
      System.out.println(str1 + " equals " + str3);
    else
      System.out.println(str1 + " does not equal " + str3);

    if(str1.equals(str4))
      System.out.println(str1 + " equals " + str4);
    else
      System.out.println(str1 + " does not equal " + str4);

    if(str1.equalsIgnoreCase(str4))
      System.out.println("Ignoring case differences, " + str1 +
                         " equals " + str4);
    else
      System.out.println(str1 + " does not equal " + str4);
  }
}

// -----------------------------------------

// equals() vs ==
class EqualsNotEqualTo {
  public static void main(String[] args) {
    String str1 = "Alpha";
    String str2 = new String(str1);

    System.out.println(str1 + " equals " + str2 + " is " +
                       str1.equals(str2));
    System.out.println(str1 + " == " + str2 + " is " + (str1 == str2));
  }
}

// -----------------------------------------

// Demonstrate RegionMatches.

class CompareRegions {
  public static void main(String[] args) {
    String str1 = "Standing at river's edge.";
    String str2 = "Running at river's edge.";

    if(str1.regionMatches(9, str2, 8, 12))
      System.out.println("Regions match.");

    if(!str1.regionMatches(0, str2, 0, 12))
      System.out.println("Regions do not match.");
  }
}

// -----------------------------------------

// Demonstrate compareTo() and compareToIgnoreCase().

class CompareStrings {
  public static void main(String[] args) {
    String str1 = "alpha";
    String str2 = "ALPHA";
    String str3 = "Beta";

    int result;

    // Demonstrate the differences between compareTo()
    // and compareToIgnoreCase().
    result = str1.compareTo(str2);
    if(result != 0)
      System.out.println("Using compareTo(): " +
                         str1 + " and "  + str2 + " differ");

    result = str1.compareToIgnoreCase(str2);
    if(result == 0)
      System.out.println("Using compareToIgnoreCase(): " +
                         str1 + " and "  + str2 + " are the same\n");

    // Now, compare alpha to Beta using compareTo().
    System.out.println("Using compareTo() to compare " + str1 +
                       " with " + str3);
    result = str1.compareTo(str3);
    if(result < 0)
      System.out.println(str1 + " is less than " + str3);
    else if(result == 0)
      System.out.println(str1 + " is equal to " + str3);
    else if(result > 0)
      System.out.println(str1 + " is greater than " + str3);

    System.out.println();

    // Next, compare alpha to Beta using compareToIgnoreCase().
    System.out.println("Using compareToIgnoreCase() to compare " +
                       str1 + " with " + str3);
    result = str1.compareToIgnoreCase(str3);
    if(result < 0)
      System.out.println(str1 + " is less than " + str3);
    else if(result == 0)
      System.out.println(str1 + " is equal to " + str3);
    else if(result > 0)
      System.out.println(str1 + " is greater than " + str3);

  }
}

// -----------------------------------------

// Demonstrate indexOf() and lastIndexOf().

class IndexOfDemo {
  public static void main(String[] args) {
    String str = "alpha beta gamma theta zeta";

    System.out.println("The string is: " + str);
    System.out.println("The first index of t is " + str.indexOf('t'));

    System.out.println("The last index of t is " + str.lastIndexOf('t'));

    System.out.println("The first index of eta is " + str.indexOf("eta"));

    System.out.println("The last index of eta is " + str.lastIndexOf("eta"));

    System.out.println("The first index of eta after position 10 is " +
                       str.indexOf("eta", 10));
  }
}

// -----------------------------------------

// This program demonstrates both forms of substring().

class UseSubStrings {
  public static void main(String[] args) {
    String orgStr = "This is a test. This is, too.";
    String searchStr = "is";
    String subStr = "was";
    String resultStr = "";
    int i;

    System.out.println("Original string: " + orgStr);

    // Obtain the second sentence in orgStr. This is
    // done by first finding the end of the first sentence
    // and then obtaining the remainder of the string.
    i = orgStr.indexOf(".") + 2;
    String str = orgStr.substring(i);
    System.out.println("Second sentence: " + str + "\n");

    // Replace all occurrences of searchStr with subStr.
    System.out.println ("Progressively replacing " +
                         searchStr + " with " + subStr);
    do {
      System.out.println(orgStr);

      // find next occurrences of searchStr.
      i = orgStr.indexOf(searchStr);
      if(i != -1) {
        // obtain the first part of the string
        resultStr = orgStr.substring(0, i);

        // add the replacement sequence
        resultStr = resultStr + subStr;

        // add the remainder of the string, skipping searchStr
        resultStr = resultStr + orgStr.substring(i + searchStr.length());

        // make the resulting string, the new orgstr
        orgStr = resultStr;
      }
    } while(i != -1);
  }
}

// -----------------------------------------

// This program demonstrates both forms of replace().

class Replace {
  public static void main(String[] args) {
    String orgStr = "alpha beta gamma alpha beta gamma";
    String resultStr;

    System.out.println("Original string: " + orgStr);

    // First, replace g with X.
    resultStr = orgStr.replace('g', 'X');
    System.out.println(resultStr);

    // Now, replace beta with zeta.
    resultStr = resultStr.replace("beta", "zeta");
    System.out.println(resultStr);
  }
}

// -----------------------------------------

// Using trim() to process commands.
import java.io.*;

class UseTrim {
  public static void main(String[] args)
    throws IOException
  {
    // create a BufferedReader using System.in
    BufferedReader br = new
      BufferedReader(new InputStreamReader(System.in));
    String str;

    System.out.println("Enter 'stop' to quit.");
    System.out.println("Enter State: ");
    do {
      str = br.readLine();
      str = str.trim(); // remove whitespace

      if(str.equals("Illinois"))
        System.out.println("Capital is Springfield.");
      else if(str.equals("Missouri"))
        System.out.println("Capital is Jefferson City.");
      else if(str.equals("California"))
        System.out.println("Capital is Sacramento.");
      else if(str.equals("Washington"))
        System.out.println("Capital is Olympia.");
      // ...
    } while(!str.equals("stop"));
  }
}

// -----------------------------------------

// Demonstrate toUpperCase() and toLowerCase().

class ChangeCase {
  public static void main(String[] args)
  {
    String str = "This is a test.";

    System.out.println("Original: " + str);

    String upper = str.toUpperCase();
    String lower = str.toLowerCase();

    System.out.println("Uppercase: " + upper);
    System.out.println("Lowercase: " + lower);
  }
}