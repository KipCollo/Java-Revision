package oop.interfaces;
public class Main {
    public static void main(String[] args) {
        
      var tx= calculateTax().calculateTax();
       System.out.println(tx);
       
    }

    public static TaxCalculator calculateTax(){
        return new TaxCalculator2020();

    }
}
