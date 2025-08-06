interface Product{
    double getDiscountPrice();
    void show();
}
abstract class Item implements Product{
    private String name;
    private double price;

    public Item(String name,double price){
        this.name=name;
        this.price=price;
    }
    protected String getName(){
        return name;
    }
    protected double getPrice(){
        return price;
    }
}
class Grocery extends Item{
    public Grocery(String name,double price){
        super(name,price);
    }
    public double getDiscountPrice(){
        return getPrice() * 0.9;
    }
    public void show(){
        System.out.println(getName()+"-RS"+getDiscountPrice());
    }
}
class Clothes extends Item{
    public Clothes(String name,double price){
        super(name,price);
    }
    public double getDiscountPrice(){
        return getPrice() * 0.8;
    }
    public void show(){
        System.out.println(getName()+"-RS"+getDiscountPrice());
    }
}
public class ShoppingCart{
    public static void main(String[] args) {
        Product p1=new Grocery("Rice",100);
        Product p2=new Clothes("T-shirt",500);
        p1.show();
        p2.show();
    }
}