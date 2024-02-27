import javafx.event.Event;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateHolder2 {
    private GregorianCalendar today;

    public DateHolder2(GregorianCalendar gc){
        this.today = (GregorianCalendar) gc.clone();
    }

    public void currentMonth(){
        System.out.println(this.today.get(Calendar.MONTH));
    }

    @Override
    public Object clone(){
        return new DateHolder2((GregorianCalendar) this.today.clone());
    }
}
