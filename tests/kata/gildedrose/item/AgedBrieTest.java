package kata.gildedrose.item;

import kata.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgedBrieTest {

    @Test
    public void qualityIncreasesTheOlderItGets() throws Exception {
        int initialQuality = 7;
        Item item = new AgedBrie(10, initialQuality);
        item.endOfDay();
        assertTrue(item.getQuality() > initialQuality);
    }

    @Test
    public void qualityIsNeverGreaterThan50() throws Exception {
        Item item = new StandardItem(27, 50);
        item.endOfDay();
        assertFalse(item.getQuality() > 50);
    }


}