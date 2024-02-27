import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar(); // sets date and time to right now
        System.out.println(gc.get(Calendar.MONTH)); //prints month in 0 index.
        gc.add(Calendar.MONTH,1);
        System.out.println(gc.get(Calendar.MONTH)); //prints current month +1 in 0 index.

        GregorianCalendar gc2 = new GregorianCalendar(); // sets date and time to right now
        DateHolder dh = new DateHolder(gc2);

        gc2.add(Calendar.MONTH, 3);
        dh.currentMonth(); // will print july as DateHolder only HOLDS the objects location in ram, not a new object.






        GregorianCalendar gc3 = new GregorianCalendar(); // sets date and time to right now
        DateHolder2 dh2 = new DateHolder2(gc3);

        gc3.add(Calendar.MONTH, 3);
        dh2.currentMonth(); // will print same month as DateHolder2 clones the data
    }
}