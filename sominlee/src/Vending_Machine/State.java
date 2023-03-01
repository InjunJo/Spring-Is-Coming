package Vending_Machine;

public interface State {
    void insertCoin(int money);
    void pushButton();
    void returnCoin();
}
