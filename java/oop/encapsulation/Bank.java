package oop.encapsulation;

public class Bank {

    private float balance;

    
    public float deposit(float amount){
        return this.balance+=amount;
    }

    public float withdaw(float amount){
        if (amount<balance){
            System.out.println("Insufficient funds");
            
        } 
        return this.balance-=amount;
        
    }

    public float getBalance(){
        return balance;
    }
}
