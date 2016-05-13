package kata.gildedrose.item;

import kata.gildedrose.Item;

public class BackstagePass  extends Item {

    public BackstagePass(int sellIn, int quality) {
        super("Backstage Pass", sellIn, quality);
    }

    @Override
    protected void calculateQuality() {
        increaseQuality(FACTOR_2);
    }

    @Override
    protected void calculateSellIn() {
        decreaseSellIn();
    }
}
