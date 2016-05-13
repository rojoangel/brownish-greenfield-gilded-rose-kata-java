package kata.gildedrose.item;

import kata.gildedrose.Item;

public class AgedBrie extends Item {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void calculateQuality() {
        increaseQuality();
    }

    @Override
    protected void calculateSellIn() {
        decreaseSellIn();
    }
}
