package Model;

import java.awt.*;

/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class MainModel {

    private Partie partie;
    private MenuModel menu;

    public MainModel() {
        partie = new Partie();

    }

    public void nouvellePartie(){
        setNbJoueur(3);
        creerJoueur("dsgsg",Color.black);
        creerJoueur("ghsdfh",Color.blue);
        creerJoueur("ffgd",Color.red);

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

    public Partie getPartie(){
        return partie;
    }

}
