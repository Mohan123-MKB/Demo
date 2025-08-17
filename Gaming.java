import java.util.*;
interface Playable{
    void attack();
}
abstract class GameCharacter implements Playable{
    private String name;
    private int health;
    public GameCharacter(String name,int health){
        this.name=name;
        this.health=health;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health=health;
    }
    public void displayInfo(){
        System.out.println(getName()+"has"+getHealth()+"HP");
    }
}
class Warrior extends GameCharacter{
    public Warrior(String name,int health){
        super(name,health);
    }
    @Override
    public void attack(){
        System.out.println(getName() +"swings a sword !");
    }
}
class Mage extends GameCharacter{
    public Mage(String name,int health){
        super(name,health);
    }
    @Override
    public void attack(){
        System.out.println(getName() +"casts a fireball !");
    }
}
public class Gaming {
    public static void main(String[] args) {
        //collection to store
        List<GameCharacter> players=new ArrayList<>();
        players.add(new Warrior("Arjun",100));
         players.add(new Mage("Merlin",80));
         //gameplay simulation
         for(GameCharacter player:players){
            player.displayInfo();
            player.attack();
         }
    }  
}
