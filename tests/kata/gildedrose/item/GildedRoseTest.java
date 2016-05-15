package kata.gildedrose.item;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import kata.gildedrose.Item;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(DataProviderRunner.class)
public class GildedRoseTest {

    @DataProvider
    public static Object[][] provideItems() {
        return new Object[][] {
                {"standard item - sellIn and quality lower at the end of each day",
                        new StandardItem(10, 6), new StandardItem(9, 5)},
                {"standard item - once the sell date has passed quality degrades twice as fast",
                        new StandardItem(0, 6), new StandardItem(-1, 4)},
                {"standard item - quality is never negative",
                        new StandardItem(10, 0), new StandardItem(9, 0)},
                {"aged brie - quality increases the older it gets",
                        new AgedBrie(10, 7), new AgedBrie(9, 8)},
                {"aged brie - quality is never greater than 50",
                        new AgedBrie(10, 50), new AgedBrie(9, 50)},
                {"sulfuras - never has to be sold",
                        new Sulfuras(99), new Sulfuras(99)},
                {"sulfuras - quality is 80 and never alters",
                        new Sulfuras(99), new Item("Sulfuras", 99, 80) {
                            @Override
                            protected void endOfDayQuality() {}

                            @Override
                            protected void endOfDaySellIn() {}
                }},
                {"backstage pass - quality increases",
                        new BackstagePass(15, 27), new BackstagePass(14, 28)},
                {"backstage pass - quality increases by 2 when sellIn is 10 days or less",
                        new BackstagePass(10, 27), new BackstagePass(9, 29)},
                {"backstage pass - quality increases by 3 when sellIn is 5 days or less",
                        new BackstagePass(6, 27), new BackstagePass(5, 30)},
                {"backstage pass - quality drops to zero after theConcert",
                        new BackstagePass(0, 27), new BackstagePass(-1, 0)}
        };
    }

    @Test
    @UseDataProvider( "provideItems" )
    public void testEndOfDay(String scenario, Item item, Item expected) throws Exception {
        item.endOfDay();
        assertThat(scenario, item, equalTo(expected));
    }
}
