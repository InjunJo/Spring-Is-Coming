package VendingMachine;

public class EnoughMoneyState implements State{
    @Override
    public void insertCoin(VendingMachine vm, int money) {
        Drinking drinking = vm.getDrinking();
        MoneyBox moneyBox = vm.getMoneyBox();
        if((money + moneyBox.getMoney()) == 0){
            vm.setState(vm.getNoMoneyState());
        } else if ((money + moneyBox.getMoney()) < drinking.getPrice()) {
            vm.setState(vm.getNoEnoughMoneyState());
        } else if (drinking.getStock() == 0) {
            vm.setState(vm.getSoldOutState());
        } else {
            moneyBox.insert(money);
            return;
        }
        vm.insertMoney(money);
    }

    @Override
    public void pushButton(VendingMachine vm) {
        Drinking drinking = vm.getDrinking();
        MoneyBox moneyBox = vm.getMoneyBox();

        drinking.dispense();
        moneyBox.dispense(drinking.getPrice());

        returnCoin(vm);
    }

    @Override
    public void returnCoin(VendingMachine vm) {
        int temp = vm.getMoneyBox().returnMoney();
        if (temp > 0) {
            System.out.println("거스름돈은 " + temp + "원 입니다.");
        }
    }
}
