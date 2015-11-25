package Model.Batiments;

import Model.Joueur;

/**
 * Created by Jip on 22/11/2015.
 */
public abstract class Batiment {
    protected Joueur joueur;

    public Batiment(Joueur joueur) {
        this.joueur = joueur;
    }
}
