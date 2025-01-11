
@FunctionalInterface
public interface Demo {
    //public void  name();
    public void sum(int a,int b);

    default void gender(){
        System.out.println("Default gender..");
    }

    public static void demo(){
        System.out.println("Static method");
    }

    public static void main(String[] args) {
        System.out.println("Demo main..");
        demo();
    }

}
