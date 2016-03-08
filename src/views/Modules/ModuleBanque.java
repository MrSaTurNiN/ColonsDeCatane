package views.Modules;

import Model.Partie;
import Model.ressource.Ressource;
import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import views.ViewConstants;

import java.util.*;

/**
 * Created by Mahel Sif on 25/01/2016.
 */
public class ModuleBanque extends Module implements ViewConstants  {

    public boolean isSelected;
    private Partie partie;
    private Image banque_fond;
    private Group root;
    
    private ImageView banque_fond_view;
    private Text banque_title;

    private double XCenterModule;
    private double YCenterModule;
    private double XModule;
    private double YModule;

    private Text [] banque_ressources = new Text[5];

    private Text [] banque_pions = new Text[4];

    public ModuleBanque(Partie p, Group r){
        initImage();
        this.root = r;
        this.partie = p;
        this.isSelected = true;
        XModule = WINDOW_WIDTH - banque_fond.getWidth() - 60;
        YModule = WINDOW_HEIGHT - banque_fond.getHeight() - 60;
        XCenterModule = XModule + (banque_fond.getWidth()/2);
        YCenterModule = YModule + (banque_fond.getHeight()/2);
      //  draw();
    }
    
    public void draw(){
        if(isSelected)
        {
            root.getChildren().remove(banque_fond_view);
            root.getChildren().remove(banque_title);
            root.getChildren().removeAll(banque_ressources);
            root.getChildren().removeAll(banque_pions);
            drawDeckRessource();
            drawBank();
            root.getChildren().add(banque_fond_view);
            root.getChildren().addAll(banque_ressources);
            root.getChildren().addAll(banque_pions);
            root.getChildren().add(banque_title);
        }
    }

    public void  initImage() {
            banque_fond = new Image(getClass().getResourceAsStream("/assets/img/banque_fond.png"));
    }

    public void drawBank() {
        banque_fond_view = new ImageView();
        banque_fond_view.setImage(banque_fond);
        banque_fond_view.setX(XModule);
        banque_fond_view.setY(YModule);
        //drawDeckRessource(g2);
        banque_title = new Text();
        drawString(banque_title, "BANQUE", XCenterModule, YCenterModule -180, javafx.scene.paint.Color.WHITE, mainFont);

    }

    public void drawDeckRessource() {
        double y = YCenterModule - 110;
        int i = 0;
        for (Map.Entry<String, java.util.List<Ressource>> entry : partie.getDeckRessource().getCarteRessource().entrySet()) {
            String cle = entry.getKey();
            java.util.List<Ressource> valeur = entry.getValue();
            banque_ressources[i] = new Text();
            drawString(banque_ressources[i], Ressource.valueOf(cle).getNom() + " : " + valeur.size(), XCenterModule, y, javafx.scene.paint.Color.WHITE, mainFont);
            y += 30;
            i++;
        }

        y = YCenterModule + 110;
        banque_pions[0] = new Text();
        drawString(banque_pions[0], "Colonies disponibles  : " + partie.getJoueurActif().getColonieDispo(), XCenterModule, y, Color.WHITE, mainFont);
        banque_pions[1] = new Text();
        drawString(banque_pions[1], "Villes disponibles : " + partie.getJoueurActif().getVilleDispo(), XCenterModule, y+=30, Color.WHITE, mainFont);
        banque_pions[2] = new Text();
        drawString(banque_pions[2], "Routes disponibles : " + partie.getJoueurActif().getRouteDispo(), XCenterModule, y+=30, Color.WHITE, mainFont);
        banque_pions[3] = new Text();
        drawString(banque_pions[3], "Développement : " + partie.getDeckDeveloppement().getCartDeveloppement().size(), XCenterModule, y+=30, Color.WHITE, mainFont);

       /* int dispo = YModule - banque_fond.getHeight()/ 2 + 125;
        drawStringCenter("Colonies disponibles  : " + partie.getJoueurActif().getColonieDispo(), XModule,dispo,g2);
        drawStringCenter("Villes disponibles : " + partie.getJoueurActif().getVilleDispo(), XModule, dispo + 25,g2);
        drawStringCenter("Routes disponibles : " + partie.getJoueurActif().getRouteDispo(), XModule, dispo+50,g2);
        int size = partie.getDeckDeveloppement().getCartDeveloppement().size();
        drawStringCenter("Développement : " + size, XModule , dispo + 75,g2);*/

    }

    public void changeSelected(){
        if(isSelected == true)
        {
            isSelected = false;
        }
        else{
            isSelected = true;
        }
    }

}