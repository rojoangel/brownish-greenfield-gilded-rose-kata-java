package kata.gildedrose.item;

public class StandardItem extends BaseItem {

    static final String STANDARD_ITEM = "Standard Item";

    StandardItem(int sellIn, int quality) {
        super(STANDARD_ITEM, sellIn, quality);
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
