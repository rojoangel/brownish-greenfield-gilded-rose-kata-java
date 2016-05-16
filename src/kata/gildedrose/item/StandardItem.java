package kata.gildedrose.item;

import kata.gildedrose.AdaptedItem;

public class StandardItem extends AdaptedItem {

    public StandardItem(int sellIn, int quality) {
        super("An standard item", sellIn, quality);
    }

    public void endOfDayQuality() {
        if (hasSellByDatePassed()) {
            decreaseQualityBy(2);
        } else {
            decreaseQualityBy(1);
        }
    }

    public void endOfDaySellIn() {
        decreaseSellIn();
    }

}
