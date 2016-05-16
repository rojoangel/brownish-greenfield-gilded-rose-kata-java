package kata.gildedrose.item;

public class AgedBrie extends BaseItem {

    AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void endOfDayQuality() {
        increaseQualityBy(1);
    }

    @Override
    public void endOfDaySellIn() {
        decreaseSellIn();
    }
}
