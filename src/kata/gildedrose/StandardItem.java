package kata.gildedrose;

import com.gildedrose.Item;

public class StandardItem {

    public static final int SELL_IN_STEP = 1;
    public static final int QUALITY_STEP = 1;
    private final Item item;

    public StandardItem(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    public void endOfDay() {
        decreaseSellIn();
        calculateQuality();
    }

    private void calculateQuality() {

        if ("Aged Brie".equals(this.item.name)) {
            increaseQuality();
        } else {
            if (hasSellByDatePassed()) {
                int factor = 1;
                decreaseQuality(factor);
            } else {
                int factor = 2;
                decreaseQuality(factor);
            }
        }
    }

    private void increaseQuality() {
        setQuality(getQuality() + QUALITY_STEP);
    }

    private void decreaseQuality(int factor) {
        setQuality(getQuality() - factor * QUALITY_STEP);
    }

    private void decreaseSellIn() {
        setSellIn(getSellIn() - SELL_IN_STEP);
    }

    private boolean hasSellByDatePassed() {
        return this.item.sellIn >= 0;
    }

    private void setQuality(int newQuality) {
        if (newQuality < 0) {
            newQuality = 0;
        }
        this.item.quality = newQuality;
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
