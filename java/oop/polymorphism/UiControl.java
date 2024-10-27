package oop.polymorphism;

public abstract class UiControl {

    public void enable(){
        
        System.out.println("Enabled..");
    }

    public abstract void draw();
}
