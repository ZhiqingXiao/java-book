// A simple generic class.
// Here, T is a type parameter that will be replaced by a
// real type when an object of type Gen is created.
class Gen<T> {
  T ob; // declare a reference to an object of type T

  // Pass the constructor a reference to
  // an object of type T.
  Gen(T o) {
    ob = o;
  }

  // Return ob.
  T getob() {
    return ob;
  }

  // Show type of T.
  void showType() {
    System.out.println("Type of T is " +
                       ob.getClass().getName());
    }
  }

// Demonstrate the generic class.
class GenDemo {
  public static void main(String[] args) {
    // Create a Gen reference for Integers.
    Gen<Integer> iOb;

    // Create a Gen<Integer> object and assign its
    // reference to iOb. Notice the use of autoboxing
    // to encapsulate the value 88 within an Integer object.
    iOb = new Gen<Integer>(88);

    // Show the type of data used by iOb.
    iOb.showType();

    // Get the value in iOb. Notice that
    // no cast is needed.
    int v = iOb.getob();
    System.out.println("value: " + v);

    System.out.println();

    // Create a Gen object for Strings.
    Gen<String> strOb = new Gen<String>("Generics Test");

    // Show the type of data used by strOb.
    strOb.showType();

    // Get the value of strOb. Again, notice
    // that no cast is needed.
    String str = strOb.getob();
    System.out.println("value: " + str);
  }
}

// -----------------------------------------

// A simple generic class with two type parameters: T and V.
class TwoGen<T, V> {
  T ob1;
  V ob2;

  // Pass the constructor references to
  // objects of type T and V.
  TwoGen(T o1, V o2) {
    ob1 = o1;
    ob2 = o2;
  }

  // Show types of T and V.
  void showTypes() {
    System.out.println("Type of T is " +
                       ob1.getClass().getName());

    System.out.println("Type of V is " +
                       ob2.getClass().getName());
  }

  T getob1() {
    return ob1;
  }

  V getob2() {
    return ob2;
  }
}

// Demonstrate TwoGen.
class SimpGen {
  public static void main(String[] args) {

    TwoGen<Integer, String> tgObj =
      new TwoGen<Integer, String>(88, "Generics");

    // Show the types.
    tgObj.showTypes();

    // Obtain and show values.
    int v = tgObj.getob1();
    System.out.println("value: " + v);

    String str = tgObj.getob2();
    System.out.println("value: " + str);
  }
}

// -----------------------------------------

// NumericFns attempts (unsuccessfully) to create
// a generic class that can compute various
// numeric functions, such as the reciprocal or the
// fractional component, given any type of number.
class NumericFns<T> {
  T num;

  // Pass the constructor a reference to
  // a numeric object.
  NumericFns(T n) {
    num = n;
  }

  // Return the reciprocal.
  double reciprocal() {
    return 1 / num.doubleValue(); // Error!
  }

  // Return the fractional component.
  double fraction() {
    return num.doubleValue() - num.intValue(); // Error!
  }

  // ...
}

// -----------------------------------------

// In this version of NumericFns, the type argument
// for T must be either Number, or a class derived
// from Number.
class NumericFns<T extends Number> {
  T num;

  // Pass the constructor a reference to
  // a numeric object.
  NumericFns(T n) {
    num = n;
  }

  // Return the reciprocal.
  double reciprocal() {
    return 1 / num.doubleValue();
  }

  // Return the fractional component.
  double fraction() {
    return num.doubleValue() - num.intValue();
  }

  // ...
}

// Demonstrate NumericFns.
class BoundsDemo {
  public static void main(String[] args) {

    NumericFns<Integer> iOb =
                      new NumericFns<Integer>(5);

    System.out.println("Reciprocal of iOb is " +
                        iOb.reciprocal());
    System.out.println("Fractional component of iOb is " +
                        iOb.fraction());

    System.out.println();

    NumericFns<Double> dOb =
                      new NumericFns<Double>(5.25);

    System.out.println("Reciprocal of dOb is " +
                        dOb.reciprocal());
    System.out.println("Fractional component of dOb is " +
                        dOb.fraction());


    // This won't compile because String is not a
    // subclass of Number.
// NumericFns<String> strOb = new NumericFns<String>("Error");
  }
}

// -----------------------------------------

class Pair<T, V extends T> {
  T first;
  V second;

  Pair(T a, V b) {
    first = a;
    second = b;
  }

  // ...
}

// -----------------------------------------

// Use a wildcard.
class NumericFns<T extends Number> {
  T num;

