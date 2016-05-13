package kata.gildedrose.item;

import kata.gildedrose.Item;

public class Sulfuras extends Item {

    public Sulfuras(int initialSellIn, int i) {
        super("Sulfuras", initialSellIn, i);
    }

    @Override
    protected void calculateQuality() {
        // do nothing
    }

    @Override
    protected void calculateSellIn() {
        // do nothing;
    }
}
