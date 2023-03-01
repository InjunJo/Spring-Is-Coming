package Vending_Machine;

class NoMoneyState implements State{
    VendingMachine vendingMachine;

    NoMoneyState (VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int money) {
        System.out.println("money = " + money);
        Drinking drink = vendingMachine.getDrinking();
        // 동전이 충분하면 getEnough 로 충분하지 않으면 noEnough 로
        if(money > drink.getPrice()){
            vendingMachine.setState(vendingMachine.getEnoughMoneyState());
        } else {
            vendingMachine.setState(vendingMachine.getNoEnoughMoneyState());
        }
    }

    @Override
    public void pushButton() {
        System.out.println("돈을 투입해 주세요.");
    }

    @Override
    public void returnCoin() {
        System.out.println("돈을 투입하지 않았습니다.");
    }
}
