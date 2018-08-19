// An improved version of the StopWatch class from Try This 17-1.
// This version uses a separate thread to display the elapsed
// time when the stopwatch is running.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

class ThreadStopWatch {

  JLabel jlab; // display the elapsed time

  JButton jbtnStart; // start the stopwatch
  JButton jbtnStop;  // stop the stopwatch

  long start; // holds the start time in milliseconds

  boolean running=false; // true when stopwatch is running

  Thread thrd; // reference to the timing thread

  ThreadStopWatch() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Thread-based Stopwatch");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(230, 90);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the elapsed-time label.
    jlab = new JLabel("Press Start to begin timing.");

    // Make the Start and Stop buttons.
    jbtnStart = new JButton("Start");
    jbtnStop = new JButton("Stop");

    // Initially disable the Stop button.
    jbtnStop.setEnabled(false);

    // Create the Runnable instance that will become the second thread.
    Runnable myThread = new Runnable() {
      // This method will run in a separate thread.
      public void run() {
        try {
          // Report elapsed time every tenth of a second.
          for(; ; ) {
            // Pause for a tenth of a second.
            Thread.sleep(100);

            // Invoke updateTime() on the event dispatching thread.
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                updateTime();
              }
            });
          }
        } catch(InterruptedException exc) {
          System.out.println("Call to sleep was interrupted.");
          System.exit(1);
        }
      }
    };

    // Create a new thread.
    thrd = new Thread(myThread);

    // Start the thread.
    thrd.start();

    // Add the action listeners for the Start and
    // Stop buttons.
    jbtnStart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

        // Store start time.
        start = Calendar.getInstance().getTimeInMillis();

        // Reverse the state of the buttons.
        jbtnStop.setEnabled(true);
        jbtnStart.setEnabled(false);

        // Start the stopwatch.
        running = true;
      }
    });

    jbtnStop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        long stop = Calendar.getInstance().getTimeInMillis();

        // Compute the elapsed time.
        jlab.setText("Elapsed time is "
             + (double) (stop - start)/1000);

        // Reverse the state of the buttons.
        jbtnStart.setEnabled(true);
        jbtnStop.setEnabled(false);

        // Stop the stopwatch.
        running = false;
      }
    });

    // Add the buttons and label to the content pane.
    jfrm.add(jbtnStart);
    jfrm.add(jbtnStop);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Update the elapsed time display.
  void updateTime() {
    if(!running) return;

    long temp = Calendar.getInstance().getTimeInMillis();
    jlab.setText("Elapsed time is " +
                 (double) (temp - start)/1000);
  }

  public static void main(String[] args) {
    // Create the frame on the event-dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new ThreadStopWatch();
      }
    });
  }
}

// -----------------------------------------

// This version of the stopwatch uses the Timer class.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

class TimerStopWatch {

  JLabel jlab; // display the elapsed time

  JButton jbtnStart; // start the stopwatch
  JButton jbtnStop;  // stop the stopwatch

  long start; // holds the start time in milliseconds

  Timer swTimer; // the timer for the stopwatch

  TimerStopWatch() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Timer-based Stopwatch");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(230, 90);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the elapsed-time label.
    jlab = new JLabel("Press Start to begin timing.");

    // Make the Start and Stop buttons.
    jbtnStart = new JButton("Start");
    jbtnStop = new JButton("Stop");
    jbtnStop.setEnabled(false);

    // This action listener is called when the timer
    // goes off.
    ActionListener timerAL = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        updateTime();
      }
    };

    // Create a timer that goes off every tenth of a second.
    swTimer = new Timer(100, timerAL);

    // Add the action listeners for the start and
    // stop buttons.
    jbtnStart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {

        // Store start time.
        start = Calendar.getInstance().getTimeInMillis();

        // Reverse the state of the buttons.
        jbtnStop.setEnabled(true);
        jbtnStart.setEnabled(false);

        // Start the stopwatch.
        swTimer.start();
      }
    });

    jbtnStop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        long stop = Calendar.getInstance().getTimeInMillis();

        // Compute the elapsed time.
        jlab.setText("Elapsed time is "
             + (double) (stop - start)/1000);

        // Reverse the state of the buttons.
        jbtnStart.setEnabled(true);
        jbtnStop.setEnabled(false);

        // Stop the stopwatch.
        swTimer.stop();
      }
    });

    // Add the buttons and label to the content pane.
    jfrm.add(jbtnStart);
    jfrm.add(jbtnStop);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Update the elapsed time display. Notice
  // that the running variable is no longer needed.
  void updateTime() {
    long temp = Calendar.getInstance().getTimeInMillis();
    jlab.setText("Elapsed time is " +
                 (double) (temp - start)/1000);
  }

  public static void main(String[] args) {
    // Create the frame on the event-dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new TimerStopWatch();
      }
    });
  }
}

