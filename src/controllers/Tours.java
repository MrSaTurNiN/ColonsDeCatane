package controllers;

import Model.Batiments.Colonie;
import Model.Joueur;
import Model.Partie;
import Model.graph.Vertex;

import java.awt.*;

public class Tours {
    private Partie partie;
    public Tours(Partie partie){
        this.partie=partie;

    }
    public void phaseinit(){
        partie.setOrdreJoueur();
        Joueur joueur;
        Colonie colo;
        Vertex v;
        for (int i = 0; i <partie.getListeJoueur().size(); i++) {
            joueur=partie.getListeJoueur().get(i);
            if (joueur.getCouleurJoueur()== Color.BLUE){
                v=new Vertex();
                //TODO récupérer la position fixée par les règles du batiment
                //v.
               // colo=new Colonie(joueur,);
                joueur.placerColonie(new Colonie(joueur,new Vertex()));

            }
            partie.initMainJoueur(joueur);
            partie.initFicheConstruct(joueur);
        }
    }

}
