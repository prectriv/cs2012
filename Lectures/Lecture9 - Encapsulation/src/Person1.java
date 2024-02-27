import java.util.LinkedList;

public class Person1 {

    public LinkedList<Integer> wallet = new LinkedList<Integer>();
    public void buyPizza(){
        if(this.wallet.contains(5)){
            this.wallet.removeFirstOccurrence(5);
            System.out.println("Delicious pizza is delicious");
        }
        else {
            System.err.println("No Pizza? :(");
        }
    }



}
