package kata.gildedrose.item;

import kata.gildedrose.Item;

public class Sulfuras extends Item {

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
