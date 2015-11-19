package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Model.Partie;
import views.panels.PanelGame;

public class MainWindow extends JFrame implements ViewConstants {
	private PanelGame game;

	public MainWindow(Partie partie) {
		game= new PanelGame(partie);
		setContentPane(game);
		setTitle("Catane");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);

	}

}
