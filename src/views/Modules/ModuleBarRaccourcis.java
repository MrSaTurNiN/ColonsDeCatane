package views.Modules;

import Model.Partie;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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
    private Image icone_commerce;

    public Button btn;

    private ImageView background_boutons[] = new ImageView[2];
    private ImageView icones[] = new ImageView[2];

    public ModuleBarRaccourcis(Partie p, Group r, Stage s)
    {
        initImage();
        this.partie = p;
        this.root = r;
        this.stage = s;

       // draw();
    }

    public void  initImage() {
        background_bouton = new Image(getClass().getResourceAsStream("/assets/img/background_bouton.png"));
        icone_banque = new Image(getClass().getResourceAsStream("/assets/img/icone_banque.png"));
        icone_commerce = new Image(getClass().getResourceAsStream("/assets/img/icone_commerce.png"));

    }

    public void draw()
    {

        root.getChildren().remove(background_boutons[0]);
        root.getChildren().remove(icones[0]);
        drawBoutons();
        root.getChildren().addAll(background_boutons);
        root.getChildren().addAll(icones);
    }

    public void drawBoutons()
    {
        background_boutons[0] = new ImageView();
        background_boutons[1] = new ImageView();
        icones[0] = new ImageView();
        icones[1] = new ImageView();
        drawButtonCenter(background_boutons[0], icones[0], background_bouton, icone_banque, stage.getWidth()- 80, stage.getHeight() - 100, "button_bank");
        drawButtonCenter(background_boutons[1], icones[1], background_bouton, icone_commerce, stage.getWidth()- 150, stage.getHeight() - 100, "button_trade");


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
