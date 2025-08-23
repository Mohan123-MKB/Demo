//Encapsulation
class BankAccount1 {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount1(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter & Setter
    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs " + amount);
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: Rs " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

//Inheritance
// Base class
class Shape1 {
    public void draw() {
        System.out.println("Drawing a shape...");
    }
}

// Derived class
class Circle1 extends Shape1 {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Derived class
class Rectangle1 extends Shape1 {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

//Abstraction
abstract class Animal {
    abstract void sound();   // abstract method

    public void sleep() {
        System.out.println("Sleeping...");
    }
}
class Dog1 extends Animal {
    public void sound() {
        System.out.println("Woof Woof!");
    }
}
class Cat1 extends Animal {
    public void sound() {
        System.out.println("Meow Meow!");
    }
}

//Interface
interface Discountable {
    double applyDiscount(double price);
}
class FoodItem1 implements Discountable {
    private String name;
    private double price;

    public FoodItem1(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double applyDiscount(double price) {
        return price * 0.9; // 10% discount
    }

    public void display() {
        System.out.println(name + " original price: " + price 
                           + ", discounted price: " + applyDiscount(price));
    }
}

//polymorphism
class Calculator1 {
    // Method overloading
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
}
class AdvancedCalculator extends Calculator1 {
    // Method overriding
    @Override
    public int add(int a, int b) {
        System.out.println("Advanced calculation");
        return super.add(a, b);
    }
}

public class OOPSTOPICSALL {
      public static void main(String[] args) {
        System.out.println("Encapsulation");
        BankAccount1 acc = new BankAccount1("Mohan", 5000);
        acc.deposit(2000);
        acc.withdraw(1000);
        System.out.println("Final Balance: Rs " + acc.getBalance());

        System.out.println("Inheriatnce");
        Shape1 s1 = new Circle1();    // Polymorphism
        Shape1 s2 = new Rectangle1();
        s1.draw();
        s2.draw();

        System.out.println("Abstraction");
        Animal a1 = new Dog1();
        Animal a2 = new Cat1();
        a1.sound();
        a1.sleep();
        a2.sound();

        System.out.println("Interface");
        FoodItem1 pizza = new FoodItem1("Pizza", 200);
        pizza.display();

        System.out.println("Polymorphism");
        Calculator1 c1 = new Calculator1();
        AdvancedCalculator c2 = new AdvancedCalculator();
        System.out.println("Sum (int): " + c1.add(5, 10));
        System.out.println("Sum (double): " + c1.add(3.5, 2.5));
        System.out.println("Overridden sum: " + c2.add(7, 8));
    }  
}
