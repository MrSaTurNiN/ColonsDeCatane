package views.Modules;

import Model.Partie;
import Model.ressource.Ressource;
import javafx.scene.Group;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import views.ViewConstants;

import java.util.*;

/**
 * Created by Drago on 09/03/2016.
 */
public class ModuleCommerce extends Module implements ViewConstants {

    public boolean isSelected;
    private Partie partie;
    private Image banque_fond;
    private Group root;

    private ImageView banque_fond_view;
    private Text commerce_title;

    private double XCenterModule;
    private double YCenterModule;
    private double XModule;
    private double YModule;

    public ModuleCommerce(Partie p, Group r){
        initImage();
        this.root = r;
        this.partie = p;
        this.isSelected = true;
        XModule = WINDOW_WIDTH - banque_fond.getWidth() - 60;
        YModule = WINDOW_HEIGHT - banque_fond.getHeight() - 60;
        XCenterModule = XModule + (banque_fond.getWidth()/2);
        YCenterModule = YModule + (banque_fond.getHeight()/2);
        //  draw();
    }

    public void  initImage() {
        banque_fond = new Image(getClass().getResourceAsStream("/assets/img/banque_fond.png"));
    }

    public void draw(){
        root.getChildren().remove(banque_fond_view);
        root.getChildren().remove(commerce_title);
        drawCommerce();
        root.getChildren().add(banque_fond_view);
        root.getChildren().add(commerce_title);
    }

    public void drawCommerce() {
        banque_fond_view = new ImageView();
        banque_fond_view.setImage(banque_fond);
        banque_fond_view.setX(XModule);
        banque_fond_view.setY(YModule);
        //drawDeckRessource(g2);
        commerce_title = new Text();
        drawString(commerce_title, "Commerce", XCenterModule, YCenterModule - 180, javafx.scene.paint.Color.WHITE, mainFont);

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
