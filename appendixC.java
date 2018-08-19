/*
  Compute your weight on the moon.

  Call this file Moon.java.
*/
class Moon {
  public static void main(String[] args) {
    double earthWeight; // weight on earth
    double moonWeight; // weight on moon

    earthWeight = 165;

    moonWeight = earthWeight * 0.17;

    System.out.println(earthWeight +
                       " earth-pounds is equivalent to " +
                       moonWeight + " moon-pounds.");
  }
}

// -----------------------------------------

/*
  This program displays a conversion
  table of inches to meters.

  Call this program InchToMeterTable.java.
*/
class InchToMeterTable {
  public static void main(String[] args) {
    double inches, meters;
    int counter;

    counter = 0;
    for(inches = 1; inches <= 144; inches++) {
      meters = inches / 39.37; // convert to meters
      System.out.println(inches + " inches is " +
          meters + " meters.");
      counter++;

      // every 12th line, print a blank line
      if(counter == 12) {
        System.out.println();
        counter = 0; // reset the line counter
      }
    }
  }
}

// -----------------------------------------

// Find prime numbers between 2 and 100.
class Prime {
  public static void main(String[] args) {
    int i, j;
    boolean isprime;

    for(i=2; i < 100; i++) {
      isprime = true;

      // see if the number is evenly divisible
      for(j=2; j <= i/j; j++)
        // if it is, then it's not prime
        if((i%j) == 0) isprime = false;

      if(isprime)
        System.out.println(i + " is prime.");
    }
  }
}

// -----------------------------------------

// Count spaces.
class Spaces {
  public static void main(String[] args)
      throws java.io.IOException {

    char ch;
    int spaces = 0;

    System.out.println("Enter a period to stop.");

    do {
      ch = (char) System.in.read();
      if(ch == ' ') spaces++;
    } while(ch != '.');

    System.out.println("Spaces: " + spaces);
  }
}

// -----------------------------------------

/* Use a for loop to generate the progression

   1 2 4 8 16 32 64
*/
class Progress {
  public static void main(String[] args) {

    for(int i = 1; i < 100; i += i)
      System.out.print(i + " ");
  }
}

// -----------------------------------------

// Change case.
class CaseChg {
  public static void main(String[] args)
      throws java.io.IOException {

    char ch;
    int changes = 0;

    System.out.println("Enter period to stop.");

    do {
      ch = (char) System.in.read();
      if(ch >= 'a' & ch <= 'z') {
        ch -= 32;
        changes++;
        System.out.println(ch);
      }
      else if(ch >= 'A' & ch <= 'Z') {
        ch += 32;
        changes++;
        System.out.println(ch);
      }
    } while(ch != '.');
    System.out.println("Case changes: " + changes);
  }
}

// -----------------------------------------

// Average 10 double values.
class Avg {
  public static void main(String[] args) {
    double[] nums = { 1.1, 2.2, 3.3, 4.4, 5.5,
                      6.6, 7.7, 8.8, 9.9, 10.1 };
    double sum = 0;

    for(int i=0; i < nums.length; i++)
      sum += nums[i];

    System.out.println("Average: " + sum / nums.length);
  }
}

// -----------------------------------------

// Demonstrate the Bubble sort with strings.
class StrBubble {
  public static void main(String[] args) {
    String[] strs = {
                    "this", "is", "a", "test",
                    "of", "a", "string", "sort"
                    };
    int a, b;
    String t;
    int size;

    size = strs.length; // number of elements to sort

    // display original array
    System.out.print("Original array is:");
    for(int i=0; i < size; i++)
      System.out.print(" " + strs[i]);
    System.out.println();

    // This is the bubble sort for strings.
    for(a=1; a < size; a++)
      for(b=size-1; b >= a; b--) {
        if(strs[b-1].compareTo(strs[b]) > 0) { // if out of order
          // exchange elements
          t = strs[b-1];
          strs[b-1] = strs[b];
          strs[b] = t;
        }
      }

    // display sorted array
    System.out.print("Sorted array is:");
    for(int i=0; i < size; i++)
      System.out.print(" " + strs[i]);
    System.out.println();
  }
}

