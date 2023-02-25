package VendingMachine;

public class VendingMachine {
    private State state = new NoMoneyState();
    private Drinking drinking;
    private MoneyBox moneyBox;


    VendingMachine(int stock, int price) {
        drinking = new Drinking(stock, price);
        moneyBox = new MoneyBox();
    }
    void setState(State state) {
        this.state = state;
    }
    void insertMoney(VendingMachine this, int money) {
        state.insertCoin(this, money);
    }

    void pushButton(VendingMachine this) {
        state.pushButton(this);
    }
    void returnMoney(VendingMachine this) {
        state.returnCoin(this);
    }
    MoneyBox getMoneyBox(){
        return moneyBox;
    }
    Drinking getDrinking() {
        return drinking;
    }

    State getNoMoneyState() {
        return new NoMoneyState();
    }
    State getNoEnoughMoneyState() {
        return new NoEnoughMoneyState();
    }
    State getEnoughMoneyState() {
        return new EnoughMoneyState();
    }
    State getSoldOutState() {
        return new SoldOutState();
    }
}


