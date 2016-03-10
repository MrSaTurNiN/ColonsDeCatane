package views.Modules;

import Model.Partie;
import controllers.ControlMenu;
import javafx.animation.*;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 * Created by Victor on 08/03/2016.
 */
public class ModuleMenu extends Module {
    public Partie partie;
    private Stage stage;

    private Group root;
    private Text[] text_menu;
    private double Y;
    private Group g;
    private Blend blend;
    private Timeline timelineanim;
    private Timeline timelinenaimreverse;
    private Blend blendanim;
    private Timeline Timeline2;
    private KeyValue kv;
    private KeyValue kv1;
    private KeyFrame kf;

    public ModuleMenu(Partie p, Group root, Stage s)
    {
        final Timeline timeline = new Timeline();
        this.root = root;
        this.partie = p;
        this.stage = s;
        text_menu=new Text[4];
        initText();
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

        drawMenu();

        root.getChildren().addAll(text_menu);

    }

    public void initText()
    {
        text_menu[0]=new Text("Colons de Catane");
        text_menu[0].setId("colons");

        text_menu[1]=new Text("Nouvelle Partie");
        text_menu[1].setId("newPart");

        text_menu[2]=new Text("options");
        text_menu[2].setId("Options");

        text_menu[3]=new Text("règles");
        text_menu[3].setId("Regles");

        blend = new Blend();
        blend.setMode(BlendMode.MULTIPLY);

        DropShadow ds = new DropShadow();
        ds.setColor(Color.rgb(254, 235, 66, 0.3));
        ds.setOffsetX(5);
        ds.setOffsetY(5);
        ds.setRadius(5);
        ds.setSpread(0.2);

        blend.setBottomInput(ds);

        DropShadow ds1 = new DropShadow();
        ds1.setColor(Color.web("#f13a00"));
        ds1.setRadius(7);
        ds1.setSpread(0.1);

        Blend blend2 = new Blend();
        blend2.setMode(BlendMode.MULTIPLY);

        InnerShadow is = new InnerShadow();
        is.setColor(Color.web("#feeb42"));
        is.setRadius(9);
        is.setChoke(0.8);
        blend2.setBottomInput(is);

        InnerShadow is1 = new InnerShadow();
        is1.setColor(Color.web("#f13a00"));
        is1.setRadius(5);
        is1.setChoke(0.4);
        blend2.setTopInput(is1);

        Blend blend1 = new Blend();
        blend1.setMode(BlendMode.MULTIPLY);
        blend1.setBottomInput(ds1);
        blend1.setTopInput(blend2);

        blend.setTopInput(blend1);

        blendanim = new Blend();
        blendanim.setMode(BlendMode.MULTIPLY);

        DropShadow dss = new DropShadow();
        dss.setColor(Color.rgb(254, 235, 66, 0.3));
        dss.setOffsetX(5);
        dss.setOffsetY(5);
        dss.setRadius(5);
        dss.setSpread(0.2);

        blendanim.setBottomInput(dss);

        DropShadow dss1 = new DropShadow();
        dss1.setColor(Color.web("#feeb42"));
        dss1.setRadius(7);
        dss1.setSpread(0.5);

        Blend blendd2 = new Blend();
        blendd2.setMode(BlendMode.MULTIPLY);

        InnerShadow iss = new InnerShadow();
        iss.setColor(Color.web("#f13a00"));
        iss.setRadius(9);
        iss.setChoke(0.8);
        blendd2.setBottomInput(iss);

        InnerShadow iss1 = new InnerShadow();
        iss1.setColor(Color.web("#feeb42"));
        iss1.setRadius(5);
        iss1.setChoke(0.4);
        blendd2.setTopInput(iss1);

        Blend blendd1 = new Blend();
        blendd1.setMode(BlendMode.MULTIPLY);
        blendd1.setBottomInput(dss1);
        blendd1.setTopInput(blendd2);

        blendanim.setTopInput(blendd1);


    }

    public void drawMenu(){

        drawString(text_menu[0], stage.getWidth() / 2, Y, Color.YELLOW,titleFont);
        drawString(text_menu[1],stage.getWidth()/2,Y+200,Color.YELLOW,subtitleFont);
        drawString(text_menu[2], stage.getWidth() / 2, Y + 300, Color.YELLOW, subtitleFont);
        drawString(text_menu[3], stage.getWidth() / 2, Y + 400, Color.YELLOW, subtitleFont);

        text_menu[0].setEffect(blend);
        text_menu[1].setEffect(blend);
        text_menu[2].setEffect(blend);
        text_menu[3].setEffect(blend);

    }

    public void setMenuController(ControlMenu listener){
        for (Text t:text_menu){
            t.addEventHandler(MouseEvent.MOUSE_CLICKED,listener);
            t.addEventHandler(MouseEvent.MOUSE_ENTERED,listener);
            t.addEventHandler(MouseEvent.MOUSE_EXITED,listener);
        }
    }

    public void unHover(Text t){
       // timelineanim.;
       // t.setEffect(blend);
       // t.setFill(Paint.valueOf("yellow"));
     /*   Timeline2=new Timeline();
        KeyValue kv;
        KeyFrame kf;
        kv = new KeyValue(t.translateYProperty(),-5, Interpolator.EASE_BOTH);
        kf = new KeyFrame(Duration.millis(200), kv);
        Timeline2.getKeyFrames().add(kf);*/

            //timelineanim.setAutoReverse(false);
        if (!t.getId().equals("colons")) {
            timelineanim.jumpTo(Duration.millis(0));
            timelineanim.stop();
        }
           // timelineanim.setCycleCount(0);

    }


    public void drawHover(Text t) {

        if (!t.getId().equals("colons")){
            timelineanim=new Timeline();
            kv = new KeyValue(t.translateYProperty(),8, Interpolator.EASE_OUT);
            kv1 = new KeyValue(t.scaleYProperty(),0.98, Interpolator.EASE_OUT);
            kf = new KeyFrame(Duration.millis(300), kv,kv1);
            timelineanim.getKeyFrames().add(kf);
            timelineanim.setAutoReverse(true);
            timelineanim.setCycleCount(Animation.INDEFINITE);
            timelineanim.play();
            System.out.println(t.getId());
        }
    }
}
