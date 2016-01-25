package views.modules;

import Model.Partie;
import Model.ressource.Ressource;
import views.ViewConstants;
import views.DrawingFunction;
import views.panels.PanelGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.*;

/**
 * Created by Mahel Sif on 25/01/2016.
 */
public class ModuleBank implements ViewConstants {

    public boolean isSelected = false;
    private Font BanqueFontSize;
    private Graphics2D g2;
    private ImageObserver imageObserver;
    private Partie partie;
    private BufferedImage banque_fond;


    public ModuleBank(Partie partie, Graphics2D g2, ImageObserver i){
        initFont();
        initImage();
        this.g2 = g2;
        this.imageObserver = i;
        this.partie = partie;

    }

    public void  initImage() {
        try {

            banque_fond = ImageIO.read(PanelGame.class.getResource("/assets/img/banque_fond.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initFont(){
        try {
            Font mainFont = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"));
            BanqueFontSize = mainFont.deriveFont(40f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawBank() {
        g2.setColor(Color.WHITE);
        g2.setColor(BLACK);
        g2.drawImage(banque_fond, XBANK - 200, YBANK - 300, imageObserver);
        drawDeckRessource(g2);
        g2.setFont(BanqueFontSize);
        DrawingFunction.drawStringCenter("BANQUE", XBANK , YBANK - banque_fond.getHeight()/ 2 + 60,g2);
    }

    public void drawDeckRessource(Graphics2D g2) {
        int x = XBANK;
        int y = YBANK - banque_fond.getHeight()/ 2 + 250;
        g2.setFont(PanelGame.mainFontSize);
        g2.setColor(Color.white);
        for (Map.Entry<String, java.util.List<Ressource>> entry : partie.getDeckRessource().getCarteRessource().entrySet()) {
            String cle = entry.getKey();
            java.util.List<Ressource> valeur = entry.getValue();
            DrawingFunction.drawStringCenter(Ressource.valueOf(cle).getNom() + " : " + valeur.size(), x, y,g2);
            y += 25;
        }

        int dispo = YBANK - banque_fond.getHeight()/ 2 + 125;
        DrawingFunction.drawStringCenter("Colonies disponibles  : " + partie.getJoueurActif().getColonieDispo(), XBANK,dispo,g2);
        DrawingFunction.drawStringCenter("Villes disponibles : " + partie.getJoueurActif().getVilleDispo(), XBANK, dispo + 25,g2);
        DrawingFunction.drawStringCenter("Routes disponibles : " + partie.getJoueurActif().getRouteDispo(), XBANK, dispo+50,g2);
        int size = partie.getDeckDeveloppement().getCartDeveloppement().size();
        DrawingFunction.drawStringCenter("Développement : " + size, XBANK , dispo + 75,g2);

    }

}
