package datastructures.collections.array;

public class Main {

    public static void main(String[] args) {
        SingleDimensioArray sda =  new SingleDimensioArray(10);
        sda.insert(0,0 );
        sda.insert(1, 10);
        sda.insert(2, 20);
        sda.insert(1, 30);
        sda.insert(12, 120);

        var firstElement =sda.arr[0];
        System.out.println(firstElement);
    }
}
