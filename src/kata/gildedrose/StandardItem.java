package kata.gildedrose;

import com.gildedrose.Item;

public class StandardItem {

    public static final int SELL_IN_DECREASE_STEP = 1;
    public static final int QUALITY_DECREASE_STEP = 1;
    private final Item item;

    public StandardItem(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    public void endOfDay() {
        setSellIn(getSellIn() - SELL_IN_DECREASE_STEP);
        if (hasSellByDatePassed()) {
            setQuality(getQuality() - QUALITY_DECREASE_STEP);
        } else {
            setQuality(getQuality() - 2 * QUALITY_DECREASE_STEP);
        }

    }

    private boolean hasSellByDatePassed() {
        return this.item.sellIn >= 0;
    }

    private void setQuality(int newQuantity) {
        this.item.quality = newQuantity;
    }

    private void setSellIn(int newSellIn) {
        this.item.sellIn = newSellIn;
    }

    public int getSellIn() {
        return this.item.sellIn;
    }

    public int getQuality() {
        return this.item.quality;
    }
}
