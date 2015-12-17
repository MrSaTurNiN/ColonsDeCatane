package controllers;

import Model.Partie;
import views.panels.PanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Victor on 12/17/2015.
 */
public class ButtonListener extends MainController implements ActionListener {

    private Partie partie;
    private PanelGame panel;


    public ButtonListener(Partie partie){
        this.partie = partie;

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void joueurSuivant(){
        partie.setJoueurActif(partie.getListeJoueur().get((partie.getNbTour() + 1) % partie.getNbJoueur()));
        partie.setNbTour(partie.getNbTour() + 1);
    }
}
