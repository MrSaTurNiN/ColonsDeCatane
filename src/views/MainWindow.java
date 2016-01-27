package views;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controllers.MainController;
import Model.Partie;
import javafx.scene.layout.Pane;
import views.panels.PanelGame;
import views.panels.PanelMenu;

public class MainWindow extends JFrame implements ViewConstants {
	private PanelGame game;
	private PanelMenu menu;
	private InitJoueurView initJoueurView;
	private MainController mainControl;

	public MainWindow(Partie partie, MainController mainControl) {
		this.mainControl=mainControl;
		menu = new PanelMenu(mainControl);
		game = new PanelGame(partie);
		game.initImage();
		setContentPane(menu);
		setTitle("Catane");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		

	}

    public PanelGame getPanel()
    {
        return this.game;
    }

    public void displayGamePanel(){
    	setContentPane(game);
    	game.setVisible(true);
    	repaint();
    	revalidate();
    }
    
}
