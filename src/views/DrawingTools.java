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
    public static Font banqueFont;
    public static DropShadow shadowText;

    public DrawingTools()
    {
            mainFont = new Font(24f);
            banqueFont = new Font(40f);
            mainFont.loadFont(this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"), 10);
            banqueFont.loadFont(this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"), 10);

            DropShadow ds = new DropShadow();
            ds.setOffsetY(0.0f);
            ds.setColor(javafx.scene.paint.Color.BLACK);

    }

    public static void drawStringCenter(Text t, double x, double y)
    {
        double width = t.getLayoutBounds().getWidth();
        double height = t.getLayoutBounds().getHeight();

        t.setX(x-(width/2));
        t.setY(y-height/2);
    }

    public static void drawString(Text t, String txt, double x, double y, Color c, Font f) {
        t.setText(txt);
        t.setEffect(shadowText);
        drawStringCenter(t, x, y);
        t.setFill(c);
        t.setFont(f);
    }

}