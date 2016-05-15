package kata.gildedrose.item;

import kata.gildedrose.Item;

public class StandardItem extends Item {

    public StandardItem(int sellIn, int quality) {
        super("An standard item", sellIn, quality);
    }

    protected void endOfDayQuality() {
        if (hasSellByDatePassed()) {
            decreaseQualityBy(1);
        } else {
            decreaseQualityBy(2);
        }
    }

    protected void endOfDaySellIn() {
        decreaseSellIn();
    }

}
