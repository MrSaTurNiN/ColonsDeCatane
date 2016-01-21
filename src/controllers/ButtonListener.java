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
    private ClickListener click;


    public ButtonListener(Partie partie,ClickListener click){
        this.partie = partie;
        this.click=click;

        currentWindow.getPanel().setButtonController(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==currentWindow.getPanel().getDes()&&partie.getNbTour()>(partie.getNbJoueur())*2-1&&!partie.isDes()){
            System.out.println("le joueur lance les dés");
            partie.lanceDes();
        }
        if (e.getSource()==currentWindow.getPanel().getSkip()&&partie.getNbTour()>(partie.getNbJoueur())*2-1&&!partie.isSkip()){
            partie.skip();
            joueurSuivant();
            currentWindow.repaint();
        }

    }
    public void joueurSuivant(){
        partie.setJoueurActif(partie.getListeJoueur().get((partie.getNbTour() + 1) % partie.getNbJoueur()));
        partie.setNbTour(partie.getNbTour() + 1);
    }
}
