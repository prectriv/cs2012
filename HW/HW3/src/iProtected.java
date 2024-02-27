import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface iProtected {

    /**
     * Iterates over the stored data in the field to get the best ranking
     *
     * @param date Current date to get month data from
     * @return the best rank as an int
     */
    public int bestRankThisMonth(GregorianCalendar date);

    /**
     * Gets total subscribers gained on the specific month and year provided
     *
     * @param month - a month when 0 represents January and 11 represents December
     * @param year  - a year
     * @return total subscribers during that month.
     */
    public int totalSubscribers(int month, int year);

    /**
     * Adds today's Analytical data to the fields and adds one day to the calendar.
     *
     * @param analytics - a LinkedList of Analytics
     * @param date      - a gregorean callender representing todays date.
     */
    public void addTodaysAnalytics(LinkedList<Analytics> analytics, GregorianCalendar date);

}
