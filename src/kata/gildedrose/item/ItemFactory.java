package kata.gildedrose.item;

import kata.gildedrose.Item;

import static kata.gildedrose.item.AgedBrie.AGED_BRIE;
import static kata.gildedrose.item.BackstagePass.BACKSTAGE_PASS;
import static kata.gildedrose.item.Conjured.CONJURED;
import static kata.gildedrose.item.StandardItem.STANDARD_ITEM;
import static kata.gildedrose.item.Sulfuras.SULFURAS;

public class ItemFactory {

    public static Item build(String name, int sellIn, int quality) {
        if (name.startsWith(CONJURED)) {
            String itemName = name.substring(CONJURED.length() + 1);
            return new Conjured(buildItem(itemName, sellIn, quality));
        } else {
            return buildItem(name, sellIn, quality);
        }
    }

    private static Item buildItem(String name, int sellIn, int quality) {
        switch (name) {
            case STANDARD_ITEM:
                return new StandardItem(sellIn, quality);
            case AGED_BRIE:
                return new AgedBrie(sellIn, quality);
            case SULFURAS:
                return new Sulfuras(sellIn);
            case BACKSTAGE_PASS:
                return new BackstagePass(sellIn, quality);
            default:
                throw new RuntimeException("Unknown item name : " + name);
        }
    }
}
