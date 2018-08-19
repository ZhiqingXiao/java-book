// A simple Swing program.

import javax.swing.*;

class SwingDemo {

  SwingDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("A Simple Swing Application");

    // Give the frame an initial size.
    jfrm.setSize(275, 100);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a text-based label.
    JLabel jlab = new JLabel(" Swing defines the modern Java GUI.");

    // Add the label to the content pane.
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SwingDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate a button.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonDemo implements ActionListener {

  JLabel jlab;

  ButtonDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("A Button Example");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(220, 90);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Make two buttons.
    JButton jbtnFirst = new JButton("First");
    JButton jbtnSecond = new JButton("Second");

    // Add action listeners.
    jbtnFirst.addActionListener(this);
    jbtnSecond.addActionListener(this);

    // Add the buttons to the content pane.
    jfrm.add(jbtnFirst);
    jfrm.add(jbtnSecond);

    // Create a text-based label.
    jlab = new JLabel("Press a button.");

    // Add the label to the frame.
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle button events.
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("First"))
      jlab.setText("First button was pressed.");
    else
      jlab.setText("Second button was pressed. ");
  }

  public static void main(String[] args) {

    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new ButtonDemo();
      }
    });
  }
}

// -----------------------------------------

// Try This 17-1: A Simple stopwatch.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class StopWatch implements ActionListener {

  JLabel jlab;
  long start; // holds the start time in milliseconds

  StopWatch() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("A Simple Stopwatch");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(230, 90);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Make two buttons.
    JButton jbtnStart = new JButton("Start");
    JButton jbtnStop = new JButton("Stop");

    // Add action listeners.
    jbtnStart.addActionListener(this);
    jbtnStop.addActionListener(this);

    // Add the buttons to the content pane.
    jfrm.add(jbtnStart);
    jfrm.add(jbtnStop);

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
    }
    else
      // Compute the elapsed time.
      jlab.setText("Elapsed time is "
           + (double) (cal.getTimeInMillis() - start)/1000);
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

// Demonstrate a text field.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JTextFieldDemo implements ActionListener {

  JTextField jtf;
  JLabel jlab;

  JTextFieldDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("A Text Field Example");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(240, 90);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a text field instance.
    jtf = new JTextField(10);

    // Add an action listener for the text field.
    jtf.addActionListener(this);

    // Add the text field to the content pane.
    jfrm.add(jtf);

    // Create an empty text-based label.
    jlab = new JLabel("");

    // Add the label to the frame.
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle action events.
  public void actionPerformed(ActionEvent ae) {

    // Obtain the current text and display it in a label.
    jlab.setText("Current contents: " + jtf.getText());
  }

  public static void main(String[] args) {

    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JTextFieldDemo();
      }
    });
  }
}

// -----------------------------------------

// Use two text fields.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TwoTFDemo implements ActionListener {

  JTextField jtf1;
  JTextField jtf2;
  JLabel jlab;

  TwoTFDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Use Two Text Fields");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(240, 120);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create two text field instances.
    jtf1 = new JTextField(10);
    jtf2 = new JTextField(10);

    // Set the action commands.
    jtf1.setActionCommand("One");
    jtf2.setActionCommand("Two");

    // Add action listeners for the text fields.
    jtf1.addActionListener(this);
    jtf2.addActionListener(this);

    // Add the text fields to the content pane.
    jfrm.add(jtf1);
    jfrm.add(jtf2);

    // Create an empty text-based label.
    jlab = new JLabel("");

    // Add the label to the frame.
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle action events.
  public void actionPerformed(ActionEvent ae) {

    if(ae.getActionCommand().equals("One"))
      jlab.setText("ENTER pressed in tf1: "
                    + jtf1.getText());
    else
      jlab.setText("ENTER pressed in jtf2: "
                   + jtf2.getText());
  }

  public static void main(String[] args) {

    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new TwoTFDemo();
      }
    });
  }
}

// -----------------------------------------

// Try This 17-2: A simple code machine.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Coder implements ActionListener {

  JTextField jtfPlaintext;
  JTextField jtfCiphertext;

  Coder() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("A Simple Code Machine");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(340, 130);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create two labels.
    JLabel jlabPlaintext = new JLabel("   Plain Text: ");
    JLabel jlabCiphertext = new JLabel("Cipher Text: ");

    // Create two text field instances.
    jtfPlaintext = new JTextField(20);
    jtfCiphertext = new JTextField(20);

    // Set the action commands for the text fields.
    jtfPlaintext.setActionCommand("Encode");
    jtfCiphertext.setActionCommand("Decode");

    // Add action listeners for the text fields.
    jtfPlaintext.addActionListener(this);
    jtfCiphertext.addActionListener(this);

    // Add the text fields and labels to the content pane.
    jfrm.add(jlabPlaintext);
    jfrm.add(jtfPlaintext);
    jfrm.add(jlabCiphertext);
    jfrm.add(jtfCiphertext);

    // Create push button instances.
    JButton jbtnEncode = new JButton("Encode");
    JButton jbtnDecode = new JButton("Decode");
    JButton jbtnReset =  new JButton("Reset");

    // Add action listeners for the buttons.
    jbtnEncode.addActionListener(this);
    jbtnDecode.addActionListener(this);
    jbtnReset.addActionListener(this);

    // Add the buttons to the content pane.
    jfrm.add(jbtnEncode);
    jfrm.add(jbtnDecode);
    jfrm.add(jbtnReset);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle action events.
  public void actionPerformed(ActionEvent ae) {

    // If action command is "Encode" then encode the string.
    if(ae.getActionCommand().equals("Encode")) {

      // This will hold the encoded string.
      String encStr = "";

      // Obtain the plain text.
      String str = jtfPlaintext.getText();

      // Add 1 to each character.
      for(int i=0; i<str.length(); i++)
        encStr += (char)(str.charAt(i) + 1);

      // Set the coded text into the Cipher Text field.
      jtfCiphertext.setText(encStr.toString());
    }

    // If action command is "Decode" then decode the string.
    else if(ae.getActionCommand().equals("Decode")) {

      // This will hold the decoded string.
      String decStr = "";

      // Obtain the cipher text.
      String str = jtfCiphertext.getText();

      // Subtract 1 from each character.
      for(int i=0; i<str.length(); i++)
        decStr += (char)(str.charAt(i) - 1);

      // Set the decoded text into the Plain Text field.
      jtfPlaintext.setText(decStr.toString());
    }

    // Otherwise, must be "Reset" command.
    else {
      jtfPlaintext.setText("");
      jtfCiphertext.setText("");
    }
  }

  public static void main(String[] args) {

    // Create the frame on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Coder();
      }
    });
  }
}
