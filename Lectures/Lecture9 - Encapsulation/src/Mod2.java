import java.util.LinkedList;

public class Mod2 {


    public static void main(String[] args){
        Person2 person1 = new Person2(5);
        Person2 person2 = new Person2(0);
        // unable to access: person2.wallet;
        person1.buyPizza(person2);
    }



}


