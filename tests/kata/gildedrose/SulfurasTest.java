package kata.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class SulfurasTest {

    @Test
    public void neverHasToBeSold() throws Exception {
        int initialSellIn = 99;
        Item item = new Sulfuras("Sulfuras", initialSellIn, 10);
        item.endOfDay();
        assertEquals(initialSellIn, item.getSellIn());
    }

    @Test
    public void neverDecreasesInQuality() throws Exception {
        int initialQuality = 99;
        Item item = new Sulfuras("Sulfuras", 10, initialQuality);
        item.endOfDay();
        assertEquals(initialQuality, item.getQuality());
    }

}