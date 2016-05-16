package kata.gildedrose;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import kata.gildedrose.item.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(DataProviderRunner.class)
public class GildedRoseTest {

    @DataProvider
    public static Object[][] provideItems() {
        final int sellIn = -1;
        final int sellIn1 = -1;
        final int sellIn2 = -1;
        final int sellIn3 = -1;
        return new Object[][] {
                {"standard item - sellIn and quality lower at the end of each day",
                        Factory.buildItem("Standard Item", 10, 6),
                        Factory.buildItem("Standard Item", 9, 5)},

                {"standard item - once the sell date has passed quality degrades twice as fast",
                        Factory.buildItem("Standard Item", 0, 6),
                        Factory.buildItem("Standard Item", sellIn3, 4)},

                {"standard item - quality is never negative",
                        Factory.buildItem("Standard Item", 10, 0),
                        Factory.buildItem("Standard Item", 9, 0)},

                {"aged brie - quality increases the older it gets",
                        Factory.buildItem("Aged Brie", 10, 7),
                        Factory.buildItem("Aged Brie", 9, 8)},

                {"aged brie - quality is never greater than 50",
                        Factory.buildItem("Aged Brie", 10, 50),
                        Factory.buildItem("Aged Brie", 9, 50)},

                {"sulfuras - quality is 80 and never has to be sold",
                        Factory.buildItem("Sulfuras", 99, 80),
                        Factory.buildItem("Sulfuras", 99, 80)},

                {"backstage pass - quality increases",
                        Factory.buildItem("Backstage Pass", 15, 27),
                        Factory.buildItem("Backstage Pass", 14, 28)},

                {"backstage pass - quality increases by 2 when sellIn is 10 days or less",
                        Factory.buildItem("Backstage Pass", 10, 27),
                        Factory.buildItem("Backstage Pass", 9, 29)},

                {"backstage pass - quality increases by 3 when sellIn is 5 days or less",
                        Factory.buildItem("Backstage Pass", 6, 27),
                        Factory.buildItem("Backstage Pass", 5, 30)},

                {"backstage pass - quality drops to zero after theConcert",
                        Factory.buildItem("Backstage Pass", 0, 27),
                        Factory.buildItem("Backstage Pass", sellIn2, 0)},

                {"conjured standard item - quality degrades twice as fast",
                        Factory.buildItem("Conjured Standard Item", 10, 6),
                        Factory.buildItem("Conjured Standard Item", 9, 4)},

                {"conjured standard item - once the sell date has passed quality degrades twice as fast",
                        Factory.buildItem("Conjured Standard Item", 0, 6),
                        Factory.buildItem("Conjured Standard Item", sellIn1, 2)},

                {"conjured aged brie - quality increases the older it gets twice as fast",
                        Factory.buildItem("Conjured Aged Brie", 10, 7),
                        Factory.buildItem("Conjured Aged Brie", 9, 9)},

                {"conjured sulfuras - quality is 80 and never has to be sold",
                        Factory.buildItem("Conjured Sulfuras", 99, 80),
                        Factory.buildItem("Conjured Sulfuras", 99, 80)},

                {"conjured backstage pass - quality increases twice as fast",
                        Factory.buildItem("Conjured Backstage Pass", 15, 27),
                        Factory.buildItem("Conjured Backstage Pass", 14, 29)},

                {"conjured backstage pass - quality increases when sellIn is 10 days or less twice as fast",
                        Factory.buildItem("Conjured Backstage Pass", 10, 27),
                        Factory.buildItem("Conjured Backstage Pass", 9, 31)},

                {"conjured backstage pass - quality increases when sellIn is 5 days or less twice as fast",
                        Factory.buildItem("Conjured Backstage Pass", 6, 27),
                        Factory.buildItem("Conjured Backstage Pass", 5, 33)},

                {"conjured backstage pass - quality drops to zero after theConcert",
                        Factory.buildItem("Conjured Backstage Pass", 0, 27),
                        Factory.buildItem("Conjured Backstage Pass", sellIn, 0)}
        };
    }

    @Test
    @UseDataProvider( "provideItems" )
    public void testEndOfDay(String scenario, Item item, Item expected) throws Exception {
        GildedRose gildedRose = new GildedRose();
        gildedRose.add(item);
        gildedRose.endOfDay();
        assertThat(scenario, item, equalTo(expected));
    }

    @Test
    public void testEndOfDayWithMultipleItems() throws Exception {
        GildedRose gildedRose = new GildedRose();

        Item standardItem = Factory.buildItem("Standard Item", 10, 6);
        gildedRose.add(standardItem);

        Item conjuredBackStagePass = Factory.buildItem("Conjured Backstage Pass", 0, 27);
        gildedRose.add(conjuredBackStagePass);

        gildedRose.endOfDay();

        assertThat(standardItem, equalTo(Factory.buildItem("Standard Item", 9, 5)));
        final int sellIn = -1;
        assertThat(conjuredBackStagePass, equalTo(Factory.buildItem("Conjured Backstage Pass", sellIn, 0)));
    }
}
