import java.util.LinkedList;

public class Person3 {
    private IWallet wallet;
    public Person3(IWallet wallet){
        this.wallet = wallet;
    }
    public boolean request5(Person3 p){
        return p.give5(this); //ask p to give me $5
    }

    public boolean give5(Person3 p){
        return this.wallet.transfer(5,p.wallet); //smart wallets go beep-boop
    }

    public void buyPizza(Person3 p){
        if(this.wallet.removeAmount(5)){
            System.out.println("Delicious pizza is delicious");
        }
        else if(this.request5(p)){ //I'm short, let me ask and then try again
            this.buyPizza(p);
        } else {
            System.err.println("No Pizza? :("); //Tragic tale of the garlic-knot-havers and the garlic-have-notters
        }
    }
}
