package kata.gildedrose.item;

class AgedBrie extends BaseItem {

    static final String AGED_BRIE = "Aged Brie";

    AgedBrie(int sellIn, int quality) {
        super(AGED_BRIE, sellIn, quality);
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
