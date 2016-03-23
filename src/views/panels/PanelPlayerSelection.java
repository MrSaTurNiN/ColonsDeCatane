package views.panels;

import Model.MainModel;
import Model.Partie;
import controllers.ControlMenu;
import javafx.beans.NamedArg;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import views.Modules.Module;
import views.Modules.ModuleInitPlay;
import views.Modules.ModuleMenu;
import views.ViewConstants;

/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class PanelPlayerSelection extends Scene implements ViewConstants {
    Group root;
    Stage stage;
    Partie partie;
    ModuleMenu moduleMenu;
    Image background;
    Rectangle rectangle;
    Canvas canvas;
    GraphicsContext gc;
    ModuleInitPlay moduleInitPlay;


    public PanelPlayerSelection(@NamedArg("root") Parent r, Group root, Stage stage, MainModel model) {
        super(r);
        this.root = root;
        this.stage = stage;
        this.canvas = new Canvas(stage.getWidth(), stage.getHeight());
        gc = canvas.getGraphicsContext2D();
        partie = model.getPartie();
        moduleMenu = new ModuleMenu(partie, root, stage);
        moduleInitPlay = new ModuleInitPlay(partie, root, stage);
        background = new Image(getClass().getResourceAsStream("/assets/img/background.png"));
        this.rectangle = new Rectangle(0, 0, stage.getWidth(), stage.getHeight());

    }

    public ModuleMenu getModuleMenu() {
        return moduleMenu;
    }

    public void draw() {
        root.getChildren().remove(rectangle);
        drawBackground();
        root.getChildren().add(rectangle);
        moduleMenu.draw();
    }

    public void drawBackground() {
        rectangle.setFill(new ImagePattern(background, 0, 0, background.getWidth(), background.getHeight(), false));
    }


    public void setPlayerSelectionController(ControlMenu listener) {
        moduleMenu.setMenuController(listener);
        moduleInitPlay.setMenuController(listener);
    }

    public ModuleMenu getMenuModule() {
        return moduleMenu;
    }

    public ModuleInitPlay getModuleInitPlay() {
        return moduleInitPlay;
    }
}