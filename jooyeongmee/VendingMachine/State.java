package VendingMachine;

public interface State {
    void insertCoin(VendingMachine vm, int money);
    void pushButton(VendingMachine vm);
    void returnCoin(VendingMachine vm);
}
