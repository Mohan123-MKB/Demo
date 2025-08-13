//banking sector:managing accounts,deposits,withdrawls,overdraft policies
import java.util.*;
interface Transaction {
    void deposit(double amt);
    void withdraw(double amt);
}
abstract class BankAccount implements Transaction{
    private String acntHolder;
    private double balance;
    BankAccount(String aH,double bal){
        acntHolder=aH;
        balance=bal;
    }
    public String getAcntHolder(){
        return acntHolder;
    }
    public double getBalance(){
        return balance;
    }
    protected void setBalance(double bal){
        this.balance=bal;
    }
    @Override
    public void deposit(double amt){
        setBalance(getBalance()+amt);
    }
    @Override
    public abstract void withdraw(double amt);
}
class SavingsAccount extends BankAccount{
    public SavingsAccount(String holder,double bal){
        super(holder,bal);
    }
    @Override
    public void withdraw(double amt){
        if(amt>getBalance()){
            System.out.println("Insufficient in savings account");
        } else{
            setBalance(getBalance()-amt);
            System.out.println(amt+"withdrawn"+":"+"New Balance"+getBalance());
        }
    }
}
class CurrentAccount extends BankAccount{
    private double overdraftLimit=500.0;
     public CurrentAccount(String holder,double bal){
        super(holder,bal);
    }
    @Override
    public void withdraw(double amt){
        if(amt>getBalance()+overdraftLimit){
            System.out.println("OverdraftLimit exceed in current account.");
        }
        else{
            setBalance(getBalance()-amt);
            System.out.println(amt+"withdrawn"+":"+"New Baance"+getBalance());
        }
    }
}
public class BankManagementSystem {
    public static void main(String[] args) {
        Map<Integer,BankAccount> accounts=new HashMap<>();
        //create accounts
        accounts.put(1,new SavingsAccount("Sanjay", 10000));
        accounts.put(2,new CurrentAccount("Wisdam", 2000));
        //perform transactions
        accounts.get(1).deposit(500);
        accounts.get(1).withdraw(5000);
        accounts.get(2).deposit(3000);
    }
    
}
