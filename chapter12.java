// Create a thread by implementing Runnable.

class MyThread implements Runnable {
  String thrdName;

  MyThread(String name) {
    thrdName = name;
  }

  // Entry point of thread.
  public void run() {
    System.out.println(thrdName + " starting.");
    try {
      for(int count=0; count < 10; count++) {
        Thread.sleep(400);
        System.out.println("In " + thrdName +
                           ", count is " + count);
      }
    }
    catch(InterruptedException exc) {
      System.out.println(thrdName + " interrupted.");
    }
    System.out.println(thrdName + " terminating.");
  }
}

class UseThreads {
  public static void main(String[] args) {
    System.out.println("Main thread starting.");

    // First, construct a MyThread object.
    MyThread mt = new MyThread("Child #1");

    // Next, construct a thread from that object.
    Thread newThrd = new Thread(mt);

    // Finally, start execution of the thread.
    newThrd.start();

    for(int i=0; i < 50; i++) {
      System.out.print(".");
      try {
        Thread.sleep(100);
      }
      catch(InterruptedException exc) {
        System.out.println("Main thread interrupted.");
      }
    }

    System.out.println("Main thread ending.");
  }
}

// -----------------------------------------

// Improved MyThread.

class MyThread implements Runnable {
  Thread thrd;

  // Construct a new thread.
  MyThread(String name) {
    thrd = new Thread(this, name);
    thrd.start(); // start the thread
  }

  // Begin execution of new thread.
  public void run() {
    System.out.println(thrd.getName() + " starting.");
    try {
      for(int count=0; count < 10; count++) {
        Thread.sleep(400);
        System.out.println("In " + thrd.getName() +
                           ", count is " + count);
      }
    }
    catch(InterruptedException exc) {
      System.out.println(thrd.getName() + " interrupted.");
    }
    System.out.println(thrd.getName() + " terminating.");
  }
}

class UseThreadsImproved {
  public static void main(String[] args) {
    System.out.println("Main thread starting.");

    MyThread mt = new MyThread("Child #1");

    for(int i=0; i < 50; i++) {
      System.out.print(".");
      try {
        Thread.sleep(100);
      }
      catch(InterruptedException exc) {
        System.out.println("Main thread interrupted.");
      }
    }

    System.out.println("Main thread ending.");
  }
}

// -----------------------------------------

/*
   Try This 12-1

   Extend Thread.
*/
class MyThread extends Thread {

  // Construct a new thread.
  MyThread(String name) {
    super(name); // name thread
    start(); // start the thread
  }

  // Begin execution of new thread.
  public void run() {
    System.out.println(getName() + " starting.");
    try {
      for(int count=0; count < 10; count++) {
        Thread.sleep(400);
        System.out.println("In " + getName() +
                           ", count is " + count);
      }
    }
    catch(InterruptedException exc) {
      System.out.println(getName() + " interrupted.");
    }

    System.out.println(getName() + " terminating.");
  }
}

class ExtendThread {
  public static void main(String[] args) {
    System.out.println("Main thread starting.");

    MyThread mt = new MyThread("Child #1");

    for(int i=0; i < 50; i++) {
      System.out.print(".");
      try {
        Thread.sleep(100);
      }
      catch(InterruptedException exc) {
        System.out.println("Main thread interrupted.");
      }
    }

    System.out.println("Main thread ending.");
  }
}

// -----------------------------------------

// Create multiple threads.

class MyThread implements Runnable {
  Thread thrd;

  // Construct a new thread.
  MyThread(String name) {
    thrd = new Thread(this, name);

    thrd.start(); // start the thread
  }

  // Begin execution of new thread.
  public void run() {
    System.out.println(thrd.getName() + " starting.");
    try {
      for(int count=0; count < 10; count++) {
        Thread.sleep(400);
        System.out.println("In " + thrd.getName() +
                           ", count is " + count);
      }
    }
    catch(InterruptedException exc) {
      System.out.println(thrd.getName() + " interrupted.");
    }
    System.out.println(thrd.getName() + " terminating.");
  }
}

class MoreThreads {
  public static void main(String[] args) {
    System.out.println("Main thread starting.");

    MyThread mt1 = new MyThread("Child #1");
    MyThread mt2 = new MyThread("Child #2");
    MyThread mt3 = new MyThread("Child #3");

    for(int i=0; i < 50; i++) {
      System.out.print(".");
      try {
        Thread.sleep(100);
      }
      catch(InterruptedException exc) {
        System.out.println("Main thread interrupted.");
      }
    }

    System.out.println("Main thread ending.");
  }
}

// -----------------------------------------

// Use isAlive().
class MoreThreads {
  public static void main(String[] args) {
    System.out.println("Main thread starting.");

    MyThread mt1 = new MyThread("Child #1");
    MyThread mt2 = new MyThread("Child #2");
    MyThread mt3 = new MyThread("Child #3");

    do {
      System.out.print(".");
      try {
        Thread.sleep(100);
      }
      catch(InterruptedException exc) {
        System.out.println("Main thread interrupted.");
      }
    } while (mt1.thrd.isAlive() ||
             mt2.thrd.isAlive() ||
             mt3.thrd.isAlive());

    System.out.println("Main thread ending.");
  }
}

