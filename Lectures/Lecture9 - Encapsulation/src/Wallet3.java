import java.util.LinkedList;

public class Wallet3 implements IWallet {
    public LinkedList<Integer> bills = new LinkedList<>();

    public Wallet3(int amt){
        this.bills.add(amt);
    }
    @Override
    public boolean removeAmount(int amt) {
        if(this.bills.contains(amt)){
            this.bills.removeFirstOccurrence(amt);
            return true;
        }
        return false;
    }

    @Override
    public void addAmount(int amt) {
        this.bills.add(amt);
    }
}