  // Pass the constructor a reference to
  // a numeric object.
  NumericFns(T n) {
    num = n;
  }

  // Return the reciprocal.
  double reciprocal() {
    return 1 / num.doubleValue();
  }

  // Return the fractional component.
  double fraction() {
    return num.doubleValue() - num.intValue();
  }

  // Determine if the absolute values of two
  // objects are the same.
  boolean absEqual(NumericFns<?> ob) {
    if(Math.abs(num.doubleValue()) ==
         Math.abs(ob.num.doubleValue())) return true;

    return false;
  }

  // ...
}

// Demonstrate a wildcard.
class WildcardDemo {
  public static void main(String[] args) {

    NumericFns<Integer> iOb =
                      new NumericFns<Integer>(6);

    NumericFns<Double> dOb =
                      new NumericFns<Double>(-6.0);

    NumericFns<Long> lOb =
                      new NumericFns<Long>(5L);

    System.out.println("Testing iOb and dOb.");
    if(iOb.absEqual(dOb))
      System.out.println("Absolute values are equal.");
    else
      System.out.println("Absolute values differ.");

    System.out.println();

    System.out.println("Testing iOb and lOb.");
    if(iOb.absEqual(lOb))
      System.out.println("Absolute values are equal.");
    else
      System.out.println("Absolute values differ.");

  }
}

// -----------------------------------------

class A {
  // ...
}

class B extends A {
  // ...
}

class C extends A {
  // ...
}

// Note that D does NOT extend A.
class D {
  // ...
}

// -----------------------------------------

// A simple generic class.
class Gen<T> {
  T ob;

  Gen(T o) {
    ob = o;
  }
}

// -----------------------------------------

class UseBoundedWildcard {
  // Here, the ? will match A or any class type
  // that extends A.
  static void test(Gen<? extends A> o) {
    // ...
  }

  public static void main(String[] args) {
    A a = new A();
    B b = new B();
    C c = new C();
    D d = new D();

    Gen<A> w = new Gen<A>(a);
    Gen<B> w2 = new Gen<B>(b);
    Gen<C> w3 = new Gen<C>(c);
    Gen<D> w4 = new Gen<D>(d);

    // These calls to test() are OK.
    test(w);
    test(w2);
    test(w3);

    // Can't call test() with w4 because
    // it is not an object of a class that
    // inherits A.
//    test(w4); // Error!
  }
}

// -----------------------------------------

// Demonstrate a simple generic method.
class GenericMethodDemo {

  // Determine if the contents of two arrays are the same.
  static <T, V extends T> boolean arraysEqual(T[] x, V[] y) {
    // If array lengths differ, then the arrays differ.
    if(x.length != y.length) return false;

    for(int i=0; i < x.length; i++)
      if(!x[i].equals(y[i])) return false; // arrays differ

    return true; // contents of arrays are equivalent
  }

  public static void main(String[] args) {

    Integer[] nums = { 1, 2, 3, 4, 5 };
    Integer[] nums2 = { 1, 2, 3, 4, 5 };
    Integer[] nums3 = { 1, 2, 7, 4, 5 };
    Integer[] nums4 = { 1, 2, 7, 4, 5, 6 };

    if(arraysEqual(nums, nums))
      System.out.println("nums equals nums");

    if(arraysEqual(nums, nums2))
      System.out.println("nums equals nums2");

    if(arraysEqual(nums, nums3))
      System.out.println("nums equals nums3");

    if(arraysEqual(nums, nums4))
      System.out.println("nums equals nums4");

    // Create an array of Doubles
    Double[] dvals = { 1.1, 2.2, 3.3, 4.4, 5.5 };

    // This won't compile because nums and dvals
    // are not of the same type.
//    if(arraysEqual(nums, dvals))
//      System.out.println("nums equals dvals");
  }
}

// -----------------------------------------

// Use a generic constructor.
class Summation {
  private int sum;

  <T extends Number> Summation(T arg) {
    sum = 0;

    for(int i=0; i <= arg.intValue(); i++)
      sum += i;
  }

  int getSum() {
    return sum;
  }
}

class GenConsDemo {
  public static void main(String[] args) {
    Summation ob = new Summation(4.0);

    System.out.println("Summation of 4.0 is " + ob.getSum());
  }
}

// -----------------------------------------

// A simple generic class hierarchy.
class Gen<T> {
  T ob;

  Gen(T o) {
    ob = o;
  }

  // Return ob.
  T getob() {
    return ob;
  }
}

// A subclass of Gen.
class Gen2<T> extends Gen<T> {
  Gen2(T o) {
    super(o);
  }
}

