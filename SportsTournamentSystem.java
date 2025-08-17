import java.util.*;
interface Scorable{
    void calScore();
}
abstract class Team{
    private String name;
    private int players;
    Team(String n,int p){
        name=n;
        players=p;
    }
    public String getName(){
        return name;
    }
    public int getPlayers(){
        return players;
    }
    public abstract void playMatch();
    public void displayTeamInfo(){
        System.out.println("team:"+name+"players"+players);
    }
}
class CricketTeam extends Team implements Scorable{
    public CricketTeam(String name){
        super(name,11);
    } 
    @Override
    public void playMatch(){
        System.out.println(getName()+"is playing a cricket match!");
    }
    @Override
    public void calScore(){
        System.out.println(getName()+"scored runs using bat and ball!.");
    }
}
class FootballTeam extends Team implements Scorable{
    public FootballTeam(String name){
        super(name,11);
    } 
    @Override
    public void playMatch(){
        System.out.println(getName()+"is playing a football match!");
    }
    @Override
    public void calScore(){
        System.out.println(getName()+"scored goals!.");
    }
}
class BasketballTeam extends Team implements Scorable{
    public BasketballTeam(String name){
        super(name,5);
    } 
    @Override
    public void playMatch(){
        System.out.println(getName()+"is playing a basketball match!");
    }
    @Override
    public void calScore(){
        System.out.println(getName()+"scored points with baskets!.");
    }
}
public class SportsTournamentSystem {
    public static void main(String[] args) {
        List<Team> teams=new ArrayList<>();
        teams.add(new CricketTeam("India"));
        teams.add(new FootballTeam("Brazil"));
        teams.add(new BasketballTeam("America"));

        for(Team team:teams){
            team.displayTeamInfo();
            team.playMatch();
            if(team instanceof Scorable){
                ((Scorable) team).calScore();
            }
        }
    }
}
