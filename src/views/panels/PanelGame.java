package views.panels;



import Model.Batiments.Colonie;
import Model.Batiments.Ville;
import Model.graph.Edge;
import Model.graph.Vertex;
import controllers.ClickListener;
import views.ViewConstants;
import java.awt.*;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
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

    private BufferedImage desert;
    private BufferedImage paturage;
    private BufferedImage montagne;
    private BufferedImage terreCultivable;
    private BufferedImage colline;
    private BufferedImage foret;
    private BufferedImage fond;
    private BufferedImage barUp;




    public PanelGame(Partie partie) {

        initImage();

        this.partie = partie;
    }

    public void  initImage()
    {
        try {
            desert = ImageIO.read(PanelGame.class.getResource("/assets/img/desert.png"));
            montagne = ImageIO.read(PanelGame.class.getResource("/assets/img/montagne.png"));
            terreCultivable = ImageIO.read(PanelGame.class.getResource("/assets/img/terreCultivable.png"));
            colline = ImageIO.read(PanelGame.class.getResource("/assets/img/colline.png"));
            foret = ImageIO.read(PanelGame.class.getResource("/assets/img/foret.png"));
            paturage = ImageIO.read(PanelGame.class.getResource("/assets/img/paturage.png"));
            fond = ImageIO.read(PanelGame.class.getResource("/assets/img/fond.png"));
            barUp = ImageIO.read(PanelGame.class.getResource("/assets/img/barUp.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setLayout(null);
        clear();
        drawBackground();
		drawMap();
        drawBarUp();
		drawDeckRessource();
		drawInfoJoueur();
		drawBank();

	}

    public void clear()
    {
        g2.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
    }

    public void drawBackground()
    {

        Rectangle r = new Rectangle(0, 0, 402, 402);
        g2.setPaint(new TexturePaint(fond, r));
        Rectangle rect = new Rectangle(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        g2.fill(rect);
    }

	public void drawMap() {

		g2.setColor(SEA);
        g2.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
		g2.setColor(Color.BLACK);
		g2.fillOval(MAP_X, MAP_Y, MAP_WIDTH, MAP_HEIGHT);
        g2.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 1));
		Plateau plat = partie.getPlateau();
		Tuile[] tuiles = plat.getTuiles();

		int index = tuiles.length;
		//On dessine les Tuile
		for (int i =0; i < index; i++)
		{
			//g2.setColor(getColorTuile(tuiles[i]));

			//g2.fillPolygon(transformTuile(tuiles[i]));
			g2.setColor(Color.BLACK);

			Vertex v = tuiles[i].getSommets().get(0);
			if(!(tuiles[i] instanceof Desert))g2.drawString(tuiles[i].getNumero()+"",v.getX()-10,v.getY()+40);
			if (tuiles[i].getVoleur() != null)
			{
				g2.setColor(Color.RED);
				g2.drawString("Voleur",v.getX()-5,v.getY()+60);
			}
            drawImageTuile(tuiles[i]);
		}
		//On déssine les Edges:
		List<Edge> edges = plat.getGraph().getEdges();
		for(Edge e : edges){
			if(e.getRoute() == null) {
				g2.setColor(Color.YELLOW);
			}
			else{
				g2.setColor(e.getRoute().getJoueur().getCouleurJoueur());
			}
            g2.setStroke(new BasicStroke(3));
			g2.drawLine(e.getVertexA().getX(), e.getVertexA().getY(), e.getVertexB().getX(), e.getVertexB().getY());

		}
	//On déssine les points
        Vertex[] vertices = plat.getGraph().getVertices();
        for (int i = 0; i < vertices.length; i++) {
            Vertex v = vertices[i];

        }
        for(int i =0;i<vertices.length;i++){
			Vertex v = vertices[i];
			if(v.getBatiment() == null){
                g2.setColor(Color.YELLOW);
                g2.fillOval(v.getX()-TAILLEVERTEX/2,v.getY()-TAILLEVERTEX/2,TAILLEVERTEX,TAILLEVERTEX);
            }
			else {
				g2.setColor(v.getBatiment().getJoueur().getCouleurJoueur());
                if(v.getBatiment() instanceof Ville)
				{
					g2.fillRect(v.getX()-TAILLEVERTEX/2,v.getY()-TAILLEVERTEX/2,TAILLEVERTEX,TAILLEVERTEX);
				}
				else if (v.getBatiment() instanceof Colonie){
					g2.fillOval(v.getX()-TAILLEVERTEX/2,v.getY()-TAILLEVERTEX/2,TAILLEVERTEX,TAILLEVERTEX);
				}
            }

            if(v.isHover())
            {
                g2.setColor(partie.getJoueurActif().getCouleurJoueur());
                g2.drawOval(v.getX()-TAILLEVERTEX/2-5,v.getY()-TAILLEVERTEX/2-5,TAILLEVERTEX+10,TAILLEVERTEX+10);
            }


		}

	}

	public void drawBank() {
        g2.setColor(Color.WHITE);
        g2.fillRect(XBANK, YBANK, BANK_WIDTH, BANK_HEIGHT);
		g2.setColor(BLACK);
		drawDeveloppement();
		drawDeckRessource();
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
        g2.setColor(Color.WHITE);
        g2.fillRect(JOUEUR_INFO_X, JOUEUR_INFO_Y, JOUEUR_INFO_WIDTH, JOUEUR_INFO_HEIGHT);

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

    public void drawImageTuile(Tuile t)
    {
        Vertex v1 = t.getSommets().get(0);
        Vertex v2 = t.getSommets().get(3);

        int x = v1.getX()+((v2.getX() - v1.getX())/2);
        int y = v1.getY()+((v2.getY() - v1.getY())/2);

        if (t instanceof Desert) g2.drawImage(desert, x - 60, y - 60, this);
        else if (t instanceof Foret) g2.drawImage(foret, x - 60, y - 60, this);
        else if (t instanceof Paturage) g2.drawImage(paturage, x - 60, y - 60, this);
        else if (t instanceof TerreCultivable) g2.drawImage(terreCultivable, x - 60, y - 60, this);
        else if (t instanceof Montagne) g2.drawImage(montagne, x - 60, y - 60, this);
        else if (t instanceof Colline) g2.drawImage(colline, x - 60, y - 60, this);
    }

    public void drawBarUp()
    {

        Rectangle r = new Rectangle(0, 0, 64, 64);
        g2.setPaint(new TexturePaint(barUp, r));
        Rectangle rect = new Rectangle(0,0,WINDOW_WIDTH,64);
        g2.fill(rect);

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

    public void setControler(ClickListener listener)
    {
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);
    }
}
