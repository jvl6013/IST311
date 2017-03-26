/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jvl6013
 */
public class CalUI2 extends JFrame{
    public CalUI2(){
        JFrame frame = new JFrame("Table");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        JPanel panel = new JPanel();
        panel = initCal();
        
        frame.setSize(800, 800);
        frame.add(panel);
    }
    
    private JPanel initCal(){
        Calendar cal = new GregorianCalendar(2017, 2, 1);
        int day, month, year;
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(1, 3));
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1));
        
        JLabel yearLabel = new JLabel();
        yearLabel.setText("YEAR: " + cal.get(GregorianCalendar.YEAR));
        JLabel monthLabel = new JLabel();
        monthLabel.setText("MONTH: " + (cal.get(GregorianCalendar.MONTH) + 1));
        textPanel.add(yearLabel);
        textPanel.add(monthLabel);
        
        JButton prevMonth = new JButton();
        prevMonth.setText("Previous Month");
        JButton nextMonth = new JButton();
        nextMonth.setText("Next Month");

        navPanel.add(prevMonth);
        navPanel.add(textPanel);
        navPanel.add(nextMonth);
        
        panel.add(navPanel);
        
        String[] columnNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String data[][] = {{}};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        model.setRowCount(6);
        model.setColumnCount(7);
        
        JTable table = new JTable(model);
        table.setRowHeight(50);
        
        day = cal.get(GregorianCalendar.DAY_OF_MONTH);
        month = cal.get(GregorianCalendar.MONTH);
        year = cal.get(GregorianCalendar.YEAR);
        
        System.out.println(day + " " + month + " " + year);
        
        int som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        int nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        System.out.println(som);
        System.out.println(nod);
        
        for (int i=1; i<=nod; i++){
            int row = new Integer((i+som-2)/7);
            int column = (i+som-2)%7;
            table.setValueAt(i, row, column);
        }
        
        JScrollPane pane = new JScrollPane(table);
        
        panel.add(pane);
        panel.setOpaque(true);
        
        return panel;
    }
    
    
}
