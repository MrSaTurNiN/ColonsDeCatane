package views.panels;


/*
Minerai => Duracier (Géonosis)
Bois => Supraconducteur (Hoth)
Laine => Cristaux (Dagobah)
Blé => Cellule Energetique (Kamino)
Argile => Gas Tibanna (Naboo)

Carte développement = 1 Duracier 1 Cristal 1 Cellule Energetique 1 Gas
Colonie => Vaisseau Coloniale = 1 Cellule Energétique 1 Cristal 1 Supraconducteur
Ville => Station orbitale = 3 Duraciers 2 Cellules Energétiques
Route => Portail Liaison SuperLumière (PLS) = 1 Gas Tibanna 1 Supra Conducteur



import Model.Batiments.Colonie;
import Model.Batiments.Ville;
import Model.graph.Edge;
import Model.graph.Vertex;
import controllers.ClickListener;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import views.DrawingTools;
import views.ViewConstants;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javafx.scene.image.Image;

import javax.swing.*;
import javafx.scene.image.Image;

import Model.Partie;
import Model.Plateau;
import Model.Tuile.*;
import views.modules.ModuleBank;
import views.modules.ModuleInfoJoueur;

public class PanelGame extends Application implements ViewConstants {
	public Color seaColor;
	public Color deckRessourceColor;
	private Partie partie;


    private BufferedImage desert;
    private BufferedImage paturage;
    private BufferedImage montagne;
    private BufferedImage terreCultivable;
    private BufferedImage colline;
    private BufferedImage foret;
    private Image fond;
    private BufferedImage stormtrooper;
    private BufferedImage rond_point;

    private BufferedImage boba;

    private BufferedImage icone_de;

    private BufferedImage colonie_rouge;
    private BufferedImage colonie_jaune;
    private BufferedImage colonie_vert;
    private BufferedImage colonie_bleu;
    
    private JButton des;
	private JButton skip;

    private BufferedImage colonie_rouge_hover;
    private BufferedImage colonie_jaune_hover;
    private BufferedImage colonie_vert_hover;
    private BufferedImage colonie_bleu_hover;

    public static Font mainFont;
    public static Font mainFontSize;

    private Font fontPointVictoireSize;

    private ModuleBank bank;
    private ModuleInfoJoueur infoJoueur;






    public PanelGame(Partie partie) {
        this.partie = partie;
        initImage();
        initButton();
        initFont();
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
            fond = new Image("../assets/img/background.png");
            rond_point = ImageIO.read(PanelGame.class.getResource("/assets/img/rond_point.png"));
            stormtrooper = ImageIO.read(PanelGame.class.getResource("/assets/img/stormtrooper.png"));
            boba = ImageIO.read(PanelGame.class.getResource("/assets/img/boba.png"));

            icone_de = ImageIO.read(PanelGame.class.getResource("/assets/img/icone_de.png"));

            colonie_bleu = ImageIO.read(PanelGame.class.getResource("/assets/img/colonie_bleu.png"));
            colonie_rouge = ImageIO.read(PanelGame.class.getResource("/assets/img/colonie_rouge.png"));
            colonie_jaune = ImageIO.read(PanelGame.class.getResource("/assets/img/colonie_jaune.png"));
            colonie_vert = ImageIO.read(PanelGame.class.getResource("/assets/img/colonie_vert.png"));

            colonie_bleu_hover = ImageIO.read(PanelGame.class.getResource("/assets/img/colonie_bleu_hover.png"));
            colonie_rouge_hover = ImageIO.read(PanelGame.class.getResource("/assets/img/colonie_rouge_hover.png"));
            colonie_jaune_hover = ImageIO.read(PanelGame.class.getResource("/assets/img/colonie_jaune_hover.png"));
            colonie_vert_hover = ImageIO.read(PanelGame.class.getResource("/assets/img/colonie_vert_hover.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void initFont()
	{
		try {
			Font mainFont = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"));
			mainFontSize = mainFont.deriveFont(24f);
            fontPointVictoireSize = mainFont.deriveFont(40f);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


    @Override
    public void start(Stage primaryStage) throws Exception {

        Canvas canvas = new Canvas(WINDOW_WIDTH,WINDOW_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        clear();
        drawBackground();
        drawMap();



        drawPointVictoire();
        drawButton();
    }

    public void clear()
    {
        gc.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public void drawBackground()
    {

         javafx.scene.shape.Rectangle rekt = new Rectangle(0,0, WINDOW_WIDTH, WINDOW_HEIGHT );

        ImagePattern imagePattern = new ImagePattern(fond);
        rekt.setFill(imagePattern);

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
            g2.setFont(mainFontSize);
			g2.setColor(Color.ORANGE);

			Vertex v = tuiles[i].getSommets().get(0);

            drawImageTuile(tuiles[i]);
            if(!(tuiles[i] instanceof Desert))g2.drawString(tuiles[i].getNumero()+"",v.getX()-10,v.getY()+100);
            if (tuiles[i].getVoleur() != null)
            {
                gc.drawImage(boba,v.getX()-20,v.getY()+50);
            }
		}
		//On déssine les Edges:
		List<Edge> edges = plat.getGraph().getEdges();
		for(Edge e : edges){
			if(e.getRoute() == null) {
				g2.setColor(Color.gray);
			}
			else{
				g2.setColor(e.getRoute().getJoueur().getCouleurJoueur());
			}


            if(e.isHover())
            {
                g2.setStroke(new BasicStroke(5));
            }
            else
            {
                g2.setStroke(new BasicStroke(3));
            }
			g2.drawLine(e.getVertexA().getX(), e.getVertexA().getY(), e.getVertexB().getX(), e.getVertexB().getY());

		}
	//On déssine les points
        Vertex[] vertices = plat.getGraph().getVertices();
        for (int i = 0; i < vertices.length; i++) {
            Vertex v = vertices[i];

        }
        for(int i =0;i<vertices.length;i++){
			Vertex v = vertices[i];

            if(v.isHover()) {
                g2.setColor(partie.getJoueurActif().getCouleurJoueur());
                g2.drawOval(v.getX()-TAILLEVERTEX/2-5,v.getY()-TAILLEVERTEX/2-5,TAILLEVERTEX+10,TAILLEVERTEX+10);
            }
			if(v.getBatiment() == null){
                g2.setColor(Color.gray);
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

                    if(v.isHover())
                    {
                        if(v.getBatiment().getJoueur().getCouleurJoueur() == Color.cyan){
                            g2.drawImage(colonie_bleu_hover, v.getX()-25, v.getY()-25,this);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == Color.red){
                            g2.drawImage(colonie_rouge_hover, v.getX()-25, v.getY()-25,this);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == Color.yellow){
                            g2.drawImage(colonie_jaune_hover, v.getX()-25, v.getY()-25,this);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == Color.green){
                            g2.drawImage(colonie_vert_hover, v.getX()-25, v.getY()-25,this);
                        }
                    }
                    else{
                        if(v.getBatiment().getJoueur().getCouleurJoueur() == Color.cyan){
                            g2.drawImage(colonie_bleu, v.getX()-25, v.getY()-25,this);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == Color.red){
                            g2.drawImage(colonie_rouge, v.getX()-25, v.getY()-25,this);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == Color.yellow){
                            g2.drawImage(colonie_jaune, v.getX()-25, v.getY()-25,this);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == Color.green){
                            g2.drawImage(colonie_vert, v.getX()-25, v.getY()-25,this);
                        }
                    }


				}
            }

            if(v.isHover())
            {
                g2.setColor(partie.getJoueurActif().getCouleurJoueur());
                g2.drawOval(v.getX() - TAILLEVERTEX / 2 - 5, v.getY() - TAILLEVERTEX / 2 - 5, TAILLEVERTEX + 10, TAILLEVERTEX+10);
            }



		}

	}

    public void drawPointVictoire()
    {
        int x = WINDOW_WIDTH - 70;
        int y = 250 ;
        g2.setFont(fontPointVictoireSize);

        g2.drawImage(rond_point, x-40, y-42, this);
        DrawingTools.drawStringCenter(Integer.toString(partie.getListeJoueur().get(0).getPointJoueur()), x, y, g2);
        g2.setFont(mainFontSize);
    }

    public void drawButton(){
        int x = WINDOW_WIDTH - 70;
        int y = 325 ;
        if(!partie.isDes()){
            g2.drawImage(rond_point, x-40, y-42, this);
            g2.drawImage(icone_de, x-40,y-40,this);
        }
        else {
            g2.drawImage(rond_point, x-40, y-42, this);
            DrawingTools.drawStringCenter("->", x,y,g2);
        }
    }

    public void switchButton(){
        if (partie.isDes()){
            des.setVisible(false);
            skip.setVisible(true);
        }
        else {
            des.setVisible(true);
            skip.setVisible(false);
        }
    }
    private void initButton() {
        int x = WINDOW_WIDTH - 70;
        int y = 325 ;
        this.setLayout(null);
        des=new JButton();
        des.setBorder(BorderFactory.createEmptyBorder());
        des.setContentAreaFilled(false);
        des.setBounds( x-40, y-42, 80, 80);
        skip=new JButton();
        skip.setContentAreaFilled(false);
        skip.setBorder(BorderFactory.createEmptyBorder());
        skip.setBounds( x-40, y-42, 80, 80);

        this.add(des);
        this.add(skip);
        des.setVisible(true);
        skip.setVisible(false);
    }



	public void drawBulleJoueur()
	{
		g2.drawImage(stormtrooper, WINDOW_WIDTH-240, 10, this);
	}

	/*
		Transforme la Tuile donnée en paramètre en un Polygon qu'on peut dessiner avec l'objet Graphics
	 */

    /*
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
        des.addActionListener(listener);
        skip.addActionListener(listener);
    }
    public JButton getDes() {
        return des;
    }
    public JButton getSkip(){
        return skip;
    }
    public void setButtonController(ActionListener al){
       // des.addActionListener(al);
       // skip.addActionListener(al);
    }


}
*/