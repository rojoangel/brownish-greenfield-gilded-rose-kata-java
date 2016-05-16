package kata.gildedrose.item;

import kata.gildedrose.AdaptedItem;

public class Sulfuras extends AdaptedItem {

    public static final int QUALITY = 80;

    public Sulfuras(int initialSellIn) {
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
