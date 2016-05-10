package kata.gildedrose;

import com.gildedrose.Item;

public class StandardItem extends kata.gildedrose.Item {

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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

}
