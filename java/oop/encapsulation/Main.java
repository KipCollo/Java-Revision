package oop.encapsulation;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.deposit(20);
        bank.withdaw(55);
        
        System.out.println(bank.getBalance());
    }
}
