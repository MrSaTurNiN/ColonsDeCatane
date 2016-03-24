package views.Modules;

import Model.Batiments.Colonie;
import Model.Partie;
import Model.Plateau;
import Model.Tuile.*;
import Model.graph.Edge;
import Model.graph.Vertex;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.ViewConstants;

/**
 * Created by Mahel Sif on 01/03/2016.
 */


/**
 * Created by Mahel Sif on 25/01/2016.
 */
public class ModuleMap extends Module implements ViewConstants {

    public boolean isChecked;
    public Partie partie;
    Stage stage;

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

    private Line LineEdges[] = new Line[72];
    private Circle PointVertices[] = new Circle[54];
    private ImageView Colonies[] = new ImageView[54];

    private ImageView bobaV;

    private ImageView TuilesV[] = new ImageView[19];
    private Text NumeroTuiles[] = new Text[19];
    private Circle BackgroundTuiles[] = new Circle[19];

    private Circle backgroundMap;

    Text ressource;
    Rectangle barUpR;
    ImageView i;
    Button btn;

    java.util.List<Edge> edges;
    Plateau plat;


    private ImageView background_boutons[] = new ImageView[1];
    private ImageView icone_de[] = new ImageView[1];

    private Group root;

    public ModuleMap(Partie p, Group root, Stage s) {
        this.root = root;
        this.partie = p;
        this.stage = s;
        isChecked = false;

        plat = partie.getPlateau();
        edges = plat.getGraph().getEdges();


        initImage();


    }

    public void draw() {
        root.getChildren().remove(backgroundMap);
        root.getChildren().removeAll(TuilesV);
        root.getChildren().removeAll(NumeroTuiles);
        root.getChildren().removeAll(BackgroundTuiles);
        root.getChildren().removeAll(PointVertices);
        root.getChildren().removeAll(LineEdges);
        root.getChildren().removeAll(Colonies);
        root.getChildren().remove(bobaV);
        drawMap();
        root.getChildren().add(backgroundMap);
        root.getChildren().addAll(TuilesV);
        root.getChildren().addAll(BackgroundTuiles);
        root.getChildren().addAll(NumeroTuiles);
        root.getChildren().addAll(LineEdges);
        root.getChildren().addAll(PointVertices);
        root.getChildren().addAll(Colonies);
        root.getChildren().add(bobaV);
    }

    public void initImage() {
        desert = new Image(getClass().getResourceAsStream("/assets/img/desert.png"));
        montagne = new Image(getClass().getResourceAsStream("/assets/img/montagne.png"));
        terreCultivable = new Image(getClass().getResourceAsStream("/assets/img/terreCultivable.png"));
        colline = new Image(getClass().getResourceAsStream("/assets/img/colline.png"));
        foret = new Image(getClass().getResourceAsStream("/assets/img/foret.png"));
        paturage = new Image(getClass().getResourceAsStream("/assets/img/paturage.png"));
        rond_point = new Image(getClass().getResourceAsStream("/assets/img/background_bouton.png"));
        stormtrooper = new Image(getClass().getResourceAsStream("/assets/img/stormtrooper.png"));
        boba = new Image(getClass().getResourceAsStream("/assets/img/boba.png"));

        colonie_bleu = new Image(getClass().getResourceAsStream("/assets/img/colonie_bleu.png"));
        colonie_rouge = new Image(getClass().getResourceAsStream("/assets/img/colonie_rouge.png"));
        colonie_jaune = new Image(getClass().getResourceAsStream("/assets/img/colonie_jaune.png"));
        colonie_vert = new Image(getClass().getResourceAsStream("/assets/img/colonie_vert.png"));

        colonie_bleu_hover = new Image(getClass().getResourceAsStream("/assets/img/colonie_bleu_hover.png"));
        colonie_rouge_hover = new Image(getClass().getResourceAsStream("/assets/img/colonie_rouge_hover.png"));
        colonie_jaune_hover = new Image(getClass().getResourceAsStream("/assets/img/colonie_jaune_hover.png"));
        colonie_vert_hover = new Image(getClass().getResourceAsStream("/assets/img/colonie_vert_hover.png"));


    }

