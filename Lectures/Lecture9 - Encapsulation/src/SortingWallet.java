import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SortingWallet implements IWallet{
    private ArrayList<Integer> bills = new ArrayList<>();
    public SortingWallet() {

    }
    public int findBill(int amt, int[] sortedBills){
        // iterative binary search using a while-loop
        int i = sortedBills.length / 2;
        int sizeToSearch = sortedBills.length / 2;
        while(sizeToSearch > 0){
            if(sortedBills[i] == amt){
                return i;
            }
            else if(sortedBills[i] > amt){
                sizeToSearch = sizeToSearch / 2;
                i = i - sizeToSearch;
            }
            else {
                sizeToSearch = sizeToSearch / 2;
                i = i + sizeToSearch;
            }
        }
        return -1;
    }
    @Override
    public boolean removeAmount(int amt) {
        int[] sortedBills = this.bills.stream().mapToInt(Integer::intValue).toArray();
        int index = this.findBill(amt, sortedBills);
        if(index != -1) {
            this.bills.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void addAmount(int amt) {
        this.bills.add(amt);
        this.bills.sort(Integer::compareTo);
    }

    @Test
    public void test_findBill()
    {
        this.addAmount(1);
        this.addAmount(1);
        this.addAmount(5);
        this.addAmount(3);
        this.addAmount(1);
        this.addAmount(2);
        this.addAmount(10);
        this.addAmount(20);
        this.addAmount(10);
        this.addAmount(50);
        assertEquals(4,this.findBill(3,this.bills.stream().mapToInt(Integer::intValue).toArray()));
    }
}
