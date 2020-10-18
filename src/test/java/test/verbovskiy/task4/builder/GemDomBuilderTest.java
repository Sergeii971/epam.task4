package test.verbovskiy.task4.builder;

import com.verbovskiy.task4.builder.AbstractGemBuilder;
import com.verbovskiy.task4.builder.GemDomBuilder;
import test.verbovskiy.task4.data_provider.GemData;
import com.verbovskiy.task4.entity.Gem;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class GemDomBuilderTest {
    AbstractGemBuilder builder;

    @BeforeClass
    public void setUp() {
        builder = new GemDomBuilder();
    }

    @Test
    public void buildListGemsTest() {
        List<Gem> expected = GemData.getGems();
        builder.buildListGems("data/gems.xml");
        List<Gem> actual = builder.getGems();
        assertEquals(actual, expected);
    }
}