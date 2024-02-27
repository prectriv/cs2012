import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Streamometer {
    private GregorianCalendar date;
    //private LinkedList<DailyRatings> ratings;
    private iProtected ratings;
    public Streamometer(GregorianCalendar today, iProtected initialRatings){
        this.date = today;
        this.ratings = initialRatings;
    }

    /**
     * Iterates over the stored data in the field to get the best ranking
     * @return the best rank as an int
     */
    public int bestRankThisMonth(){
        return this.ratings.bestRankThisMonth(this.date);
    }

    /**
     * Gets total subscribers gained on the specific month and year provided
     * @param month - a month when 0 represents January and 11 represents December
     * @param year - a year
     * @return total subscribers during that month.
     */
    public int totalSubscribers(int month, int year){
        return this.ratings.totalSubscribers(month, year);
    }

    /**
     * Adds today's Analytical data to the fields and adds one day to the calendar.
     * @param analytics - a LinkedList of Analytics
     */
    public void addTodaysAnalytics(LinkedList<Analytics> analytics){
        GregorianCalendar dataDate = (GregorianCalendar) this.date.clone();
            this.date.add(GregorianCalendar.DAY_OF_YEAR, 1);
            this.ratings.addTodaysAnalytics(analytics, dataDate);

    }
}