// -----------------------------------------

// Use join().

class MyThread implements Runnable {
  Thread thrd;

  // Construct a new thread.
  MyThread(String name) {
    thrd = new Thread(this, name);
    thrd.start(); // start the thread
  }

  // Begin execution of new thread.
  public void run() {
    System.out.println(thrd.getName() + " starting.");
    try {
      for(int count=0; count < 10; count++) {
        Thread.sleep(400);
        System.out.println("In " + thrd.getName() +
                           ", count is " + count);
      }
    }
    catch(InterruptedException exc) {
      System.out.println(thrd.getName() + " interrupted.");
    }
    System.out.println(thrd.getName() + " terminating.");
  }
}

class JoinThreads {
  public static void main(String[] args) {
    System.out.println("Main thread starting.");

    MyThread mt1 = new MyThread("Child #1");
    MyThread mt2 = new MyThread("Child #2");
    MyThread mt3 = new MyThread("Child #3");

    try {
      mt1.thrd.join();
      System.out.println("Child #1 joined.");
      mt2.thrd.join();
      System.out.println("Child #2 joined.");
      mt3.thrd.join();
      System.out.println("Child #3 joined.");
    }
    catch(InterruptedException exc) {
      System.out.println("Main thread interrupted. ");
    }
    System.out.println("Main thread ending.");
  }
}

// -----------------------------------------

// Use synchronize to control access.

class SumArray {
  private int sum;

  synchronized int sumArray(int[] nums) {
    sum = 0; // reset sum

    for(int i=0; i<nums.length; i++) {
      sum += nums[i];
      System.out.println("Running total for " +
             Thread.currentThread().getName() +
             " is " + sum);
      try {
        Thread.sleep(10); // allow task-switch
      }
      catch(InterruptedException exc) {
        System.out.println("Thread interrupted.");
      }
    }
    return sum;
  }
}

class MyThread implements Runnable {
  Thread thrd;
  static SumArray sa = new SumArray();
  int[] a;
  int answer;

  // Construct a new thread.
  MyThread(String name, int[] nums) {
    thrd = new Thread(this, name);
    a = nums;
    thrd.start(); // start the thread
  }

  // Begin execution of new thread.
  public void run() {
    int sum;

    System.out.println(thrd.getName() + " starting.");

    answer = sa.sumArray(a);
    System.out.println("Sum for " + thrd.getName() +
                       " is " + answer);

    System.out.println(thrd.getName() + " terminating.");
  }
}

class Sync {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};

    MyThread mt1 = new MyThread("Child #1", a);
    MyThread mt2 = new MyThread("Child #2", a);

    try {
      mt1.thrd.join();
      mt2.thrd.join();
    }
    catch(InterruptedException exc) {
      System.out.println("Main thread interrupted.");
    }
  }
}

// -----------------------------------------

// Use a synchronized block to control access to SumArray.
class SumArray {
  private int sum;

  int sumArray(int[] nums) {
    sum = 0; // reset sum

    for(int i=0; i<nums.length; i++) {
      sum += nums[i];
      System.out.println("Running total for " +
             Thread.currentThread().getName() +
             " is " + sum);
      try {
        Thread.sleep(10); // allow task-switch
      }
      catch(InterruptedException exc) {
        System.out.println("Thread interrupted.");
      }
    }
    return sum;
  }
}

class MyThread implements Runnable {
  Thread thrd;
  static SumArray sa = new SumArray();
  int[] a;
  int answer;

  // Construct a new thread.
  MyThread(String name, int[] nums) {
    thrd = new Thread(this, name);
    a = nums;
    thrd.start(); // start the thread
  }

  // Begin execution of new thread.
  public void run() {
    System.out.println(thrd.getName() + " starting.");

    // synchronize calls to sumArray()
    synchronized(sa) {
      answer = sa.sumArray(a);
    }
    System.out.println("Sum for " + thrd.getName() +
                       " is " + answer);

    System.out.println(thrd.getName() + " terminating.");
  }
}

class Sync {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};

    MyThread mt1 = new MyThread("Child #1", a);
    MyThread mt2 = new MyThread("Child #2", a);

    try {
      mt1.thrd.join();
      mt2.thrd.join();
    } catch(InterruptedException exc) {
      System.out.println("Main Thread interrupted.");
    }
  }
}

// -----------------------------------------

// Use wait() and notify() to create a ticking clock.

class TickTock {

  String state; // contains the state of the clock

  synchronized void tick(boolean running) {
    if(!running) { // stop the clock
      state = "ticked";
      notify(); // notify any waiting threads
      return;
    }

    System.out.print("Tick ");

    state = "ticked"; // set the current state to ticked

    notify(); // let tock() run
    try {
      while(!state.equals("tocked"))
        wait(); // wait for tock() to complete
    }
    catch(InterruptedException exc) {
      System.out.println("Thread interrupted.");
    }
  }

