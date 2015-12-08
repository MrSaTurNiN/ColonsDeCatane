package controllers;

import java.awt.Color;

import Model.Partie;
import views.InitJoueurView;
import views.InitNbJoueurView;
import views.MainWindow;

public class MainController {

	protected static MainWindow currentWindow;
	protected static Partie partie;
	private InitJoueurView initJoueurView;
	private InitNbJoueurView initNbJoueurView;
	
	
	public MainController(Partie partie){
		this.partie = partie;
		initNbJoueur();
		initAllJoueur();
		currentWindow = new MainWindow(this.partie, this);
        new ClickListener(partie);
		currentWindow.setVisible(true);
        Tours tours = new Tours(this.partie);

	}

    public MainController() {
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
		}
	}
	public void joueurSuivant(){
		partie.setJoueurActif(partie.getListeJoueur().get(partie.getNbTour()%partie.getNbJoueur()));
		partie.setNbTour(partie.getNbTour()+1);
		System.out.println(partie.getJoueurActif().getNomJoueur());
	}
	public Partie getPartie(){
		return partie;
	}
}
