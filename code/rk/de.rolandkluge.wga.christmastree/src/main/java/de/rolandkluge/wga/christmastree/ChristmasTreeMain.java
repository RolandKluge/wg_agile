package de.rolandkluge.wga.christmastree;

public class ChristmasTreeMain
{
    public static void main(final String[] args)
    {
        final ChristmasTreeRenderer renderer = new ChristmasTreeRenderer();
        System.out.println(renderer.renderTreeOfHeight(7));
    }
}
