package pl.sda.sklepzoologiczny;

import pl.sda.sklepzoologiczny.animals.Cat;
import pl.sda.sklepzoologiczny.animals.Tortoise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tortoise t1 = new Tortoise(50060, "Zbyszek");
        Tortoise t2 = new Tortoise(20020, "Zbigniew");
        Tortoise t3 = new Tortoise(40010, "Zbysio");

        Cat c1 = new Cat(10050, "Brown", 1);
        Cat c2 = new Cat(20000, "Black", 12);
        Cat c3 = new Cat(30000, "Grey", 6);

        Inventory inventory = new Inventory();
        inventory.addAnimal(t1);
        inventory.addAnimal(t2);
        inventory.addAnimal(t3);
        inventory.addAnimal(c1);
        inventory.addAnimal(c2);
        inventory.addAnimal(c3);

        while (true) {
            inventory.printInventory();
            System.out.println("Chcesz kupic kota czy zolwia?");
            String answer = scanner.nextLine().toUpperCase();

            if ("KOTA".equals(answer)) {
                inventory.addToFinalPrice(inventory.sellCat());
            } else if ("ZOLWIA".equals(answer)) {
                inventory.addToFinalPrice(inventory.sellTortoise());
            } else if ("KONIEC".equals(answer)) {

                System.out.println("Suma koszyka to: " + inventory.getFinalPriceAfterSales());
                return;
            }else {
                System.out.println("Nie mamy " + answer);
            }
        }
    }
}
