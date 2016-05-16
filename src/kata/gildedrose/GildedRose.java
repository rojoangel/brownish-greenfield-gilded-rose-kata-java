package kata.gildedrose;

import kata.gildedrose.item.ItemFactory;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private final List<Item> items = new ArrayList<>();

    public void endOfDay() {
        for (Item item : items) {
            item.endOfDaySellIn();
            item.endOfDayQuality();
        }
    }

    public Item add(String name, int sellIn, int quality) {
        Item item = ItemFactory.build(name, sellIn, quality);
        items.add(item);
        return item;
    }
}
