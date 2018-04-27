package pl.sda.sklepzoologiczny.sales;

import pl.sda.sklepzoologiczny.Inventory;

public class FinalPriceSale implements ISale{
    private Inventory inventory;
    private boolean doesApply;

    public FinalPriceSale(Inventory inventory) {
        this.inventory = inventory;
        this.doesApply = inventory.getFinalPrice() > 100000;
    }

    public double applySale() {
        if (doesApply) {
            return (double) this.inventory.getFinalPrice() * 0.8 / 100;
        }
        return (double) this.inventory.getFinalPrice() / 100;
    }

}
