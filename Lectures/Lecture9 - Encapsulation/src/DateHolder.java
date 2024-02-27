import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateHolder{
    private GregorianCalendar today;

    public DateHolder(GregorianCalendar gc){
        this.today = gc;
    }

    public void currentMonth(){
        System.out.println(this.today.get(Calendar.MONTH));
    }
}
