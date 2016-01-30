package views;


import controllers.MainController;
import Model.Partie;
import javafx.stage.Stage;
import views.panels.PanelGameFx;


public class MainWindow extends Stage implements ViewConstants {
	private PanelGameFx game;
	private InitJoueurView initJoueurView;
	private MainController mainControl;

	public MainWindow(Partie partie, MainController mainControl) {
		this.setTitle("Catane");
		this.setAlwaysOnTop(true);
		this.setResizable(false);

		this.mainControl=mainControl;
		game = new PanelGameFx(partie);


	}

    public PanelGameFx getPanel()
    {
        return this.game;
    }

}
