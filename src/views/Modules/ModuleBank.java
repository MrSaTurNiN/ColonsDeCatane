package views.Modules;

import Model.Partie;
import Model.ressource.Ressource;
import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import views.DrawingTools;
import views.ViewConstants;
import views.panels.PanelGame;

import java.awt.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.*;

/**
 * Created by Mahel Sif on 25/01/2016.
 */
public class ModuleBank extends DrawingTools implements ViewConstants  {

    public boolean isSelected;
    private Font BanqueFontSize;
    private Graphics2D g2;
    private Partie partie;
    private Image banque_fond;
    private Group root;
    
    private ImageView banque_fond_view;
    private Text banque_title;

    private double xcenter_banque;
    private double ycenter_banque;
    private double XBANK;
    private double YBANK;

    private Text [] banque_info = new Text[5];

    public ModuleBank(Partie p, Group root){
        initImage();
        this.root = root;
        this.partie = p;

        XBANK = WINDOW_WIDTH - banque_fond.getWidth() - 40;
        YBANK = WINDOW_HEIGHT - banque_fond.getHeight() - 40;
        xcenter_banque = XBANK + (banque_fond.getWidth()/2)-20;
        ycenter_banque = YBANK + (banque_fond.getHeight()/2)-20;
        draw();
    }
    
    public void draw(){
        root.getChildren().remove(banque_fond_view);
        root.getChildren().remove(banque_title);
        root.getChildren().removeAll(banque_info);
        drawDeckRessource();
        drawBank();
        root.getChildren().add(banque_fond_view);
        root.getChildren().addAll(banque_info);
        root.getChildren().add(banque_title);
    }

    public void  initImage() {
            banque_fond = new Image(getClass().getResourceAsStream("/assets/img/banque_fond.png"));
    }

    public void drawBank() {
        banque_fond_view = new ImageView();
        banque_fond_view.setImage(banque_fond);
        banque_fond_view.setX(XBANK);
        banque_fond_view.setY(YBANK);
        //drawDeckRessource(g2);
        banque_title = new Text();
        drawString(banque_title, "BANQUE", xcenter_banque, ycenter_banque-160, javafx.scene.paint.Color.WHITE, mainFont);

    }

    public void drawDeckRessource() {
        double x = xcenter_banque;
        double y = ycenter_banque;
        int i = 0;
        for (Map.Entry<String, java.util.List<Ressource>> entry : partie.getDeckRessource().getCarteRessource().entrySet()) {
            String cle = entry.getKey();
            java.util.List<Ressource> valeur = entry.getValue();
            banque_info[i] = new Text();
            drawString(banque_info[i], Ressource.valueOf(cle).getNom() + " : " + valeur.size(), x, y, javafx.scene.paint.Color.WHITE, mainFont);
            y += 30;
            i++;
        }

       /* int dispo = YBANK - banque_fond.getHeight()/ 2 + 125;
        drawStringCenter("Colonies disponibles  : " + partie.getJoueurActif().getColonieDispo(), XBANK,dispo,g2);
        drawStringCenter("Villes disponibles : " + partie.getJoueurActif().getVilleDispo(), XBANK, dispo + 25,g2);
        drawStringCenter("Routes disponibles : " + partie.getJoueurActif().getRouteDispo(), XBANK, dispo+50,g2);
        int size = partie.getDeckDeveloppement().getCartDeveloppement().size();
        drawStringCenter("Développement : " + size, XBANK , dispo + 75,g2);*/

    }

}