// -----------------------------------------

// An improved XOR cipher.
class SimpleCipher2 {
  public static void main(String[] args) {
    String msg = "This is a test";
    String encMsg = "";
    String decMsg = "";
    String key = "abcdefgi";
    int j;

    System.out.print("Original message: ");
    System.out.println(msg);

    // encode the message
    j = 0;
    for(int i=0; i < msg.length(); i++) {
      encMsg = encMsg + (char) (msg.charAt(i) ^ key.charAt(j));
      j++;
      if(j==8) j = 0;
    }

    System.out.print("Encoded message: ");
    System.out.println(encMsg);

    // decode the message
    j = 0;
    for(int i=0; i < msg.length(); i++) {
      decMsg = decMsg + (char) (encMsg.charAt(i) ^ key.charAt(j));
      j++;
      if(j==8) j = 0;
    }

    System.out.print("Decoded message: ");
    System.out.println(decMsg);
  }
}

// -----------------------------------------

// Find the minimum and maximum values in an array.
class MinMax {
  public static void main(String[] args) {
    int[] nums = new int[10];
    int min, max;

    nums[0] = 99;
    nums[1] = -10;
    nums[2] = 100123;
    nums[3] = 18;
    nums[4] = -978;
    nums[5] = 5623;
    nums[6] = 463;
    nums[7] = -9;
    nums[8] = 287;
    nums[9] = 49;

    min = max = nums[0];
    for(int v : nums) {
      if(v < min) min = v;
      if(v > max) max = v;
    }
    System.out.println("min and max: " + min + " " + max);
  }
}

// -----------------------------------------

// Display a string backwards using recursion.
class Backwards {
  String str;

  Backwards(String s) {
    str = s;
  }

  void backward(int idx) {
    if(idx != str.length()-1) backward(idx+1);

    System.out.print(str.charAt(idx));
  }
}

class BWDemo {
  public static void main(String[] args) {
    Backwards s = new Backwards("This is a test");

    s.backward(0);
  }
}

// -----------------------------------------

class SumIt {
  int sum(int ... n) {
    int result = 0;

    for(int i = 0; i < n.length; i++)
      result += n[i];
    return result;
  }
}

class SumDemo {
  public static void main(String[] args) {

    SumIt siObj = new SumIt();

    int total = siObj.sum(1, 2, 3);
    System.out.println("Sum is " + total);

    total = siObj.sum(1, 2, 3, 4, 5);
    System.out.println("Sum is " + total);
  }
}

// -----------------------------------------

// A subclass of TwoDShape for circles.
class Circle extends TwoDShape {
  // A default constructor.
  Circle() {
    super();
  }

  // Construct Circle
  Circle(double x) {
    super(x, "circle"); // call superclass constructor
  }

  // Construct an object from an object.
  Circle(Circle ob) {
    super(ob); // pass object to TwoDShape constructor
  }

  double area() {
    return (getWidth() / 2) * (getWidth() / 2) * 3.1416;
  }
}

// -----------------------------------------

interface IVehicle {

  // Return the range.
  int range();

  // Compute fuel needed for a given distance.
  double fuelNeeded(int miles);

  // Accessor methods
  int getPassengers();
  void setPassengers(int p);
  int getFuelCap();
  void setFuelCap(int f);
  int getMpg();
  void setMpg(int m);
}

// -----------------------------------------

/* Copy a text file, substituting hyphens for spaces.

   This version uses byte streams.

   To use this program, specify the name
   of the source file and the destination file.
   For example,

   java Hyphen source target
*/

import java.io.*;

