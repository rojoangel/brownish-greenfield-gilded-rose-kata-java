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

}