package kata.gildedrose;

public class GildedRose {
    private final Item item;

    public GildedRose(Item item) {
        this.item = item;
    }

    public Item endOfDay() {
        item.endOfDaySellIn();
        item.endOfDayQuality();
        return item;
    }
}
