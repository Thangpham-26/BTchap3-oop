import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class TestMyDate {
    public static boolean isLeapYear(int year) {
        if(year % 400 == 0){
            return true;
        }
        if (year % 4 == 0 && year % 100 != 0){
            return true;
        }
        return false;
    }
    public static boolean isValidDate(int year, int month, int day) {
        String dateString = String.format("%d-%d-%d", year, month, day);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateString);
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
    public static int getDayOfWeek(int year, int month, int day) {
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String dateString = String.format("%d-%d-%d", year, month, day);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(MyDate.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        dateString = new SimpleDateFormat("EEEE").format(date);
        int d=0;
        for(String week: weeks){
            if(week.equals(dateString)) break;
            d++;
        }
        return d;
    }
    public static void main(String[] args) {
        MyDate d1 = new MyDate(2012, 2, 28);
        System.out.println(d1);             // Tuesday 28 Feb 2012
        System.out.println(d1.nextDay());   // Wednesday 29 Feb 2012
        System.out.println(d1.nextDay());   // Thursday 1 Mar 2012
        System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012
        System.out.println(d1.nextYear());  // Monday 1 Apr 2013
        MyDate d2 = new MyDate(2012, 1, 2);
        System.out.println(d2);                 // Monday 2 Jan 2012
        System.out.println(d2.previousDay());   // Sunday 1 Jan 2012
        System.out.println(d2.previousDay());   // Saturday 31 Dec 2011
        System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011
        System.out.println(d2.previousYear());  // Tuesday 30 Nov 2010
        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear());  // Monday 28 Feb 2011
        MyDate d4 = new MyDate(2099, 11, 31); // Invalid year, month, or day!
        MyDate d5 = new MyDate(2011, 2, 29);  // Invalid year, month, or day!
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(getDayOfWeek(2099, 10, 31));
        System.out.println(isValidDate(2099, 10, 32));
    }
}
