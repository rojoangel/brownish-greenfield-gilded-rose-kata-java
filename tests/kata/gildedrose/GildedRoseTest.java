package kata.gildedrose;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import kata.gildedrose.item.AgedBrie;
import kata.gildedrose.item.BackstagePass;
import kata.gildedrose.item.StandardItem;
import kata.gildedrose.item.Sulfuras;
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
                        new StandardItem(10, 6),
                        buildItem("An standard item", 9, 5)},

                {"standard item - once the sell date has passed quality degrades twice as fast",
                        new StandardItem(0, 6),
                        buildItem("An standard item", -1, 4)},

                {"standard item - quality is never negative",
                        new StandardItem(10, 0),
                        buildItem("An standard item", 9, 0)},

                {"aged brie - quality increases the older it gets",
                        new AgedBrie(10, 7),
                        buildItem("Aged Brie", 9, 8)},

                {"aged brie - quality is never greater than 50",
                        new AgedBrie(10, 50),
                        buildItem("Aged Brie", 9, 50)},

                {"sulfuras - quality is 80 and never has to be sold",
                        new Sulfuras(99),
                        buildItem("Sulfuras", 99, 80)},

                {"backstage pass - quality increases",
                        new BackstagePass(15, 27),
                        buildItem("Backstage Pass", 14, 28)},

                {"backstage pass - quality increases by 2 when sellIn is 10 days or less",
                        new BackstagePass(10, 27),
                        buildItem("Backstage Pass", 9, 29)},

                {"backstage pass - quality increases by 3 when sellIn is 5 days or less",
                        new BackstagePass(6, 27),
                        buildItem("Backstage Pass", 5, 30)},

                {"backstage pass - quality drops to zero after theConcert",
                        new BackstagePass(0, 27),
                        buildItem("Backstage Pass", -1, 0)},

                {"conjured standard item - quality degrades twice as fast",
                        new Conjured(new StandardItem(10, 6)),
                        new Conjured(buildItem("An standard item", 9, 4))},

                {"conjured standard item - once the sell date has passed quality degrades twice as fast",
                        new Conjured(new StandardItem(0, 6)),
                        new Conjured(buildItem("An standard item", -1, 2))},

                {"conjured aged brie - quality increases the older it gets twice as fast",
                        new Conjured(new AgedBrie(10, 7)),
                        new Conjured(buildItem("Aged Brie", 9, 9))},

                {"conjured sulfuras - quality is 80 and never has to be sold",
                        new Conjured(new Sulfuras(99)),
                        new Conjured(buildItem("Sulfuras", 99, 80))},

                {"conjured backstage pass - quality increases twice as fast",
                        new Conjured(new BackstagePass(15, 27)),
                        new Conjured(buildItem("Backstage Pass", 14, 29))},

                {"conjured backstage pass - quality increases when sellIn is 10 days or less twice as fast",
                        new Conjured(new BackstagePass(10, 27)),
                        new Conjured(buildItem("Backstage Pass", 9, 31))},

                {"conjured backstage pass - quality increases when sellIn is 5 days or less twice as fast",
                        new Conjured(new BackstagePass(6, 27)),
                        new Conjured(buildItem("Backstage Pass", 5, 33))},

                {"conjured backstage pass - quality drops to zero after theConcert",
                        new Conjured(new BackstagePass(0, 27)),
                        new Conjured(buildItem("Backstage Pass", -1, 0))}
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

        Item standardItem = new StandardItem(10, 6);
        gildedRose.add(standardItem);

        Item conjuredBackStagePass = new Conjured(new BackstagePass(0, 27));
        gildedRose.add(conjuredBackStagePass);

        gildedRose.endOfDay();

        assertThat(standardItem, equalTo(buildItem("An standard item", 9, 5)));
        assertThat(conjuredBackStagePass, equalTo(new Conjured(buildItem("Backstage Pass", -1, 0))));
    }

    private static Item buildItem(final String name, final int sellIn, final int quality) {
        return new BaseItem(name, sellIn, quality) {
            @Override
            public void endOfDayQuality() {}

            @Override
            public void endOfDaySellIn() {}
        };
    }
}
