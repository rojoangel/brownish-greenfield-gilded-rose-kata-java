package kata.gildedrose.item;

import kata.gildedrose.Item;

public class StandardItem extends Item {

    public StandardItem(int sellIn, int quality) {
        super("An standard item", sellIn, quality);
    }

    protected void endOfDayQuality() {
        if (hasSellByDatePassed()) {
            decreaseQualityBy(2);
        } else {
            decreaseQualityBy(1);
        }
    }

    protected void endOfDaySellIn() {
        decreaseSellIn();
    }

}
