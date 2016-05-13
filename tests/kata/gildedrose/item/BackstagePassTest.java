package kata.gildedrose.item;

import kata.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackstagePassTest {

    @Test
    public void qualityIncreasesBy2WhenSellInIs10DaysOrLess () throws Exception {
        int initialQuality = 27;
        Item item = new BackstagePass(10, initialQuality);
        item.endOfDay();
        assertTrue(item.getQuality() == initialQuality + 2);
    }

    @Test
    public void qualityIncreasesBy3WhenSellInIs5DaysOrLess () throws Exception {
        int initialQuality = 27;
        Item item = new BackstagePass(6, initialQuality);
        item.endOfDay();
        assertTrue(item.getQuality() == initialQuality + 3);
    }

}