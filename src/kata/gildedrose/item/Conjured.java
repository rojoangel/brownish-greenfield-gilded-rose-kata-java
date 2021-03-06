package kata.gildedrose.item;

import kata.gildedrose.Item;

class Conjured implements Item {

    static final String CONJURED = "Conjured";

    private final Item item;

    Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void endOfDayQuality() {
        item.endOfDayQuality();
        item.endOfDayQuality();
    }

    @Override
    public void endOfDaySellIn() {
        item.endOfDaySellIn();
    }

    @Override
    public String toString() {
        return "Conjured{" +
                "item=" + item +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conjured)) return false;

        Conjured conjured = (Conjured) o;

        return item.equals(conjured.item);

    }

    @Override
    public int hashCode() {
        return item.hashCode();
    }
}
