package pl.sda.sklepzoologiczny.animals;

public class Cat extends Animal{
    private String color;
    private int age;

    public Cat(int price, String color, int age) {
        super(price);
        this.color = color;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", age=" + age +
                "} " + super.toString();
    }
}
