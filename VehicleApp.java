interface Rentable{
    void calRent(int hours);
}
abstract class Vehicle implements Rentable{
    private String model;
    public Vehicle(String model){
        this.model=model;
    }
    public String getModel(){
        return model;
    }
}
class Car extends Vehicle{
    public Car(String model){
        super(model);
    }
    public void calRent(int hours){
        System.out.println("Rent for car "+getModel()+":rs"+(hours * 100));
    }
}
class Bike extends Vehicle{
    public Bike(String model){
        super(model);
    }
    public void calRent(int hours){
        System.out.println("Rent for bike"+getModel()+":rs"+(hours * 50));
    }
}
public class VehicleApp {
    public static void main(String[] args) {
        Rentable r1=new Car("swift"); //Use parent class reference to create child objectss
        Rentable r2=new Bike("pulsar");
        r1.calRent(3);
        r2.calRent(5); //polymorphism(overriding behaviour of methods based on diff objects)
    }
    
}
