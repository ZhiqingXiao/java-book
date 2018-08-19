/* A program that uses the Vehicle class.

   Call this file VehicleDemo.java
*/
class Vehicle {
  int passengers; // number of passengers
  int fuelCap; // fuel capacity in gallons
  int mpg; // fuel consumption in miles per gallon
}

// This class declares an object of type Vehicle.
class VehicleDemo {
  public static void main(String[] args) {
    Vehicle minivan = new Vehicle();
    int range;

    // assign values to fields in minivan
    minivan.passengers = 7;
    minivan.fuelCap = 16;
    minivan.mpg = 21;

    // compute the range assuming a full tank of gas
    range = minivan.fuelCap * minivan.mpg;
    System.out.println("Minivan can carry " + minivan.passengers +
                       " with a range of " + range);
  }
}

// -----------------------------------------

// This program creates two Vehicle objects.

class Vehicle {
  int passengers; // number of passengers
  int fuelCap; // fuel capacity in gallons
  int mpg; // fuel consumption in miles per gallon
}

// This class declares an object of type Vehicle.
class TwoVehicles {
  public static void main(String[] args) {
    Vehicle minivan = new Vehicle();
    Vehicle sportscar = new Vehicle();

    int range1, range2;

    // assign values to fields in minivan
    minivan.passengers = 7;
    minivan.fuelCap = 16;
    minivan.mpg = 21;

    // assign values to fields in sportscar
    sportscar.passengers = 2;
    sportscar.fuelCap = 14;
    sportscar.mpg = 12;

    // compute the ranges assuming a full tank of gas
    range1 = minivan.fuelCap * minivan.mpg;
    range2 = sportscar.fuelCap * sportscar.mpg;

    System.out.println("Minivan can carry " + minivan.passengers +
                       " with a range of " + range1);

    System.out.println("Sportscar can carry " + sportscar.passengers +
                       " with a range of " + range2);
  }
}

// -----------------------------------------

// Add range to Vehicle.

class Vehicle {
  int passengers; // number of passengers
  int fuelCap; // fuel capacity in gallons
  int mpg; // fuel consumption in miles per gallon

  // Display the range.
  void range() {
    System.out.println("Range is " + fuelCap * mpg);
  }
}

class AddMeth {
  public static void main(String[] args) {
    Vehicle minivan = new Vehicle();
    Vehicle sportscar = new Vehicle();

    int range1, range2;

    // assign values to fields in minivan
    minivan.passengers = 7;
    minivan.fuelCap = 16;
    minivan.mpg = 21;

    // assign values to fields in sportscar
    sportscar.passengers = 2;
    sportscar.fuelCap = 14;
    sportscar.mpg = 12;


    System.out.print("Minivan can carry " + minivan.passengers + ". ");

    minivan.range(); // display range of minivan

    System.out.print("Sportscar can carry " + sportscar.passengers + ". ");

    sportscar.range(); // display range of sportscar.
  }
}

// -----------------------------------------

// Use a return value.

class Vehicle {
  int passengers; // number of passengers
  int fuelCap; // fuel capacity in gallons
  int mpg; // fuel consumption in miles per gallon

  // Return the range.
  int range() {
    return mpg * fuelCap;
  }
}

class RetMeth {
  public static void main(String[] args) {
    Vehicle minivan = new Vehicle();
    Vehicle sportscar = new Vehicle();

    int range1, range2;

    // assign values to fields in minivan
    minivan.passengers = 7;
    minivan.fuelCap = 16;
    minivan.mpg = 21;

    // assign values to fields in sportscar
    sportscar.passengers = 2;
    sportscar.fuelCap = 14;
    sportscar.mpg = 12;

    // get the ranges
    range1 = minivan.range();
    range2 = sportscar.range();

    System.out.println("Minivan can carry " + minivan.passengers +
                       " with range of " + range1 + " miles");

    System.out.println("Sportscar can carry " + sportscar.passengers +
                       " with range of " + range2 + " miles");
  }
}

