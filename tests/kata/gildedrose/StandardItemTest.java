package kata.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class StandardItemTest {

    @Test
    public void sellInLowersAtTheEndOfEachDay()
    {
        String name = "An standard item";
        int sellIn = 10;
        int quality = 6;

        StandardItem item = new StandardItem(name, sellIn, quality);
        item.endOfDay();
        assertTrue(item.getSellIn() < sellIn);
    }

}