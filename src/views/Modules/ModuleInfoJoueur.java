package views.Modules;

import Model.Partie;
import Model.ressource.Ressource;
import controllers.ControlGame;
import controllers.ControlHover;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.ViewConstants;

import java.util.*;

/**
 * Created by Mahel Sif on 25/01/2016.
 */
public class ModuleInfoJoueur extends Module implements ViewConstants {

    public boolean isChecked;
    public Partie partie;
    private Stage stage;

    private Image icone_cellule_energetique;
    private Image icone_gaz;
    private Image icone_minerai;
    private Image icone_cristaux;
    private Image icone_supraconducteur;

    private Image barUp;
    private Image barUpRight;
    private Image background_bouton;

    private ImageView backgroundPoint;
    private ImageView[] img_ressource = new ImageView[5];
    private Text[] text_ressource = new Text[5];

    Text text_point;
    Text ressource;
    Rectangle barUpR;
    ImageView i;

    private Group root;

    public ModuleInfoJoueur(Partie p, Group root, Stage s)
    {
        this.root = root;
        this.partie = p;
        this.stage = s;
        isChecked = false;

        initImage();
        initRessource();
       // drawBarUp();
        //drawInfoRessource();
    }

    public void draw(){

        root.getChildren().remove(ressource);
        root.getChildren().remove(barUpR);
        root.getChildren().remove(i);
        root.getChildren().remove(backgroundPoint);
        root.getChildren().remove(text_point);
        root.getChildren().removeAll(img_ressource);

        drawBarUp();
        drawInfoRessource();
        drawPoint();


        root.getChildren().add(barUpR);
        root.getChildren().add(i);
        root.getChildren().add(ressource);
        root.getChildren().add(backgroundPoint);
        root.getChildren().add(text_point);
        root.getChildren().addAll(text_ressource);
        root.getChildren().addAll(img_ressource);

    }

    public void initImage()
    {
            barUp = new Image(getClass().getResourceAsStream("/assets/img/bar_up.png"));
            barUpRight = new Image(getClass().getResourceAsStream("/assets/img/bar_up_right.png"));
            background_bouton = new Image(getClass().getResourceAsStream("/assets/img/background_bouton.png"));

            icone_cellule_energetique = new Image(getClass().getResourceAsStream("/assets/img/icone_cellule_energetique.png"));
            icone_gaz = new Image(getClass().getResourceAsStream("/assets/img/icone_gaz.png"));
            icone_minerai = new Image(getClass().getResourceAsStream("/assets/img/minerai.png"));
            icone_supraconducteur = new Image(getClass().getResourceAsStream("/assets/img/icone_supraconducteur.png"));
            icone_cristaux = new Image(getClass().getResourceAsStream("/assets/img/icone_cristaux.png"));
    }

    public void drawBarUp()
    {
        barUpR = new Rectangle(0, 0, 1000, 50);
        barUpR.setFill(new ImagePattern(barUp, 0, 0, barUp.getWidth(), barUp.getHeight(), false));
        i = new ImageView();
        i.setImage(barUpRight);
        i.setX(1000);
        i.setY(0);
    }

    public void drawPoint(){
        double x = stage.getWidth() - 80;
        double y = stage.getHeight() - 800;
        backgroundPoint = new ImageView();
        text_point = new Text();
        drawImageCenter(backgroundPoint, background_bouton, x, y);
        drawString(text_point, String.valueOf(partie.getJoueurActif().getPointJoueur()), x, y, colorToPaint(partie.getJoueurActif().getCouleurJoueur()), banqueFont);
    }
    public void initRessource(){
        img_ressource[0] = new ImageView();
        img_ressource[0].setId("supraconducteur");
        img_ressource[1] = new ImageView();
        img_ressource[1].setId("cristaux");
        img_ressource[2] = new ImageView();
        img_ressource[2].setId("cellule_energetique");
        img_ressource[3] = new ImageView();
        img_ressource[3].setId("gaz");
        img_ressource[4] = new ImageView();
        img_ressource[4].setId("minerai");
    }
    public void drawInfoRessource() {
        root.getChildren().remove(ressource);
        ressource = new Text();
        ressource.setText("Vos ressources :");
        ressource.setEffect(shadowText);
        ressource.setX(20f);
        ressource.setY(25f);
        ressource.setFill(Color.WHITE);
        ressource.setFont(mainFont);

        int x = 300;

        for (Map.Entry<String, java.util.List<Ressource>> entry : this.partie.getJoueurActif().getMainRessource().entrySet()) {
            String cle = entry.getKey();
            Ressource r = Ressource.valueOf(cle);
            java.util.List<Ressource> valeur = entry.getValue();
            if (cle == "Bois") {

                img_ressource[0].setImage(icone_supraconducteur);
                img_ressource[0].setX(x - 25);
                img_ressource[0].setY(0);
                text_ressource[0] = new Text();
                text_ressource[0].setText(" -> " + valeur.size());
                text_ressource[0].setX(x + 5);
                text_ressource[0].setY(28);
            } else if (cle == "Laine") {

                img_ressource[1].setImage(icone_cristaux);
                img_ressource[1].setX(x - 25);
                img_ressource[1].setY(0);
                text_ressource[1] = new Text();
                text_ressource[1].setText(" -> " + valeur.size());
                text_ressource[1].setX(x + 5);
                text_ressource[1].setY(28);
            } else if (cle == "Ble") {

                img_ressource[2].setImage(icone_cellule_energetique);
                img_ressource[2].setX(x - 25);
                img_ressource[2].setY(0);
                text_ressource[2] = new Text();
                text_ressource[2].setText(" -> " + valeur.size());
                text_ressource[2].setX(x + 5);
                text_ressource[2].setY(28);
            }
            else if (cle == "Argile") {
                img_ressource[3].setImage(icone_gaz);
                img_ressource[3].setX(x - 25);
                img_ressource[3].setY(0);
                text_ressource[3] = new Text();
                text_ressource[3].setText(" -> " + valeur.size());
                text_ressource[3].setX(x + 5);
                text_ressource[3].setY(28);
            } else if (cle == "Minerai") {
                img_ressource[4].setImage(icone_minerai);
                img_ressource[4].setX(x - 25);
                img_ressource[4].setY(0);
                text_ressource[4] = new Text();
                text_ressource[4].setText(" -> " + valeur.size());
                text_ressource[4].setX(x + 5);
                text_ressource[4].setY(28);
            }

            x += 100;


        }

        for (int j = 0; j < text_ressource.length; j++) {
            text_ressource[j].setFill(Color.WHITE);
            text_ressource[j].setFont(mainFont);
            text_ressource[j].setEffect(shadowText);
        }



    }

    public void setControlHover(ControlHover listener){
        img_ressource[0].addEventFilter(MouseEvent.MOUSE_ENTERED,listener);
        img_ressource[1].addEventFilter(MouseEvent.MOUSE_ENTERED,listener);
        img_ressource[2].addEventFilter(MouseEvent.MOUSE_ENTERED,listener);
        img_ressource[3].addEventFilter(MouseEvent.MOUSE_ENTERED,listener);
        img_ressource[4].addEventFilter(MouseEvent.MOUSE_ENTERED,listener);
    }
}