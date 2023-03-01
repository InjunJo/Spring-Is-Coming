package Vending_Machine;

public class VendingMachine {
    final State noMoenyState;
    final State noEnoughMoneyState;
    final State enoughMoneyState;
    final State soldOutState;
    private State currentState;

    public VendingMachine(){
        this.noMoenyState = new NoMoneyState(this);
        this.noEnoughMoneyState = new NoEnoughMoneyState(this);
        this.enoughMoneyState = new EnoughMoneyState(this);
        this.soldOutState = new SoldOutState(this);
        this.currentState = noMoenyState;
    }

    public void setState(State state){
        this.currentState = state;
    }

    public void insertMoney(int money){
        currentState.insertCoin(money);
    }

    void pushButton(){
        currentState.pushButton();
    }

    void returnMoney(){
        currentState.returnCoin();
    }

    public MoneyBox getMoneyBox(){
        return new MoneyBox();
    }

    public Drinking getDrinking(){
        return new Drinking();
    }

    public State getEnoughMoneyState(){
        return enoughMoneyState;
    }

    public State getNoMoenyState(){
        return noMoenyState;
    }
    public State getNoEnoughMoneyState(){
        return noEnoughMoneyState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

}
