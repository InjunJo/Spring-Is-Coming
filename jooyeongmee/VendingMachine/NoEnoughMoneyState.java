package VendingMachine;

public class NoEnoughMoneyState implements State{
    @Override
    public void insertCoin(VendingMachine vm, int money) {
        Drinking drinking = vm.getDrinking();
        MoneyBox moneyBox = vm.getMoneyBox();
        if((money + moneyBox.getMoney()) == 0){
            vm.setState(vm.getNoMoneyState());
        } else if ((money + moneyBox.getMoney()) < drinking.getPrice()) {
            moneyBox.insert(money);
            return;
        } else if (drinking.getStock() == 0) {
            vm.setState(vm.getSoldOutState());
        } else {
            vm.setState(vm.getEnoughMoneyState());
        }
        vm.insertMoney(money);

    }

    @Override
    public void pushButton(VendingMachine vm) {
        System.out.println("구매하려면 돈을 더 넣어주세요.");
    }

    @Override
    public void returnCoin(VendingMachine vm) {
        MoneyBox moneyBox = vm.getMoneyBox();
        int temp = moneyBox.returnMoney();
        System.out.println(temp + "원을 반환했습니다.");
    }
}
