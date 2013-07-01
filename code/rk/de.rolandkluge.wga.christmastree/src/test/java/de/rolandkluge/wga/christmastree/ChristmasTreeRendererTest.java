package de.rolandkluge.wga.christmastree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChristmasTreeRendererTest
{

    private ChristmasTreeRenderer renderer;

    @Before
    public void setUp()
    {
        this.renderer = new ChristmasTreeRenderer();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHeight()
        throws Exception
    {
        this.renderer.renderTreeOfHeight(-1);
    }

    @Test
    public void test1()
        throws Exception
    {
        final int height = 0;
        final String expectedTree = "";

        this.runTestCase(height, expectedTree);
    }

    @Test
    public void test2()
        throws Exception
    {
        final int height = 1;
        final String expectedTree = //
        "  $  \n $$$ \n$$$$$\n";

        this.runTestCase(height, expectedTree);
    }

    @Test
    public void test3()
        throws Exception
    {
        final int height = 2;
        final String expectedTree = //
        "   $   \n  $$$  \n $$$$$ \n" + //
                "  $$$  \n $$$$$ \n$$$$$$$\n";
        this.runTestCase(height, expectedTree);

    }

    private void runTestCase(final int height, final String expectedTree)
    {
        final String actualTree = this.renderer.renderTreeOfHeight(height);

        final String expectedTreeWithCorrectSymbol = expectedTree.replaceAll("\\$", this.renderer.getTreeBodySymbol());
        Assert.assertEquals(expectedTreeWithCorrectSymbol, actualTree);
    }

}
