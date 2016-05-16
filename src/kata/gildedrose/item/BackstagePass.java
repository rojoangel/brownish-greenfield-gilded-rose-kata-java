package kata.gildedrose.item;

import kata.gildedrose.AdaptedItem;

public class BackstagePass  extends AdaptedItem {

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
        return hasSellByDatePassed();
    }

    private boolean daysLeftToConcert(int days) {
        return this.item.sellIn <= days;
    }

    @Override
    protected void endOfDaySellIn() {
        decreaseSellIn();
    }
}
