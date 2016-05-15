package kata.gildedrose.item;

import kata.gildedrose.Item;

public class BackstagePass  extends Item {

    public BackstagePass(int sellIn, int quality) {
        super("Backstage Pass", sellIn, quality);
    }

    @Override
    protected void endOfDayQuality() {
        if (hasConcertDayPassed()) {
            zeroQuality();
            return;
        }

        if (daysLeftToConcert(5)) {
            increaseQualityBy(3);
            return;
        }

        if (daysLeftToConcert(10)) {
            increaseQualityBy(2);
            return;
        }

        increaseQualityBy(1);
    }

    private boolean hasConcertDayPassed() {
        return getSellIn() < 0;
    }

    private boolean daysLeftToConcert(int days) {
        return getSellIn() <= days;
    }

    @Override
    protected void endOfDaySellIn() {
        decreaseSellIn();
    }
}
