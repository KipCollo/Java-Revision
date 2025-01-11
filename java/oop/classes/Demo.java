package oop.classes;
public class Demo {

    // properties - fields
    private int number;
    private int num2;
    

    // methods - behavior
    public int calculater(int number, int num2){
        return number + num2;
    }

    public Demo(int number){ // constructor
        setNumber(number);
    }

    public void setNumber(int number){
        this.number = number;// this is a reference to current object
    }
    public int getNumber(){
        return number;
    }

}
