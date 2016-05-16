package kata.gildedrose;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import kata.gildedrose.item.ItemFactory;
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
                        new Object[] {"Standard Item", 10, 6},
                        ItemFactory.build("Standard Item", 9, 5)},

                {"standard item - once the sell date has passed quality degrades twice as fast",
                        new Object[] {"Standard Item", 0, 6},
                        ItemFactory.build("Standard Item", -1, 4)},

                {"standard item - quality is never negative",
                        new Object[] {"Standard Item", 10, 0},
                        ItemFactory.build("Standard Item", 9, 0)},

                {"aged brie - quality increases the older it gets",
                        new Object[] {"Aged Brie", 10, 7},
                        ItemFactory.build("Aged Brie", 9, 8)},

                {"aged brie - quality is never greater than 50",
                        new Object[] {"Aged Brie", 10, 50},
                        ItemFactory.build("Aged Brie", 9, 50)},

                {"sulfuras - quality is 80 and never has to be sold",
                        new Object[] {"Sulfuras", 99, 80},
                        ItemFactory.build("Sulfuras", 99, 80)},

                {"backstage pass - quality increases",
                        new Object[] {"Backstage Pass", 15, 27},
                        ItemFactory.build("Backstage Pass", 14, 28)},

                {"backstage pass - quality increases by 2 when sellIn is 10 days or less",
                        new Object[] {"Backstage Pass", 10, 27},
                        ItemFactory.build("Backstage Pass", 9, 29)},

                {"backstage pass - quality increases by 3 when sellIn is 5 days or less",
                        new Object[] {"Backstage Pass", 6, 27},
                        ItemFactory.build("Backstage Pass", 5, 30)},

                {"backstage pass - quality drops to zero after theConcert",
                        new Object[] {"Backstage Pass", 0, 27},
                        ItemFactory.build("Backstage Pass", -1, 0)},

                {"conjured standard item - quality degrades twice as fast",
                        new Object[] {"Conjured Standard Item", 10, 6},
                        ItemFactory.build("Conjured Standard Item", 9, 4)},

                {"conjured standard item - once the sell date has passed quality degrades twice as fast",
                        new Object[] {"Conjured Standard Item", 0, 6},
                        ItemFactory.build("Conjured Standard Item", -1, 2)},

                {"conjured aged brie - quality increases the older it gets twice as fast",
                        new Object[] {"Conjured Aged Brie", 10, 7},
                        ItemFactory.build("Conjured Aged Brie", 9, 9)},

                {"conjured sulfuras - quality is 80 and never has to be sold",
                        new Object[] {"Conjured Sulfuras", 99, 80},
                        ItemFactory.build("Conjured Sulfuras", 99, 80)},

                {"conjured backstage pass - quality increases twice as fast",
                        new Object[] {"Conjured Backstage Pass", 15, 27},
                        ItemFactory.build("Conjured Backstage Pass", 14, 29)},

                {"conjured backstage pass - quality increases when sellIn is 10 days or less twice as fast",
                        new Object[] {"Conjured Backstage Pass", 10, 27},
                        ItemFactory.build("Conjured Backstage Pass", 9, 31)},

                {"conjured backstage pass - quality increases when sellIn is 5 days or less twice as fast",
                        new Object[] {"Conjured Backstage Pass", 6, 27},
                        ItemFactory.build("Conjured Backstage Pass", 5, 33)},

                {"conjured backstage pass - quality drops to zero after theConcert",
                        new Object[] {"Conjured Backstage Pass", 0, 27},
                        ItemFactory.build("Conjured Backstage Pass", -1, 0)}
        };
    }

    @Test
    @UseDataProvider( "provideItems" )
    public void testEndOfDay(
            String scenario,
            Object[] itemValues,
            Item expected
    ) throws Exception {

        String name = (String) itemValues[0];
        int sellIn = (int) itemValues[1];
        int quality = (int) itemValues[2];

        GildedRose gildedRose = new GildedRose();
        Item item = gildedRose.add(name, sellIn, quality);
        gildedRose.endOfDay();

        assertThat(scenario, item, equalTo(expected));
    }

    @Test
    public void testEndOfDayWithMultipleItems() throws Exception {
        GildedRose gildedRose = new GildedRose();
        Item standardItem = gildedRose.add("Standard Item", 10, 6);
        Item conjuredBackStagePass = gildedRose.add("Conjured Backstage Pass", 0, 27);

        gildedRose.endOfDay();

        assertThat(standardItem, equalTo(ItemFactory.build("Standard Item", 9, 5)));
        assertThat(conjuredBackStagePass, equalTo(ItemFactory.build("Conjured Backstage Pass", -1, 0)));
    }
}
