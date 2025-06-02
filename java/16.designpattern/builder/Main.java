public class Main {

    public static void main(String[] args) {

        var maize = new Builder()
                .setName("Maize")
                .setPrize(10.33f)
                .setImage("img")
                .build();

        var beans = new Builder()
                .setName("Beans")
                .setPrize(10.37f)
                .setImage("img")
                .setDescription("very fresh")
                .build();

        var mango = new Builder().build();

        System.out.println("==================================");
        welcome();
        System.out.println("==============================================================================");
        System.out.println(maize);
        System.out.println("==============================================================================");
        System.out.println(beans);
        System.out.println("==============================================================================");
        System.out.println(mango);

    }

    public static void welcome(){
        System.out.println("welcome to My products");

    }

}