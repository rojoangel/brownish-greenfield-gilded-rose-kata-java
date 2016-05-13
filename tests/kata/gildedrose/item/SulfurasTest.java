package kata.gildedrose.item;

import kata.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class SulfurasTest {

    @Test
    public void neverHasToBeSold() throws Exception {
        int initialSellIn = 99;
        Item item = new Sulfuras(initialSellIn);
        item.endOfDay();
        assertEquals(initialSellIn, item.getSellIn());
    }

    @Test
    public void qualityIs80AndNeverAlters() throws Exception {
        Item item = new Sulfuras(10);
        item.endOfDay();
        assertEquals(Sulfuras.QUALITY, item.getQuality());
    }
}