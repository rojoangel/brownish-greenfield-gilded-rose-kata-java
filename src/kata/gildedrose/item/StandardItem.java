package kata.gildedrose.item;

public class StandardItem extends BaseItem {

    static final String AN_STANDARD_ITEM = "An standard item";

    StandardItem(int sellIn, int quality) {
        super(AN_STANDARD_ITEM, sellIn, quality);
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
