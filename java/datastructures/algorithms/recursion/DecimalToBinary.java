package datastructures.algorithms.recursion;

public class DecimalToBinary {

    public static void main(String[] args) {
        String bin = binary(233,"");

    }

    public static String binary(int decimal, String result){
        if (decimal==0){
            return result;
        }

        result = decimal % 2 +result;
        return binary(decimal/2, result);
    }
}
