package VendingMachine;

public class Drinking {
    private int price;
    private int stock;

    Drinking(){}

    Drinking(int stock, int price) {
        this.price = price;
        this.stock = stock;
    }

    int getPrice() {return price;}
    int getStock() {
        return stock;
    }

    public void dispense() {
        stock--;
        System.out.println("음료 제조 완료");
    }
}
