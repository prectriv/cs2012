import java.util.LinkedList;

public class Mod1 {

    public static void main(String[] args){
        Person1 person1 = new Person1();
        Person1 person2 = new Person1();
        person2.wallet.add(5);
        if(person2.wallet.contains(5)){
            person2.wallet.removeFirstOccurrence(5);
            person1.wallet.add(5);
        }
        person1.buyPizza();
    }
}
