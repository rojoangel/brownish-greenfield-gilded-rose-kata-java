package kata.gildedrose.item;

class Sulfuras extends BaseItem {

    private static final int QUALITY = 80;
    static final String SULFURAS = "Sulfuras";

    Sulfuras(int initialSellIn) {
        super(SULFURAS, initialSellIn, QUALITY);
    }

    @Override
    public void endOfDayQuality() {
        // do nothing
    }

    @Override
    public void endOfDaySellIn() {
        // do nothing;
    }
}
