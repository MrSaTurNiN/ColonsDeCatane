package Model;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by jpabegg on 13/11/15.
 */
public class Joueur
{
    private Color couleurJoueur;
    private String nomJoueur;
    private int pointJoueur = 0;
    private Map<String,List<Ressource>> mainRessource;
    private List<Developpement> mainDeveloppement;


    public Joueur(String nomJoueur, Color couleurJoueur) {
        this.nomJoueur = nomJoueur;
        this.couleurJoueur = couleurJoueur;
    }

    public void obtenirCarte(Ressource r)
    {

    }
    public void obtenirCarte(Developpement d)
    {

    }

    public Ressource retirerCarte(String s)
    {
        return null;
    }
    public int getPointJoueur() {
        return pointJoueur;
    }

    public void setPointJoueur(int pointJoueur) {
        this.pointJoueur = pointJoueur;
    }


}
