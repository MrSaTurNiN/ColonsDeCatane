package Model.Batiments;

import Model.Joueur;

import java.io.Serializable;

/**
 * Created by Jip on 22/11/2015.
 */
public abstract class Batiment implements Serializable{
    protected Joueur joueur;
    public static String name;

    public Batiment(Joueur joueur) {
        this.joueur = joueur;
        this.name="Batiment";
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
