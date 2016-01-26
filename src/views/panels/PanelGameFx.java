package views.panels;

import Model.Partie;
import controllers.ClickListener;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import views.ViewConstants;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.ImagingOpException;

/**
 * Created by Mahel Sif on 26/01/2016.
 */
public class PanelGameFx extends Application implements ViewConstants {

    private GraphicsContext gc;
    private Partie partie;

    private JButton des;
    private JButton skip;

    private Image fond;


    public PanelGameFx(Partie partie){
        this.partie = partie;

    }

    public void initImage()
    {
        try {
            fond = new Image("file:background.png");
        }catch (ImagingOpException e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        initImage();
        Circle circ = new Circle(40, 40, 30);
        Group root = new Group(circ);
        Canvas canvas = new Canvas(WINDOW_WIDTH,WINDOW_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        drawBackground();

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void drawBackground()
    {

        Rectangle rekt = new Rectangle(0,0, WINDOW_WIDTH, WINDOW_HEIGHT );
        gc.drawImage(fond,0,0);
        ImagePattern imagePattern = new ImagePattern(fond);
        rekt.setFill(imagePattern);


    }

    public void setControler(ClickListener listener)
    {
        /*
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
        des.addActionListener(listener);
        skip.addActionListener(listener);*/
    }


    public void setButtonController(ActionListener al){
        // des.addActionListener(al);
        // skip.addActionListener(al);
    }

    public JButton getDes() {
        return des;
    }

    public JButton getSkip(){
        return skip;
    }
}
