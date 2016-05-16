package kata.gildedrose.item;

import kata.gildedrose.AdaptedItem;

public class Sulfuras extends AdaptedItem {

    public static final int QUALITY = 80;

    public Sulfuras(int initialSellIn) {
        super("Sulfuras", initialSellIn, QUALITY);
    }

    @Override
    protected void endOfDayQuality() {
        // do nothing
    }

    @Override
    protected void endOfDaySellIn() {
        // do nothing;
    }
}
