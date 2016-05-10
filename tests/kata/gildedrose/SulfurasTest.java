package kata.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class SulfurasTest {

    @Test
    public void neverHasToBeSold() throws Exception {
        int initialSellIn = 99;
        Sulfuras item = new Sulfuras("Sulfuras", initialSellIn, 10);
        item.endOfDay();
        assertEquals(initialSellIn, item.getSellIn());
    }
}