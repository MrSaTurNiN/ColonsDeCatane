package views;


import controllers.ControlGame;
import controllers.ControlGameButton;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;




/**
 * Created by Mahel Sif on 26/01/2016.
 */
public class Module {

    public static Font mainFont;
    public static Font banqueFont;
    public static DropShadow shadowText;

    public Module()
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
        t.setY(y-(height/2));
    }

    public static void drawString(Text t, String txt, double x, double y, Color c, Font f) {
        t.setText(txt);
        t.setEffect(shadowText);
        t.setFill(c);
        t.setFont(f);
        drawStringCenter(t, x, y);
    }

    public static void drawImage(ImageView Iv, javafx.scene.image.Image i, double x, double y)
    {
        Iv.setImage(i);
        Iv.setX(x);
        Iv.setY(y);
    }

    public void setModuleController(ControlGameButton listener){

    }

    public void setModuleController(ControlGame listener){

    }

    public double setLayoutXCenter(Button btn,double x){
        return x-btn.getPrefWidth()/2;
    }

    public double setLayoutYCenter(Button btn, double y){
        return  y-btn.getPrefHeight()/2;
    }
}