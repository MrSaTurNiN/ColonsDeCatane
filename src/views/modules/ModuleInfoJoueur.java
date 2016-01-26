/*package views.modules;

import Model.Developpement;
import Model.Partie;
import Model.ressource.Ressource;
import views.DrawingTools;
import views.ViewConstants;
import views.panels.PanelGameFx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.*;


public class ModuleInfoJoueur extends DrawingTools implements ViewConstants {

    public boolean isChecked;
    public Partie partie;
    public Graphics2D g2;
    public ImageObserver imageObserver;

    private BufferedImage icone_cellule_energetique;
    private BufferedImage icone_gaz;
    private BufferedImage icone_minerai;
    private BufferedImage icone_cristaux;
    private BufferedImage icone_supraconducteur;

    private BufferedImage barUp;
    private BufferedImage barUpRight;

    public ModuleInfoJoueur(Partie p, Graphics2D g2, ImageObserver i)
    {
        this.partie = p;
        this.g2 = g2;
        this.imageObserver = i;
        isChecked = false;

        initImage();
        drawBarUp();
    }

    public void  initImage()
    {
        try {
            barUp = ImageIO.read(PanelGame.class.getResource("/assets/img/bar_up.png"));
            barUpRight = ImageIO.read(PanelGame.class.getResource("/assets/img/bar_up_right.png"));

            icone_cellule_energetique = ImageIO.read(PanelGame.class.getResource("/assets/img/icone_cellule_energetique.png"));
            icone_gaz = ImageIO.read(PanelGame.class.getResource("/assets/img/icone_gaz.png"));
            icone_minerai = ImageIO.read(PanelGame.class.getResource("/assets/img/minerai.png"));
            icone_supraconducteur = ImageIO.read(PanelGame.class.getResource("/assets/img/icone_supraconducteur.png"));
            icone_cristaux = ImageIO.read(PanelGame.class.getResource("/assets/img/icone_cristaux.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawBarUp()
    {

        Rectangle r = new Rectangle(0, 0, 80, 50);
        g2.setPaint(new TexturePaint(barUp, r));
        Rectangle rect = new Rectangle(0,0,1000 ,50);
        g2.fill(rect);

        g2.drawImage(barUpRight, 1000, 0, imageObserver);

    }


    public void drawInfoJoueur() {
        g2.setFont(mainFontSize);
        int x = 300;
        int y = JOUEUR_INFO_Y + 50;
        g2.setColor(Color.WHITE);
        //g2.fillRect(JOUEUR_INFO_X, JOUEUR_INFO_Y, JOUEUR_INFO_WIDTH, JOUEUR_INFO_HEIGHT);

        g2.setColor(partie.getJoueurActif().getCouleurJoueur());
        g2.drawString(partie.getJoueurActif().getNomJoueur(), 825, 25);
        y+=40;


        y+=20;
        g2.setColor(Color.WHITE);
        g2.drawString("Vos ressources : ", 20, 25);
        for (Map.Entry<String, java.util.List<Ressource>> entry : partie.getJoueurActif().getMainRessource().entrySet()) {
            String cle = entry.getKey();
            Ressource r = Ressource.valueOf(cle);
            java.util.List<Ressource> valeur = entry.getValue();
            if(cle == "Bois") {
                g2.drawImage(icone_supraconducteur, x-25, 0, imageObserver);
                g2.drawString(" -> " + valeur.size(), x + 5, 28);}
            else if(cle == "Laine") {
                g2.drawImage(icone_cristaux, x-25, 0, imageObserver);
                g2.drawString(" -> " + valeur.size(), x + 5, 28);}
            else if(cle == "Ble") {
                g2.drawImage(icone_cellule_energetique, x - 25, 0,imageObserver);
                g2.drawString(" -> " + valeur.size(), x + 5, 28);
            }//cellule energetique
            else if(cle == "Argile") {
                g2.drawImage(icone_gaz, x-25, 0, imageObserver);
                g2.drawString(" -> " + valeur.size(), x + 5, 28);}
            else if(cle == "Minerai") {
                g2.drawImage(icone_minerai, x-25, 0, imageObserver);
                g2.drawString(" -> " + valeur.size(), x + 5, 28);}

            x += 100;
        }

        for (Developpement d : partie.getJoueurActif().getMainDeveloppement()) {
            g2.drawString(d.name(), x+50, y+50);
        }


    }
}
*/