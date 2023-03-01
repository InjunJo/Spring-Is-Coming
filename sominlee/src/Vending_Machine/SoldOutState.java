package Vending_Machine;

class SoldOutState implements State{
    VendingMachine vendingMachine;

    SoldOutState (VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    MoneyBox moneyBox = vendingMachine.getMoneyBox();

    @Override
    public void insertCoin(int money) {
        moneyBox.insert(money);
        System.out.println("money = " + money);
        System.out.println("재고가 부족합니다.");
    }

    @Override
    public void pushButton() {
        System.out.println("재고가 부족합니다.");
    }

    @Override
    public void returnCoin() {
        // 동전 다시 반환
        System.out.println(moneyBox.returnMoney());
    }
}
