package views.Modules;

import Model.Partie;
import controllers.ControlGame;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import views.Module;
import views.ViewConstants;

/**
 * Created by Mahel on 20/02/2016.
 */
public class ModuleBarRaccourcis extends Module implements ViewConstants {

    public boolean isSelected;
    private Partie partie;
    private Group root;
    private Stage stage;

    private double XPositionBoutons;
    private double YPositionBoutons;
    private double XModule;
    private double YModule;

    private Image background_bouton;
    Button btn;
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
        root.getChildren().remove(btn);
        drawBoutons();
        root.getChildren().add(btn);
    }

    public void drawBoutons()
    {

        background_boutons[0] = new ImageView();
        //drawImage(background_boutons[0], background_bouton, XPositionBoutons, stage.getHeight() - 150);
        background_boutons[0].setImage(background_bouton);
        btn = new Button("i love",background_boutons[0]);
        btn.setLayoutX(XPositionBoutons);
        btn.setLayoutY(stage.getHeight() - 150);
    }

    @Override
    public void setModuleController(ControlGame listener)
    {
       /* background_boutons[0].setId("Button_Banque");
        background_boutons[0].setOnMouseReleased(listener);*/
        btn.setId("Button_Banque");
        btn.setOnMouseClicked(listener);
    }



}