// -----------------------------------------

// A non-generic class can be the superclass
// of a generic subclass.

// A non-generic class.
class NonGen {
  int num;

  NonGen(int i) {
    num = i;
  }

  int getnum() {
    return num;
  }
}

// A generic subclass.
class Gen<T> extends NonGen {
  T ob; // declare an object of type T

  // Pass the constructor a reference to
  // an object of type T.
  Gen(T o, int i) {
    super(i);
    ob = o;
  }

  // Return ob.
  T getob() {
    return ob;
  }
}

// -----------------------------------------

// Overriding a generic method in a generic class.
class Gen<T> {
  T ob; // declare an object of type T

  // Pass the constructor a reference to
  // an object of type T.
  Gen(T o) {
    ob = o;
  }

  // Return ob.
  T getob() {
    System.out.print("Gen's getob(): " );
    return ob;
  }
}

// A subclass of Gen that overrides getob().
class Gen2<T> extends Gen<T> {

  Gen2(T o) {
    super(o);
  }

  // Override getob().
  T getob() {
    System.out.print("Gen2's getob(): ");
    return ob;
  }
}

// Demonstrate generic method override.
class OverrideDemo {
  public static void main(String[] args) {

   // A Gen reference that can refer to any type of Gen object.
    Gen<?> gRef;

    // Create a Gen object for Integers.
    Gen<Integer> iOb = new Gen<Integer>(88);

    // Create a Gen2 object for Integers.
    Gen2<Integer> iOb2 = new Gen2<Integer>(99);

    // Create a Gen2 object for Strings.
    Gen2<String> strOb2 = new Gen2<String> ("Generics Test");

    gRef = iOb;
    System.out.println(gRef.getob());

    gRef = iOb2;
    System.out.println(gRef.getob());

    gRef = strOb2;
    System.out.println(gRef.getob());
  }
}

// -----------------------------------------

// A generic interface example.

// A generic containment interface.
// This interface implies that an implementing
// class contains one or more values.
interface Containment<T> {
  // The contains() method tests if a
  // specific item is contained within
  // an object that implements Containment.
  boolean contains(T o);
}

// Implement Containment using an array to
// hold the values.
class MyClass<T> implements Containment<T> {
  T[] arrayRef;

  MyClass(T[] o) {
    arrayRef = o;
  }

  // Implement Contains().
  public boolean contains(T o) {
    for(T x : arrayRef)
      if(x.equals(o)) return true;
    return false;
  }
}

class GenIFDemo {
  public static void main(String[] args) {
    Integer[] x = { 1, 2, 3 };

    MyClass<Integer> ob = new MyClass<Integer>(x);

    if(ob.contains(2))
      System.out.println("2 is in ob");
    else
      System.out.println("2 is NOT in ob");

    if(ob.contains(5))
      System.out.println("5 is in ob");
    else
      System.out.println("5 is NOT in ob");

    // The following is illegal because ob
    // is an Integer Containment and 9.25 is
    // a Double value.
//    if(ob.contains(9.25)) // Illegal!
//      System.out.println("9.25 is in ob");
  }
}

// -----------------------------------------

// A generic interface for a simple stack.
public interface IGenSimpleStack<T> {

  // Push an item onto the stack.
  void push(T item) throws StackFullException;

  // Pop an item from the stack.
  T pop() throws StackEmptyException;

  // Return true if the stack is empty.
  boolean isEmpty();

  // Return true if the stack is full.
  boolean isFull();
}

// An exception for stack-full errors.
class StackFullException extends Exception {
  int size;

  StackFullException(int s) {
    super("Stack Full");
    size = s;
  }

  public String toString() {
    return "\nStack is full. Maximum size is " + size;
  }
}

// An exception for stack-empty errors.
class StackEmptyException extends Exception {

  StackEmptyException() {
    super("Stack Empty");
  }

  public String toString() {
    return "\nStack is empty.";
  }
}

// A simple generic fixed-length stack.
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
    if(isFull())
      throw new StackFullException(data.length);

    data[tos] = obj;
    tos++;
  }

  // Pop an item from the stack.
  public T pop() throws StackEmptyException {
    if(isEmpty())
      throw new StackEmptyException();

    tos--;
    return data[tos];
  }

  // Return true if the stack is empty.
  public boolean isEmpty() {
    return tos==0;
  }

  // Return true if the stack is full.
  public boolean isFull() {
    return tos==data.length;
  }
}

/*
    Try This 14-1

    Demonstrate a simple generic stack class.
*/

