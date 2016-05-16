package kata.gildedrose.item;

import kata.gildedrose.Item;

import static kata.gildedrose.item.AgedBrie.AGED_BRIE;
import static kata.gildedrose.item.BackstagePass.BACKSTAGE_PASS;
import static kata.gildedrose.item.Conjured.CONJURED;
import static kata.gildedrose.item.StandardItem.STANDARD_ITEM;
import static kata.gildedrose.item.Sulfuras.SULFURAS;

public class ItemFactory {

    public static Item build(String name, int sellIn, int quality) {
        if (isConjured(name)) {
            return new Conjured(
                    buildNormalItem(
                            notConjuredItemNameFor(name),
                            sellIn,
                            quality
                    ));
        } else {
            return buildNormalItem(
                    name,
                    sellIn,
                    quality);
        }
    }

    private static boolean isConjured(String name) {
        return name.startsWith(CONJURED);
    }

    private static String notConjuredItemNameFor(String name) {
        return name.substring(CONJURED.length() + 1);
    }

    private static Item buildNormalItem(String name, int sellIn, int quality) {
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
