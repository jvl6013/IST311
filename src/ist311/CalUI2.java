/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import static java.awt.GridBagConstraints.PAGE_START;

/**
 *
 * @author jvl6013
 */
public class CalUI2 extends JFrame{
    JFrame frame = new JFrame("Table");
    JPanel panel = new JPanel();
    JTable table = new JTable();
    JScrollPane pane = new JScrollPane();

    public CalUI2(){

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        JPanel panel = new JPanel();
        panel = initCal();
        
        frame.setSize(800, 600);
        frame.setTitle("Calendar");
        frame.add(panel);
    }
    
    private JPanel initCal(){
        CalCtrl calcontrol = new CalCtrl();

        panel.setLayout(new BorderLayout());
        
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout());
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1));
        
        JLabel yearLabel = new JLabel("" + calcontrol.getYear(), SwingConstants.CENTER);
        JLabel monthLabel = new JLabel(calcontrol.toStringtMonth(calcontrol.getMonth()), SwingConstants.CENTER);
        textPanel.add(yearLabel);
        textPanel.add(monthLabel);
        
        JButton prevMonth = new JButton();
        prevMonth.setText("Previous Month");
        prevMonth.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                panel.remove(pane);

                calcontrol.prevMonth();
                table = calcontrol.getCalendar();
                yearLabel.setText("" + calcontrol.getYear());
                monthLabel.setText(calcontrol.toStringtMonth(calcontrol.getMonth()));

                pane = new JScrollPane(table);


                pane.revalidate();
                panel.add(pane);

            }
        });
        JButton nextMonth = new JButton();
        nextMonth.setText("Next Month");
        nextMonth.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                panel.remove(pane);

                calcontrol.nextMonth();
                table = calcontrol.getCalendar();
                yearLabel.setText("" + calcontrol.getYear());
                monthLabel.setText(calcontrol.toStringtMonth(calcontrol.getMonth()));

                pane = new JScrollPane(table);
                panel.add(pane);

            }
        });


        navPanel.add(prevMonth);
        navPanel.add(textPanel);
        navPanel.add(nextMonth);
        
        panel.add(navPanel, BorderLayout.PAGE_START);

        table = calcontrol.getCalendar();

        System.out.println(calcontrol.cal.get(Calendar.DAY_OF_WEEK));
        
        pane = new JScrollPane(table);
        
        panel.add(pane, BorderLayout.CENTER);
        panel.setOpaque(true);
        
        return panel;
    }
    
}
