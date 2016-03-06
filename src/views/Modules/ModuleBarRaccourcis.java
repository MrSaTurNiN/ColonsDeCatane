package views.Modules;

import Model.Partie;
import controllers.ControlGame;
import controllers.ControlGameButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import views.Module;
import views.ViewConstants;

/**
 * Created by Mahel on 20/02/2016.
 */
public class ModuleBarRaccourcis extends Module implements ViewConstants {

    public boolean isSelected;
    private Partie partie;
    private Group root;
    private Stage stage;

    private Image background_bouton;
    private Image icone_banque;

    public Button btn;

    private ImageView background_boutons[] = new ImageView[1];
    private ImageView icones[] = new ImageView[1];

    public ModuleBarRaccourcis(Partie p, Group r, Stage s)
    {
        initImage();
        this.partie = p;
        this.root = r;
        this.stage = s;

        draw();
    }

    public void  initImage() {
        background_bouton = new Image(getClass().getResourceAsStream("/assets/img/background_bouton.png"));
        icone_banque = new Image(getClass().getResourceAsStream("/assets/img/icone_banque.png"));

    }

    public void draw()
    {

        root.getChildren().remove(background_boutons[0]);
        root.getChildren().remove(icones[0]);
        drawBoutons();
        root.getChildren().add(background_boutons[0]);
        root.getChildren().add(icones[0]);
    }

    public void drawBoutons()
    {
        background_boutons[0] = new ImageView();
        icones[0] = new ImageView();
        drawButtonCenter(background_boutons[0], icones[0], background_bouton, icone_banque, stage.getWidth()- 80, stage.getHeight() - 100, "button_bank");


        //btn.setStyle("-fx-background-color: transparent;");
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
