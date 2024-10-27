package introduction.enumaration.enums;

public enum Laptop {
    MAC(20000),
    SAMSUNG(15000),
    LENOVO(12000),
    HP;

    private int price;

    //Defining constructor in enum class
    Laptop(){
        price=500;//Default when no price is specified
    }

    Laptop(int price){
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
