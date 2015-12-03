package views.panels;



import Model.graph.Edge;
import Model.graph.Vertex;
import views.ViewConstants;
import java.awt.*;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.*;

import Model.Developpement;
import Model.Partie;
import Model.Ressource;
import Model.Plateau;
import Model.Tuile.*;

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

		Plateau plat = partie.getPlateau();
		Tuile[] tuiles = plat.getTuiles();

		int index = tuiles.length;
		//On déssine les Tuile
		for (int i =0; i < index; i++)
		{
			g2.setColor(getColorTuile(tuiles[i]));
			g2.fillPolygon(transformTuile(tuiles[i]));
			g2.setColor(Color.BLACK);
			Vertex v = tuiles[i].getSommets().get(0);
			if(!(tuiles[i] instanceof Desert))g2.drawString(tuiles[i].getNumero()+"",v.getX()-10,v.getY()+40);
			if (tuiles[i].getVoleur() != null)
			{
				g2.setColor(Color.RED);
				g2.drawString("Voleur",v.getX()-5,v.getY()+60);
			}
		}
		//On déssine les Edges:
		List<Edge> edges = plat.getGraph().getEdges();
		for(Edge e : edges){
			if(e.getRoute() == null) {
				g2.setColor(Color.BLACK);
			}
			else{
				g2.setColor(e.getRoute().getJoueur().getCouleurJoueur());
			}
			g2.drawLine(e.getVertexA().getX(), e.getVertexA().getY(), e.getVertexB().getX(), e.getVertexB().getY());
		}
		//On déssine les points
		Vertex[] vertices = plat.getGraph().getVertices();
		for(int i =0;i<vertices.length;i++){
			Vertex v = vertices[i];
			if(v.getBatiment() == null)g2.setColor(Color.BLACK);
			else g2.setColor(v.getBatiment().getJoueur().getCouleurJoueur());
			g2.fillOval(v.getX()-5,v.getY()-5,10,10);
		}

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

	/*
		Transforme la Tuile donnée en paramètre en un Polygon qu'on peut dessiner avec l'objet Graphics
	 */
	public Polygon transformTuile(Tuile t)
	{
		List<Vertex> sommets = t.getSommets();
		int[] x = new int[sommets.size()];
		int[] y = new int[sommets.size()];
		int i = 0;
		for(Vertex v:sommets) {
			x[i] = v.getX();
			y[i] = v.getY();
			i++;
		}
		return new Polygon(x,y,x.length);
	}

	private Color getColorTuile(Tuile t){

		if (t instanceof Colline) return Color.green;
		if (t instanceof Desert) return Color.YELLOW;
		if (t instanceof Foret) return Color.darkGray;
		if (t instanceof Montagne) return Color.gray;
		if (t instanceof Paturage) return Color.ORANGE;
		if (t instanceof TerreCultivable) return Color.WHITE;

		return Color.black;

	}
}
