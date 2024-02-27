public interface IWallet {

    public boolean removeAmount(int amt);
    public void addAmount(int amt);

    public default boolean transfer(int amt, IWallet wallet){
        if(this.removeAmount(amt)){
            wallet.addAmount(amt);
            return true;
        }
        return false;
    }
}
