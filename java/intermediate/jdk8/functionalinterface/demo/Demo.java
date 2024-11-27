
@FunctionalInterface
public interface Demo {
    //public void  name();
    public void sum(int a,int b);

    default void gender(){
        System.out.println("Default gender..");
    }

}
