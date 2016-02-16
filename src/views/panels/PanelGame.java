package views.panels;

import Model.Batiments.Colonie;
import Model.Batiments.Ville;
import Model.MainModel;
import Model.Partie;
import Model.Plateau;
import Model.Tuile.*;
import Model.graph.Edge;
import Model.graph.Vertex;
import com.sun.javafx.geom.Point2D;
import controllers.ControlGame;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import views.Modules.ModuleInfoJoueur;
import views.ViewConstants;
import java.awt.*;
import java.awt.Font;
import java.io.IOException;

/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class PanelGame extends Scene implements ViewConstants {

    Group root;
    Group surface;
    Stage stage;
    Canvas canvas;
    Partie partie;
    GraphicsContext gc;

    Font mainFontSize;
    Font fontPointVictoireSize;

    private Image background;

    private Rectangle backgroundN;
    private Line LineEdges[] = new Line[72];
    private Circle PointVertices[] = new Circle[54];

    private Image desert;
    private Image paturage;
    private Image montagne;
    private Image terreCultivable;
    private Image colline;
    private Image foret;
    private Image fond;
    private Image stormtrooper;
    private Image rond_point;
    private Image boba;

    private Image colonie_rouge;
    private Image colonie_jaune;
    private Image colonie_vert;
    private Image colonie_bleu;

    private Image colonie_rouge_hover;
    private Image colonie_jaune_hover;
    private Image colonie_vert_hover;
    private Image colonie_bleu_hover;

    java.util.List<Edge> edges;
    Plateau plat;

    ModuleInfoJoueur infoJoueur;

    public PanelGame(@NamedArg("root") Parent r, Group root, Stage stage, MainModel model) {
        super(r);
        this.root = root;
        this.stage = stage;
        this.partie = model.getPartie();
        this.canvas = new Canvas(stage.getWidth(), stage.getHeight());
        gc = canvas.getGraphicsContext2D();
        plat = partie.getPlateau();
        edges = plat.getGraph().getEdges();
        plat.getGraph().getEdges().size();




        initNodes();
        initImage();
        initFont();
        drawBackground();
        root.getChildren().add(canvas);
        drawMap();

        infoJoueur = new ModuleInfoJoueur(partie, root);



    }

    public void initNodes()
    {
        backgroundN = new Rectangle(0,0,stage.getWidth(), stage.getHeight());

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

    public void initImage()
    {
        try {
            desert = new Image(getClass().getResourceAsStream("/assets/img/desert.png"));
            montagne = new Image(getClass().getResourceAsStream("/assets/img/montagne.png"));
            terreCultivable = new Image(getClass().getResourceAsStream("/assets/img/terreCultivable.png"));
            colline = new Image(getClass().getResourceAsStream("/assets/img/colline.png"));
            foret =new Image(getClass().getResourceAsStream("/assets/img/foret.png"));
            paturage =new Image(getClass().getResourceAsStream("/assets/img/paturage.png"));
            rond_point =new Image(getClass().getResourceAsStream("/assets/img/rond_point.png"));
            stormtrooper = new Image(getClass().getResourceAsStream("/assets/img/stormtrooper.png"));
            boba = new Image(getClass().getResourceAsStream("/assets/img/boba.png"));

            colonie_bleu = new Image(getClass().getResourceAsStream("/assets/img/colonie_bleu.png"));
            colonie_rouge = new Image(getClass().getResourceAsStream("/assets/img/colonie_bleu.png"));
            colonie_jaune = new Image(getClass().getResourceAsStream("/assets/img/colonie_jaune.png"));
            colonie_vert = new Image(getClass().getResourceAsStream("/assets/img/colonie_vert.png"));

            colonie_bleu_hover = new Image(getClass().getResourceAsStream("/assets/img/colonie_bleu_hover.png"));
            colonie_rouge_hover = new Image(getClass().getResourceAsStream("/assets/img/colonie_rouge_hover.png"));
            colonie_jaune_hover = new Image(getClass().getResourceAsStream("/assets/img/colonie_jaune_hover.png"));
            colonie_vert_hover = new Image(getClass().getResourceAsStream("/assets/img/colonie_vert_hover.png"));


            background  = new Image(getClass().getResourceAsStream("/assets/img/background.png"));
        } catch (Exception e){
            System.out.println("Erreur Chargement Image");
            e.printStackTrace();
        }
    }


    public void draw()
    {
        root.getChildren().removeAll(canvas);
        root.getChildren().removeAll(backgroundN);
        root.getChildren().removeAll(LineEdges);
        root.getChildren().removeAll(PointVertices);
        drawBackground();

        drawMap();



        root.getChildren().add(backgroundN);

        root.getChildren().add(canvas);
        root.getChildren().addAll(LineEdges);
        root.getChildren().addAll(PointVertices);

        infoJoueur.draw();


    }

    public void drawBackground()
    {
        backgroundN.setFill(new ImagePattern(background, 0, 0, background.getWidth(), background.getHeight(), false));
    }

    public void setGameController(ControlGame listener)
    {
        this.widthProperty().addListener((ChangeListener<? super Number>) listener);
        this.setOnMouseClicked(listener);
        //this.addMouseListener(listener);
        this.setOnMouseMoved(listener);
        //des.addActionListener(listener);
        //skip.addActionListener(listener);
    }

    public void drawMap()
    {
        gc.setFill(colorToPaint(java.awt.Color.BLACK));
        gc.fillOval(MAP_X, MAP_Y, MAP_WIDTH, MAP_HEIGHT);
        Plateau plat = partie.getPlateau();
        Tuile[] tuiles = plat.getTuiles();

        int index = tuiles.length;
        //On dessine les Tuile
        for (int i =0; i < index; i++)
        {
            //g2.setColor(getColorTuile(tuiles[i]));

            //g2.fillPolygon(transformTuile(tuiles[i]));

            gc.setFill(colorToPaint(java.awt.Color.ORANGE));

            Vertex v = tuiles[i].getSommets().get(0);

            drawImageTuile(tuiles[i]);
            if(!(tuiles[i] instanceof Desert))gc.fillText(tuiles[i].getNumero()+"",v.getX()-10,v.getY()+100);
            if (tuiles[i].getVoleur() != null)
            {
                gc.drawImage(boba,v.getX()-20,v.getY()+50);
            }
        }
        //On dessine les Edges:

        int compteur = 0;
        for(Edge e : edges){
            LineEdges[compteur] = new Line(edges.get(compteur).getVertexA().getX(), edges.get(compteur).getVertexA().getY(), edges.get(compteur).getVertexB().getX(), edges.get(compteur).getVertexB().getY());

            if(e.getRoute() == null)
            {
                LineEdges[compteur].setStroke(Color.GREY);
            }
            else
            {
                LineEdges[compteur].setStroke(colorToPaint(e.getRoute().getJoueur().getCouleurJoueur()));
            }

            if(e.isHover())
            {
                LineEdges[compteur].setStrokeWidth(5);
            }
            else
            {
                LineEdges[compteur].setStrokeWidth(3);
            }
            compteur++;
        }

        //On déssine les points
        Vertex[] vertices = plat.getGraph().getVertices();
        for(int i =0;i<vertices.length;i++){
            Vertex v = vertices[i];


            if(v.getBatiment() == null){
                if(v.isHover()) {
                    PointVertices[i]= new Circle(v.getX(),v.getY(),TAILLEVERTEX+2,colorToPaint(partie.getJoueurActif().getCouleurJoueur()));
                }else {
                    PointVertices[i]= new Circle(v.getX(),v.getY(),TAILLEVERTEX,Color.GREY);
                }

            }
            else {
                gc.setFill(colorToPaint(v.getBatiment().getJoueur().getCouleurJoueur()));
                if(v.getBatiment() instanceof Ville)
                {
                    gc.fillRect(v.getX()-TAILLEVERTEX/2,v.getY()-TAILLEVERTEX/2,TAILLEVERTEX,TAILLEVERTEX);
                }
                else if (v.getBatiment() instanceof Colonie){
                    gc.fillOval(v.getX()-TAILLEVERTEX/2,v.getY()-TAILLEVERTEX/2,TAILLEVERTEX,TAILLEVERTEX);

                    if(v.isHover())
                    {
                        if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.cyan){
                            gc.drawImage(colonie_bleu_hover, v.getX()-25, v.getY()-25);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.red){
                            gc.drawImage(colonie_rouge_hover, v.getX()-25, v.getY()-25);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.yellow){
                            gc.drawImage(colonie_jaune_hover, v.getX()-25, v.getY()-25);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.green){
                            gc.drawImage(colonie_vert_hover, v.getX()-25, v.getY()-25);
                        }
                    }
                    else{
                        if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.cyan){
                            gc.drawImage(colonie_bleu, v.getX()-25, v.getY()-25);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.red){
                            gc.drawImage(colonie_rouge, v.getX()-25, v.getY()-25);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.yellow){
                            gc.drawImage(colonie_jaune, v.getX()-25, v.getY()-25);
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.green){
                            gc.drawImage(colonie_vert, v.getX()-25, v.getY()-25);
                        }
                    }


                }
            }

            if(v.isHover())
            {
                gc.setFill(colorToPaint(partie.getJoueurActif().getCouleurJoueur()));
                gc.fillOval(v.getX() - TAILLEVERTEX / 2 - 5, v.getY() - TAILLEVERTEX / 2 - 5, TAILLEVERTEX + 10, TAILLEVERTEX+10);
            }



        }


    }

    public Color colorToPaint(java.awt.Color c)
    {
        java.awt.Color color = c;
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int a = color.getAlpha();
        double opacity = a / 255.0 ;
        return Color.rgb(r, g, b, opacity);
    }

    public void drawImageTuile(Tuile t)
    {
        Vertex v1 = t.getSommets().get(0);
        Vertex v2 = t.getSommets().get(3);

        int x = v1.getX()+((v2.getX() - v1.getX())/2);
        int y = v1.getY()+((v2.getY() - v1.getY())/2);

        if (t instanceof Desert) gc.drawImage(desert, x - 60, y - 60);
        else if (t instanceof Foret) gc.drawImage(foret, x - 60, y - 60);
        else if (t instanceof Paturage) gc.drawImage(paturage, x - 60, y - 60);
        else if (t instanceof TerreCultivable) gc.drawImage(terreCultivable, x - 60, y - 60);
        else if (t instanceof Montagne) gc.drawImage(montagne, x - 60, y - 60);
        else if (t instanceof Colline) gc.drawImage(colline, x - 60, y - 60);
    }



}