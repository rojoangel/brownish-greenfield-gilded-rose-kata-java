package kata.gildedrose.item;

import kata.gildedrose.Item;

public class BackstagePass  extends Item {

    private static final int FACTOR_3 = 3;

    public BackstagePass(int sellIn, int quality) {
        super("Backstage Pass", sellIn, quality);
    }

    @Override
    protected void calculateQuality() {
        if (getSellIn() < 0) {
            zeroQuality();
            return;
        }

        if (getSellIn() <= 5) {
            increaseQuality(FACTOR_3);
            return;
        }

        increaseQuality(FACTOR_2);

    }

    @Override
    protected void calculateSellIn() {
        decreaseSellIn();
    }
}