class Hyphen {
  public static void main(String[] args)
  {
    int i;
    FileInputStream fin = null;
    FileOutputStream fout = null;

    // First make sure that both files have been specified.
    if(args.length !=2 ) {
      System.out.println("Usage: Hyphen From To");
      return;
    }

    // Copy file and substitute hyphens.
    try {
      fin = new FileInputStream(args[0]);
      fout = new FileOutputStream(args[1]);

      do {
        i = fin.read();

        // convert space to a hyphen
        if((char)i == ' ') i = '-';

        if(i != -1) fout.write(i);
      } while(i != -1);
    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    } finally {
      try {
        if(fin != null) fin.close();
      } catch(IOException exc) {
        System.out.println("Error closing input file.");
      }

      try {
        if(fin != null) fout.close();
      } catch(IOException exc) {
        System.out.println("Error closing output file.");
      }
    }
  }
}

// -----------------------------------------

/* Copy a text file, substituting hyphens for spaces.

   This version uses character streams.

   To use this program, specify the name
   of the source file and the destination file.
   For example,

   java Hyphen2 source target

   This code requires JDK 7 or later.
*/

import java.io.*;

class Hyphen2 {
  public static void main(String[] args)
  {
    int i;

    // First make sure that both files have been specified.
    if(args.length !=2 ) {
      System.out.println("Usage: CopyFile From To");
      return;
    }

    // Copy file and substitute hyphens.
    // Use the try-with-resources statement.
    try (FileReader fin = new FileReader(args[0]);
         FileWriter fout = new FileWriter(args[1]))
    {
      do {
        i = fin.read();

        // convert space to a hyphen
        if((char)i == ' ') i = '-';

        if(i != -1) fout.write(i);
      } while(i != -1);
    } catch(IOException exc) {
      System.out.println("I/O Error: " + exc);
    }
  }
}

// -----------------------------------------

// Make the TickTock class actually keep time.

class TickTock {

  String state; // contains the state of the clock

