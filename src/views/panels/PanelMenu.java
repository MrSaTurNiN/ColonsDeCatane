package views.panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.MainController;
import views.ViewConstants;
import views.modules.ModuleBank;
import views.modules.ModuleInfoJoueur;

public class PanelMenu extends JPanel implements ViewConstants {
	private BufferedImage fond;
	private MainController mainController;
	private JButton launch;
	private JButton load;
	private JButton help;
	public static Font mainFont;
	public static Font mainFontSize;

	private Graphics2D g2;

	public PanelMenu(MainController mainController) {
		this.mainController = mainController;
		initImage();
		initButton();

	}

	public void initButton() {

		launch = new JButton("Nouvelle partie");
		launch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainController.nouvellePartie();
			}
		});
		add(launch);
		launch.setVisible(true);
		
		load = new JButton("Charger une partie");
		add(load);
		help = new JButton("help");
		add(help);

	}

	public void initImage() {
		try {
			fond = ImageIO.read(PanelGame.class.getResource("/assets/img/background.png"));
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setLayout(null);
		clear();
		drawBackground();

	}

	public void clear() {
		g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void drawBackground() {

		Rectangle r = new Rectangle(0, 0, 402, 402);
		g2.setPaint(new TexturePaint(fond, r));
		Rectangle rect = new Rectangle(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		g2.fill(rect);
	}

	public void initFont() {
		try {
			Font mainFont = Font.createFont(Font.TRUETYPE_FONT,
					this.getClass().getResourceAsStream("/assets/font/radiospace.ttf"));
			mainFontSize = mainFont.deriveFont(24f);
			
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
