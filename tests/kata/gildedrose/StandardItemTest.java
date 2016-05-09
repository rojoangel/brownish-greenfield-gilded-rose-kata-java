package kata.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class StandardItemTest {

    @Test
    public void sellInLowersAtTheEndOfEachDay()
    {
        int initialSellIn = 10;
        StandardItem item = new StandardItem("An standard item", initialSellIn, 6);

        item.endOfDay();

        assertTrue(item.getSellIn() < initialSellIn);
    }
}
