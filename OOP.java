//class and object
class Student{
    String name;
    int age;
    Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    void display(){
        System.out.println(name+":"+age);
    }
}
//Inheritance
class Animal{
    void sound(){
        System.out.println("Animal makes a sound");
    }
}
class Dog extends Animal{
    @Override
    void sound(){
        System.out.println("Dog barks");

    }
}
//Encapsulation
class BankAccount{
    private double balance;
    public void setBalance(double amount){
        if(amount >=0){
            balance=amount;
        }
    }
    public double getBalance(){
        return balance;
    }
}
//polymorphism
class Shape{
    void area(){
        System.out.println("calculating area...");
    }
}
class Circle extends Shape{
    @Override
    void area(){
        System.out.println("pi r square");
    }
}
class Square extends Shape{
    @Override
    void area(){
        System.out.println("side * side");
    }
}
//Abstraction(abstract class(Is a relation)-Not support multiple inheritance,Interface(can do cabability)-achieve loose coupling[multiple inheritance supported])
abstract class Vehicle{
    abstract void run();
}
class Bike extends Vehicle{
    void run(){
        System.out.println("Bike is running...");
    }
}
public class OOP{
    public static void main(String[] ar){
        Student s1=new Student("mohan",20);
        s1.display();

        Dog d=new Dog();
        d.sound();

        BankAccount ac=new BankAccount();
        ac.setBalance(1000);
        System.out.println(ac.getBalance());

        Shape sh1=new Circle();
        Shape sh2=new Square();
        sh1.area();
        sh2.area();

        Bike v=new Bike();
        v.run();
    }
}