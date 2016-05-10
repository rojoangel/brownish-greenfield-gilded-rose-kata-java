package kata.gildedrose;

public class AgedBrie extends StandardItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void calculateQuality() {
        increaseQuality();
    }
}