  synchronized void tock(boolean running) {
    if(!running) { // stop the clock
      state = "tocked";
      notify(); // notify any waiting threads
      return;
    }

    System.out.println("Tock");

    state = "tocked"; // set the current state to tocked

    notify(); // let tick() run
    try {
      while(!state.equals("ticked"))
        wait(); // wait for tick to complete
    }
    catch(InterruptedException exc) {
      System.out.println("Thread interrupted.");
    }
  }
}

class MyThread implements Runnable {
  Thread thrd;
  TickTock ttOb;

  // Construct a new thread.
  MyThread(String name, TickTock tt) {
    thrd = new Thread(this, name);
    ttOb = tt;
    thrd.start(); // start the thread
  }

  // Begin execution of new thread.
  public void run() {

    if(thrd.getName().compareTo("Tick") == 0) {
      for(int i=0; i<5; i++) ttOb.tick(true);
      ttOb.tick(false);
    }
    else {
      for(int i=0; i<5; i++) ttOb.tock(true);
      ttOb.tock(false);
    }
  }
}

class ThreadCom {
  public static void main(String[] args) {
    TickTock tt = new TickTock();
    MyThread mt1 = new MyThread("Tick", tt);
    MyThread mt2 = new MyThread("Tock", tt);

    try {
      mt1.thrd.join();
      mt2.thrd.join();
    } catch(InterruptedException exc) {
      System.out.println("Main thread interrupted.");
    }
  }
}

// -----------------------------------------

// No calls to wait() or notify().
class TickTock {

  String state; // contains the state of the clock

  synchronized void tick(boolean running) {
    if(!running) { // stop the clock
      state = "ticked";
      return;
    }

    System.out.print("Tick ");

    state = "ticked"; // set the current state to ticked
  }

  synchronized void tock(boolean running) {
    if(!running) { // stop the clock
      state = "tocked";
      return;
    }

    System.out.println("Tock");

    state = "tocked"; // set the current state to tocked
  }
}

// -----------------------------------------

// Suspending, resuming, and stopping a thread.

class MyThread implements Runnable {
  Thread thrd;

  boolean suspended;
  boolean stopped;

  MyThread(String name) {
    thrd = new Thread(this, name);
    suspended = false;
    stopped = false;
    thrd.start();
  }

  // This is the entry point for thread.
  public void run() {
    System.out.println(thrd.getName() + " starting.");
    try {
      for(int i = 1; i < 1000; i++) {
        System.out.print(i + " ");
        if((i%10)==0) {
          System.out.println();
          Thread.sleep(250);
        }

        // Use synchronized block to check suspended and stopped.
        synchronized(this) {
          while(suspended) {
            wait();
          }
          if(stopped) break;
        }
      }
    } catch (InterruptedException exc) {
      System.out.println(thrd.getName() + " interrupted.");
    }
    System.out.println(thrd.getName() + " exiting.");
  }

  // Stop the thread.
  synchronized void myStop() {
    stopped = true;

    // The following ensures that a suspended thread can be stopped.
    suspended = false;
    notify();
  }

  // Suspend the thread.
  synchronized void mySuspend() {
    suspended = true;
  }

  // Resume the thread.
  synchronized void myResume() {
    suspended = false;
    notify();
  }
}

class Suspend {
  public static void main(String[] args) {
    MyThread ob1 = new MyThread("My Thread");

    try {
      Thread.sleep(1000); // let ob1 thread start executing

      ob1.mySuspend();
      System.out.println("Suspending thread.");
      Thread.sleep(1000);

      ob1.myResume();
      System.out.println("Resuming thread.");
      Thread.sleep(1000);

      ob1.mySuspend();
      System.out.println("Suspending thread.");
      Thread.sleep(1000);

      ob1.myResume();
      System.out.println("Resuming thread.");
      Thread.sleep(1000);

      ob1.mySuspend();
      System.out.println("Stopping thread.");
      ob1.myStop();
    } catch (InterruptedException e) {
      System.out.println("Main thread Interrupted");
    }

    // wait for thread to finish
    try {
      ob1.thrd.join();
    } catch (InterruptedException e) {
      System.out.println("Main thread Interrupted");
    }

    System.out.println("Main thread exiting.");
  }
}

// -----------------------------------------

/*
   Try This 12-2

   Controlling the main thread.
*/

class UseMain {
  public static void main(String[] args) {
    Thread thrd;

    // Get the main thread.
    thrd = Thread.currentThread();

    // Display main thread's name.
    System.out.println("Main thread is called: " +
                       thrd.getName());

    // Display main thread's priority.
    System.out.println("Priority: " +
                       thrd.getPriority());

    System.out.println();

    // Set the name.
    System.out.println("Setting name.\n");
    thrd.setName("Thread #1");

    System.out.println("Main thread is now called: " +
                       thrd.getName());
  }
}
