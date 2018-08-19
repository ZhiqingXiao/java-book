// Demonstrate JLabel and ImageIcon.
// This example displays the three states of a traffic light.

import javax.swing.*;
import java.awt.*;

class JLabelDemo {

  JLabelDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JLabel and ImageIcon Example");

    // Give the frame an initial size.
    jfrm.setSize(320, 280);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create an icon and label for Go.
    ImageIcon goIcon = new ImageIcon("Go.gif");
    JLabel jlabGo = new JLabel("  Go  ", goIcon, SwingConstants.LEFT);

    // Create an icon and label for Caution.
    ImageIcon cautionIcon = new ImageIcon("Caution.gif");
    JLabel jlabCaution = new JLabel("  Caution  ", cautionIcon,
                                    SwingConstants.CENTER);

    // Create an icon and label for Stop.
    ImageIcon stopIcon = new ImageIcon("Stop.gif");
    JLabel jlabStop = new JLabel("  Stop  ", stopIcon,
                                 SwingConstants.RIGHT);

    // Add the labels to the content pane.
    jfrm.add(jlabGo, BorderLayout.NORTH);
    jfrm.add(jlabCaution, BorderLayout.CENTER);
    jfrm.add(jlabStop, BorderLayout.SOUTH);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JLabelDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate icon-based JButtons.
// This example displays traffic light icons inside buttons.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemo implements ActionListener {
  JLabel jlab;

  JButtonDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JButton Example");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(300, 180);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the buttons.
    ImageIcon goIcon = new ImageIcon("Go.gif");
    JButton jbtnGo = new JButton(goIcon);
    jbtnGo.setActionCommand("Go");
    jbtnGo.addActionListener(this);

    ImageIcon cautionIcon = new ImageIcon("Caution.gif");
    JButton jbtnCaution = new JButton(cautionIcon);
    jbtnCaution.setActionCommand("Caution");
    jbtnCaution.addActionListener(this);

    ImageIcon stopIcon = new ImageIcon("Stop.gif");
    JButton jbtnStop = new JButton(stopIcon);
    jbtnStop.setActionCommand("Stop");
    jbtnStop.addActionListener(this);

    // Add the buttons to the content pane.
    jfrm.add(jbtnGo);
    jfrm.add(jbtnCaution);
    jfrm.add(jbtnStop);

     // Create and add the label to content pane.
    jlab = new JLabel("Select a Traffic Light");
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle button events.
  public void actionPerformed(ActionEvent ae) {
    jlab.setText("You selected " + ae.getActionCommand() + ".");
  }

