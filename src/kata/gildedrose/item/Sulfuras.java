package kata.gildedrose.item;

public class Sulfuras extends BaseItem {

    public static final int QUALITY = 80;

    Sulfuras(int initialSellIn) {
        super("Sulfuras", initialSellIn, QUALITY);
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
