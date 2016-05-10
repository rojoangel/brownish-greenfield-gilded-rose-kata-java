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
        decreaseSellIn();
        decreaseQuality();
    }

    private void decreaseQuality() {
        int newQuality;

        if ("Aged Brie".equals(this.item.name)) {
            newQuality = getQuality() + QUALITY_DECREASE_STEP;
        } else {
            if (hasSellByDatePassed()) {
                newQuality = getQuality() - QUALITY_DECREASE_STEP;
            } else {
                newQuality = getQuality() - 2 * QUALITY_DECREASE_STEP;
            }
        }

        if (newQuality < 0) {
            newQuality = 0;
        }

        setQuality(newQuality);
    }

    private void decreaseSellIn() {
        setSellIn(getSellIn() - SELL_IN_DECREASE_STEP);
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
