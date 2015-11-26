package controllers;

import java.awt.Color;

import Model.Partie;
import views.InitJoueurView;
import views.MainWindow;

public class MainController {

	protected static MainWindow currentWindow;
	protected static Partie partie;
	private InitJoueurView initJoueurView;
	
	
	public MainController(Partie partie){
		this.partie = partie;
		initJoueur();
		
		currentWindow = new MainWindow(this.partie, this);
		currentWindow.setVisible(true);
	
	
		
	}
	
	public void creerJoueur(String nomJoueur, Color colorJoueur){
		partie.creerJoueur(nomJoueur, colorJoueur);
		
	}
	
	public void initJoueur(){
		initJoueurView = new InitJoueurView(this, currentWindow);
		initJoueurView.setVisible(true);
	}
}
