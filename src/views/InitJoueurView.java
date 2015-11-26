package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import controllers.MainController;

public class InitJoueurView extends JDialog  {
	private JTextField nomJoueur;
	private JComboBox<Color> colorJoueur;
	private JButton valide;
	private MainController mainControl;


	public InitJoueurView(MainController mainControl, JFrame parent ) {
		super(parent);
		setModal(true);
		this.mainControl=mainControl;
		setSize(400, 400);
		nomJoueur = new JTextField(20);
		colorJoueur = new JComboBox<>();
		colorJoueur.addItem(Color.BLUE);
		colorJoueur.addItem(Color.GREEN);
		valide = new JButton("Valider");
		valide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				valideActionPerform();
				
			}
		});
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(nomJoueur);
		getContentPane().add(colorJoueur);
		getContentPane().add(valide);

		Renderer renderer = new Renderer();

		colorJoueur.setRenderer(new ListCellRenderer<Color>() {
			@Override
			public Component getListCellRendererComponent(
					JList<? extends Color> list, Color value, int index,
					boolean isSelected, boolean cellHasFocus) {
				renderer.color = value;

				renderer.setPreferredSize(new Dimension(50, 20));
				return renderer;
			}
		});

	}

	public static class Renderer extends JComponent {
		Color color;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(color);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	};
	
	public void valideActionPerform(){
		mainControl.creerJoueur(nomJoueur.getText(), (Color) colorJoueur.getSelectedItem());
		setVisible(false);
	}
}
