package kata.gildedrose.item;

import kata.gildedrose.Item;

public class BackstagePass  extends Item {

    private static final int FACTOR_3 = 3;

    public BackstagePass(int sellIn, int quality) {
        super("Backstage Pass", sellIn, quality);
    }

    @Override
    protected void calculateQuality() {
        int factor = FACTOR_2;
        if (getSellIn() <= 5) {
            factor = FACTOR_3;
        }
        increaseQuality(factor);
    }

    @Override
    protected void calculateSellIn() {
        decreaseSellIn();
    }
}
