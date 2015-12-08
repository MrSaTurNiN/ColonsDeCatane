package views;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controllers.MainController;
import Model.Partie;
import javafx.scene.layout.Pane;
import views.panels.PanelGame;

public class MainWindow extends JFrame implements ViewConstants {
	private PanelGame game;
	private InitJoueurView initJoueurView;
	private MainController mainControl;

	public MainWindow(Partie partie, MainController mainControl) {
		this.mainControl=mainControl;
		
		game = new PanelGame(partie);
		setContentPane(game);
		setTitle("Catane");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		

	}

    public PanelGame getPanel()
    {
        return this.game;
    }

}
