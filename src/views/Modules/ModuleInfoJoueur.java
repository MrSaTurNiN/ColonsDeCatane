package views.Modules;

import Model.Developpement;
import Model.Partie;
import Model.ressource.Ressource;
import javafx.scene.Group;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.DrawingTools;
import views.ViewConstants;
import views.panels.PanelGame;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

/**
 * Created by Mahel Sif on 25/01/2016.
 */
public class ModuleInfoJoueur extends DrawingTools implements ViewConstants {

    public boolean isChecked;
    public Partie partie;

    private Image icone_cellule_energetique;
    private Image icone_gaz;
    private Image icone_minerai;
    private Image icone_cristaux;
    private Image icone_supraconducteur;

    private Image barUp;
    private Image barUpRight;

    private ImageView[] img_ressource = new ImageView[4];
    private Text[] text_ressource = new Text[4];

    Text ressource;
    Rectangle barUpR;
    ImageView i;

    private Group root;

    public ModuleInfoJoueur(Partie p, Group root)
    {
        this.root = root;
        this.partie = p;
        isChecked = false;

        initImage();
        drawBarUp();
        drawInfoJoueur();
    }

    public void draw(){

        root.getChildren().remove(ressource);
        root.getChildren().remove(barUpR);
        root.getChildren().remove(i);

        drawBarUp();
        drawInfoJoueur();


        root.getChildren().addAll(text_ressource);
        root.getChildren().addAll(img_ressource);
        root.getChildren().add(barUpR);
        root.getChildren().add(i);
        root.getChildren().add(ressource);

    }

    public void  initImage()
    {
            barUp = new Image(getClass().getResourceAsStream("/assets/img/bar_up.png"));
            barUpRight = new Image(getClass().getResourceAsStream("/assets/img/bar_up_right.png"));

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

    public void drawInfoJoueur() {
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
                text_ressource[0].setText(" -> " + valeur.size());
                text_ressource[0].setX(x + 5);
                text_ressource[0].setY(28);
            } else if (cle == "Laine") {
                //gc.drawImage(icone_cristaux, x-25, 0, imageObserver);
                //gc.drawString(" -> " + valeur.size(), x + 5, 28);
            } else if (cle == "Ble") {
                // gc.drawImage(icone_cellule_energetique, x - 25, 0,imageObserver);
                //gc.drawString(" -> " + valeur.size(), x + 5, 28);
            }//cellule energetique
            else if (cle == "Argile") {
                //gc.drawImage(icone_gaz, x-25, 0, imageObserver);
                //gc.drawString(" -> " + valeur.size(), x + 5, 28);
            } else if (cle == "Minerai") {
                //gc.drawImage(icone_minerai, x-25, 0, imageObserver);
                //gc.drawString(" -> " + valeur.size(), x + 5, 28);}

                x += 100;
            }


        }


  /*  public void drawInfoJoueur() {
        gc.setFont(mainFontSize);
        int x = 300;
        int y = JOUEUR_INFO_Y + 50;
        gc.setColor(Color.WHITE);
        //gc.fillRect(JOUEUR_INFO_X, JOUEUR_INFO_Y, JOUEUR_INFO_WIDTH, JOUEUR_INFO_HEIGHT);

        gc.setColor(partie.getJoueurActif().getCouleurJoueur());
        gc.drawString(partie.getJoueurActif().getNomJoueur(), 825, 25);
        y+=40;


        y+=20;
        gc.setColor(Color.WHITE);
        gc.drawString("Vos ressources : ", 20, 25);
        for (Map.Entry<String, java.util.List<Ressource>> entry : partie.getJoueurActif().getMainRessource().entrySet()) {
            String cle = entry.getKey();
            Ressource r = Ressource.valueOf(cle);
            java.util.List<Ressource> valeur = entry.getValue();
            if(cle == "Bois") {
                gc.drawImage(icone_supraconducteur, x-25, 0, imageObserver);
                gc.drawString(" -> " + valeur.size(), x + 5, 28);}
            else if(cle == "Laine") {
                gc.drawImage(icone_cristaux, x-25, 0, imageObserver);
                gc.drawString(" -> " + valeur.size(), x + 5, 28);}
            else if(cle == "Ble") {
                gc.drawImage(icone_cellule_energetique, x - 25, 0,imageObserver);
                gc.drawString(" -> " + valeur.size(), x + 5, 28);
            }//cellule energetique
            else if(cle == "Argile") {
                gc.drawImage(icone_gaz, x-25, 0, imageObserver);
                gc.drawString(" -> " + valeur.size(), x + 5, 28);}
            else if(cle == "Minerai") {
                gc.drawImage(icone_minerai, x-25, 0, imageObserver);
                gc.drawString(" -> " + valeur.size(), x + 5, 28);}

            x += 100;
        }

        for (Developpement d : partie.getJoueurActif().getMainDeveloppement()) {
            gc.drawString(d.name(), x+50, y+50);
        }


    }*/

    }
}