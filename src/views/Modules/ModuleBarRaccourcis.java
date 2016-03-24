package views.Modules;

import Model.Partie;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
    private Image icone_info_contruction;

    public Button btn;

    private ImageView background_boutons[] = new ImageView[3];
    private ImageView icones[] = new ImageView[3];
    private Text text_icone_info;

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
        icone_info_contruction = new Image(getClass().getResourceAsStream("/assets/img/background_bouton.png"));
    }

    public void draw()
    {

        root.getChildren().remove(background_boutons[0]);
        root.getChildren().remove(icones[0]);
        root.getChildren().remove(text_icone_info);
        drawBoutons();
        root.getChildren().addAll(background_boutons);
        root.getChildren().addAll(icones);
        root.getChildren().add(text_icone_info);
    }

    public void drawBoutons()
    {
        background_boutons[0] = new ImageView();
        background_boutons[1] = new ImageView();
        background_boutons[2] = new ImageView();
        icones[0] = new ImageView();
        icones[1] = new ImageView();
        icones[2] = new ImageView();
        drawButtonCenter(background_boutons[0], icones[0], background_bouton, icone_banque, stage.getWidth()- 80, stage.getHeight() - 100, "button_bank");
        drawButtonCenter(background_boutons[1], icones[1], background_bouton, icone_commerce, stage.getWidth()- 160, stage.getHeight() - 100, "button_trade");

        text_icone_info = new Text();
        drawString(text_icone_info, "C", stage.getWidth() - 240, stage.getHeight() - 100, Color.WHITE,banqueFont);
        drawButtonCenter(background_boutons[2], icones[2], background_bouton, icone_info_contruction, stage.getWidth()- 240, stage.getHeight() - 100, "button_infos_buildings");


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
