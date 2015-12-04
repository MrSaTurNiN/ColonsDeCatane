package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.MainController;
import javafx.scene.control.ComboBox;

public class InitNbJoueurView extends JDialog {

	private JComboBox<Integer> nbJoueur;
	private JButton valide;
	private JLabel message;
	private MainController mainControl;

	public InitNbJoueurView(MainController mainControl, JFrame parent ) {
	super(parent);
	setModal(true);
	this.mainControl=mainControl;
	setSize(500, 100);
	
	
	valide= new JButton("valider");
	message = new JLabel("Veuillez choisir le nombre de joueur");
	nbJoueur = new JComboBox<>();
	nbJoueur.addItem(3);
	nbJoueur.addItem(4);
	valide.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			valideActionPerform();
			
		}
	});
	
	getContentPane().setLayout(new FlowLayout());
	getContentPane().add(message);
	getContentPane().add(nbJoueur);
	getContentPane().add(valide);
	}
	
	public void valideActionPerform(){
		mainControl.setNbJoueur((int)nbJoueur.getSelectedItem());
		setVisible(false);
	}
}