  public static void main(String[] args) {

    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JButtonDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate JToggleButton.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JToggleButtonDemo {

  JLabel jlab;
  JToggleButton jtbn;

  JToggleButtonDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JToggleButton Example");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(200, 100);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label.
    jlab = new JLabel("Button is off.");

    // Make a toggle button.
    jtbn =  new JToggleButton("On/Off");

    // Add an item listener for the toggle button.
    jtbn.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent ie) {
        if(jtbn.isSelected())
          jlab.setText("Button is on.");
        else
          jlab.setText("Button is off.");
      }
    });

    // Add the toggle button and label to the content pane.
    jfrm.add(jtbn);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {

    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JToggleButtonDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate JCheckbox.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCheckBoxDemo implements ItemListener {
  JLabel jlabChange;
  JLabel jlabSupported;

  JCheckBox cbWin;
  JCheckBox cbLinux;
  JCheckBox cbMac;

  JCheckBoxDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JCheckBox Example");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(340, 140);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add check boxes to the content pane.
    cbWin = new JCheckBox("Windows");
    cbWin.addItemListener(this);
    jfrm.add(cbWin);

    cbLinux = new JCheckBox("Linux");
    cbLinux.addItemListener(this);
    jfrm.add(cbLinux);

    cbMac = new JCheckBox("Mac OS");
    cbMac.addItemListener(this);
    jfrm.add(cbMac);

    // Create labels.
    jlabChange = new JLabel("Select Supported Operating Systems");
    jfrm.add(jlabChange);

    jlabSupported = new JLabel();
    jfrm.add(jlabSupported);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle item events for the check boxes.
  public void itemStateChanged(ItemEvent ie) {
    JCheckBox cb = (JCheckBox)ie.getItem();

    if(cb.isSelected())
      jlabChange.setText(cb.getText() + " has been selected");
    else
      jlabChange.setText(cb.getText() + " has been cleared");

    // Build a string the indicate all selections.
    String supported = "Supported Operating Systems: ";
    if(cbWin.isSelected()) supported += "Windows  ";
    if(cbLinux.isSelected()) supported += "Linux  ";
    if(cbMac.isSelected()) supported += "Mac OS";

    jlabSupported.setText(supported);
  }

  public static void main(String[] args) {

    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JCheckBoxDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate JRadioButton
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButtonDemo implements ActionListener {
  JLabel jlab;

  JRadioButtonDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JRadioButton Example");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(350, 100);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create radio buttons and add them to content pane.
    JRadioButton b1 = new JRadioButton("Debug");
    b1.addActionListener(this);
    jfrm.add(b1);

    JRadioButton b2 = new JRadioButton("Maximize Speed");
    b2.addActionListener(this);
    jfrm.add(b2);

    JRadioButton b3 = new JRadioButton("Minimize Size");
    b3.addActionListener(this);
    jfrm.add(b3);

    // Define a button group.
    ButtonGroup bg = new ButtonGroup();
    bg.add(b1);
    bg.add(b2);
    bg.add(b3);

    // Create a label and add it to the content pane.
    jlab = new JLabel("Select One");
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Handle button selection.
  public void actionPerformed(ActionEvent ae) {
    jlab.setText("You selected " + ae.getActionCommand());
  }

  public static void main(String[] args) {

    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JRadioButtonDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate various features of a text field.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class JTextFieldDemo {

  JLabel jlabAll;
  JLabel jlabSelected;

  JTextField jtf;

  JButton jbtnCut;
  JButton jbtnPaste;

  public JTextFieldDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JTextField Example");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(200, 150);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create labels.
    jlabAll = new JLabel("All text: ");
    jlabSelected = new JLabel("Selected text: ");

    // Create the text field.
    jtf = new JTextField("This is a test.", 15);

    // Add an action listener for the text field.
    // Each time the user presses enter, the contents
    // of the field are displayed. Any currently
    // selected text is also displayed.
    jtf.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        jlabAll.setText("All text: " + jtf.getText());
        if(jtf.getSelectedText() != null)
          jlabSelected.setText("Selected text: " +
                               jtf.getSelectedText());
      }
    });

    // Create the Cut and Paste buttons.
    jbtnCut = new JButton("Cut");
    jbtnPaste = new JButton("Paste");

    // Add action listener for the Cut button.
    jbtnCut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        // Cut any selected text and put it
        // on the clipboard.
        jtf.cut();
        jlabAll.setText("All text: " + jtf.getText());
        if(jtf.getSelectedText() != null)
          jlabSelected.setText("Selected text: " +
                               jtf.getSelectedText());
      }
    });

    // Add action listener for the Paste button.
    jbtnPaste.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        // Paste text from the clipboard into
        // the text field.
        jtf.paste();
      }
    });

    // Add the components to the content pane.
    jfrm.add(jtf);
    jfrm.add(jbtnCut);
    jfrm.add(jbtnPaste);
    jfrm.add(jlabAll);
    jfrm.add(jlabSelected);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JTextFieldDemo();
      }
    });
  }
}

// -----------------------------------------

