import java.util.GregorianCalendar;
import java.util.LinkedList;

public class LLRatings implements iProtected {
    private LinkedList<DailyRatings> ratings;
    public LLRatings(LinkedList<DailyRatings> ratings){
        this.ratings = ratings;
    }


    /**
     * Iterates over the stored data in the field to get the best ranking
     *
     * @param date - Current date to get month data from
     * @return the best rank as an int
     */
    @Override
    public int bestRankThisMonth(GregorianCalendar date) {
        int best = Integer.MAX_VALUE;
        for(DailyRatings dr : this.ratings){
            if(dr.getDate().get(GregorianCalendar.MONTH) == date.get(GregorianCalendar.MONTH)){
                for(int i = 0; i < dr.getRankings().size(); i++){
                    int r = dr.getRankings().get(i);
                    if(r < best) best = r;
                }
            }
        }
        return best;
    }

    /**
     * Gets total subscribers gained on the specific month and year provided
     *
     * @param month - a month when 0 represents January and 11 represents December
     * @param year  - a year
     * @return total subscribers during that month.
     */
    @Override
    public int totalSubscribers(int month, int year) {
        int answer = 0;
        for(DailyRatings dr : this.ratings){
            if(dr.getDate().get(GregorianCalendar.YEAR) == year && dr.getDate().get(GregorianCalendar.MONTH) == month){
                for(Integer s : dr.getSubscribers()){
                    answer += s;
                }
            }
        }
        return answer;
    }

    /**
     * Adds today's Analytical data to the fields and adds one day to the calendar.
     *
     * @param analytics - a LinkedList of Analytics
     * @param date  - a gregorian calendar representing todays date.
     */
    @Override
    public void addTodaysAnalytics(LinkedList<Analytics> analytics, GregorianCalendar date) {
        LinkedList<Integer> rankings = new LinkedList<>();
        LinkedList<Integer> subscribers = new LinkedList<>();
        for(Analytics a: analytics){
            rankings.add(a.getRank());
            subscribers.add(a.getSubscribers());
        }

        DailyRatings todaysRating = new DailyRatings(date, rankings, subscribers);
        ratings.add(todaysRating);

    }
}
