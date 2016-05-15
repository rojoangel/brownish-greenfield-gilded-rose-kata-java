package kata.gildedrose;


public abstract class Item {

    private static final int SELL_IN_STEP = 1;
    private static final int QUALITY_STEP = 1;

    protected final com.gildedrose.Item item;

    public Item(String name, int sellIn, int quality) {
        this.item = new com.gildedrose.Item(name, sellIn, quality);
    }

    public int getSellIn() {
        return this.item.sellIn;
    }

    public int getQuality() {
        return this.item.quality;
    }

    private void setQuality(int newQuality) {
        if (newQuality < 0) {
            newQuality = 0;
        }

        if (newQuality > 50) {
            newQuality = 50;
        }
        this.item.quality = newQuality;
    }

    private void setSellIn(int newSellIn) {
        this.item.sellIn = newSellIn;
    }

    protected void increaseQualityBy(int factor) {
        setQuality(getQuality() + factor * QUALITY_STEP);
    }

    protected void decreaseQualityBy(int factor) {
        setQuality(getQuality() - factor * QUALITY_STEP);
    }

    protected void zeroQuality() {
        setQuality(0);
    }

    protected void decreaseSellIn() {
        setSellIn(getSellIn() - SELL_IN_STEP);
    }

    protected boolean hasSellByDatePassed() {
        return this.item.sellIn >= 0;
    }

    public void endOfDay() {
        endOfDaySellIn();
        endOfDayQuality();
    }

    protected abstract void endOfDayQuality();

    protected abstract void endOfDaySellIn();

    @Override
    public String toString() {
        return "Item{" +
                "item=" + item +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item1 = (Item) o;

        if (item.sellIn != item1.item.sellIn) return false;
        if (item.quality != item1.item.quality) return false;
        return item.name.equals(item1.item.name);
    }
}
