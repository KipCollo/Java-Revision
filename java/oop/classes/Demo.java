package oop.classes;

class OuterDemo {

    // properties - fields
    int number;
    int num2;
    

    // methods - behavior
    public int calculater(int number, int num2){
        return number + num2;
    }

    public OuterDemo(int number){ // constructor
        setNumber(number);
    }

    public void setNumber(int number){
        this.number = number;
    }

}


class Demo {

    public static void main(String[] args) {
      
        OuterDemo demo = new OuterDemo(2);
        System.out.println(demo.calculater(1,3));
    }

   

}
