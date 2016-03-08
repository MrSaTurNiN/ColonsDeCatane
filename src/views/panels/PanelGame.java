package views.panels;

import Model.MainModel;
import Model.Partie;
import Model.Plateau;
import Model.Tuile.*;
import Model.graph.Edge;
import Model.graph.Vertex;
import controllers.ControlGame;
import controllers.ControlGameButton;
import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import views.Modules.*;
import views.ViewConstants;

/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class PanelGame extends Scene implements ViewConstants {

    Group root;
    Stage stage;
    Canvas canvas;
    Partie partie;
    GraphicsContext gc;

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
    ModuleBanque banque;
    ModuleMap map;
    ModuleBarRaccourcis barRaccourcis;



    ModuleDe de;
    Button btn;

    public PanelGame(@NamedArg("root") Parent r, Group root, Stage s, MainModel model) {

        super(r);
        this.root = root;
        this.stage = s;
        this.partie = model.getPartie();
        this.canvas = new Canvas(stage.getWidth(), stage.getHeight());
        gc = canvas.getGraphicsContext2D();
        plat = partie.getPlateau();
        edges = plat.getGraph().getEdges();
        plat.getGraph().getEdges().size();

        initNodes();
        initImage();
        drawBackground();
        root.getChildren().add(canvas);




        infoJoueur = new ModuleInfoJoueur(partie, root, stage);
        banque = new ModuleBanque(partie, root);
        barRaccourcis = new ModuleBarRaccourcis(partie, root, stage);
        de = new ModuleDe(partie, root, stage);
        map = new ModuleMap(partie,root,stage);

        draw();


    }

    public ModuleDe getDe() {
        return de;
    }

    public ModuleBarRaccourcis getBarRaccourcis() {

        return barRaccourcis;
    }

    public ModuleBanque getBanque()
    {
        return banque;
    }

    public ModuleInfoJoueur getInfoJoueur() {
        return infoJoueur;
    }

    public void initNodes()
    {
        backgroundN = new Rectangle(0,0,stage.getWidth(), stage.getHeight());
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
            rond_point =new Image(getClass().getResourceAsStream("/img/background_bouton.png"));
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


            background  = new Image(getClass().getResourceAsStream("/assets/img/background.png"));
        } catch (Exception e){
            System.out.println("Erreur Chargement Image");
            e.printStackTrace();
        }
    }


    public void draw()
    {
       // root.getChildren().removeAll(canvas);
        root.getChildren().removeAll(backgroundN);
        initNodes();
        drawBackground();

        root.getChildren().add(backgroundN);

       // root.getChildren().add(canvas);


        infoJoueur.draw();
        banque.draw();
        barRaccourcis.draw();
        de.draw();
        map.draw();

    }

    public void drawBackground()
    {
        backgroundN.setFill(new ImagePattern(background, 0, 0, background.getWidth(), background.getHeight(), false));
    }

    public void setGameController(ControlGame listener)
    {
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,listener);
        this.addEventHandler(MouseEvent.MOUSE_MOVED,listener);

    }

    public void setGameButtonController(ControlGameButton listener){
        this.addEventFilter(ActionEvent.ACTION,listener);
    }

    public void drawImageTuile(Tuile t)
    {
        Vertex v1 = t.getSommets().get(0);
        Vertex v2 = t.getSommets().get(3);

        double x = v1.getX()+((v2.getX() - v1.getX())/2);
        double y = v1.getY()+((v2.getY() - v1.getY())/2);

        if (t instanceof Desert) gc.drawImage(desert, x - 60, y - 60);
        else if (t instanceof Foret) gc.drawImage(foret, x - 60, y - 60);
        else if (t instanceof Paturage) gc.drawImage(paturage, x - 60, y - 60);
        else if (t instanceof TerreCultivable) gc.drawImage(terreCultivable, x - 60, y - 60);
        else if (t instanceof Montagne) gc.drawImage(montagne, x - 60, y - 60);
        else if (t instanceof Colline) gc.drawImage(colline, x - 60, y - 60);
    }



}