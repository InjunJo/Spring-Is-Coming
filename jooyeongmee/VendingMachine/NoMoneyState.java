package VendingMachine;

public class NoMoneyState implements State{
    @Override
    public void insertCoin(VendingMachine vm, int money) {
        Drinking drinking = vm.getDrinking();
        MoneyBox moneyBox = vm.getMoneyBox();
        if((money + moneyBox.getMoney()) == 0){
            System.out.println("돈을 안 넣으셨어요!");
            return;
        } else if ((money + moneyBox.getMoney()) < drinking.getPrice()) {
            vm.setState(vm.getNoEnoughMoneyState());
        } else if (drinking.getStock() == 0) {
            vm.setState(vm.getSoldOutState());
        } else {
            vm.setState(vm.getEnoughMoneyState());
        }

        vm.insertMoney(money);
    }

    @Override
    public void pushButton(VendingMachine vm) {
        System.out.println("돈을 먼저 넣고 버튼을 누르세요.");
    }

    @Override
    public void returnCoin(VendingMachine vm) {
        System.out.println("반환할 돈이 없습니다.");
    }
}
