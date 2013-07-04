package de.rolandkluge.wga.christmastree;

import org.apache.commons.lang.StringUtils;

/**
 * The Christmas tree renderer produces ASCII art christmas trees.
 *
 * A tree is specified by its height. A tree of height 0 is an empty string. A tree of height 1
 * looks like this:
 *
 * <pre>
 *   #  \n
 *  ### \n
 * #####\n
 * </pre>
 *
 * A tree T of height n is build from a tree S of height n-1 as follows: We add three more lines to
 * the bottom of S. The topmost line of T is two units smaller than the bottom line of S. The
 * intermediate line is just as broad an the new bottom line is two units wider than the bottom line
 * of S. For instance, a tree of height 2 looks like this:
 *
 * <pre>
 *    #   \n
 *   ###  \n
 *  ##### \n
 *   ###  \n
 *  ##### \n
 * #######\n
 * </pre>
 *
 * Additional features:
 *
 * <ul>
 * <li>Add candles (* on top of |)</li>
 * <li>Switch candles on of (* + | and |)</li>
 * <li>Change symbols of the tree (# -> o)
 * </ul>
 *
 * @author Roland Kluge
 *
 */
public class ChristmasTreeRenderer
{

    private static final String DEFAULT_TREE_BODY_SYMBOL = "#";
    private String treeBodySymbol;

    public ChristmasTreeRenderer()
    {
        this.setTreeBodySymbol(DEFAULT_TREE_BODY_SYMBOL);
    }

    public String getTreeBodySymbol()
    {
        return this.treeBodySymbol;
    }

    public void setTreeBodySymbol(final String treeBodySymbol)
    {
        this.treeBodySymbol = treeBodySymbol;
    }

    public String renderTreeOfHeight(final int height)
    {

        if (height < 0)
            throw new IllegalArgumentException("Negative height not allowed");

        StringBuilder sb = new StringBuilder();

        for (int l = 1; l <= height; ++l) {
            for (int n = 2 * l - 1; n <= 2 * l + 3; n += 2) {
                final String treeRow = StringUtils.repeat(this.getTreeBodySymbol(), n);
                final String paddedRow = StringUtils.center(treeRow, 2 * height + 3);
                sb.append(paddedRow);
                sb.append("\n");
            }
        }

        return sb.toString();

    }
}
