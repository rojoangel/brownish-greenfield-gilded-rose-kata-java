package kata.gildedrose.item;

public class StandardItem extends BaseItem {

    StandardItem(int sellIn, int quality) {
        super("An standard item", sellIn, quality);
    }

    public void endOfDayQuality() {
        if (hasSellByDatePassed()) {
            decreaseQualityBy(2);
        } else {
            decreaseQualityBy(1);
        }
    }

    public void endOfDaySellIn() {
        decreaseSellIn();
    }

}
