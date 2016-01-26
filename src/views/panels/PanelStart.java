package views.panels;

import Model.Partie;
import javafx.application.Application;
import javafx.stage.Stage;
import views.InitJoueurView;
import views.InitNbJoueurView;

/**
 * Created by Mahel Sif on 26/01/2016.
 */
public class PanelStart  extends Application{

    Partie partie;

    public PanelStart(Partie p){
        this.partie = p;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        InitJoueurView initJoueurView = new InitJoueurView(partie);
    }
}