  synchronized void tick(boolean running) {
    if(!running) { // stop the clock
      state = "ticked";
      notify(); // notify any waiting threads
      return;
    }

    System.out.print("Tick ");

    // wait 1/2 second
    try {
      Thread.sleep(500);
    } catch(InterruptedException exc) {
      System.out.println("Thread interrupted.");
    }

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

    // wait 1/2 second
    try {
      Thread.sleep(500);
    } catch(InterruptedException exc) {
      System.out.println("Thread interrupted.");
    }

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

// -----------------------------------------

enum Tools {
  SCREWDRIVER, WRENCH, HAMMER, PLIERS
}

class ShowEnum {
  public static void main(String[] args) {
    for(Tools d : Tools.values())
      System.out.print(d + " has ordinal value of " +
                       d.ordinal() + '\n');
  }
}

// -----------------------------------------

// An improved version of the traffic light simulation that
// stores the light delay in TrafficLightColor.

// An enumeration of the colors of a traffic light.
enum TrafficLightColor {
  RED(12000), GREEN(10000), YELLOW(2000);

  private int delay;

  TrafficLightColor(int d) {
    delay = d;
  }

  int getDelay() { return delay; }
}

// A computerized traffic light.
class TrafficLightSimulator implements Runnable {
  private Thread thrd; // holds the thread that runs the simulation
  private TrafficLightColor tlc; // holds the current traffic light color
  boolean stop = false; // set to true to stop the simulation
  boolean changed = false; // true when the light has changed

  TrafficLightSimulator(TrafficLightColor init) {
    tlc = init;

    thrd = new Thread(this);
    thrd.start();
  }

  TrafficLightSimulator() {
    tlc = TrafficLightColor.RED;

    thrd = new Thread(this);
    thrd.start();
  }

  // Start up the light.
  public void run() {
    while(!stop) {
      // Notice how this code has been simplified!
      try {
        Thread.sleep(tlc.getDelay());
      } catch(InterruptedException exc) {
        System.out.println(exc);
      }

      changeColor();
    }
  }

  // Change color.
  synchronized void changeColor() {
    switch(tlc) {
      case RED:
        tlc = TrafficLightColor.GREEN;
        break;
      case YELLOW:
        tlc = TrafficLightColor.RED;
        break;
      case GREEN:
        tlc = TrafficLightColor.YELLOW;
    }

    changed = true;
    notify(); // signal that the light has changed
  }

  // Wait until a light change occurs.
  synchronized void waitForChange() {
    try {
      while(!changed)
        wait(); // wait for light to change
      changed = false;
    } catch(InterruptedException exc) {
      System.out.println(exc);
    }
  }

  // Return current color.
  synchronized TrafficLightColor getColor() {
    return tlc;
  }

  // Stop the traffic light.
  synchronized void cancel() {
    stop = true;
  }
}

class TrafficLightDemo {
  public static void main(String[] args) {
    TrafficLightSimulator tl =
      new TrafficLightSimulator(TrafficLightColor.GREEN);

    for(int i=0; i < 9; i++) {
      System.out.println(tl.getColor());
      tl.waitForChange();
    }

    tl.cancel();
  }
}

// -----------------------------------------

/* A simple banner applet that uses parameters.
*/
import java.awt.*;
import java.applet.*;

/*
<applet code="ParamBanner" width=300 height=50>
<param name=message value=" I like Java! ">
<param name=delay value=500>
</applet>
*/

public class ParamBanner extends Applet implements Runnable {
  String msg;
  int delay;
  Thread t;

  boolean stopFlag;

  // Initialize t to null.
  public void init() {
    String temp;

    msg = getParameter("message");
    if(msg == null) msg = " Java Rules the Web ";

    temp = getParameter("delay");

    try {
      if(temp != null)
        delay = Integer.parseInt(temp);
      else
        delay = 250; // default if not specified
    } catch(NumberFormatException exc) {
      delay = 250 ; // default on error
    }

    t = null;
  }

  // Start thread when the applet is needed.
  public void start() {
    t = new Thread(this);
    stopFlag = false;
    t.start();
  }

  // Entry point for the thread that runs the banner.
  public void run() {
    // Request a repaint at the specified interval.
    for( ; ; ) {
      try {
        repaint();
        Thread.sleep(delay);
        if(stopFlag) break;
      } catch(InterruptedException exc) {}
    }
  }

  // Pause the banner.
  public void stop() {
    stopFlag = true;
    t = null;
  }

  // Display the banner.
  public void paint(Graphics g) {
    char ch;

    ch = msg.charAt(0);
    msg = msg.substring(1, msg.length());
    msg += ch;

    g.drawString(msg, 50, 30);
  }
}

// -----------------------------------------

// A simple clock applet.

import java.util.*;
import java.awt.*;
import java.applet.*;
/*
<object code="Clock" width=200 height=50>
</object>
*/

public class Clock extends Applet implements Runnable {
  String msg;
  Thread t;
  Calendar clock;

  boolean stopFlag;

  // Initialize
  public void init() {
    t = null;
    msg = "";
  }

  // Start thread when the applet is needed.
  public void start() {
    t = new Thread(this);
    stopFlag = false;
    t.start();
  }

  // Entry point for the clock.
  public void run() {
    // Request a repaint every second.
    for( ; ; ) {
      try {
        repaint();
        Thread.sleep(1000);
        if(stopFlag) break;
      } catch(InterruptedException exc) {}
    }
  }

  // Pause the clock.
  public void stop() {
    stopFlag = true;
    t = null;
  }

  // Display the clock.
  public void paint(Graphics g) {
    clock = Calendar.getInstance();

    msg = "Current time is " +
          Integer.toString(clock.get(Calendar.HOUR));
    msg = msg + ":" +
          Integer.toString(clock.get(Calendar.MINUTE));
    msg = msg + ":" +
          Integer.toString(clock.get(Calendar.SECOND));

    g.drawString(msg, 30, 30);
  }
}

// -----------------------------------------

// A version of the stopwatch for Try This 17-1 that
// uses a single push button.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class StopWatch implements ActionListener {

  JLabel jlab;
  long start; // holds the start time in milliseconds
  JButton jbtnStartStop; // a start or stop button

  StopWatch() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("A Simple Stopwatch");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(250, 90);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Make one button.
    jbtnStartStop = new JButton("Start");

    // Add action listeners.
    jbtnStartStop.addActionListener(this);

    // Add the buttons to the content pane.
    jfrm.add(jbtnStartStop);

    // Create a text-based label.
    jlab = new JLabel("Press Start to begin timing.");

    // Add the label to the frame.
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle button events.
  public void actionPerformed(ActionEvent ae) {
    // get the current system time
    Calendar cal = Calendar.getInstance();

    if(ae.getActionCommand().equals("Start")) {
      // Store start time.
      start = cal.getTimeInMillis();
      jlab.setText("Stopwatch is Running...");
      jbtnStartStop.setText("Stop");
    }
    else {
      // Compute the elapsed time.
      jlab.setText("Elapsed time is "
           + (double) (cal.getTimeInMillis() - start)/1000);
      jbtnStartStop.setText("Start");
    }
  }

  public static void main(String[] args) {

    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new StopWatch();
      }
    });
  }
}
// -----------------------------------------

