public class Product {

    private String name;
    private  float prize;
    private  String description;
    private  String image;

    public Product(String name, float prize, String description, String image) {
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.image = image;
    }


    @Override
    public String toString() {
        return "builder.Product{" +
                "name='" + name + '\'' +
                ", prize=" + prize +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
