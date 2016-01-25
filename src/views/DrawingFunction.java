package views;

import java.awt.*;

/**
 * Created by Mahel Sif on 25/01/2016.
 */
public class DrawingFunction {


    public static void drawStringCenter(String s, int x, int y, Graphics2D g2) {
        FontMetrics fm = g2.getFontMetrics();

        g2.drawString(s, x - (fm.stringWidth(s) / 2), y + (fm.getDescent() + fm.getAscent()) / 4);
    }
}