// -----------------------------------------

// A simple example that uses a parameter.

class ChkNum {

  // Return true if x is even.
  boolean isEven(int x) {
    if((x%2) == 0) return true;
    else return false;
  }
}

class ParmDemo {
  public static void main(String[] args) {
    ChkNum e = new ChkNum();

    if(e.isEven(10)) System.out.println("10 is even.");

    if(e.isEven(9)) System.out.println("9 is even.");

    if(e.isEven(8)) System.out.println("8 is even.");
  }
}

// -----------------------------------------

class Factor {

  // Return true if a is a factor of b.
  boolean isFactor(int a, int b) {
    if( (b % a) == 0) return true;
    else return false;
  }
}

class IsFact {
  public static void main(String[] args) {
    Factor x = new Factor();

    if(x.isFactor(2, 20)) System.out.println("2 is factor");
    if(x.isFactor(3, 20)) System.out.println("this won't be displayed");
  }
}

// -----------------------------------------

/*
   Add a parameterized method that computes the
   fuel required for a given distance.
*/

class Vehicle {
  int passengers; // number of passengers
  int fuelCap; // fuel capacity in gallons
  int mpg; // fuel consumption in miles per gallon

  // Return the range.
  int range() {
    return mpg * fuelCap;
  }

  // Compute fuel needed for a given distance.
  double fuelNeeded(int miles) {
    return (double) miles / mpg;
  }
}

class CompFuel {
  public static void main(String[] args) {
    Vehicle minivan = new Vehicle();
    Vehicle sportscar = new Vehicle();
    double gallons;
    int dist = 252;

    // assign values to fields in minivan
    minivan.passengers = 7;
    minivan.fuelCap = 16;
    minivan.mpg = 21;

    // assign values to fields in sportscar
    sportscar.passengers = 2;
    sportscar.fuelCap = 14;
    sportscar.mpg = 12;

    gallons = minivan.fuelNeeded(dist);

    System.out.println("To go " + dist + " miles minivan needs " +
                       gallons + " gallons of fuel.");

    gallons = sportscar.fuelNeeded(dist);

    System.out.println("To go " + dist + " miles sportscar needs " +
                       gallons + " gallons of fuel.");
  }
}

// -----------------------------------------

/*
    Try This 4-1

    Convert the help system from Try This 3-3 into
    a Help class.
*/

class Help {

  // Display help.
  void helpOn(int what) {
    switch(what) {
      case '1':
        System.out.println("The if:\n");
        System.out.println("if(condition) statement;");
        System.out.println("else statement;");
        break;
      case '2':
        System.out.println("The switch:\n");
        System.out.println("switch(expression) {");
        System.out.println("  case constant:");
        System.out.println("    statement sequence");
        System.out.println("    break;");
        System.out.println("  // ...");
        System.out.println("}");
        break;
      case '3':
        System.out.println("The for:\n");
        System.out.print("for(init; condition; iteration)");
        System.out.println(" statement;");
        break;
      case '4':
        System.out.println("The while:\n");
        System.out.println("while(condition) statement;");
        break;
      case '5':
        System.out.println("The do-while:\n");
        System.out.println("do {");
        System.out.println("  statement;");
        System.out.println("} while (condition);");
        break;
      case '6':
        System.out.println("The break:\n");
        System.out.println("break; or break label;");
        break;
      case '7':
        System.out.println("The continue:\n");
        System.out.println("continue; or continue label;");
        break;
    }
    System.out.println();
  }

  // Display menu.
  void showMenu() {
    System.out.println("Help on:");
    System.out.println("  1. if");
    System.out.println("  2. switch");
    System.out.println("  3. for");
    System.out.println("  4. while");
    System.out.println("  5. do-while");
    System.out.println("  6. break");
    System.out.println("  7. continue\n");
    System.out.print("Choose one (q to quit): ");
  }

  // Return true if ch is a valid selection.
  boolean isValid(int ch) {
    if(ch < '1' | ch > '7' & ch != 'q') return false;
    else return true;
  }
}

