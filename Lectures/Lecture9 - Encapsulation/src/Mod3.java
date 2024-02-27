public class Mod3 {
    public static void main(String[] args){
        Person3 person1 = new Person3(new Wallet3(0));
        //Person3 person2 = new Person3(new Wallet3(5));
        SortingWallet sw = new SortingWallet();
        sw.addAmount(10);
        sw.addAmount(5);
        sw.addAmount(2);
        sw.addAmount(1);
        sw.addAmount(1);
        sw.addAmount(20);
        Person3 person2 = new Person3(sw);
        person1.buyPizza(person2);
    }
}
