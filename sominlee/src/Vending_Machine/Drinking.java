package Vending_Machine;

public class Drinking {
    int price;
    int stock;

    public Drinking() {
        this.price = 1500;
        this.stock = 5;
    }

    void dispense(){
        System.out.println("음료가 나왔습니다.");
        this.stock -= 1;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
