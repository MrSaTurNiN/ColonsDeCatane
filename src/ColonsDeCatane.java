import Model.*;
import controllers.MainController;

/**
 * Created by FRANCOIS on 14/11/15.
 */
public class ColonsDeCatane {
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Partie model = new Partie();
                MainController mainControl = new MainController(model);
            }
        });
    }
}
