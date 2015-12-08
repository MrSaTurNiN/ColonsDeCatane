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
	private ClickListener click;
	
	public MainController(Partie partie){
		this.partie = partie;
		initNbJoueur();
		initAllJoueur();
		currentWindow = new MainWindow(this.partie, this);
        click=new ClickListener(partie);
		currentWindow.setVisible(true);
		partie.setOrdreJoueur();
        partie.setJoueurActif(partie.getListeJoueur().get(0));
		partie.setLaunched();

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
            partie.initFicheConstruct(partie.getListeJoueur().get(i));
		}
	}

	public Partie getPartie(){
		return partie;
	}

}
