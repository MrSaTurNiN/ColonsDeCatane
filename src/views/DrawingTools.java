package views;


import javafx.scene.effect.DropShadow;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;

import java.awt.*;

import java.io.IOException;



/**
 * Created by Mahel Sif on 26/01/2016.
 */
public class DrawingTools {

    public static Font mainFont;
    public static DropShadow shadowText;

    public DrawingTools()
    {
            mainFont = new Font(24f);
            mainFont.loadFont(this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"), 10);

            DropShadow ds = new DropShadow();
            ds.setOffsetY(0.0f);
            ds.setColor(javafx.scene.paint.Color.BLACK);

    }

    public static void drawStringCenter(String s, int x, int y, Graphics2D g2) {
        FontMetrics fm = g2.getFontMetrics();

        g2.drawString(s, x - (fm.stringWidth(s) / 2), y + (fm.getDescent() + fm.getAscent()) / 4);
    }

}