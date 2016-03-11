package views.Modules;

import Model.Partie;
import controllers.ControlMenu;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by Victor on 3/10/2016.
 */
public class ModuleInitPlay extends Module{
public Partie partie;
private Stage stage;
private Group root;

private double Y;

private Text[] text_menu;
private Rectangle[] rectangles;
    private Boolean draw=false;

    public ModuleInitPlay(Partie p, Group root, Stage s)
        {
            final Timeline timeline = new Timeline();
            this.root = root;
            this.partie = p;
            this.stage = s;
            text_menu=new Text[4];
            rectangles=new Rectangle[3];
            init();

            Y=s.getHeight();


            initTimeline(text_menu, 1500, 300, (-(s.getHeight() - 300)), Interpolator.EASE_OUT, timeline);
            timeline.play();
   /*     g=new Group();

        g.getChildren().add(text_menu[0]);
        g.getChildren().add(text_menu[1]);
        g.getChildren().add(text_menu[2]);
        g.getChildren().add(text_menu[3]);*/
            // drawBarUp();
            //drawInfoRessource();
        }
    public void initTimeline(Text[] text,int tps,int decal,double animValue,Interpolator inter,Timeline timeline){

        KeyValue kv;
        KeyFrame kf;
        for (int i = 0; i <text.length; i++) {
            kv = new KeyValue(text[i].yProperty(),animValue, inter);
            kf = new KeyFrame(Duration.millis(tps), kv);
            tps+=decal;
            timeline.getKeyFrames().add(kf);
        }

    }

    public void draw(){


        root.getChildren().removeAll(text_menu);
        if (draw) {
            drawMenu();

            root.getChildren().addAll(text_menu);
        }

    }

    public void init()
    {
        rectangles[0]=new Rectangle(100,100, Paint.valueOf("red"));
        rectangles[0].setOpacity(0.5);
     //   rectangles[0].boundsInLocalProperty().va
        text_menu[0]=new Text("Choix des joueurs");
        text_menu[0].setId("colons");

        text_menu[1]=new Text("Nouvelle Partie");
        text_menu[1].setId("newPart");

        text_menu[2]=new Text("options");
        text_menu[2].setId("Options");

        text_menu[3]=new Text("règles");
        text_menu[3].setId("Regles");

         }

    public void drawMenu(){

        drawString(text_menu[0], stage.getWidth() / 2, Y, Color.YELLOW, titleFont);
    }

    public void setMenuController(ControlMenu listener){
        for (Text t:text_menu){
            t.addEventHandler(MouseEvent.MOUSE_CLICKED,listener);
            t.addEventHandler(MouseEvent.MOUSE_ENTERED,listener);
            t.addEventHandler(MouseEvent.MOUSE_EXITED,listener);
        }
    }
    public void setDraw(Boolean bool){
        draw=bool;
    }


}