// Menu demo program, final version.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuDemo implements ActionListener {

  JLabel jlab;
  JMenuBar jmb;

  MenuDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Menu Demo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(220, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will display the menu selection.
    jlab = new JLabel();

    // Create the menu bar.
    jmb = new JMenuBar();

    // Create the File menu.
    makeFileMenu();

    // Create the Options menu.
    makeOptionsMenu();

    // Create the Help menu.
    makeHelpMenu();

    // Add the label to the content pane.
    jfrm.add(jlab);

    // Add the menu bar to the frame.
    jfrm.setJMenuBar(jmb);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Create the File menu with mnemonics and accelerators.
  void makeFileMenu() {

    JMenu jmFile = new JMenu("File");
    jmFile.setMnemonic(KeyEvent.VK_F);

    JMenuItem jmiOpen = new JMenuItem("Open",
                                  KeyEvent.VK_O);
    jmiOpen.setAccelerator(
              KeyStroke.getKeyStroke(KeyEvent.VK_O,
                                 InputEvent.CTRL_DOWN_MASK));

    JMenuItem jmiClose = new JMenuItem("Close",
                                  KeyEvent.VK_C);
    jmiClose.setAccelerator(
               KeyStroke.getKeyStroke(KeyEvent.VK_C,
                                  InputEvent.CTRL_DOWN_MASK));

    JMenuItem jmiSave = new JMenuItem("Save",
                                  KeyEvent.VK_S);
    jmiSave.setAccelerator(
              KeyStroke.getKeyStroke(KeyEvent.VK_S,
                                 InputEvent.CTRL_DOWN_MASK));

    JMenuItem jmiExit = new JMenuItem("Exit",
                                  KeyEvent.VK_E);
    jmiExit.setAccelerator(
              KeyStroke.getKeyStroke(KeyEvent.VK_E,
                                 InputEvent.CTRL_DOWN_MASK));

    jmFile.add(jmiOpen);
    jmFile.add(jmiClose);
    jmFile.add(jmiSave);
    jmFile.addSeparator();
    jmFile.add(jmiExit);
    jmb.add(jmFile);

    jmiOpen.addActionListener(this);
    jmiClose.addActionListener(this);
    jmiSave.addActionListener(this);
    jmiExit.addActionListener(this);

  }

  // Create the Options menu.
  void makeOptionsMenu() {

    // Create the Options menu.
    JMenu jmOptions = new JMenu("Options");

    // Create the Colors submenu.
    JMenu jmColors = new JMenu("Colors");

    // Use check boxes for colors. This allows
    // the user to select more than one color.
    // Notice that Red is initially selected.
    JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red", true);
    JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
    JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");

    jmColors.add(jmiRed);
    jmColors.add(jmiGreen);
    jmColors.add(jmiBlue);
    jmOptions.add(jmColors);

    // Create the Priority submenu.
    JMenu jmPriority = new JMenu("Priority");

    // Use radio buttons for the priority setting.
    // This lets the menu show which priority is used
    // but also ensures that one and only one priority
    // can be selected at any one time. Notice that
    // the High radio button is initially selected.
    JRadioButtonMenuItem jmiHigh =
      new JRadioButtonMenuItem("High", true);
    JRadioButtonMenuItem jmiLow =
      new JRadioButtonMenuItem("Low");

    jmPriority.add(jmiHigh);
    jmPriority.add(jmiLow);
    jmOptions.add(jmPriority);

    // Create button group for the radio button menu items.
    ButtonGroup bg = new ButtonGroup();
    bg.add(jmiHigh);
    bg.add(jmiLow);

    // Create the Reset menu item.
    JMenuItem jmiReset = new JMenuItem("Reset");
    jmOptions.addSeparator();
    jmOptions.add(jmiReset);

    jmiRed.addActionListener(this);
    jmiGreen.addActionListener(this);
    jmiBlue.addActionListener(this);
    jmiHigh.addActionListener(this);
    jmiLow.addActionListener(this);
    jmiReset.addActionListener(this);

    // Finally, add the entire Options menu to
    // the menu bar
    jmb.add(jmOptions);
  }

  // Create the Help menu.
  void makeHelpMenu() {

    // Create the Help menu.
    JMenu jmHelp = new JMenu("Help");
    ImageIcon iconAbout = new ImageIcon("AboutIcon.gif");
    JMenuItem jmiAbout = new JMenuItem("About", iconAbout);
    jmiAbout.setToolTipText("Info about the MenuDemo program.");
    jmHelp.add(jmiAbout);
    jmb.add(jmHelp);

    jmiAbout.addActionListener(this);
  }

  // Handle menu item action events.
  public void actionPerformed(ActionEvent ae) {
    // Get the action command from the menu selection.
    String comStr = ae.getActionCommand();

    // If user chooses Exit, then exit the program.
    if(comStr.equals("Exit")) System.exit(0);

    // Otherwise, display the selection.
    jlab.setText(comStr + " Selected");
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MenuDemo();
      }
    });
  }
}

