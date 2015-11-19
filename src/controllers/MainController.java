package controllers;

import Model.Partie;
import views.MainWindow;

public class MainController {

	protected static MainWindow currentWindow;
	protected static Partie partie;
	
	public MainController(Partie partie){
		this.partie = partie;
		currentWindow = new MainWindow(this.partie);
	}
}