class GenSimpleStackDemo {
  public static void main(String[] args) {
    int i;
    Integer[] nums = new Integer[5];
    String[] strs = new String[3];

    // first create a stack for integers
    GenSimpleStack<Integer> intStack = new GenSimpleStack<Integer>(nums);

    System.out.println("Demonstrating Integer stack.");

    // use intStack
    try {

      System.out.print("Pushing: ");
      // push integers onto intStack
      for(i = 0; !intStack.isFull(); i++) {
        System.out.print(i);
        intStack.push(i);
      }

      System.out.println();

      // pop integers off intStack
      System.out.print("Popping: ");
      while(!intStack.isEmpty())
        System.out.print(intStack.pop());

      System.out.println();
    } catch (StackFullException exc) {
      System.out.println(exc);
    } catch (StackEmptyException exc) {
      System.out.println(exc);
    }


    // next, create a stack for strings
    GenSimpleStack<String> strStack = new GenSimpleStack<String>(strs);

    System.out.println("\nDemonstrating String stack.");

    // now, use strStack
    try {

      System.out.println("Pushing: alpha beta gamma");

      // push strings onto strStack
      strStack.push("alpha");
      strStack.push("beta");
      strStack.push("gamma");

      // pop Strings off strStack
      System.out.print("Popping: ");
      while(!strStack.isEmpty())
        System.out.print(strStack.pop() + " ");

      System.out.println();
    } catch (StackFullException exc) {
      System.out.println(exc);
    } catch (StackEmptyException exc) {
      System.out.println(exc);
    }    System.out.println();
  }
}

// -----------------------------------------

// Demonstrate a raw type.
class Gen<T> {
  T ob; // declare a reference to an object of type T

  // Pass the constructor a reference to
  // an object of type T.
  Gen(T o) {
    ob = o;
  }

  // Return ob.
  T getob() {
    return ob;
  }
}

// Demonstrate raw type.
class RawDemo {
  public static void main(String[] args) {

    // Create a Gen object for Integers.
    Gen<Integer> iOb = new Gen<Integer>(88);

    // Create a Gen object for Strings.
    Gen<String> strOb = new Gen<String>("Generics Test");

    // Create a raw-type Gen object and give it
    // a Double value.
    Gen raw = new Gen(new Double(98.6));

    // Cast here is necessary because type is unknown.
    double d = (Double) raw.getob();
    System.out.println("value: " + d);

    // The use of a raw type can lead to run-time.
    // exceptions. Here are some examples.

    // The following cast causes a run-time error!
//    int i = (Integer) raw.getob(); // run-time error

    // This assignment overrides type safety.
    strOb = raw; // OK, but potentially wrong
//    String str = strOb.getob(); // run-time error

    // This assignment also overrides type safety.
    raw = iOb; // OK, but potentially wrong
//    d = (Double) raw.getob(); // run-time error
  }
}

// -----------------------------------------

class TwoGen<T, V> {
  T ob1;
  V ob2;

  // Pass the constructor a reference to
  // an object of type T.
  TwoGen(T o1, V o2) {
    ob1 = o1;
    ob2 = o2;
  }
  // ...
}

// -----------------------------------------

// Ambiguity caused by erasure on
// overloaded methods.
class MyGenClass<T, V> {
  T ob1;
  V ob2;

  // ...

  // These two overloaded methods are ambiguous
  // and will not compile.
  void set(T o) {
    ob1 = o;
  }

  void set(V o) {
    ob2 = o;
  }
}

// -----------------------------------------

// Can't create an instance of T.
class Gen<T> {
  T ob;
  Gen() {
    ob = new T(); // Illegal!!!
  }
}

// -----------------------------------------

class Wrong<T> {
  // Wrong, no static variables of type T.
  static T ob;

  // Wrong, no static method can use T.
  static T getob() {
    return ob;
  }
}

// -----------------------------------------

// Generics and arrays.
class Gen<T extends Number> {
  T ob;

  T[] vals; // OK

  Gen(T o, T[] nums) {
    ob = o;

    // This statement is illegal.
//  vals = new T[10]; // can't create an array of T

    // But, this statement is OK.
    vals = nums; // OK to assign reference to existent array
  }
}

class GenArrays {
  public static void main(String[] args) {
    Integer[] n = { 1, 2, 3, 4, 5 };

    Gen<Integer> iOb = new Gen<Integer>(50, n);

    // Can't create an array of type-specific generic references.
    // Gen<Integer>[] gens = new Gen<Integer>[10]; // Wrong!

    // This is OK.
    Gen<?>[] gens = new Gen<?>[10]; // OK
  }
}
