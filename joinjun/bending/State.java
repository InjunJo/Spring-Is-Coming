package chap7.bending;

public interface State {

    public void insertMoney(BendingMachine machine,int money);
    public void purchase(BendingMachine machine);
    public void moneyChange(BendingMachine machine);

}




