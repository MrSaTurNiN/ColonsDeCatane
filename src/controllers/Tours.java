package controllers;

import Exceptions.ColoniePositionException;
import Model.Batiments.Colonie;
import Model.Joueur;
import Model.Partie;
import Model.graph.Vertex;

import java.awt.*;

public class Tours {
    private Partie partie;
    public Tours(Partie partie){
        this.partie=partie;
        partie.setOrdreJoueur();

    }
    public void phaseinit(){
        Joueur joueur;
        Colonie colo;

        joueur=partie.getJoueurActif();

        while (!partie.getActionDone()) {
            while (!partie.isJoueurclick()) {
            }
            try {
                partie.getPlateau().creerColonie(joueur, partie.getVertexclique());
            } catch (ColoniePositionException cpe) {
                System.out.println(cpe.getMessage());
            }
            partie.setJoueurclick(false);
            partie.setVertexclique(null);

        }

            partie.initMainJoueur(joueur);
            partie.initFicheConstruct(joueur);

    }

}
