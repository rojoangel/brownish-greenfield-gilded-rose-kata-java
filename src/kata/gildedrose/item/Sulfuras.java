package kata.gildedrose.item;

public class Sulfuras extends BaseItem {

    public static final int QUALITY = 80;
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
