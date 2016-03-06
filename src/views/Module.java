package views;


import controllers.ControlGame;
import controllers.ControlGameButton;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;




/**
 * Created by Mahel Sif on 26/01/2016.
 */
public class Module {

    public static Font mainFont;
    public static Font banqueFont;
    public static Font pointFont;
    public static DropShadow shadowText;

    public Module()
    {
            mainFont = new Font(24f);
            banqueFont = new Font(40f);
            pointFont = new Font(45f);
            mainFont.loadFont(this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"), 10);
            banqueFont.loadFont(this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"), 10);
            pointFont.loadFont(this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"), 10);

            DropShadow ds = new DropShadow();
            ds.setOffsetY(0.0f);
            ds.setColor(javafx.scene.paint.Color.BLACK);

    }

    public static void drawStringCenter(Text t, double x, double y)
    {

        double width = t.getLayoutBounds().getWidth();
        double height = t.getBoundsInLocal().getHeight()/2;
        t.setLayoutX(x - (width/2));
        t.setLayoutY(y +(height/2));
        System.out.println(height);
    }

    public static void drawString(Text t, String txt, double x, double y, Color c, Font f) {
        t.setText(txt);
        t.setEffect(shadowText);
        t.setFill(c);
        t.setFont(f);
        drawStringCenter(t, x, y);
    }



    public static void drawImageCenter(ImageView Iv, javafx.scene.image.Image i, double x, double y)
    {
        double width = i.getWidth();
        double height = i.getHeight();

        Iv.setImage(i);
        Iv.setX(x - width/2);
        Iv.setY(y - height/2);
    }

    public static void drawButtonCenter(ImageView backgroundV, ImageView iconeV, Image background, Image icone, double x, double y, String id)
    {
        backgroundV.setId(id);
        drawImageCenter(backgroundV, background, x, y);

        iconeV.setId(id);
        drawImageCenter(iconeV, icone, x, y);

    }

    public static Color colorToPaint(java.awt.Color c)
    {
        java.awt.Color color = c;
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int a = color.getAlpha();
        double opacity = a / 255.0 ;
        return Color.rgb(r, g, b, opacity);
    }

}