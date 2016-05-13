package kata.gildedrose.item;

import kata.gildedrose.Item;

public class StandardItem extends Item {

    public StandardItem(int sellIn, int quality) {
        super("An standard item", sellIn, quality);
    }

    protected void calculateQuality() {
        if (hasSellByDatePassed()) {
            decreaseQuality(FACTOR_1);
        } else {
            decreaseQuality(FACTOR_2);
        }
    }

    protected void calculateSellIn() {
        decreaseSellIn();
    }

}
