package views.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDeckRessource extends JPanel {
	private Graphics2D g2;
	
	public PanelDeckRessource() {

	}

	@Override
	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawDeckRessource();
		g2.drawString("19", 750, 750);
		
	}

	public void drawDeckRessource() {
		System.out.println(g2);
		g2.setColor(new Color(0, 255, 255));
		g2.fillRect(700, 700, 100, 75);
	}

}
