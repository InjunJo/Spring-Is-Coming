package Vending_Machine;

class NoEnoughMoneyState implements State{
    VendingMachine vendingMachine;

    NoEnoughMoneyState (VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int money) {
        System.out.println("money = " + money);
        // money를 추가했을 때 음료 가격보다 크면 getEnoughMoney로
        Drinking drink = vendingMachine.getDrinking();
        MoneyBox moneyBox = vendingMachine.getMoneyBox();
        moneyBox.insert(money);
        if(moneyBox.getMoney() > drink.price) {
            vendingMachine.setState(vendingMachine.getEnoughMoneyState());
        }

    }

    @Override
    public void pushButton() {
        System.out.println("금액이 부족합니다.");
    }

    @Override
    public void returnCoin() {
        MoneyBox moneyBox = vendingMachine.getMoneyBox();
        // 동전 다시 반환
        System.out.println(moneyBox.returnMoney());
    }
}
