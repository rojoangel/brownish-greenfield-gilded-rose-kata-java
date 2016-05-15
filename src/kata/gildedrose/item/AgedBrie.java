package kata.gildedrose.item;

import kata.gildedrose.Item;

public class AgedBrie extends Item {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void calculateQuality() {
        increaseQualityBy(1);
    }

    @Override
    protected void calculateSellIn() {
        decreaseSellIn();
    }
}
