package kata.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class StandardItemTest {

    @Test
    public void sellInLowersAtTheEndOfEachDay() throws Exception
    {
        int initialSellIn = 10;
        StandardItem item = new StandardItem("An standard item", initialSellIn, 6);

        item.endOfDay();

        assertTrue(item.getSellIn() < initialSellIn);
    }

    @Test
    public void qualityLowersAtTheEndOfEachDay() throws Exception
    {
        int initialQuality = 6;
        StandardItem item = new StandardItem("An standard item", 10, initialQuality);

        item.endOfDay();

        assertTrue(item.getQuality() < initialQuality);
    }

    @Test
    public void onceTheSellDateHasPassedQualityDegradesTwiceAsFast() throws Exception {

        int initialQuality = 20;

        StandardItem item = new StandardItem("An standard item", 1, initialQuality);
        item.endOfDay();

        int intermediateQuality = item.getQuality();

        item.endOfDay();
        int finalQuality = item.getQuality();

        assertTrue(finalQuality - intermediateQuality == 2 * (intermediateQuality - initialQuality));

    }
}