/*
     Try This 18-1

     A Swing-based file comparison utility.

     It uses the try-with-resources statement and
     requires JDK 7 or later.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class SwingFC implements ActionListener {

  JTextField jtfFirst;  // holds the first file name
  JTextField jtfSecond; // holds the second file name

  JButton jbtnComp; // button to compare the files

  JLabel jlabFirst, jlabSecond; // displays prompts
  JLabel jlabResult; // displays results and error messages

  JCheckBox jcbLoc; // check to display location of mismatch

  SwingFC() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Compare Files");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(200, 220);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the text fields for the file names.
    jtfFirst = new JTextField(14);
    jtfSecond = new JTextField(14);

    // Create the Compare button.
    JButton jbtnComp = new JButton("Compare");

    // Add action listener for the Compare button.
    jbtnComp.addActionListener(this);

    // Create the labels.
    jlabFirst = new JLabel("First file: ");
    jlabSecond = new JLabel("Second file: ");
    jlabResult = new JLabel("");

    // Create check box.
    jcbLoc = new JCheckBox("Show position of mismatch");

    // Add the components to the content pane.
    jfrm.add(jlabFirst);
    jfrm.add(jtfFirst);
    jfrm.add(jlabSecond);
    jfrm.add(jtfSecond);
    jfrm.add(jcbLoc);
    jfrm.add(jbtnComp);
    jfrm.add(jlabResult);

    // Display the frame.
    jfrm.setVisible(true);
  }

  // Compare the files when the Compare button is pressed.
  public void actionPerformed(ActionEvent ae) {
    int i = 0, j = 0;
    int count = 0;

    // First, confirm that both file names have been entered.
    if(jtfFirst.getText().equals("")) {
      jlabResult.setText("First file name missing.");
      return;
    }
    if(jtfSecond.getText().equals("")) {
      jlabResult.setText("Second file name missing.");
      return;
    }

    // Compare files. Use try-with-resources to manage the files.
    try (FileInputStream f1 =
             new FileInputStream(jtfFirst.getText());
         FileInputStream f2 =
             new FileInputStream(jtfSecond.getText()))
    {

      // Check the contents of each file.
      do {
        i = f1.read();
        j = f2.read();
        if(i != j) break;
        count++;
      } while(i != -1 && j != -1);

      if(i != j) {
        if(jcbLoc.isSelected())
          jlabResult.setText("Files differ at location " + count);
        else
          jlabResult.setText("Files are not the same.");
      }
      else
        jlabResult.setText("Files compare equal.");

    } catch(IOException exc) {
      jlabResult.setText("File Error");
    }
  }

  public static void main(String[] args) {

    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SwingFC();
      }
    });
  }
}

// -----------------------------------------

// A simple JScrollPane example.
import javax.swing.*;

class JScrollPaneDemo {

  JScrollPaneDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JScrollPane Example");

    // Give the frame an initial size.
    jfrm.setSize(200, 120);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a long, HTML-based label.
    JLabel jlab =
      new JLabel("<html>JScrollPane simplifies what would<br>" +
                 "otherwise be complicated tasks.<br>" +
                 "It can be used to scroll any lightweight <br>" +
                 "component or lightweight container. It is <br>" +
                 "especially useful when scrolling tables, lists,<br>" +
                 "or images.");

    // Create a scroll pane and have it scroll the label.
    JScrollPane jscrlp = new JScrollPane(jlab);

    // Add the scroll pane to the frame.
    jfrm.add(jscrlp);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {

    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JScrollPaneDemo();
      }
    });
  }
}

// -----------------------------------------

// Try This 18-2: Use a JScrollPane to scroll a JPanel.

import java.awt.*;
import javax.swing.*;

class ScrollJPanelDemo {

  ScrollJPanelDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("Scroll a JPanel");

    // Give the frame an initial size.
    jfrm.setSize(280, 130);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a label.
    JLabel jlabOptions = new JLabel("Select one or more options: ");

    // Make some check boxes.
    JCheckBox jcbOpt1 = new JCheckBox("Option One");
    JCheckBox jcbOpt2 = new JCheckBox("Option Two");
    JCheckBox jcbOpt3 = new JCheckBox("Option Three");
    JCheckBox jcbOpt4 = new JCheckBox("Option Four");
    JCheckBox jcbOpt5 = new JCheckBox("Option Five");
    JCheckBox jcbOpt6 = new JCheckBox("Option Six");
    JCheckBox jcbOpt7 = new JCheckBox("Option Seven");
    JCheckBox jcbOpt8 = new JCheckBox("Option Eight");
    JCheckBox jcbOpt9 = new JCheckBox("Option Nine");
    JCheckBox jcbOpt10 = new JCheckBox("Option Ten");

    // No event handlers used by this example, but as an
    // exercise, you might try adding some.

    // Create a JPanel to hold the options check boxes.
    JPanel jpnl = new JPanel();
    jpnl.setLayout(new GridLayout(5, 3));

    // Add check boxes and label to the JPanel.
    jpnl.add(jlabOptions);
    jpnl.add(new JLabel("")); // a placeholder label
    jpnl.add(new JLabel("")); // a placeholder label

    jpnl.add(jcbOpt1);
    jpnl.add(jcbOpt2);
    jpnl.add(jcbOpt3);
    jpnl.add(jcbOpt4);
    jpnl.add(jcbOpt5);
    jpnl.add(jcbOpt6);
    jpnl.add(jcbOpt7);
    jpnl.add(jcbOpt8);
    jpnl.add(jcbOpt9);
    jpnl.add(jcbOpt10);

    // Create a scroll pane that will scroll the panel.
    JScrollPane jscrlp = new JScrollPane(jpnl);

    // Add that scroll pane to the frame.
    jfrm.add(jscrlp);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {

    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new ScrollJPanelDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate a simple JList.

// This program requires JDK 7 or later.

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class JListDemo {

  JList<String> jlst;
  JLabel jlab;
  JScrollPane jscrlp;

  // Create an array of apple varieties.
  String[] apples = { "Winesap", "Cortland", "Red Delicious",
                      "Golden Delicious", "Gala", "Fuji",
                      "Granny Smith", "Jonathan" };

  JListDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JList Demo");

    // Specify FlowLayout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(240, 200);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a JList.
    jlst = new JList<String>(apples);

    // Set the list selection mode to single- selection.
    jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // Add list to a scroll pane.
    jscrlp = new JScrollPane(jlst);

    // Set the preferred size of the scroll pane.
    jscrlp.setPreferredSize(new Dimension(120, 90));

    // Make a label that displays the selection.
    jlab = new JLabel("Please Choose an Apple.");

    // Add selection listener for the list.
    jlst.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent le) {
        // Get the index of the changed item.
        int idx = jlst.getSelectedIndex();

        // Display selection, if item was selected.
        if(idx != -1)
          jlab.setText("Current selection: " + apples[idx]);
        else // Otherwise, reprompt.
          jlab.setText("Please Choose choose an Apple.");

      }
    });

    // Add the list and label to the content pane.
    jfrm.add(jscrlp);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JListDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate a simple combo box.

// This program requires JDK 7 or later.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JComboBoxDemo {

  JComboBox<String> jcbb;
  JLabel jlab;

  // Create an array of apple varieties.
  String[] apples = { "Winesap", "Cortland", "Red Delicious",
                      "Golden Delicious", "Gala", "Fuji",
                      "Granny Smith", "Jonathan" };

  JComboBoxDemo() {
    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JComboBox Demo");

    // Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    // Give the frame an initial size.
    jfrm.setSize(380, 240);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a JComboBox
    jcbb = new JComboBox<String>(apples);

    // Make a label that displays the selection.
    jlab = new JLabel("Please Choose an Apple.");

    // Add action listener for the combo box.
    jcbb.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        // Get a reference to the item selected.
        String item = (String) jcbb.getSelectedItem();

        // Display the selected item.
        jlab.setText("Current selection: " + item);
      }
    });

    // Add the combo box and label to the content pane.
    jfrm.add(jcbb);
    jfrm.add(jlab);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JComboBoxDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate JTree.
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class JTreeDemo {
  JTree tree;
  JLabel jlab;

  JTreeDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JTree Example");

    // Give the frame an initial size.
    jfrm.setSize(300, 240);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create root node of tree.
    DefaultMutableTreeNode root =
           new DefaultMutableTreeNode("Java Keywords");

    // Create subtree for types.
    DefaultMutableTreeNode types = new DefaultMutableTreeNode("Types");
    root.add(types);

    // Create subtree for floating point types.
    DefaultMutableTreeNode fpTypes =
           new DefaultMutableTreeNode("Floating Point");
    types.add(fpTypes);
    fpTypes.add(new DefaultMutableTreeNode("float"));
    fpTypes.add(new DefaultMutableTreeNode("double"));

    // Create subtree for integer types.
    DefaultMutableTreeNode intTypes =
           new DefaultMutableTreeNode("Integer");
    types.add(intTypes);
    intTypes.add(new DefaultMutableTreeNode("byte"));
    intTypes.add(new DefaultMutableTreeNode("short"));
    intTypes.add(new DefaultMutableTreeNode("int"));
    intTypes.add(new DefaultMutableTreeNode("long"));

    // Create nodes for char and boolean.
    types.add(new DefaultMutableTreeNode("char"));
    types.add(new DefaultMutableTreeNode("boolean"));

    // Create subtree for loops.
    DefaultMutableTreeNode loops = new DefaultMutableTreeNode("Loops");
    root.add(loops);
    loops.add(new DefaultMutableTreeNode("for"));
    loops.add(new DefaultMutableTreeNode("while"));
    loops.add(new DefaultMutableTreeNode("do"));

    // Create the tree.
    tree = new JTree(root);

    // Add the tree to a scroll pane.
    JScrollPane jsp = new JScrollPane(tree);

    // Add the scroll pane to the center of the default BorderLayout.
    jfrm.add(jsp);

    // Add the label to the south region of the default BorderLayout.
    jlab = new JLabel("Select from the tree.");
    jfrm.add(jlab, BorderLayout.SOUTH);

    // Handle tree selection events.
    tree.addTreeSelectionListener(new TreeSelectionListener() {
      public void valueChanged(TreeSelectionEvent tse) {
        jlab.setText("Selection is " +
             tse.getPath().getLastPathComponent());
      }
    });

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {
    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JTreeDemo();
      }
    });
  }
}

// -----------------------------------------

// Demonstrate JTable.
import java.awt.*;
import javax.swing.*;

public class JTableDemo {

  JTableDemo() {

    // Create a new JFrame container.
    JFrame jfrm = new JFrame("JTable Example");

    // Give the frame an initial size.
    jfrm.setSize(400, 300);

    // Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Initialize column headings.
    String[] Headings = { "Name", "Student ID", "Midterm", "Final" };

    // Initialize data.
    String[][] data = {
      { "Tom", " 4-616", " 97", " 87" },
      { "Ken", " 3-786", " 88", " 95" },
      { "Rachel", " 4-674", " 92", " 83" },
      { "Sherry", " 3-235", " 91", " 99" },
      { "Adam", " 2-923", " 76", " 96" },
      { "Jon", " 3-561", " 84", " 80" },
      { "Stuart", " 1-337", " 62", " 74" },
      { "Mary", " 4-731", " 68", " 58" },
      { "Todd", " 2-924", " 82", " 72" },
      { "Shane", " 2-434", " 93", " 91" },
      { "Robert", " 3-769", " 99", " 92" },
    };

    // Create the table.
    JTable table = new JTable(data, Headings);

    // Add the table to a scroll pane.
    JScrollPane jsp = new JScrollPane(table);

    // Add the scroll pane to the content pane.
    jfrm.add(jsp);

    // Display the frame.
    jfrm.setVisible(true);
  }

  public static void main(String[] args) {

    // Create the GUI on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new JTableDemo();
      }
    });
  }
}