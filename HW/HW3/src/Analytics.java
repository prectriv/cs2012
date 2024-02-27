public class Analytics {
    private int rank;
    private int subscribers;

    public Analytics(int rank, int subscribers){
        this.rank = rank;
        this.subscribers = subscribers;
    }
    public int getRank(){
        int r = this.rank; //duplicate variable - creates new memory reference.
        return r;
    }
    public int getSubscribers(){
        int s = this.subscribers;
        return s;
    }
}
