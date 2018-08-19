// A very simple JOptionPane demonstration.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MsgDialogDemo {

  JLabel jlab;
  JButton jbtnShow;
  JFrame jfrm;

  MsgDialogDemo() {
    // Create a new JFrame container.
    jfrm = new JFrame("Simple Message Dialog");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 250);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will show when the dialog returns.
    jlab = new JLabel();

    // Create a button that will display the dialog.
    jbtnShow = new JButton("Show Dialog");

    // Add action listener for the button.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        jlab.setText("Dialog Opened");

        // Create a dialog that shows a message.
        JOptionPane.showMessageDialog(jfrm,
                                      "Disk space is low.");

        // This statement won't execute until the
        // call to showMessageDialog() returns.
        jlab.setText("Dialog Closed");
      }
    });

    // Add the button and label to the content pane.
    jfrm.add(jbtnShow);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MsgDialogDemo();
      }
    });
  }
}

// -----------------------------------------

// Use a simple confirmation dialog.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ConfirmDialogDemo {

  JLabel jlab;
  JButton jbtnShow;
  JFrame jfrm;

  ConfirmDialogDemo() {
    // Create a new JFrame container.
    jfrm = new JFrame("A Confirmation Dialog");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 250);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will show the user's response.
    jlab = new JLabel();

    // Create button that will display the dialog.
    jbtnShow = new JButton("Show Dialog");

    // Add action listener for the button.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        // Create a confirmation dialog.
        int response = JOptionPane.showConfirmDialog(
                         jfrm,
                         "Remove unused files?");

        // Show the response.
        switch(response) {
          case JOptionPane.YES_OPTION:
            jlab.setText("You answered Yes.");
            break;
          case JOptionPane.NO_OPTION:
            jlab.setText("You answered No.");
            break;
          case JOptionPane.CANCEL_OPTION:
            jlab.setText("Cancel pressed.");
            break;
          case JOptionPane.CLOSED_OPTION:
            jlab.setText("Dialog closed without response.");
            break;
        }
      }
    });

    // Add the button and label to the content pane.
    jfrm.add(jbtnShow);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new ConfirmDialogDemo();
      }
    });
  }
}

// -----------------------------------------

