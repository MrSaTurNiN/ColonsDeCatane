package views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.MainModel;
import views.panels.PanelGame;
import views.panels.PanelMenu;


/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class MainWindow extends Stage implements ViewConstants{

    private final PanelMenu menu;
    private final PanelGame game;

    public MainWindow(MainModel model){
        this.setTitle("Colons de Catanes");
        this.setAlwaysOnTop(true);
        this.setHeight(WINDOW_HEIGHT);
        this.setWidth(WINDOW_WIDTH);

        Group root = new Group();
        Group root2 = new Group();

        this.menu = new PanelMenu(root,root, this);
        this.game = new PanelGame(root2, root2, this, model);

        this.setScene(game);
        this.show();
    }

    public PanelMenu getMenuPanel()
    {
        return menu;
    }

    public PanelGame getGamePanel()
    {
        return game;
    }

    public Stage getStage() { return this;}

    public void switchPanel(Scene s) {
        this.setScene(s);
    }



}
