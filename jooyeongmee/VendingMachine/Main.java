package VendingMachine;

public class Main {
    public static void main(String[] args) {

        VendingMachine vm = new VendingMachine(3, 1000);

        vm.pushButton();

        vm.insertMoney(500);
        vm.insertMoney(0);
        vm.insertMoney(500);

        vm.pushButton();

        vm.insertMoney(4000);
        vm.pushButton();

        vm.insertMoney(1000);
        vm.pushButton();

        vm.insertMoney(1000);
        vm.returnMoney();
        vm.pushButton();

    }
}

