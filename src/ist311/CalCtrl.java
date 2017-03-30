package ist311;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by fivewen on 3/26/17.
 */
public class CalCtrl {
    Calendar cal;

    public CalCtrl() {
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

        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                table.setValueAt(null, i, j);
            }
        }

        int som = cal.get(Calendar.DAY_OF_WEEK);
        int nod = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i=1; i<=nod; i++){
            int row = new Integer((i+som-2)/7);
            int column = (i+som-2)%7;
            table.setValueAt(i, row, column);
        }

        return table;
    }
}
