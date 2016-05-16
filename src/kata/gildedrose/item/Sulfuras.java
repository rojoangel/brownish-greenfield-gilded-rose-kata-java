package kata.gildedrose.item;

import kata.gildedrose.BaseItem;

public class Sulfuras extends BaseItem {

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
