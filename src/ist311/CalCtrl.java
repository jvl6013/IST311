package ist311;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.List;
import javax.swing.table.TableCellRenderer;

/**
 * Created by fivewen on 3/26/17.
 */
public class CalCtrl {

    Calendar cal;
    String username;

    public CalCtrl(String username) {
        this.username = username;
        cal = new GregorianCalendar();
    }

    public String toStringtMonth(int month) {
        String monthString;
        switch (month) {
            case 0:
                monthString = "January";
                break;
            case 1:
                monthString = "February";
                break;
            case 2:
                monthString = "March";
                break;
            case 3:
                monthString = "April";
                break;
            case 4:
                monthString = "May";
                break;
            case 5:
                monthString = "June";
                break;
            case 6:
                monthString = "July";
                break;
            case 7:
                monthString = "August";
                break;
            case 8:
                monthString = "September";
                break;
            case 9:
                monthString = "October";
                break;
            case 10:
                monthString = "November";
                break;
            case 11:
                monthString = "December";
                break;
            default:
                monthString = "Invalid month";
                break;
        }
        return monthString;
    }

    public int getYear() {
        return cal.get(Calendar.YEAR);
    }

    public int getMonth() {
        return cal.get(Calendar.MONTH);

    }

    public int getDay() {
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public void prevMonth() {
        cal.add(Calendar.MONTH, -1);
    }

    public void nextMonth() {
        cal.add(Calendar.MONTH, 1);
    }

    public JTable getCalendar() {
        cal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
        //System.out.println(cal.get(Calendar.YEAR) + " " + cal.get(Calendar.MONTH) + " " + cal.get(Calendar.DAY_OF_MONTH));

        String[] columnNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String data[][] = {{}};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        model.setRowCount(6);
        model.setColumnCount(7);

        JTable table = new JTable(model);
        table.setRowHeight(80);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                table.setValueAt(null, i, j);

            }
        }

        int som = cal.get(Calendar.DAY_OF_WEEK);
        int nod = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        TaskListCtrl tlc = new TaskListCtrl(username);
        tlc.addTask("Do Laundry", "Do Laundry", new Date());
        tlc.addTask("Do Homework", "Do Laundry", new Date());

        for (int i = 1; i <= nod; i++) {
            int row = new Integer((i + som - 2) / 7);
            int column = (i + som - 2) % 7;

            table.setValueAt(i, row, column);

            for(int j = 0; j < tlc.taskList.size(); j++) {
                if (!(table.getValueAt(row, column) instanceof String)) {
                    if (cal.get(Calendar.YEAR) == (tlc.taskList.get(j).taskDueDate.getYear() + 1900) &&
                            cal.get(Calendar.MONTH) == tlc.taskList.get(j).taskDueDate.getMonth() &&
                            (Integer) table.getValueAt(row, column) == tlc.taskList.get(j).taskDueDate.getDay()) {

                        table.setValueAt(i + " (*)", row, column);
                    }
                }
            }
        }

        table.setDefaultEditor(Object.class, null);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    int frameRowCounter = 2;

                    JFrame frame = new JFrame("Tasks");


                    for(int i = 0; i < tlc.taskList.size(); i++){
                        if(cal.get(Calendar.YEAR) == (tlc.taskList.get(i).taskDueDate.getYear() + 1900) &&
                                cal.get(Calendar.MONTH) == tlc.taskList.get(i).taskDueDate.getMonth() &&
                                Integer.parseInt(((String)table.getValueAt(row, column)).substring(0,1)) == tlc.taskList.get(i).taskDueDate.getDay()){

                            frameRowCounter++;
                        }
                    }

                    JPanel panel = new JPanel(new GridLayout(frameRowCounter, 1));

                    JLabel dateLabel = new JLabel();
                    dateLabel.setText(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + Integer.parseInt(((String)table.getValueAt(row, column)).substring(0,1)));
                    panel.add(dateLabel);

                    panel.add(new JLabel(""));


                    for(int i = 0; i < tlc.taskList.size(); i++){
                        if(cal.get(Calendar.YEAR) == (tlc.taskList.get(i).taskDueDate.getYear() + 1900) &&
                                cal.get(Calendar.MONTH) == tlc.taskList.get(i).taskDueDate.getMonth() &&
                                Integer.parseInt(((String)table.getValueAt(row, column)).substring(0,1)) == tlc.taskList.get(i).taskDueDate.getDay()){

                            JLabel jl = new JLabel();
                            jl.setText(tlc.taskList.get(i).taskName + ": " + tlc.taskList.get(i).taskDescription);
                            panel.add(jl);
                        }
                    }

                    frame.add(panel);
                    frame.pack();
                    frame.setVisible(true);

                }
            }
        });

        return table;
    }
}
