package views.Modules;

import Model.Partie;
import controllers.ControlGame;
import javafx.beans.value.ChangeListener;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import views.DrawingTools;
import views.ViewConstants;

/**
 * Created by Mahel on 20/02/2016.
 */
public class ModuleBarRaccourcis extends DrawingTools implements ViewConstants {

    public boolean isSelected;
    private Partie partie;
    private Group root;
    private Stage stage;

    private double XPositionBoutons;
    private double YPositionBoutons;
    private double XModule;
    private double YModule;

    private Image background_bouton;
    ImageView l;

    private ImageView background_boutons[] = new ImageView[1];

    public ModuleBarRaccourcis(Partie p, Group r, Stage s)
    {
        initImage();
        this.partie = p;
        this.root = r;
        this.stage = s;

        XPositionBoutons = s.getWidth() - 100;
        YPositionBoutons = s.getHeight() - 100;

        draw();
    }

    public void  initImage() {
        background_bouton = new Image(getClass().getResourceAsStream("/assets/img/background_bouton.png"));
    }

    public void draw()
    {
        root.getChildren().removeAll(background_boutons);
        drawBoutons();
        root.getChildren().addAll(background_boutons);
    }

    public void drawBoutons()
    {
        background_boutons[0] = new ImageView();
        drawImage(background_boutons[0], background_bouton, XPositionBoutons, stage.getHeight() - 150);
    }


    public void setBarRaccourcisController(ControlGame listener)
    {
    }



}
