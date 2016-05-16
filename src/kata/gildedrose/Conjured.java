package kata.gildedrose;

public class Conjured implements Item {

    private final Item item;

    public Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void endOfDay() {
        endOfDaySellIn();
        endOfDayQuality();
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
