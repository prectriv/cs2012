import java.util.LinkedList;

public class Person2 {

    private LinkedList<Integer> wallet = new LinkedList<Integer>();
    public Person2(Integer i){
        wallet.add(i);
    }
    public boolean request5(Person2 p){
        return p.give5(this);
    }

    public boolean give5(Person2 p){
        if(this.wallet.contains(5)){
            this.wallet.removeFirstOccurrence(5);
            p.wallet.add(5);
            return true;
        }
        return false;
    }

    public void buyPizza(Person2 p){
        if(this.wallet.contains(5)){
            this.wallet.removeFirstOccurrence(5);
            System.out.println("Delicious pizza is delicious");
        }
        else if(this.request5(p)){
            this.buyPizza(p);
        } else {
            System.err.println("No Pizza? :(");
        }
    }
}