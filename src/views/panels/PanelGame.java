package views.panels;
import views.ViewConstants;
import java.awt.*;

import javax.swing.*;

import Model.Partie;
import Model.Ressource;

public class PanelGame extends JPanel implements ViewConstants{
	public Color seaColor;
	public Color deckRessourceColor;
	private Partie partie;
	private Graphics2D g2;

	public PanelGame(Partie partie) {
		this.partie = partie;
		seaColor = new Color(0, 0, 255);

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

		g2.setColor(new Color(0, 0, 255));
		g2.fillRect(MAP_X, MAP_Y, MAP_WIDTH, MAP_HEIGHT);
	}
	
	public void drawBank(){
		drawDeveloppement();
		drawDeckRessource();
		g2.drawRect(XBANK, YBANK, BANK_WIDTH, BANK_HEIGHT);
		g2.drawString("Banque", XBANK+50, YBANK+50);
	}

	public void drawDeckRessource() {
		drawArgile();
		drawBle();
		drawBois();
		drawlaine();
		drawMinerai();

	}

	public void drawBois() {
		int size = partie.getDeckRessource().getCarteRessource().get("Bois").size();

		g2.drawString("Bois : " + size, XBANK+20, YBANK+100);
	}

	public void drawArgile() {
		int size = partie.getDeckRessource().getCarteRessource().get("Argile").size();

		g2.drawString("Argile : " + size, XBANK+20, YBANK+125);
	}

	public void drawlaine() {
		int size = partie.getDeckRessource().getCarteRessource().get("Laine").size();

		g2.drawString("Laine : " + size, XBANK+20, YBANK+150);
	}

	public void drawMinerai() {
		int size = partie.getDeckRessource().getCarteRessource().get("Minerai").size();

		g2.drawString("Minerai : " + size, XBANK+20, YBANK+175);
	}

	public void drawBle() {
		int size = partie.getDeckRessource().getCarteRessource().get("Ble").size();

		g2.drawString("Ble : " + size, XBANK+20, YBANK+200);
	}

	public void drawDeveloppement(){
		int size = partie.getDeckDeveloppement().getCartDeveloppement().size();
		g2.drawString("Carte de développpement : "+ size, XBANK+20, YBANK+225);
	}
	
	
	public void drawInfoJoueur() {
		g2.setColor(partie.getListeJoueur().get(0).getCouleurJoueur());
		g2.drawString(partie.getListeJoueur().get(0).getNomJoueur(), JOUEUR_INFO_X, JOUEUR_INFO_Y);
	}

}