// -----------------------------------------

// Answer to question 9.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
This HTML can be used to launch the applet:
<object code="ScrollText" width=240 height=100>
</object>

*/

public class ScrollText extends JApplet {

  JLabel jlab;

  String msg = " Swing makes the GUI move! ";

  ActionListener scroller;

  Timer stTimer; // This timer controls the scroll rate.
  int counter; // use to reverse the scroll.

  // This value controls when the scroll direction changes.
  int scrollLimit;

  // Initialize the applet.
  public void init() {
    counter = 0;
    scrollLimit = 100;

    try {
      SwingUtilities.invokeAndWait(new Runnable () {
        public void run() {
          guiInit();
        }
      });
    } catch(Exception exc) {
      System.out.println("Can't create because of " + exc);
    }
  }

  // Start the timer when the applet is started.
  public void start() {
    stTimer.start();
  }

  // Stop the timer when the applet is stopped.
  public void stop() {
    stTimer.stop();
  }

  // Stop the timer when the applet is destroyed.
  public void destroy() {
    stTimer.stop();
  }

  // Initialize the timer GUI.
  private void guiInit() {

    // Create the label that will scroll the message.
    jlab = new JLabel(msg);
    jlab.setHorizontalAlignment(SwingConstants.CENTER);

    // Create the action listener for the timer.
    // This version reverse the direction of scroll
    // every 20 seconds.
    scroller = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if(counter < scrollLimit) {
          // Left-scroll the message one character.
          char ch = msg.charAt(0);
          msg = msg.substring(1, msg.length());
          msg += ch;
        } else {
          // Right-scroll the message one character.
          char ch = msg.charAt(msg.length()-1);
          msg = msg.substring(0, msg.length()-1);
          msg = ch + msg;
          if(counter == scrollLimit*2) counter = 0;
        }
        counter++;
        jlab.setText(msg);
      }
    };

    // Create the timer.
    stTimer = new Timer(200, scroller);

    // Add the label to the applet content pane.
    getContentPane().add(jlab);
  }
}