package kata.gildedrose;

public class Sulfuras extends StandardItem {

    public Sulfuras(String name, int initialSellIn, int i) {
        super(name, initialSellIn, i);
    }

    @Override
    protected void calculateSellIn() {
        // do nothing;
    }
}
