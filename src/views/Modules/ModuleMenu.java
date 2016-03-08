package views.Modules;

import Model.Partie;
import Model.ressource.Ressource;
import controllers.ControlHover;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Map;

/**
 * Created by Victor on 08/03/2016.
 */
public class ModuleMenu extends Module {
    public Partie partie;
    private Stage stage;

    private Group root;
    private Button[] buttonGroup;
    private Text titre;

    public ModuleMenu(Partie p, Group root, Stage s)
    {
        this.root = root;
        this.partie = p;
        this.stage = s;
        buttonGroup=new Button[3];
        titre=new Text("Colons De Catane");
        initButton();
        // drawBarUp();
        //drawInfoRessource();
    }

    public void draw(){
        root.getChildren().removeAll(buttonGroup);


        root.getChildren().addAll(buttonGroup);

    }

    public void initButton()
    {
        buttonGroup[0]=new Button("Nouvelle Partie");
        buttonGroup[0].setId("newPart");

        buttonGroup[1]=new Button("Options");
        buttonGroup[1].setId("Options");

        buttonGroup[2]=new Button("Règles");
        buttonGroup[2].setId("Regles");
        for (Button b:buttonGroup) {
            b.setFont(mainFont);
        }
    }

    public void drawMenu(){
       // buttonGroup[0].setLayoutX();
        //drawString(deValue, String.valueOf(partie.getDeValue()), stage.getWidth() - 150, stage.getHeight() - 650, Color.WHITE, banqueFont);
    }


}
