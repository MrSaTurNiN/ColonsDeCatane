package controllers;

import java.awt.*;

import Model.Partie;
import views.InitJoueurView;
import views.InitNbJoueurView;
import views.MainWindow;
import views.panels.PanelGame;
import views.panels.PanelMenu;

public class MainController {

	protected static MainWindow currentWindow;
	protected static Partie partie;
	private PanelGame panel;
	private PanelMenu menuPanel;
	private InitJoueurView initJoueurView;
	private InitNbJoueurView initNbJoueurView;
	private ClickListener click;

	public MainController(Partie partie){
		this.partie = partie;
		currentWindow = new MainWindow(this.partie, this);
		currentWindow.setVisible(true);


	}

	public MainController() {

	}

	public void nouvellePartie(){

		initNbJoueur();
		initAllJoueur();

		panel=currentWindow.getPanel();
		click=new ClickListener(this.partie);

		currentWindow.displayGamePanel();
		partie.setOrdreJoueur();
		partie.setJoueurActif(partie.getListeJoueur().get(0));
		partie.setLaunched();
	}
	public void creerJoueur(String nomJoueur, Color colorJoueur){
		partie.creerJoueur(nomJoueur, colorJoueur);
		partie.getListCouleur().remove(partie.getJoueurActif().getCouleurJoueur());

	}

	public void setNbJoueur(int nbJoueur){
		partie.setNbJoueur(nbJoueur);
	}

	public void initJoueur(){
		initJoueurView = new InitJoueurView(this, currentWindow);
		initJoueurView.setVisible(true);
	}

	public void initNbJoueur(){
		initNbJoueurView = new InitNbJoueurView(this, currentWindow);
		initNbJoueurView.setVisible(true);
	}
	public void initAllJoueur(){
		for (int i = 0; i < partie.getNbJoueur(); i++) {
			initJoueur();
			partie.initFicheConstruct(partie.getListeJoueur().get(i));
		}
	}

	public Partie getPartie(){
		return partie;
	}

}