class HelpClassDemo {
  public static void main(String[] args)
    throws java.io.IOException {

    char choice, ignore;
    Help hlpobj = new Help();

    for(;;) {
      do {
        hlpobj.showMenu();

        choice = (char) System.in.read();

        do {
          ignore = (char) System.in.read();
        } while(ignore != '\n');

      } while( !hlpobj.isValid(choice) );

      if(choice == 'q') break;

      System.out.println("\n");

      hlpobj.helpOn(choice);
    }
  }
}

// -----------------------------------------

// A simple constructor.

class MyClass {
  int x;

  MyClass() {
    x = 10;
  }
}

class ConsDemo {
  public static void main(String[] args) {
    MyClass t1 = new MyClass();
    MyClass t2 = new MyClass();

    System.out.println(t1.x + " " + t2.x);
  }
}

// -----------------------------------------

// A parameterized constructor.

class MyClass {
  int x;

  MyClass(int i) {
    x = i;
  }
}

class ParmConsDemo {
  public static void main(String[] args) {
    MyClass t1 = new MyClass(10);
    MyClass t2 = new MyClass(88);

    System.out.println(t1.x + " " + t2.x);
  }
}

// -----------------------------------------

// Add a constructor.

class Vehicle {
  int passengers; // number of passengers
  int fuelCap;    // fuel capacity in gallons
  int mpg;        // fuel consumption in miles per gallon

  // This is a constructor for Vehicle.
  Vehicle(int p, int f, int m) {
    passengers = p;
    fuelCap = f;
    mpg = m;
  }

  // Return the range.
  int range() {
    return mpg * fuelCap;
  }

  // Compute fuel needed for a given distance.
  double fuelNeeded(int miles) {
    return (double) miles / mpg;
  }
}

class VehConsDemo {
  public static void main(String[] args) {

    // construct complete vehicles
    Vehicle minivan = new Vehicle(7, 16, 21);
    Vehicle sportscar = new Vehicle(2, 14, 12);

    double gallons;
    int dist = 252;

    gallons = minivan.fuelNeeded(dist);

    System.out.println("To go " + dist + " miles minivan needs " +
                       gallons + " gallons of fuel.");

    gallons = sportscar.fuelNeeded(dist);

    System.out.println("To go " + dist + " miles sportscar needs " +
                       gallons + " gallons of fuel.");
  }
}

// -----------------------------------------

/*
    Try This 4-2

    Demonstrate garbage collection and the finalize() method.
*/

class MyClass {
  int x;

  MyClass(int i) {
    x = i;
  }

  // Called when object is recycled.
  protected void finalize() {
    System.out.println("Finalizing " + x);
  }

  // Generates an object that is immediately abandoned.
  void generate(int i) {
    MyClass o = new MyClass(i);
  }
}

class GCDemo {
  public static void main(String[] args) {
    MyClass ob = new MyClass(0);

    /* Now, generate a large number of objects. At
       some point, garbage collection will occur.
       Note: you might need to increase the number
       of objects generated in order to force
       garbage collection. */

    for(int count=1; count < 1000000; count++)
      ob.generate(count);
  }
}

// -----------------------------------------

class Power {
  double b;
  int e;
  double val;

  Power(double base, int exp) {
    b = base;
    e = exp;

    val = 1;
    if(exp==0) return;
    for( ; exp>0; exp--) val = val * base;
  }

  double getPwr() {
    return val;
  }
}

class DemoPower {
  public static void main(String[] args) {
    Power x = new Power(4.0, 2);
    Power y = new Power(2.5, 1);
    Power z = new Power(5.7, 0);

    System.out.println(x.b + " raised to the " + x.e +
                       " power is " + x.getPwr());
    System.out.println(y.b + " raised to the " + y.e +
                       " power is " + y.getPwr());
    System.out.println(z.b + " raised to the " + z.e +
                       " power is " + z.getPwr());
  }
}
