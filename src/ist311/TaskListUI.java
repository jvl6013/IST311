/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author jvl6013
 */
public class TaskListUI {
    TaskListCtrl tlc = new TaskListCtrl();
    DefaultListModel<Task> model = new DefaultListModel<Task>();
    JList<Task> taskJList;
    
    public TaskListUI(){
        tlc.addTask("Laundry", "Do Laudnry", new Date());
        tlc.addTask("Homework", "Do Homework", new Date());

        for(Task t:tlc.getTaskList()){
            model.addElement(t);
        }
        
        initComp();
    }

    private void initComp() {
        JButton addTaskButton = new JButton("Add");
        JButton deleteTaskButton = new JButton("Delete");
        JButton editTaskButton = new JButton("Edit");
        
        JLabel taskNameL = new JLabel("Task Name: ");
        JLabel taskDescriptionL = new JLabel("Task Description: ");
        JLabel taskDueDateL = new JLabel("Due Date: ");
        JLabel taskDueDateYL = new JLabel("Year: ");
        JLabel taskDueDateML = new JLabel("Month: ");
        JLabel taskDueDateDL = new JLabel("Day: ");
        JLabel taskCreatedDateL = new JLabel("Created Date: ");
        
        JTextField yearTextField = new JTextField();
        yearTextField.setPreferredSize(new Dimension(80, 20));
        yearTextField.setMaximumSize(yearTextField.getPreferredSize());
        
        String[] monthString = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        JComboBox monthComboBox = new JComboBox(monthString);
        monthComboBox.setPreferredSize(new Dimension(80, 20));
        monthComboBox.setMaximumSize(monthComboBox.getPreferredSize());
        
        String[] dayString = { "1", "2", "3", "4", "5", "6" ,"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        JComboBox dayComboBox = new JComboBox(dayString);
        
        dayComboBox.setPreferredSize(new Dimension(80, 20));
        dayComboBox.setMaximumSize(monthComboBox.getPreferredSize());
        
        
        JTextField taskName = new JTextField();
        taskName.setPreferredSize(new Dimension(500, 20));
        taskName.setMaximumSize(taskName.getPreferredSize());
        
        JTextField taskDescription = new JTextField();
        taskDescription.setPreferredSize(new Dimension(500, 100));
        taskDescription.setMaximumSize(taskDescription.getPreferredSize());
        
        JTextField taskCreatedDate = new JTextField();
        taskCreatedDate.setPreferredSize(new Dimension(500, 20));
        taskCreatedDate.setMaximumSize(taskCreatedDate.getPreferredSize());
        
        addTaskButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Task t = new Task(taskName.getText(), taskDescription.getText(), new Date(Integer.parseInt(yearTextField.getText()) - 1900, monthComboBox.getSelectedIndex(), dayComboBox.getSelectedIndex() + 1));
                tlc.addTask(t);
                model.addElement(t);
                taskJList.revalidate();
            }
        });
        deleteTaskButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DefaultListModel model = (DefaultListModel) taskJList.getModel();
                int selectedIndex = taskJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    model.remove(selectedIndex);
                    tlc.deleteTask(selectedIndex);
                    taskJList.revalidate();
                }
            }
        });
        editTaskButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DefaultListModel model = (DefaultListModel) taskJList.getModel();
                int selectedIndex = taskJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    tlc.setTask(selectedIndex, taskName.getText(), taskDescription.getText(), new Date(Integer.parseInt(yearTextField.getText()) - 1900, monthComboBox.getSelectedIndex(), dayComboBox.getSelectedIndex() + 1));
                    taskJList.revalidate();
                    taskJList.repaint();
                }
            }
        });
        
        JFrame frame = new JFrame("Task List");
        frame.setPreferredSize(new Dimension(600, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        JPanel panel = new JPanel();
        JPanel listPanel = new JPanel();
        JPanel displayPanel = new JPanel();
        
        taskJList = new JList(model);
        
        taskJList.setCellRenderer(new TaskRenderer());
        taskJList.setVisibleRowCount(-1);
        
        ListSelectionModel listSelectionModel;
        listSelectionModel = taskJList.getSelectionModel();
        
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                JList list = (JList) listSelectionEvent.getSource();
                int selections[] = list.getSelectedIndices();
                for (int i = 0, n = selections.length; i < n; i++) {
                    taskName.setText(tlc.getTaskList().get(selections[i]).taskName);
                    taskDescription.setText(tlc.getTaskList().get(selections[i]).taskDescription);
                    yearTextField.setText((tlc.getTaskList().get(selections[i]).taskDueDate.getYear() + 1900 ) + "");
                    taskCreatedDate.setText(tlc.getTaskList().get(selections[i]).taskCreatedDate.toString());
                    monthComboBox.setSelectedIndex(tlc.getTaskList().get(selections[i]).taskDueDate.getMonth());
                    dayComboBox.setSelectedIndex(tlc.getTaskList().get(selections[i]).taskDueDate.getDate() - 1);
                }
            }
        };
        taskJList.addListSelectionListener(listSelectionListener);
        
        JScrollPane pane = new JScrollPane(taskJList);
        pane.setPreferredSize(new Dimension(250,400));

        listPanel.add(pane);
        listPanel.add(addTaskButton);
        listPanel.add(deleteTaskButton);
        listPanel.add(editTaskButton);
        
        //---------------------------------------------------------------------------------------------------------
        
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        
        displayPanel.add(taskNameL);
        displayPanel.add(taskName);
        displayPanel.add(taskDescriptionL);
        displayPanel.add(taskDescription);
        displayPanel.add(taskDueDateL);
        displayPanel.add(taskDueDateYL);
        displayPanel.add(yearTextField);
        displayPanel.add(taskDueDateML);
        displayPanel.add(monthComboBox);
        displayPanel.add(taskDueDateDL);
        displayPanel.add(dayComboBox);
        displayPanel.add(taskCreatedDateL);
        displayPanel.add(taskCreatedDate);
        
        panel.setLayout(new GridLayout(1, 2));
        panel.add(listPanel);
        panel.add(displayPanel);
        
        frame.setContentPane(panel);        
        frame.pack();
        frame.setVisible(true);
        
    }
}

class TaskRenderer extends JLabel implements ListCellRenderer {
  private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

  public TaskRenderer() {
    setOpaque(true);
  }

  public Component getListCellRendererComponent(JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {
    Task tk = (Task) value;
    setText(tk.getTaskName());
    
    if (isSelected) {
      setBackground(HIGHLIGHT_COLOR);
      setForeground(Color.white);
    } else {
      setBackground(Color.white);
      setForeground(Color.black);
    }
    return this;
  }
}
