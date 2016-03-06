package views;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.MainModel;
import javafx.stage.WindowEvent;
import views.Modules.ModuleBanque;
import views.Modules.ModuleBarRaccourcis;
import views.Modules.ModuleDe;
import views.Modules.ModuleInfoJoueur;
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
        this.setHeight(WINDOW_HEIGHT);
        this.setWidth(WINDOW_WIDTH);

        Group root = new Group();
        Group root2 = new Group();

        this.menu = new PanelMenu(root,root, this);

        this.game = new PanelGame(root2, root2, this, model);

        this.setScene(game);
        this.show();
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
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
