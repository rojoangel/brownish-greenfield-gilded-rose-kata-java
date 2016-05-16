package kata.gildedrose.item;

import kata.gildedrose.AdaptedItem;

public class StandardItem extends AdaptedItem {

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
