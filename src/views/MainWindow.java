package views;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        this.getIcons().add(new Image(getClass().getResourceAsStream("/assets/img/stormtrooper.png")));
        this.setHeight(WINDOW_HEIGHT);
        this.setWidth(WINDOW_WIDTH);


        Group root = new Group();
        Group root2 = new Group();

        menu = new PanelMenu(root,root, this, model);
        game = new PanelGame(root2, root2, this, model);

        setScene(menu);
        System.out.println(this.getClass());
        String css = this.getClass().getResource("/views/css/css.css").toExternalForm();
        this.getScene().getStylesheets().add(css);
        show();
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        menu.draw();
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
        if (s instanceof PanelMenu){
            menu.draw();
        }
        else {
            game.draw();
        }
    }

    public void setPanel(Scene panel){
        this.setScene(panel);
    }




}
