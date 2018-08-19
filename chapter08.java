public interface Series {
  int getNext(); // return next number in series
  void reset(); // restart
  void setStart(int x); // set starting value
}

// -----------------------------------------

// Implement Series.
class ByTwos implements Series {
  int start;
  int val;

  ByTwos() {
    start = 0;
    val = 0;
  }

  // Implement the methods specified by Series.
  public int getNext() {
    val += 2;
    return val;
  }

  public void reset() {
    val = start;
  }

  public void setStart(int x) {
    start = x;
    val = x;
  }
}

// -----------------------------------------

// Demonstrate the use of Series.
class SeriesDemo {
  public static void main(String[] args) {
    ByTwos ob = new ByTwos();

    for(int i=0; i < 5; i++)
      System.out.println("Next value is " + ob.getNext());

    System.out.println("\nResetting");
    ob.reset();
    for(int i=0; i < 5; i++)
      System.out.println("Next value is " + ob.getNext());

    System.out.println("\nStarting at 100");
    ob.setStart(100);
    for(int i=0; i < 5; i++)
      System.out.println("Next value is " + ob.getNext());
  }
}

// -----------------------------------------

// Implement Series and add getPriorVal().
class ByTwos implements Series {
  int start;
  int val;
  int priorVal;

  ByTwos() {
    start = 0;
    val = 0;
    priorVal = -2;
  }

  // Implement the methods specified by Series.
  public int getNext() {
    priorVal = val;
    val += 2;
    return val;
  }

  public void reset() {
    val = start;
    priorVal = start - 2;
  }

  public void setStart(int x) {
    start = x;
    val = x;
    priorVal = x - 2;
  }

  // Return the previous value. This method is not
  // defined by Series.
  int getPriorVal() {
    return priorVal;
  }
}

// -----------------------------------------

// Implement Series a different way.
class ByThrees implements Series {
  int start;
  int val;

  ByThrees() {
    start = 0;
    val = 0;
  }

  // Implement the methods specified by Series.
  public int getNext() {
    val += 3;
    return val;
  }

  public void reset() {
    val = start;
  }

  public void setStart(int x) {
    start = x;
    val = x;
  }
}

// -----------------------------------------

class SeriesDemo2 {
  public static void main(String[] args) {
    ByTwos twoOb = new ByTwos();
    ByThrees threeOb = new ByThrees();

    Series iRef; // an interface reference

    for(int i=0; i < 5; i++) {
      iRef = twoOb; // refers to a ByTwos object
      System.out.println("Next ByTwos value is " +
                         iRef.getNext());
      iRef = threeOb; // refers to a ByThrees object
      System.out.println("Next ByThrees value is " +
                         iRef.getNext());
    }
  }
}

// -----------------------------------------

class Simulation {
  // numSeq refers to the number series generator
  // that will be used by the simulation.
  Series numSeq;

  // Pass the number series generator that will be used
  // by the instance of Simulation being constructed.
  Simulation(Series s) {
    numSeq = s;
  }

  // ...
}

// -----------------------------------------

interface IfA {
  void doSomething();
}

interface IfB {
  void doSomethingElse();
}

// Implement both IfA and IfB.
class MyClass implements IfA, IfB {
  public void doSomething() {
    System.out.println("Doing something.");
  }

  public void doSomethingElse() {
    System.out.println("Doing something else.");
  }
}

// -----------------------------------------

// Both IfA and IfB declare the method doSomething().
interface IfA {
  void doSomething();
}

interface IfB {
  void doSomething();
}

// Implement both IfA and IfB
class MyClass implements IfA, IfB {

  // This method implements both IfA and IfB.
  public void doSomething() {
    System.out.println("Doing something.");
  }
}

class MultiImpDemo {
  public static void main(String[] args) {
    IfA aRef;
    IfB bRef;
    MyClass obj = new MyClass();

    // Both interfaces use the same doSomething().
    aRef = obj;
    aRef.doSomething();

    bRef = obj;
    bRef.doSomething();
  }
}

// -----------------------------------------

// An interface for a simple stack that stores characters.
public interface ISimpleStack {

  // Push a character onto the stack.
  void push(char ch);

  // Pop a character from the stack.
  char pop();

  // Return true if the stack is empty.
  boolean isEmpty();

  // Return true if the stack is full.
  boolean isFull();
}

// A fixed-length stack for characters.
class FixedLengthStack implements ISimpleStack {
  private char[] data; // this array holds the stack
  private int tos; // index of top of stack

  // Construct an empty stack given its size.
  FixedLengthStack(int size) {
    data = new char[size]; // create the array to hold the stack
    tos = 0;
  }

  // Construct a stack from a stack.
  FixedLengthStack(FixedLengthStack otherStack) {
    // size of new stack equals that of otherStack
    data = new char[otherStack.data.length];

    // set tos to the same position
    tos = otherStack.tos;

    // copy the contents
    for(int i = 0; i < tos; i++)
      data[i] = otherStack.data[i];
  }

  // Construct a stack with initial values.
  FixedLengthStack(char[] chrs) {
    // create the array to hold the initial values
    data = new char[chrs.length];
    tos = 0;

    // initialize the stack by pushing the contents
    // of chrs onto it
    for(char ch : chrs)
      push(ch);
  }

