public class DemoImpl implements  Demo2{

    @Override
    public void name() {
        System.out.println("Name is Collins..");
    }

    @Override
    public void gender() {
        System.out.println("Gender is male..");
    }

    @Override
    public void sum(int a, int b) {
        System.out.println("sum is "+ (a+b));
    }
}
