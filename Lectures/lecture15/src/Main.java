import java.util.LinkedList;

public class Main {

    LinkedList<Integer> nums;

    public Main() throws NegativeIntException   {
        this.nums = new LinkedList<>();
        //System.out.println(this.nums.getFirst());
        Cat c = new Cat("Yan", -5);
    }

    public static void main (String[] args) {
        try {
            Main m = new Main();
        } catch(NegativeIntException e){
            System.err.println(e.getMessage());

        }
    }
}