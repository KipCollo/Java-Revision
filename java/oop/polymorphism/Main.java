package oop.polymorphism;

public class Main {

    public static void main(String[] args) {
        
     drawUi(new Button());
     drawUi(new CheckBox());
    }
  
    public static void drawUi (UiControl uiControl){
        uiControl.draw();
    }
}
