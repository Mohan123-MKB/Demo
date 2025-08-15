import java.util.*;
interface Controllable{
    void turnOn();
    void turnOff();
}
abstract class SmartDevices{
    private String name;
    SmartDevices(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    abstract void adjustSetting();
}
class Fan extends SmartDevices implements Controllable{
   Fan(String name){
    super(name);
   }
   @Override
   public void adjustSetting(){
    System.out.println(getName()+" "+"speed adjusted");
   }
   @Override
   public void turnOn(){
    System.out.println(getName()+" "+"fan turned on.");
   }
   @Override
   public void turnOff(){
     System.out.println(getName()+" "+"fan turned off.");
   }
}
class Light extends SmartDevices implements Controllable{
     Light(String name){
    super(name);
   }
   @Override
   public void adjustSetting(){
    System.out.println(getName()+" "+"+brightness adjusted");
   }
   @Override
   public void turnOn(){
    System.out.println(getName()+" "+"light turned on.");
   }
   @Override
   public void turnOff(){
     System.out.println(getName()+" "+"light turned off.");
   }
}
class AirConditioner extends SmartDevices implements Controllable{
    AirConditioner(String name){
    super(name);
   }
   @Override
   public void adjustSetting(){
    System.out.println(getName()+" "+"+cooling adjusted");
   }
   @Override
   public void turnOn(){
    System.out.println(getName()+" "+"airConditioner turned on.");
   }
   @Override
   public void turnOff(){
     System.out.println(getName()+" "+"airConditioner turned off.");
   }
}
public class SmartHomeAppliance {
    public static void main(String[] args) {
        List<SmartDevices> devices=new ArrayList<>();
        devices.add(new Light("Living Room Light"));
        devices.add(new AirConditioner("BlueStar AC"));
        devices.add(new Fan("Crompton"));
        for(SmartDevices device:devices){
            if(device instanceof Controllable){
                ((Controllable) device).turnOn();
            }
            device.adjustSetting();
            if(device instanceof Controllable){
                 ((Controllable) device).turnOff();
            }
        }
    }
    
}
