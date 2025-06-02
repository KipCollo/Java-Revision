public class Builder {

    private String name;
    private  float prize;
    private  String description;
    private  String image;

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public Builder setImage(String image) {
        this.image = image;
        return this;
    }

    public Builder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Builder setPrize(float prize) {
        this.prize = prize;
        return this;
    }

    public Product build(){
        return new Product(name, prize,description,image);
    }
}
