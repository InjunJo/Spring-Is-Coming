package VendingMachine;

public class SoldOutState implements State{
    @Override
    public void insertCoin(VendingMachine vm, int money) {
        Drinking drinking = vm.getDrinking();
        MoneyBox moneyBox = vm.getMoneyBox();
        if((money + moneyBox.getMoney()) == 0){
            vm.setState(vm.getNoMoneyState());
        } else if ((money + moneyBox.getMoney()) < drinking.getPrice()) {
            vm.setState(vm.getNoEnoughMoneyState());
        } else if (drinking.getStock() == 0) {
            returnCoin(vm);
            System.out.println("재고가 부족합니다.");
            return;
        } else {
            vm.setState(vm.getEnoughMoneyState());
        }
        vm.insertMoney(money);
    }

    @Override
    public void pushButton(VendingMachine vm) {
        System.out.println("재고가 부족합니다.");
    }

    @Override
    public void returnCoin(VendingMachine vm) {
        if (vm.getMoneyBox().getMoney() > 0) {
            int temp = vm.getMoneyBox().returnMoney();
            System.out.println(temp + "원을 반환했습니다.");
        }
    }
}
