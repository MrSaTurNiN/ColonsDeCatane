package views.Modules;

import Model.Partie;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    private Image imageSkip;

    private ImageView background_boutonsView;
    private ImageView imageDeView;

    private double XPositionBoutons;
    private double YPositionBoutons;

    Stage stage;

    Text ressource;
    Rectangle barUpR;
    ImageView i;
    Button btn;
    Button skip;

    private Text deValue;

    private ImageView background_boutons[] = new ImageView[1];
    private ImageView icone_de[] = new ImageView[1];
    private ImageView icone_skip[]=new ImageView[1];

    private Group root;

    public boolean De=false;

    public ModuleDe(Partie p, Group root, Stage s)
    {
        this.root = root;
        this.partie = p;
        this.stage = s;
        isChecked = false;

        XPositionBoutons = s.getWidth() - 100;
        YPositionBoutons = s.getHeight() - 100;

        initImage();
       // drawDe();

    }

    public void draw(){

       // root.getChildren().remove(btn);
        root.getChildren().removeAll(!De ? icone_de : icone_skip);
        root.getChildren().removeAll(background_boutons);
        root.getChildren().remove(deValue);


        drawDe();


        //root.getChildren().add(btn);
        root.getChildren().addAll(background_boutons);
        root.getChildren().addAll(!De ? icone_de : icone_skip);
        root.getChildren().add(deValue);

    }

    public void  initImage() {
        background_bouton = new Image(getClass().getResourceAsStream("/assets/img/background_bouton.png"));
        imageDe = new Image(getClass().getResourceAsStream("/assets/img/icone_de.png"));
        imageSkip = new Image(getClass().getResourceAsStream("/assets/img/forward-arrow.png"));



    }

    public void drawDe()
    {
        icone_de[0] = new ImageView();
        icone_skip[0]= new ImageView();
        background_boutons[0] = new ImageView(background_bouton);
        drawButtonCenter(background_boutons[0], De?icone_skip[0] : icone_de[0], background_bouton, De?imageSkip : imageDe, stage.getWidth() - 80, stage.getHeight() - 650, De?"skip_button" : "button_de");
        drawImageCenter(icone_de[0], De?imageSkip : imageDe, stage.getWidth() - 80, stage.getHeight() - 650);

        deValue = new Text();
        drawString(deValue, String.valueOf(partie.getDeValue()), stage.getWidth() - 150, stage.getHeight() - 650, Color.WHITE, banqueFont);
    }


}

