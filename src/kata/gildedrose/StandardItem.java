package kata.gildedrose;

import com.gildedrose.Item;

public class StandardItem {

    private final Item item;

    public StandardItem(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    public void endOfDay() {
        this.item.sellIn--;
        this.item.quality--;
    }

    public int getSellIn() {
        return this.item.sellIn;
    }

    public int getQuality() {
        return this.item.quality;
    }
}
