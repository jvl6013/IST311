package ist311;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalUI extends JFrame {

    //these are declared outside constructor for encapsulation reasons
    Calendar cal = new GregorianCalendar();
    JLabel monthLab;
    ArrayList<JButton> buttons;
    JPanel calen;

    CalUI() {
        //set stuff for window
        setTitle("Calander");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        this.setLayout(new BorderLayout());

        buttons = new ArrayList<JButton>();
        this.calen = new JPanel();

        //set up buttons and lebels
        monthLab = new JLabel();

        //Add action listeners so that way the user can scroll months
        //also calls the methods to add/remove buttons and repaint the label
        JButton monthNex = new JButton("Next Month");
        monthNex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cal.add(Calendar.MONTH, +1);
                updateLabel();
                removeButtons();
                addButtons();

            }
        });

        JButton monthPrev = new JButton("Previous Month");
        monthPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cal.add(Calendar.MONTH, -1);
                updateLabel();
                removeButtons();
                addButtons();

            }
        });

        //ad components
        this.calen.add(monthPrev, BorderLayout.NORTH);
        this.calen.add(monthLab, BorderLayout.NORTH);
        this.calen.add(monthNex, BorderLayout.NORTH);

        this.add(calen);

        //just paint the label and buttons
        updateLabel();
        addButtons();

        //add action listeners to each button, needed for calendar tasks
        //to do: make it identify each button as unique
        //pain in the fucking ass
        for (int i = 0; i < this.buttons.size(); i++) {
            buttons.get(i).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    buttonHit();

                }
            });

        }

    }

    //this changes the label to whatever month the user has
    private void updateLabel() {
        //sets day of month, gets 1st day
        cal.set(Calendar.DAY_OF_MONTH, 1);

        //gets month, makes it long, US reigon
        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);

        //gets year
        int year = cal.get(Calendar.YEAR);

        //sets label to the month + year
        monthLab.setText(month + ", " + year);

    }

    //this adds buttons corresponding to the number of days in month
    private void addButtons() {

        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < days; i++) {
            JButton day = new JButton("" + (i + 1));
            this.buttons.add(day);
            this.calen.add(day);

        }

        this.repaint();

    }

    //removesbuttons from the panel
    private void removeButtons() {
        int size = this.buttons.size();
        for (int i = 0; i < size; i++) {
            this.calen.remove(buttons.get(i));
        }

        this.buttons.clear();

    }

    //test method making sure the buttons are hit
    private void buttonHit() {

        System.out.println("Button number hit");
    }
}

/*
	Controller 
 */
class CalanCtrl {

    CalUI cal;

    CalanCtrl(CalUI cal) {
        this.cal = cal;
    }
}
