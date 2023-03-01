package Vending_Machine;

class EnoughMoneyState implements State{
    VendingMachine vendingMachine;

    EnoughMoneyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    Drinking drink = vendingMachine.getDrinking();
    MoneyBox moneyBox = vendingMachine.getMoneyBox();

    @Override
    public void insertCoin(int money) {
        moneyBox.insert(money);
        System.out.println("money = " + money);
        System.out.println("이미 동전이 들어있습니다.");
    }

    @Override
    public void pushButton() {
        if(drink.getStock() != 0){
            drink.dispense();
            moneyBox.dispense(drink.getPrice());
            if(moneyBox.getMoney() == 0){
                vendingMachine.setState(vendingMachine.getNoMoenyState());
            }
        } else {
            vendingMachine.setState(vendingMachine.getSoldOutState());
        }

    }

    @Override
    public void returnCoin() {
        System.out.println(moneyBox.returnMoney());
    }
}