    public void drawMap() {
        backgroundMap = new Circle(MAP_CENTERX, MAP_CENTERY, MAP_WIDTH / 2, Color.BLACK);

        Plateau plat = partie.getPlateau();
        Tuile[] tuiles = plat.getTuiles();

        int index = tuiles.length;
        //On dessine les Tuile
        for (int i = 0; i < index; i++) {

            Vertex v = tuiles[i].getSommets().get(0);
            TuilesV[i] = new ImageView();
            drawImageTuile(tuiles[i], TuilesV[i]);
            if (!(tuiles[i] instanceof Desert && tuiles[i].getNumero() != 0))
                NumeroTuiles[i] = new Text();
                BackgroundTuiles[i] = new Circle(v.getX() - 10, v.getY() + 100, 20, Color.BLACK);
                BackgroundTuiles[i].setOpacity(0.5);
                drawString(NumeroTuiles[i], tuiles[i].getNumero() + "", v.getX() - 10, v.getY() + 100, Color.ORANGE, mainFont);



            if (tuiles[i].getVoleur() != null)
            {
                bobaV = new ImageView();
                drawImageCenter(bobaV, boba, v.getX()-20, v.getY()+50);
            }
        }

        for (int j = 0; j < NumeroTuiles.length; j++) {
            NumeroTuiles[j].setEffect(new Glow(0.8));
        }
        //On dessine les Edges:

        int compteur = 0;
        for (Edge e : edges) {
            LineEdges[compteur] = new Line(edges.get(compteur).getVertexA().getX(), edges.get(compteur).getVertexA().getY(), edges.get(compteur).getVertexB().getX(), edges.get(compteur).getVertexB().getY());

            if (e.getRoute() == null) {
                LineEdges[compteur].setStroke(Color.WHITE);

                if (e.isHover()) {
                    LineEdges[compteur].setStrokeWidth(3);
                    LineEdges[compteur].setEffect(new Glow(0.8));

                } else {
                    LineEdges[compteur].setStrokeWidth(1);
                    LineEdges[compteur].setEffect(new Glow(0.5));
                }
            } else {
                LineEdges[compteur].setStroke(colorToPaint(e.getRoute().getJoueur().getCouleurJoueur()));
                LineEdges[compteur].setStrokeWidth(5);

                if (e.isHover()) {
                    LineEdges[compteur].setEffect(new Glow(0.8));
                }

            }


            compteur++;
        }


        //On déssine les points
        Vertex[] vertices = plat.getGraph().getVertices();
        for (int i = 0; i < vertices.length; i++) {
            Vertex v = vertices[i];
            Colonies[i] = new ImageView();

            if (v.getBatiment() == null) {
                if (v.isHover()) {
                    PointVertices[i] = new Circle(v.getX(), v.getY(), TAILLEVERTEX + 2, colorToPaint(partie.getJoueurActif().getCouleurJoueur()));
                } else {
                    PointVertices[i] = new Circle(v.getX(), v.getY(), TAILLEVERTEX, Color.WHITE);
                    PointVertices[i].setEffect(new Glow(0.3));
                }

            } else {
                //gc.setFill(colorToPaint(v.getBatiment().getJoueur().getCouleurJoueur()));
                /*if(v.getBatiment() instanceof Ville)
                {
                    gc.fillRect(v.getX()-TAILLEVERTEX/2,v.getY()-TAILLEVERTEX/2,TAILLEVERTEX,TAILLEVERTEX);
                }*/
                if (v.getBatiment() instanceof Colonie) {
                    //gc.fillOval(v.getX()-TAILLEVERTEX/2,v.getY()-TAILLEVERTEX/2,TAILLEVERTEX,TAILLEVERTEX);
                    PointVertices[i] = new Circle(v.getX(), v.getY(), TAILLEVERTEX, colorToPaint(v.getBatiment().getJoueur().getCouleurJoueur()));

                }
                    if(v.isHover())
                    {
                        if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.cyan){
                            drawImageCenter(Colonies[i], colonie_bleu_hover, v.getX(), v.getY());
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.red){
                            drawImageCenter(Colonies[i], colonie_rouge_hover, v.getX(), v.getY());
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.yellow){
                            drawImageCenter(Colonies[i], colonie_jaune_hover, v.getX(), v.getY());
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.green){
                            drawImageCenter(Colonies[i], colonie_vert_hover, v.getX(), v.getY());
                        }
                    }
                    else{
                        if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.cyan){
                            drawImageCenter(Colonies[i], colonie_bleu, v.getX(), v.getY());
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.red){
                            drawImageCenter(Colonies[i], colonie_rouge, v.getX(), v.getY());
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.yellow){
                            drawImageCenter(Colonies[i], colonie_jaune, v.getX(), v.getY());
                        }
                        else if(v.getBatiment().getJoueur().getCouleurJoueur() == java.awt.Color.green){
                            drawImageCenter(Colonies[i], colonie_vert, v.getX(), v.getY());
                        }
                    }


            }
        }
    }





    public void drawImageTuile(Tuile t, ImageView Iv)
    {
        Vertex v1 = t.getSommets().get(0);
        Vertex v2 = t.getSommets().get(3);

        double x = v1.getX()+((v2.getX() - v1.getX())/2);
        double y = v1.getY()+((v2.getY() - v1.getY())/2);

        if (t instanceof Desert) drawImageCenter(Iv, desert, x, y);
        else if (t instanceof Foret) drawImageCenter(Iv,foret, x , y);
        else if (t instanceof Paturage) drawImageCenter(Iv,paturage, x, y);
        else if (t instanceof TerreCultivable) drawImageCenter(Iv,terreCultivable, x, y);
        else if (t instanceof Montagne) drawImageCenter(Iv, montagne, x, y);
        else if (t instanceof Colline) drawImageCenter(Iv,colline, x, y);
    }



}

