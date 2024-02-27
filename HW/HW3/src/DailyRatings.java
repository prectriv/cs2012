import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyRatings {
    private GregorianCalendar currentDate;
    private LinkedList<Integer> rankings;
    private LinkedList<Integer> subscribers;

    public DailyRatings(GregorianCalendar currentDate, LinkedList<Integer> rankings, LinkedList<Integer> subscribers) {
        this.currentDate = currentDate;
        this.rankings = rankings;
        this.subscribers = subscribers;
    }

    public GregorianCalendar getDate() {
        return (GregorianCalendar) this.currentDate.clone();
    }

    public LinkedList<Integer> getRankings() {
        return new LinkedList<>(this.rankings);
    }

    public LinkedList<Integer> getSubscribers() {
        return new LinkedList<>(this.subscribers);
    }
}
