package kata.gildedrose.item;

import kata.gildedrose.Item;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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