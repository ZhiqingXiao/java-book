/*
   This is a simple Java program.

   Call this file Example.java.
*/
class Example {
  // A Java program begins with a call to main().
  public static void main(String[] args) {
    System.out.println("Java drives the Web.");
  }
}

// -----------------------------------------

/*
   This demonstrates a variable.

   Call this file Example2.java.
*/
class Example2 {
  public static void main(String[] args) {
    int var1; // this declares a variable
    int var2; // this declares another variable

    var1 = 1024; // this assigns 1024 to var1

    System.out.println("var1 contains " + var1);

    var2 = var1 / 2;

    System.out.print("var2 contains var1 / 2: ");
    System.out.println(var2);
  }
}

// -----------------------------------------

/*
   This program illustrates the differences
   between int and double.

   Call this file Example3.java.
*/
class Example3 {
  public static void main(String[] args) {
    int w; // this declares an int variable
    double x; // this declares a floating-point variable

    w = 10; // assign w the value 10

    x = 10.0; // assign x the value 10.0

    System.out.println("Original value of w: " + w);
    System.out.println("Original value of x: " + x);
    System.out.println(); // print a blank line

    // now, divide both by 4
    w = w / 4;
    x = x / 4;

    System.out.println("w after division: " + w);
    System.out.println("x after division: " + x);
  }
}

// -----------------------------------------

/*
   Try This 1-1

   This program converts gallons to liters.

   Call this program GalToLit.java.
*/
class GalToLit {
  public static void main(String[] args) {
    double gallons; // holds the number of gallons
    double liters; // holds conversion to liters

    gallons = 10; // start with 10 gallons

    liters = gallons * 3.7854; // convert to liters

    System.out.println(gallons + " gallons is " + liters + " liters.");
  }
}

// -----------------------------------------

/*
   Demonstrate the if.

   Call this file IfDemo.java.
*/
class IfDemo {
  public static void main(String[] args) {
    int a, b, c;

    a = 2;
    b = 3;

    if(a < b) System.out.println("a is less than b");

    // this won't display anything
    if(a == b) System.out.println("you won't see this");

    System.out.println();

    c = a - b; // c contains -1

    System.out.println("c contains -1");
    if(c >= 0) System.out.println("c is non-negative");
    if(c < 0) System.out.println("c is negative");

    System.out.println();

    c = b - a; // c now contains 1

    System.out.println("c contains 1");
    if(c >= 0) System.out.println("c is non-negative");
    if(c < 0) System.out.println("c is negative");
  }
}

// -----------------------------------------

/*
  Demonstrate the for loop.

  Call this file ForDemo.java.
*/
class ForDemo {
  public static void main(String[] args) {
    int count;

    for(count = 0; count < 5; count = count+1)
      System.out.println("This is count: " + count);

    System.out.println("Done!");
  }
}

// -----------------------------------------

/*
  Demonstrate a block of code.

  Call this file BlockDemo.java.
*/
class BlockDemo {
  public static void main(String[] args) {
    double i, j, d;

    i = 5;
    j = 10;

    // the target of this if is a block
    if(i != 0) {
      System.out.println("i does not equal zero");
      d = j / i;
      System.out.print("j / i is " + d);
    }
  }
}

// -----------------------------------------

/*
   Try This 1-2

   This program displays a conversion
   table of gallons to liters.

   Call this program "GalToLitTable.java".
*/
class GalToLitTable {
  public static void main(String[] args) {
    double gallons, liters;
    int counter;

    counter = 0;
    for(gallons = 1; gallons <= 100; gallons++) {
      liters = gallons * 3.7854; // convert to liters
      System.out.println(gallons + " gallons is " +
                         liters + " liters.");

      counter++;
      // every 10th line, print a blank line
      if(counter == 10) {
        System.out.println();
        counter = 0; // reset the line counter
      }
    }
  }
}