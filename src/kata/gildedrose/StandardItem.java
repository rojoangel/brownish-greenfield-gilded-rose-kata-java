package kata.gildedrose;

import com.gildedrose.Item;

public class StandardItem {

    private static final int FACTOR_1 = 1;
    private static final int SELL_IN_STEP = 1;
    private static final int QUALITY_STEP = 1;
    private static final int FACTOR_2 = 2;
    private final Item item;

    public StandardItem(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    public void endOfDay() {
        calculateSellIn();
        calculateQuality();
    }

    protected void calculateQuality() {
        if (hasSellByDatePassed()) {
            decreaseQuality(FACTOR_1);
        } else {
            decreaseQuality(FACTOR_2);
        }
    }

    protected void calculateSellIn() {
        decreaseSellIn();
    }

    protected void increaseQuality() {
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
