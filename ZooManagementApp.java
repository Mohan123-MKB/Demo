// we need to mange diiferent types of animals in a zoo.
// Each animals has a name and species,can be fed and may have diff behaviors.
// 1.Understand the problem:
// Entities:classes
//       Animal(base entity)
//       Lion,deer,etc(child classes)
// Actions:Methods
//       feed()
//       makeSound()
//       display()
// Relationships:
//       is-a:Lion is an animals
//       has-a:Zoo has a many animals(interface is contract,loose coupling)
// common behaviors:
//       Interface feedbale for feeding animals
//2.Define the Base Structure(Interface+Abstraction)
//3.Create Child classes(Inheritance+polymorphism)
//4.Use collections to store and mange Objects
import java.util.*;
interface feedable{
   void feed();
// void makesound(); //here we put not a animal hierachy here anything class we implement so that not put here.
// another reason is any classes can implement it,even if unrelated to animal classes so that here not put.
//eg. this feedable interface can implement unrelated classes like animals,humans ,others also so that only put feed() method.
}
abstract class Animal{
    private String name;
    private String species;
    Animal(String name,String species){
        this.name=name;
        this.species=species;
    }
    public String getName(){
        return name;
    }
    public String getSpecies(){
        return species;
    }
    public abstract void makeSound();
    public void display(){
        System.out.println(species+ "named" + name);
    }
}
class Lion extends Animal implements feedable{
    Lion(String name){
        super(name,"Lion");
    }
    @Override
    public void makeSound(){
        System.out.println(getName()+ "roars loudly!");
    }
    @Override
    public void feed(){
        System.out.println(getName()+ "eats meats.");
    }
}
class Elephants extends Animal implements feedable{
    Elephants(String name){
        super(name,"Elephants");
    }
    @Override
    public void makeSound(){
        System.out.println(getName()+ "trumpets!");
    }
    @Override
    public void feed(){
        System.out.println(getName()+ "eats friuts and plants.");
    }
}
class Parrot extends Animal implements feedable{
    Parrot(String name){
        super(name,"Parrot");
    }
    @Override
    public void makeSound(){
        System.out.println(getName()+ "chrips and talks!");
    }
    @Override
    public void feed(){
        System.out.println(getName()+ "eats seeds.");
    }
}
public class ZooManagementApp {
    public static void main(String[] args) {
        List<Animal> an=new ArrayList<>();
        an.add(new Lion("Simba"));
        an.add(new Elephants("Dumbo"));
        an.add(new Parrot("Killi"));

        for(Animal animal:an){
            animal.display();
            if(animal instanceof feedable){
                ((feedable) animal).feed();
            }
            animal.makeSound();
        }
    }
}
