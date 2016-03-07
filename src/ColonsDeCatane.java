import controllers.MainControl;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Model.MainModel;


/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class ColonsDeCatane extends Application{

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                ColonsDeCatane.launch(ColonsDeCatane.class);
            }

        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainModel model = new MainModel();
        MainControl.initControl(model);
    }


}