  // Push a character onto the stack.
  public void push(char ch) {
    if(isFull()) {
      System.out.println(" -- Stack is full.");
      return;
    }

    data[tos] = ch;
    tos++;
  }

  // Pop a character from the stack.
  public char pop() {
    if(isEmpty()) {
      System.out.println(" -- Stack is empty.");
      return (char) 0; // a placeholder value
    }

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

// A growable stack for characters.
class DynamicStack implements ISimpleStack {
  private char[] data; // this array holds the stack
  private int tos; // index of top of stack

  // Construct an empty stack given its size.
  DynamicStack(int size) {
    data = new char[size]; // create the array to hold the stack
    tos = 0;
  }

  // Construct a stack from a stack.
  DynamicStack(DynamicStack otherStack) {
    // size of new stack equals that of otherStack
    data = new char[otherStack.data.length];

    // set tos to the same position
    tos = otherStack.tos;

    // copy the contents
    for(int i = 0; i < tos; i++)
      data[i] = otherStack.data[i];
  }

  // Construct a stack with initial values.
  DynamicStack(char[] chrs) {
    // create the array to hold the initial values
    data = new char[chrs.length];
    tos = 0;

    // initialize the stack by pushing the contents
    // of chrs onto it
    for(char ch : chrs)
      push(ch);
  }

  // Push a character onto the stack.
  public void push(char ch) {

    // if there is no more room in the array,
    // expand the size of the stack
    if(tos == data.length) {
      // double the size of the existing array
      char[] t = new char[data.length * 2];

      // copy the contents of the stack into the larger array
      for(int i = 0; i < tos; i++)
        t[i] = data[i];

      // set data to refer to the new array
      data = t;
    }

    data[tos] = ch;
    tos++;
  }

  // Pop a character from the stack.
  public char pop() {
    if(isEmpty()) {
      System.out.println(" -- Stack is empty.");
      return (char) 0; // a placeholder value
    }

    tos--;
    return data[tos];
  }

  // Return true if the stack is empty.
  public boolean isEmpty() {
    return tos==0;
  }

  // Return true if the stack is full. For DynamicStack,
  // this method always returns false.
  public boolean isFull() {
    return false;
  }
}

// Demonstrate ISimpleStack.
class ISimpleStackDemo {
  public static void main(String[] args) {
    int i;
    char ch;

    // create an ISimpleStack interface variable
    ISimpleStack iStack;

    // Now, construct a FixedLengthStack and a DynamicStack
    FixedLengthStack fixedStack = new FixedLengthStack(10);
    DynamicStack dynStack = new DynamicStack(5);

    // first, use fixedStack through iStack
    iStack = fixedStack;

    // push characters onto fixedStack
    for(i = 0; !iStack.isFull(); i++)
      iStack.push((char) ('A'+i));

    // pop characters off fixedStack
    System.out.print("Contents of fixedStack: ");
    while(!iStack.isEmpty()) {
      ch = iStack.pop();
      System.out.print(ch);
    }

    System.out.println();

    // next, use dynStack through iStack
    iStack = dynStack;

    // push A through Z onto dynStack
    // this will result in three increases in its size
    for(i = 0; i < 26; i++)
      iStack.push((char) ('A'+i));

    // pop characters off dynStack
    System.out.print("Contents of dynStack: ");
    while(!iStack.isEmpty()) {
      ch = iStack.pop();
      System.out.print(ch);
    }
  }
}

// -----------------------------------------

// An interface that contains constants.
interface IConst {
  int MIN = 0;
  int MAX = 10;
  String ERRORMSG = "Boundary Error";
}

// Gain access to the constants by implementing IConst.
class IConstDemo implements IConst {
  public static void main(String[] args) {
    int[] nums = new int[MAX];

    for(int i=MIN; i < (MAX + 1); i++) {
      if(i >= MAX) System.out.println(ERRORMSG);
      else {
        nums[i] = i;
        System.out.print(nums[i] + " ");
      }
    }
  }
}

// -----------------------------------------

// One interface can extend another.
interface A {
  void meth1();
  void meth2();
}

// B inherits meth1() and meth2() - it adds meth3().
interface B extends A {
  void meth3();
}

// This class must implement all of A and B.
class MyClass implements B {
  public void meth1() {
    System.out.println("Implement meth1().");
  }

  public void meth2() {
    System.out.println("Implement meth2().");
  }

  public void meth3() {
    System.out.println("Implement meth3().");
  }
}

class IFExtend {
  public static void main(String[] args) {
    MyClass ob = new MyClass();

    ob.meth1();
    ob.meth2();
    ob.meth3();
  }
}

// -----------------------------------------

// A nested interface example.

// This interface contains a nested interface.
interface A {
  // this is a nested interface
  public interface NestedIF {
    boolean isNotNegative(int x);
  }

  void doSomething();
}

// This class implements the nested interface.
class B implements A.NestedIF {
  public boolean isNotNegative(int x) {
    return x < 0 ? false: true;
  }
}

class NestedIFDemo {
  public static void main(String[] args) {

    // use a nested interface reference
    A.NestedIF nif = new B();

    if(nif.isNotNegative(10))
      System.out.println("10 is not negative");
    if(nif.isNotNegative(-12))
      System.out.println("this won't be displayed");
  }
}