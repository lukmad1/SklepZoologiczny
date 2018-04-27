package pl.sda.sklepzoologiczny.animals;

public abstract class Animal {
    private int price;

    public Animal(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "price=" + price +
                '}';
    }
}
