package _todoInSection;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class StudentGUI extends JFrame {

  /**
   * Set the GUI to be visible
   * 
   * @param args
   *            unused
   */
  public static void main(String args[]) {
    new StudentGUI().setVisible(true);
  }

  // Need a TableModel to set as the model for a JTabel
  private TableModel model = null;

  // Like DefaultListModel and JList, now we have
  // a class that implements TableModel so this JTable
  // can display rows and columns of data in a graphical manner
  private JTable table = null;

  /**
   * The constructor for a StudentTable. Sets up the GUI and the JTable
   */
  public StudentGUI() {
    // set up the JFrame
    setTitle("Sort Table Demo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(700, 140);
    setLocation(30, 30);

    model = new StudentCollection();
 
    table = new JTable(model);
    
    JScrollPane scroll = new JScrollPane(table);
    
    this.add(scroll);
    
    RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
 
    table.setRowSorter(sorter);
 
    // Layout the GUI
    JButton button = new JButton("Select Highlighted Row");
    JPanel panel = new JPanel();
    panel.setMaximumSize(new Dimension(30, 30));
    panel.add(button);
    add(panel, BorderLayout.WEST);

    // Listen to the button click
    button.addActionListener(new ButtonListener());
  }

  private class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent arg0) {

      System.out.println(model.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));

    }
  }
}