package Vending_Machine;

public class MoneyBox {
    int money;

    public int getMoney() {
        return money;
    }
    public void insert(int money){
        this.money += money;
    }

    void dispense(int price){
        this.money -= price;
    }

    int returnMoney(){
        return money;
    }
}
