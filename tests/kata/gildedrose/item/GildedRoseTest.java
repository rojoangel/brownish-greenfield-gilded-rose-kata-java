package kata.gildedrose.item;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import kata.gildedrose.Item;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class GildedRoseTest {

    @DataProvider
    public static Object[][] provideItems() {
        return new Object[][] {
                {new StandardItem(10, 6), new StandardItem(9, 5)}
        };
    }

    @Test
    @UseDataProvider( "provideItems" )
    public void testEndOfDay(Item item, Item expected) throws Exception {
        item.endOfDay();
        assertEquals(expected, item);
    }
}
