import java.util.*;
class Product{
    private String name;
    private double price;
    public Product(String name,double price){
        this.name=name;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
}
class Cart{
    private List<Product> items=new ArrayList<>();
    public void addProduct(Product p){
        items.add(p);
        System.out.println(p.getName() + " added to cart.");
    }
    public double getTotalPrice(){
        double t=0;
        for(Product p:items){
            t +=p.getPrice();
        }
        return t;
    }
    public void showCart(){
        System.out.println("Your cart");
        for(Product p:items){
            System.out.println(p.getName()+": $"+p.getPrice());
        }
        System.out.println("Total: $"+getTotalPrice());
    }
}
interface PaymentMethod{
    void pay(double amt); 
}
class UpiPayment implements PaymentMethod{
    @Override
    public void pay(double amt){
        System.out.println("Paid $"+amt+"via UPI");
    }
}
class CardPayment implements PaymentMethod{
    @Override
    public void pay(double amt){
        System.out.println("Paid $"+amt+"via Card");
    }
}
public class Ecommerce {
    public static void main(String[] ard){
    Product p1=new Product("Laptop",800.00);
    Product p2=new Product("Headphones",200);
    //craete cart
    Cart cart=new Cart();
    cart.addProduct(p1);
    cart.addProduct(p2);
    cart.showCart();    
    //choose payment method
    PaymentMethod payment=new CardPayment(); //change to new UPIPayment if needed change behaviour 
    payment.pay(cart.getTotalPrice());
    }
}
