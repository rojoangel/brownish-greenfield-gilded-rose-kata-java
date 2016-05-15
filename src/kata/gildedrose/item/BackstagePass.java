package kata.gildedrose.item;

import kata.gildedrose.Item;

public class BackstagePass  extends Item {

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
            increaseQualityBy(3);
            return;
        }

        if (getSellIn() <= 10) {
            increaseQualityBy(2);
            return;
        }

        increaseQualityBy(1);
    }

    @Override
    protected void calculateSellIn() {
        decreaseSellIn();
    }
}
