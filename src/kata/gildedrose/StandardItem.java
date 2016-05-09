package kata.gildedrose;

import com.gildedrose.Item;

public class StandardItem {

    private final Item item;

    public StandardItem(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    public void endOfDay() {
        setSellIn(getSellIn() - 1);
        if (hasSellByDatePassed()) {
            setQuality(getQuality() - 1);
        } else {
            setQuality(getQuality() - 2);
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
