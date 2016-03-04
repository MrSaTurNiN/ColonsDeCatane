package views.Modules;

import Model.Partie;
import controllers.ControlGame;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.Module;
import views.ViewConstants;

/**
 * Created by Mahel Sif on 01/03/2016.
 */


/**
 * Created by Mahel Sif on 25/01/2016.
 */
public class ModuleDe extends Module implements ViewConstants {

    public boolean isChecked;
    public Partie partie;

    private Image icone_cellule_energetique;
    private Image icone_gaz;
    private Image icone_minerai;
    private Image icone_cristaux;
    private Image icone_supraconducteur;

    private Image barUp;
    private Image barUpRight;

    private Image background_bouton;
    private Image imageDe;

    private ImageView background_boutonsView;
    private ImageView imageDeView;

    private double XPositionBoutons;
    private double YPositionBoutons;

    Stage stage;

    Text ressource;
    Rectangle barUpR;
    ImageView i;

    private Group root;

    public ModuleDe(Partie p, Group root, Stage s)
    {
        this.root = root;
        this.partie = p;
        this.stage = s;
        isChecked = false;

        XPositionBoutons = s.getWidth() - 100;
        YPositionBoutons = s.getHeight() - 100;

        initImage();
        drawDe();

    }

    public void draw(){

        root.getChildren().remove(background_boutonsView);
        root.getChildren().remove(imageDeView);

        drawDe();


        root.getChildren().add(background_boutonsView);
        root.getChildren().add(imageDeView);




    }

    public void  initImage() {
        background_bouton = new Image(getClass().getResourceAsStream("/assets/img/background_bouton.png"));
        imageDe = new Image(getClass().getResourceAsStream("/assets/img/icone_de.png"));


    }

    public void drawDe()
    {
        background_boutonsView = new ImageView();
        drawImage(background_boutonsView, background_bouton, XPositionBoutons, stage.getHeight() - 400);

        imageDeView = new ImageView();
        drawImage(imageDeView, imageDe, XPositionBoutons, stage.getHeight() - 400);

    }

    public void setModuleController(ControlGame listener)
    {
        background_boutonsView.setId("Button_De");
        background_boutonsView.setOnMouseReleased(listener);
    }
}

