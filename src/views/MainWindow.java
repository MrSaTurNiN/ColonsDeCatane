package views;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controllers.MainController;
import Model.Partie;
import javafx.scene.layout.Pane;
import views.panels.PanelGameFx;


public class MainWindow implements ViewConstants {
	private PanelGameFx game;
	private InitJoueurView initJoueurView;
	private MainController mainControl;

	public MainWindow(Partie partie, MainController mainControl) {
		this.mainControl=mainControl;
		game = new PanelGameFx(partie);


	}

    public PanelGameFx getPanel()
    {
        return this.game;
    }

}
