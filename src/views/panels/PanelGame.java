package views.panels;

import views.ViewConstants;
import java.awt.*;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.*;

import Model.Developpement;
import Model.Partie;
import Model.Ressource;

public class PanelGame extends JPanel implements ViewConstants {
	public Color seaColor;
	public Color deckRessourceColor;
	private Partie partie;
	private Graphics2D g2;

	public PanelGame(Partie partie) {
		this.partie = partie;
		

	}

	@Override
	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawMap();
		drawDeckRessource();
		drawInfoJoueur();
		drawBank();

	}

	public void drawMap() {

		g2.setColor(SEA);
		g2.fillRect(MAP_X, MAP_Y, MAP_WIDTH, MAP_HEIGHT);
		g2.setColor(BLACK);
		g2.drawRect(MAP_X, MAP_Y, MAP_WIDTH, MAP_HEIGHT);

	}

	public void drawBank() {
		g2.setColor(BLACK);
		drawDeveloppement();
		drawDeckRessource();

		g2.drawRect(XBANK, YBANK, BANK_WIDTH, BANK_HEIGHT);
		g2.drawString("Banque", XBANK + 50, YBANK + 50);
	}

	public void drawDeckRessource() {
		int x = XBANK + 20;
		int y = YBANK + 100;
		for (Entry<String, List<Ressource>> entry : partie.getDeckRessource().getCarteRessource().entrySet()) {
			String cle = entry.getKey();
			List<Ressource> valeur = entry.getValue();
			g2.drawString(cle + " : " + valeur.size(), x, y);
			y += 20;
		}

	}

	public void drawDeveloppement() {
		int size = partie.getDeckDeveloppement().getCartDeveloppement().size();
		g2.drawString("Carte de développpement : " + size, XBANK + 20, YBANK + 225);
	}

	public void drawInfoJoueur() {
		int x = JOUEUR_INFO_X + 50;
		int y = JOUEUR_INFO_Y + 50;
		
		
		
		g2.setColor(partie.getJoueurActif().getCouleurJoueur());
		g2.drawString(partie.getJoueurActif().getNomJoueur(), x, y);
		y+=40;
		g2.drawString("Point de Victoire :"+ partie.getListeJoueur().get(0).getPointJoueur(), x, y);
		
		y+=20;
		g2.setColor(BLACK);
		for (Entry<String, List<Ressource>> entry : partie.getListeJoueur().get(0).getMainRessource().entrySet()) {
			String cle = entry.getKey();
			List<Ressource> valeur = entry.getValue();
			g2.drawString(cle + valeur.size(), x, y);
			y += 20;
		}
		
		for (Developpement d : partie.getListeJoueur().get(0).getMainDeveloppement()) {
			g2.drawString(d.name(), x+50, y+50);
		}
		g2.drawRect(JOUEUR_INFO_X, JOUEUR_INFO_Y, JOUEUR_INFO_WIDTH, JOUEUR_INFO_HEIGHT);
	}

}
