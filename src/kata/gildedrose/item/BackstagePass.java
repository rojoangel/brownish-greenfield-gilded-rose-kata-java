package kata.gildedrose.item;

public class BackstagePass  extends BaseItem {

    BackstagePass(int sellIn, int quality) {
        super("Backstage Pass", sellIn, quality);
    }

    @Override
    public void endOfDayQuality() {
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
    public void endOfDaySellIn() {
        decreaseSellIn();
    }
}
