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
    private ImageView[] img_ressource = new ImageView[8];


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

        icone_cellule_energetique = new Image(getClass().getResourceAsStream("/assets/img/icone_cellule_energetique.png"));
        icone_gaz = new Image(getClass().getResourceAsStream("/assets/img/icone_gaz.png"));
        icone_minerai = new Image(getClass().getResourceAsStream("/assets/img/minerai.png"));
        icone_supraconducteur = new Image(getClass().getResourceAsStream("/assets/img/icone_supraconducteur.png"));
        icone_cristaux = new Image(getClass().getResourceAsStream("/assets/img/icone_cristaux.png"));
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
            root.getChildren().removeAll(img_ressource);
            drawInfos();
            drawConstructions();
            root.getChildren().add(banque_fond_view);
            root.getChildren().addAll(constructions_ressources);
            root.getChildren().addAll(img_ressource);
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

        //récupération des icones
        img_ressource[0] = new ImageView();
        img_ressource[0].setImage(icone_cellule_energetique);
        img_ressource[0].setX(XCenterModule-30);
        img_ressource[0].setY(y-23);

        img_ressource[1] = new ImageView();
        img_ressource[1].setImage(icone_cristaux);
        img_ressource[1].setX(XCenterModule + 23);
        img_ressource[1].setY(y-23);

        img_ressource[2] = new ImageView();
        img_ressource[2].setImage(icone_supraconducteur);
        img_ressource[2].setX(XCenterModule + 73);
        img_ressource[2].setY(y -23);

        img_ressource[3] = new ImageView();
        img_ressource[3].setImage(icone_gaz);
        img_ressource[3].setX(XCenterModule + 123);
        img_ressource[3].setY(y -23);

        img_ressource[4] = new ImageView();
        img_ressource[4].setImage(icone_gaz);
        img_ressource[4].setX(XCenterModule+20);
        img_ressource[4].setY(y+27);

        img_ressource[5] = new ImageView();
        img_ressource[5].setImage(icone_supraconducteur);
        img_ressource[5].setX(XCenterModule+75);
        img_ressource[5].setY(y+27);

        img_ressource[6] = new ImageView();
        img_ressource[6].setImage(icone_minerai);
        img_ressource[6].setX(XCenterModule+17);
        img_ressource[6].setY(y+80);

        img_ressource[7] = new ImageView();
        img_ressource[7].setImage(icone_cellule_energetique);
        img_ressource[7].setX(XCenterModule+73);
        img_ressource[7].setY(y+80);

        constructions_ressources[0] = new Text();
        drawString(constructions_ressources[0], "Colonie : 1     1     1     1" , XCenterModule-20, y, javafx.scene.paint.Color.WHITE, mainFont);

        constructions_ressources[1] = new Text();
        drawString(constructions_ressources[1], "Route : 1     1  " , XCenterModule, y += 50, javafx.scene.paint.Color.WHITE, mainFont);

        constructions_ressources[2] = new Text();
        drawString(constructions_ressources[2], "Ville : 3     2 " , XCenterModule, y += 50, javafx.scene.paint.Color.WHITE, mainFont);

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
