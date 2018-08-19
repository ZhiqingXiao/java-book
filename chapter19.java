// Demonstrate a simple main menu.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuDemo implements ActionListener {

  JLabel jlab;

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
    JMenuBar jmb = new JMenuBar();

    // Create the File menu.
    JMenu jmFile = new JMenu("File");
    JMenuItem jmiOpen = new JMenuItem("Open");
    JMenuItem jmiClose = new JMenuItem("Close");
    JMenuItem jmiSave = new JMenuItem("Save");
    JMenuItem jmiExit = new JMenuItem("Exit");
    jmFile.add(jmiOpen);
    jmFile.add(jmiClose);
    jmFile.add(jmiSave);
    jmFile.addSeparator();
    jmFile.add(jmiExit);
    jmb.add(jmFile);

    // Create the Options menu.
    JMenu jmOptions = new JMenu("Options");

    // Create the Colors submenu.
    JMenu jmColors = new JMenu("Colors");
    JMenuItem jmiRed = new JMenuItem("Red");
    JMenuItem jmiGreen = new JMenuItem("Green");
    JMenuItem jmiBlue = new JMenuItem("Blue");
    jmColors.add(jmiRed);
    jmColors.add(jmiGreen);
    jmColors.add(jmiBlue);
    jmOptions.add(jmColors);

    // Create the Priority submenu.
    JMenu jmPriority = new JMenu("Priority");
    JMenuItem jmiHigh = new JMenuItem("High");
    JMenuItem jmiLow = new JMenuItem("Low");
    jmPriority.add(jmiHigh);
    jmPriority.add(jmiLow);
    jmOptions.add(jmPriority);

    // Create the Reset menu item.
    JMenuItem jmiReset = new JMenuItem("Reset");
    jmOptions.addSeparator();
    jmOptions.add(jmiReset);

    // Finally, add the entire Options menu to the menu bar
    jmb.add(jmOptions);

    // Create the Help menu.
    JMenu jmHelp = new JMenu("Help");
    JMenuItem jmiAbout = new JMenuItem("About");
    jmHelp.add(jmiAbout);
    jmb.add(jmHelp);

    // Add action listeners for the menu items.
    jmiOpen.addActionListener(this);
    jmiClose.addActionListener(this);
    jmiSave.addActionListener(this);
    jmiExit.addActionListener(this);
    jmiRed.addActionListener(this);
    jmiGreen.addActionListener(this);
    jmiBlue.addActionListener(this);
    jmiHigh.addActionListener(this);
    jmiLow.addActionListener(this);
    jmiReset.addActionListener(this);
    jmiAbout.addActionListener(this);

    // Add the label to the content pane.
    jfrm.add(jlab);

    // Add the menu bar to the frame.
    jfrm.setJMenuBar(jmb);

    // Display the frame.
    jfrm.setVisible(true);
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

// Try This 19-1: Add and remove menu items dynamically.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DynMenuDemo implements ActionListener {

  JLabel jlab;

  JMenuItem jmiYellow;
  JMenuItem jmiPurple;
  JMenuItem jmiOrange;

  JMenu jmColors;

  DynMenuDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Dynamic Menu Demo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(220, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label that will display the menu selection.
    jlab = new JLabel();

    // Create the menu bar.
    JMenuBar jmb = new JMenuBar();

    // Create the File menu.
    JMenu jmFile = new JMenu("File");
    JMenuItem jmiOpen = new JMenuItem("Open");
    JMenuItem jmiClose = new JMenuItem("Close");
    JMenuItem jmiSave = new JMenuItem("Save");
    JMenuItem jmiExit = new JMenuItem("Exit");
    jmFile.add(jmiOpen);
    jmFile.add(jmiClose);
    jmFile.add(jmiSave);
    jmFile.addSeparator();
    jmFile.add(jmiExit);
    jmb.add(jmFile);

    // Create the Options menu.
    JMenu jmOptions = new JMenu("Options");

    // Create the Colors submenu.
    jmColors = new JMenu("Colors");
    JMenuItem jmiRed = new JMenuItem("Red");
    JMenuItem jmiGreen = new JMenuItem("Green");
    JMenuItem jmiBlue = new JMenuItem("Blue");
    jmColors.add(jmiRed);
    jmColors.add(jmiGreen);
    jmColors.add(jmiBlue);

    // Create the More/Fewer Colors Menu item.
    JMenuItem jmiMoreLess = new JMenuItem("More Colors");
    jmColors.add(jmiMoreLess);

    // Add Colors menu to the Options menu.
    jmOptions.add(jmColors);

    // Create the additional colors. These will be
    // added or removed on demand.
    jmiYellow = new JMenuItem("Yellow");
    jmiPurple = new JMenuItem("Purple");
    jmiOrange = new JMenuItem("Orange");

    // Create the Priority submenu.
    JMenu jmPriority = new JMenu("Priority");
    JMenuItem jmiHigh = new JMenuItem("High");
    JMenuItem jmiLow = new JMenuItem("Low");
    jmPriority.add(jmiHigh);
    jmPriority.add(jmiLow);

    // Add the Priority menu to the Options menu.
    jmOptions.add(jmPriority);

    // Create the Reset menu item.
    JMenuItem jmiReset = new JMenuItem("Reset");
    jmOptions.addSeparator();
    jmOptions.add(jmiReset);

    // Finally, add the entire Options menu to the menu bar
    jmb.add(jmOptions);

    // Create the Help menu.
    JMenu jmHelp = new JMenu("Help");
    JMenuItem jmiAbout = new JMenuItem("About");
    jmHelp.add(jmiAbout);
    jmb.add(jmHelp);

    // Add action listeners for the menu items.
    jmiOpen.addActionListener(this);
    jmiClose.addActionListener(this);
    jmiSave.addActionListener(this);
    jmiExit.addActionListener(this);
    jmiRed.addActionListener(this);
    jmiGreen.addActionListener(this);
    jmiBlue.addActionListener(this);
    jmiHigh.addActionListener(this);
    jmiLow.addActionListener(this);
    jmiReset.addActionListener(this);
    jmiAbout.addActionListener(this);

    // Add listeners for the additional colors option.
    jmiMoreLess.addActionListener(this);
    jmiYellow.addActionListener(this);
    jmiPurple.addActionListener(this);
    jmiOrange.addActionListener(this);

    // Add the label to the content pane.
    jfrm.add(jlab);

    // Add the menu bar to the frame.
    jfrm.setJMenuBar(jmb);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle menu item action events.
  public void actionPerformed(ActionEvent ae) {
    // Get the action command from the menu selection.
    String comStr = ae.getActionCommand();

    // If user chooses Exit, then exit the program.
    if(comStr.equals("Exit"))
      System.exit(0);
    else if(comStr.equals("More Colors")) {
      jmColors.add(jmiYellow);
      jmColors.add(jmiPurple);
      jmColors.add(jmiOrange);
      JMenuItem mi = (JMenuItem) ae.getSource();
      mi.setText("Fewer Colors");
    } else if(comStr.equals("Fewer Colors")) {
      jmColors.remove(jmiYellow);
      jmColors.remove(jmiPurple);
      jmColors.remove(jmiOrange);
      JMenuItem mi = (JMenuItem) ae.getSource();
      mi.setText("More Colors");
    }

    // Otherwise, display the selection.
    jlab.setText(comStr + " Selected");
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new DynMenuDemo();
      }
    });
  }
}