// A simple input dialog.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InputDialogDemo {

  JLabel jlab;

  JButton jbtnShow;

  JFrame jfrm;

  InputDialogDemo() {
    // Create a new JFrame container.
    jfrm = new JFrame("A Simple Input Dialog");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 250);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that shows the response.
    jlab = new JLabel();

    // Create button that will display the dialog.
    jbtnShow = new JButton("Show Dialog");

    // Add action listener for the button.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        // Create a dialog that inputs a string.
        String response = JOptionPane.showInputDialog(
                            "Enter Name");

        // If the response is null, then the dialog
        // was cancelled or closed. If response is a
        // zero-length string, then no input was entered.
        // Otherwise, response contains a string entered
        // by the user.
        if(response == null)
          jlab.setText("Dialog cancelled or closed");
        else if(response.length() == 0)
          jlab.setText("No string entered");
        else
          jlab.setText("Hi there " + response);
      }
    });

    // Add the button and label to the content pane.
    jfrm.add(jbtnShow);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new InputDialogDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate an option dialog.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OptionDialogDemo {

  JLabel jlab;
  JButton jbtnShow;
  JFrame jfrm;

  OptionDialogDemo() {
    // Create a new JFrame container.
    jfrm = new JFrame("A Simple Option Dialog");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 250);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will show the selection.
    jlab = new JLabel();

    // Create button that will display the dialog.
    jbtnShow = new JButton("Show Dialog");

    // Add action listener for the button.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {

        // Define the connection options.
        String[] connectOpts = { "Modem", "Wireless",
                                 "Satellite", "Cable" };

        // Create a dialog that lets the user
        // choose how to connect to the network.
        int response = JOptionPane.showOptionDialog(
                              jfrm,
                              "Choose Network Connection",
                              "Connection Type",
                              JOptionPane.DEFAULT_OPTION,
                              JOptionPane.QUESTION_MESSAGE,
                              null,
                              connectOpts,
                              "Wireless");

         // Display the choice.
         switch(response) {
           case 0:
             jlab.setText("Connect via modem.");
             break;
           case 1:
             jlab.setText("Connect via wireless.");
             break;
           case 2:
             jlab.setText("Connect via satellite.");
             break;
           case 3:
             jlab.setText("Connect via cable.");
             break;
           case JOptionPane.CLOSED_OPTION:
             jlab.setText("Dialog cancelled.");
             break;
         }
      }
    });

    // Add the button and label to the content pane.
    jfrm.add(jbtnShow);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new OptionDialogDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate a simple JDialog.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JDialogDemo {

  JLabel jlab;

  JButton jbtnShow;
  JButton jbtnReset;

  // These buttons are contained within the dialog.
  JButton jbtnUp;
  JButton jbtnDown;

  JDialog jdlg;

  JDialogDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JDialog Demo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that shows the direction.
    jlab = new JLabel("Direction is pending.");

    // Create a button that will show the dialog.
    jbtnShow = new JButton("Show Dialog");

    // Create button that will reset the direction.
    jbtnReset = new JButton("Reset Direction");

    // Create a simple modal dialog.
    jdlg = new JDialog(jfrm, "Direction", true);
    jdlg.setSize(200, 100);
    jdlg.setLayout(new FlowLayout());

    // Create buttons used by the dialog.
    jbtnUp = new JButton("Up");
    jbtnDown = new JButton("Down");

    // Add buttons to the dialog.
    jdlg.add(jbtnUp);
    jdlg.add(jbtnDown);

    // Add a label to the dialog.
    jdlg.add(new JLabel("Press a button."));

    // Show the dialog when the Show Dialog button is pressed.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        jdlg.setVisible(true);
      }
    });

    // Reset the direction when the Reset Direction
    // button is pressed.
    jbtnReset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        jlab.setText("Direction is pending.");
      }
    });

    // Respond to the Up button in the dialog.
    jbtnUp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        jlab.setText("Direction is Up");

        // Hide the dialog after the user selects
        // a direction.
        jdlg.setVisible(false);
      }
    });

    // Respond to the Down button in the dialog.
    jbtnDown.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        jlab.setText("Direction is Down");

        // Hide the dialog after the user selects
        // a direction.
        jdlg.setVisible(false);
      }
    });

    // Add the Show Dialog button and label to the content pane.
    jfrm.add(jbtnShow);
    jfrm.add(jbtnReset);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JDialogDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate JFileChooser.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FileChooserDemo {

  JLabel jlab;
  JButton jbtnShow;
  JFileChooser jfc;

  FileChooserDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JFileChooser Demo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will show the selected file.
    jlab = new JLabel();

    // Create button that will show the dialog.
    jbtnShow = new JButton("Show File Chooser");

    // Create the file chooser.
    jfc = new JFileChooser();

    // Show the file chooser when the Show File Chooser button
    // is pressed.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        // Pass null for the parent. This centers the dialog
        // on the screen.
        int result = jfc.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION)
          jlab.setText("Selected file is: " +
                       jfc.getSelectedFile().getName());
        else
          jlab.setText("No file selected.");
      }
    });

    // Add the Show File Chooser button and label to the
    // content pane.
    jfrm.add(jbtnShow);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new FileChooserDemo();
      }
    });
  }
}

// -----------------------------------------

// Try This 20-1: Demonstrate a custom file filter.

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

// A custom file filter that displays
// Java source files and directories.
class JavaFileFilter extends FileFilter {
  public boolean accept(File file) {
    // Return true if the file is a Java source file
    // or if it is a directory.
    if(file.getName().endsWith(".java")) return true;
    if(file.isDirectory()) return true;

    // Otherwise, return false.
    return false;
  }

  public String getDescription() {
    return "Java Source Code Files";
  }
}

public class FileFilterDemo {

  JLabel jlab;
  JButton jbtnShow;
  JFileChooser jfc;

  FileFilterDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("File Filter Demo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(400, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will show the selected file.
    jlab = new JLabel();

    // Create a button that will show the dialog.
    jbtnShow = new JButton("Show File Chooser");

    // Create the file chooser.
    jfc = new JFileChooser();

    // Set the file filter.
    jfc.setFileFilter(new JavaFileFilter());

    // Show the file chooser when the Show File Chooser button
    // is pressed.
    jbtnShow.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent le) {
        // Pass null for the parent. This typically centers
        // the dialog on the screen.
        int result = jfc.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION)
          jlab.setText("Selected file is: " +
                       jfc.getSelectedFile().getName());
        else
          jlab.setText("No file selected.");
      }
    });

    // Add the Show File Chooser button and label to the
    // content pane.
    jfrm.add(jbtnShow);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new FileFilterDemo();
      }
    });
  }
}