package kata.gildedrose.item;

import kata.gildedrose.BaseItem;

public class AgedBrie extends BaseItem {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void endOfDayQuality() {
        increaseQualityBy(1);
    }

    @Override
    public void endOfDaySellIn() {
        decreaseSellIn();
    }
}