// -----------------------------------------

// A simple Swing-based applet

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
This HTML can be used to launch the applet:

<object code="MyApplet" width=240 height=100>
</object>

*/

public class MyApplet extends JApplet {
  JButton jbtnOne;
  JButton jbtnTwo;

  JLabel jlab;

  // Called first.
  public void init() {
    try {
      SwingUtilities.invokeAndWait(new Runnable () {
        public void run() {
          guiInit(); // initialize the GUI
        }
      });
    } catch(Exception exc) {
      System.out.println("Can't create because of " + exc);
    }
  }

  // Set up and initialize the GUI.
  private void guiInit() {
    // Set the applet to use flow layout.
    setLayout(new FlowLayout());

    // Create two buttons and a label.
    jbtnOne = new JButton("One");
    jbtnTwo = new JButton("Two");

    jlab = new JLabel("Press a button.");

    // Add action listeners for the buttons.
    jbtnOne.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        jlab.setText("Button One pressed.");
      }
    });

    jbtnTwo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        jlab.setText("Button Two pressed.");
      }
    });

    // Add the components to the applet's content pane.
    add(jbtnOne);
    add(jbtnTwo);
    add(jlab);
  }
}

// -----------------------------------------

// Try This 21-1: A Swing-based applet that scrolls
// text through a label.

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

  Timer stTimer; // this timer controls the scroll rate

  // Initialize the applet.
  public void init() {
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
    scroller = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        // Left-scroll the message one character.
        char ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
        jlab.setText(msg);
      }
    };

    // Create the timer.
    stTimer = new Timer(200, scroller);

    // Add the label to the applet content pane.
    add(jlab);
  }
}

// -----------------------------------------

// Paint lines to a panel.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// This class extends JPanel. It overrides
// the paintComponent() method so that random
// data is plotted in the panel.
class PaintPanel extends JPanel {
  Insets ins; // holds the panel's insets

  Random rand; // used to generate random numbers

  PaintPanel(int w, int h) {

    // Use a red line border.
    setBorder(BorderFactory.createLineBorder(Color.RED, 1));

    // Set the preferred dimension as specified.
    setPreferredSize(new Dimension(w, h));

    rand = new Random();
  }

  // Override the paintComponent() method.
  protected void paintComponent(Graphics g) {
    // Always call the superclass method first.
    super.paintComponent(g);

    // Get the height and width of the component.
    int height = getHeight();
    int width = getHeight();

      // Get the insets.
    ins = getInsets();

    // Fill the panel by plotting random data
    // in the form of a bar graph.
    for(int i=ins.left+5; i <= width-ins.right-5; i += 4) {
      // Obtain a random number between 0 and
      // the maximum height of the drawing area.
      int h = rand.nextInt(height-ins.bottom);

      // If a generated value is in or too close to the
      // border, change it to just inside the border.
      if(h <= ins.top) h = ins.top+1;

      // Draw a line that represents the data.
      g.drawLine(i, height-ins.bottom, i, h);
    }
  }

  // Change the border size.
  public void changeBorderSize(int size) {
    setBorder(
      BorderFactory.createLineBorder(Color.RED, size));
  }
}

// Demonstrate painting directly onto a panel.
class PaintDemo {

  JButton jbtnMore;
  JButton jbtnSize;
  JLabel jlab;
  PaintPanel pp;

  boolean big; // use to toggle size of panel

  PaintDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Painting Demo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(240, 260);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the panel that will be painted.
    pp = new PaintPanel(100, 100);

    // Make the buttons.
    jbtnMore = new JButton("Show More Data");
    jbtnSize = new JButton("Change Border Size");

    // Describe the graph.
    jlab = new JLabel("Bar Graph of Random Data");

    // Repaint the panel when the Show More Data button
    // is clicked.
    jbtnMore.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        pp.repaint();
      }
    });

    // Set the border size of the panel when the
    // Change Border Size button is clicked.
    // Changing the border size automatically
    // results in a repaint.
    jbtnSize.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if(!big) pp.changeBorderSize(5);
        else pp.changeBorderSize(1);
        big = !big;
      }
    });

    // Add the buttons, label, and panel to the content pane.
    jfrm.add(jlab);
    jfrm.add(pp);
    jfrm.add(jbtnMore);
    jfrm.add(jbtnSize);

    big = false;

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the frame on the event-dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new PaintDemo();
      }
    });
  }
}