package pl.sda.sklepzoologiczny.sales;

import pl.sda.sklepzoologiczny.Inventory;

public class QuantitySale implements ISale{
    private Inventory inventory;
    private boolean doesApply;

    public QuantitySale(Inventory inventory) {
        this.inventory = inventory;
        this.doesApply = inventory.getHowManyAnimalsSold() > 3;
    }

    public double applySale() {
        if (doesApply) {
            return (double) this.inventory.getFinalPrice() * 0.9 / 100;
        }
        return (double) this.inventory.getFinalPrice() / 100;
    }

}
