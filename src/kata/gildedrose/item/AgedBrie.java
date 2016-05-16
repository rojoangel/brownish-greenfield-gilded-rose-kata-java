package kata.gildedrose.item;

import kata.gildedrose.AdaptedItem;

public class AgedBrie extends AdaptedItem {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void endOfDayQuality() {
        increaseQualityBy(1);
    }

    @Override
    protected void endOfDaySellIn() {
        decreaseSellIn();
    }
}
