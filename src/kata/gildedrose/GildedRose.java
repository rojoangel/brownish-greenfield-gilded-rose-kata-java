package kata.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public void endOfDay() {
        for (Item item : items) {
            item.endOfDaySellIn();
            item.endOfDayQuality();
        }
    }
}
