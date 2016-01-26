package views;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Mahel Sif on 26/01/2016.
 */
public class DrawingTools {

    public java.awt.Font mainFontSize;

    public DrawingTools()
    {
        try {
            java.awt.Font mainFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"));
            mainFontSize = mainFont.deriveFont(24f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void drawStringCenter(String s, int x, int y, Graphics2D g2) {
        FontMetrics fm = g2.getFontMetrics();

        g2.drawString(s, x - (fm.stringWidth(s) / 2), y + (fm.getDescent() + fm.getAscent()) / 4);
    }
}
