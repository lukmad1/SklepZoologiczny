package pl.sda.sklepzoologiczny;

import pl.sda.sklepzoologiczny.animals.Animal;
import pl.sda.sklepzoologiczny.animals.Cat;
import pl.sda.sklepzoologiczny.animals.Tortoise;
import pl.sda.sklepzoologiczny.sales.FinalPriceSale;
import pl.sda.sklepzoologiczny.sales.QuantitySale;

import java.util.Arrays;

public class Inventory {
    private Animal[] animals;
    private int finalPrice = 0;
    private int howManyAnimalsSold = 0;

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }


    public void addAnimal(Animal newAnimal) {
        if (animals == null) {
            this.animals = new Animal[0];
        }
        Animal[] newAnimals;
        newAnimals = Arrays.copyOf(this.animals, this.animals.length + 1);
        newAnimals[newAnimals.length - 1] = newAnimal;
        this.animals = new Animal[newAnimals.length];
        this.animals = newAnimals;
    }


    public void removeAnimal(Animal animalToRemove) {
        int animalToRemoveIndex = 0;

        for (int i = 0; i < animals.length; i++) {
            if (animals[i].equals(animalToRemove)) {
                animalToRemoveIndex = i;
            }
        }

        Animal[] leftSideAnimals = Arrays.copyOf(animals, animalToRemoveIndex);
        Animal[] rightSideAnimals = Arrays.copyOfRange(animals, animalToRemoveIndex + 1, animals.length);
        Animal[] newAnimals = new Animal[leftSideAnimals.length + rightSideAnimals.length];

//        System.arraycopy(leftSideAnimals, 0, newAnimals, 0, leftSideAnimals.length);

        for (int i = 0; i < leftSideAnimals.length; i++) {
            newAnimals[i] = leftSideAnimals[i];
        }


        for (int i = leftSideAnimals.length, j = 0; i < newAnimals.length; i++) {
            newAnimals[i] = rightSideAnimals[j];
            j++;
        }

        this.animals = new Animal[newAnimals.length];
        this.animals = newAnimals;
    }

    public void printInventory() {
        for (Animal animal : this.animals) {
            System.out.println(animal);
        }
    }

    public int sellTortoise() {
        int mostExpensiveTortoisePrice = Integer.MIN_VALUE;
        int mostExpensiveTortoiseIndex = 0;

        boolean wasTortoise = false;
        for (int i = 0; i < this.animals.length; i++) {
            if (this.animals[i] instanceof Tortoise) {
                Tortoise tortoise = (Tortoise) this.animals[i];
                if (tortoise.getPrice() > mostExpensiveTortoisePrice) {
                    mostExpensiveTortoiseIndex = i;
                    mostExpensiveTortoisePrice = tortoise.getPrice();
                    wasTortoise = true;
                }
            }
        }
        if (wasTortoise) {
//            animals[mostExpensiveTortoiseIndex] = null;
            removeAnimal(this.animals[mostExpensiveTortoiseIndex]);
            this.howManyAnimalsSold++;
            return mostExpensiveTortoisePrice;
        } else {
            System.out.println("Brak zolwi!");
            return 0;
        }

    }

    public int sellCat() {
        int catPrice = 0;

        int youngestCatIndex = 0;
        boolean wasCat = false;
        int youngestCatAge = Integer.MAX_VALUE;
        for (int i = 0; i < this.animals.length; i++) {
            if (this.animals[i] instanceof Cat) {
                Cat cat = (Cat) this.animals[i];
                if (cat.getAge() < youngestCatAge) {
                    youngestCatIndex = i;
                    youngestCatAge = cat.getAge();
                    catPrice = cat.getPrice();
                    wasCat = true;
                }
            }
        }
        if (wasCat) {
            removeAnimal(this.animals[youngestCatIndex]);
            this.howManyAnimalsSold++;
            return catPrice;
        } else {
            System.out.println("Brak kotow!");
            return 0;
        }

    }

    public void addToFinalPrice(int priceToAdd) {
        this.finalPrice += priceToAdd;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public int getHowManyAnimalsSold() {
        return howManyAnimalsSold;
    }

    public double getFinalPriceAfterSales() {
        FinalPriceSale finalPriceSale = new FinalPriceSale(this);
        QuantitySale quantitySale = new QuantitySale(this);
        if (quantitySale.applySale() > finalPriceSale.applySale()) {
            return finalPriceSale.applySale();
        } else {
            return quantitySale.applySale();
        }
    }
}
