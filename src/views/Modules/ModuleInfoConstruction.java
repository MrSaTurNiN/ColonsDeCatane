package views.Modules;

import Model.Partie;
import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.ViewConstants;

/**
 * Created by Drago on 24/03/2016.
 */
public class ModuleInfoConstruction extends Module implements ViewConstants {

    public boolean isSelected;
    private Partie partie;
    private Image banque_fond;
    private Group root;
    private Stage stage;

    private Image icone_cellule_energetique;
    private Image icone_gaz;
    private Image icone_minerai;
    private Image icone_cristaux;
    private Image icone_supraconducteur;


    private ImageView banque_fond_view;
    private Text constructions_title;

    private double XCenterModule;
    private double YCenterModule;
    private double XModule;
    private double YModule;

    private Text [] constructions_ressources = new Text[3];


    public ModuleInfoConstruction(Partie p, Group r, Stage stage){
        initImage();
        this.root = r;
        this.partie = p;
        this.stage = stage;
        this.isSelected = false;
        XModule = stage.getWidth() - banque_fond.getWidth() - 60;
        YModule = stage.getHeight() - banque_fond.getHeight() - 60;
        XCenterModule = XModule + (banque_fond.getWidth()/2);
        YCenterModule = YModule + (banque_fond.getHeight()/2);
    }

    public void  initImage() {
        banque_fond = new Image(getClass().getResourceAsStream("/assets/img/banque_fond.png"));
    }

    public void draw(){
        XModule = stage.getWidth() - banque_fond.getWidth() - 40;
        YModule = stage.getHeight() - banque_fond.getHeight() - 100;
        XCenterModule = XModule + (banque_fond.getWidth()/2);
        YCenterModule = YModule + (banque_fond.getHeight()/2);
        if(isSelected) {
            root.getChildren().remove(banque_fond_view);
            root.getChildren().remove(constructions_title);
            root.getChildren().removeAll(constructions_ressources);
            drawInfos();
            drawConstructions();
            root.getChildren().add(banque_fond_view);
            root.getChildren().addAll(constructions_ressources);
            root.getChildren().add(constructions_title);

        }
    }

    public void drawConstructions() {
        banque_fond_view = new ImageView();
        banque_fond_view.setImage(banque_fond);
        banque_fond_view.setX(XModule);
        banque_fond_view.setY(YModule);
        constructions_title = new Text();
        drawString(constructions_title, "CONSTRUCTIONS", XCenterModule, YCenterModule - 180, javafx.scene.paint.Color.WHITE, mainFont);

    }

    public void drawInfos() {
        double y = YCenterModule - 110;
        int i = 0;

        constructions_ressources[0] = new Text();
        drawString(constructions_ressources[0], "Colonies : 1 Cellule 1 Cristal 1 Supraconducteur 1 Gas" , XCenterModule, y, javafx.scene.paint.Color.WHITE, mainFont);

        constructions_ressources[1] = new Text();
        drawString(constructions_ressources[1], "Route : 1 Gas Tibanna 1 Supra Conducteur" , XCenterModule, y += 30, javafx.scene.paint.Color.WHITE, mainFont);

        constructions_ressources[2] = new Text();
        drawString(constructions_ressources[2], "Colonies : 3 Duraciers 2 Cellules" , XCenterModule, y += 30, javafx.scene.paint.Color.WHITE, mainFont);


    }

    public void changeSelected(){
        if(isSelected == true)
        {
            isSelected = false;
        }
        else{
            isSelected = true;
        }
    }

}
