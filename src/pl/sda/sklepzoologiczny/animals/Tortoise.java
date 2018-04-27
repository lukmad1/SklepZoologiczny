package pl.sda.sklepzoologiczny.animals;

public class Tortoise extends Animal{
    private String name;

    public Tortoise(int price, String name) {
        super(price);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tortoise{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
