package views.panels;

import controllers.ControlMenu;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import views.ViewConstants;

/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class PanelMenu extends Scene implements ViewConstants {
    Button newPart;
    Group root;
    Stage stage;

    public PanelMenu(@NamedArg("root") Parent r, Group root, Stage stage) {
        super(r);
        this.setFill(Color.RED);
        this.root = root;
        this.stage = stage;
        draw();
        newPart = new Button("Nouvelle partie");
        newPart.setId("newPartie");
        root.getChildren().add(newPart);

    }

    public void draw()
    {
        drawBackground();
    }

    public void drawBackground()
    {
        Image background  = new Image(getClass().getResourceAsStream("background.png"));
        Rectangle r = new Rectangle(0,0,stage.getWidth(), stage.getHeight());
        r.setFill(new ImagePattern(background, 0, 0, background.getWidth(), background.getHeight(), false));
        root.getChildren().add(r);
    }




   public void setMenuController(ControlMenu listener)
    {
        newPart.setOnAction(listener);
        this.widthProperty().addListener(listener);
    }
}
