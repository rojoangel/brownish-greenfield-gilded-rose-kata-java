package kata.gildedrose.item;


import kata.gildedrose.Item;

public abstract class BaseItem implements Item {

    private static final int SELL_IN_STEP = 1;
    private static final int QUALITY_STEP = 1;

    protected final com.gildedrose.Item item;

    public BaseItem(String name, int sellIn, int quality) {
        this.item = new com.gildedrose.Item(name, sellIn, quality);
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
        setQuality(this.item.quality + factor * QUALITY_STEP);
    }

    protected void decreaseQualityBy(int factor) {
        setQuality(this.item.quality - factor * QUALITY_STEP);
    }

    protected void zeroQuality() {
        setQuality(0);
    }

    protected void decreaseSellIn() {
        setSellIn(this.item.sellIn - SELL_IN_STEP);
    }

    protected boolean hasSellByDatePassed() {
        return this.item.sellIn < 0;
    }

    @Override
    public String toString() {
        return "BaseItem{" +
                "item=" + item +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseItem)) return false;

        BaseItem item1 = (BaseItem) o;

        if (item.sellIn != item1.item.sellIn) return false;
        if (item.quality != item1.item.quality) return false;
        return item.name.equals(item1.item.name);
    }

    public static Item buildItem(String name, int sellIn, int quality) {
        switch (name) {
            case "An standard item":
                return new StandardItem(sellIn, quality);
            case "Aged Brie":
                return new AgedBrie(sellIn, quality);
            case "Sulfuras":
                return new Sulfuras(sellIn);
            case "Backstage Pass":
                return new BackstagePass(sellIn, quality);
            default:
                return new BaseItem(name, sellIn, quality) {
                    @Override
                    public void endOfDayQuality() {}

                    @Override
                    public void endOfDaySellIn() {}
                };
        }
    }
}
