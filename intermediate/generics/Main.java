package intermediate.generics;

public class Main {

        public static void main(String[] args) {

            Generic<Integer> num = new Generic<>();
            num.setValue(2);
            num.show();

            Generic<String> str= new Generic<>();
            str.setValue("Collins");
            str.show();

            Generic<Student> std = new Generic<>();
            std.show();




        }

}
