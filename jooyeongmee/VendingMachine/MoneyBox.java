package VendingMachine;

public class MoneyBox {

    private int money;

    MoneyBox () {
        this.money = 0;
    }

    public int getMoney() {
        return money;
    }
    public void dispense(int price) {
        money -= price;
    }
    void insert(int money) {
        this.money += money;
        System.out.println("현재 총 " + this.money + "원을 넣었습니다.");
    }
    int returnMoney() {
        int temp =  money;
        money = 0;
        return temp;

    }
}