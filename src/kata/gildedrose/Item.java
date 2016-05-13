package kata.gildedrose;


public abstract class Item {

    protected static final int FACTOR_1 = 1;
    protected static final int FACTOR_2 = 2;
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

    protected void increaseQuality(int factor) {
        setQuality(getQuality() + factor * QUALITY_STEP);
    }

    protected void decreaseQuality(int factor) {
        setQuality(getQuality() - factor * QUALITY_STEP);
    }

    protected void decreaseSellIn() {
        setSellIn(getSellIn() - SELL_IN_STEP);
    }

    protected boolean hasSellByDatePassed() {
        return this.item.sellIn >= 0;
    }

    public void endOfDay() {
        calculateSellIn();
        calculateQuality();
    }

    protected abstract void calculateQuality();

    protected abstract void calculateSellIn();


}
