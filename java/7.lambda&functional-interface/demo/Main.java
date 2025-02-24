public class Main {

    public static void main(String[] args) {
        Demo2 demo1 = new DemoImpl();//Normal interface implementation
        demo1.name();
        demo1.gender();
        demo1.sum(4, 7);

        Demo demo = (a,b)-> System.out.println("Sum is "+ (a+b));//Functional Interface implementation
        //demo.name();
        demo.gender();
        demo.sum(1, 9);
        Demo.demo();//static method
        
    }
} 
