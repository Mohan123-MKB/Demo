import java.util.*;

interface Discountable {
    double applyDiscount(double total);
}

abstract class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void display();
}

class FoodItem extends Item {
    public FoodItem(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println(getName() + " - Rs " + getPrice());
    }
}

class StationaryItem extends Item {
    public StationaryItem(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println(getName() + " - Rs " + getPrice());
    }
}

class Order implements Discountable {
    private List<Item> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void additem(Item item) {
        items.add(item);
    }

    public double calTot() {
        double sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    @Override
    public double applyDiscount(double total) {
        if (total >= 1000) {
            return total * 0.9;
        }
        return total;
    }

    public void printBill() {
        System.out.println("---------- Order Summary ----------");
        for (Item item : items) {
            item.display();
        }
        double total = calTot();
        double finalTotal = applyDiscount(total);
        System.out.println("Total: Rs " + total);
        if (finalTotal < total) {
            System.out.println("Discount 10% is applied.");
        }
        System.out.println("Payable: Rs " + finalTotal);
        System.out.println("-----------------------------------");
    }
}

public class OrderManagementSystem {
    public static void main(String[] args) {
        Order myOrder = new Order();
        myOrder.additem(new FoodItem("Pizza", 180));
         myOrder.additem(new FoodItem("Cheese Burger", 700));
        myOrder.additem(new StationaryItem("NoteBook Bundle", 200));
        myOrder.printBill();
    }
}
