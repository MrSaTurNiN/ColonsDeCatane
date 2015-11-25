package Model.Tuile;

import Model.Voleur;

/**
 * Created by jpabegg on 25/11/15.
 */
public class Tuile {
    protected Voleur voleur = null;

    public Voleur getVoleur() {
        return voleur;
    }

    public void setVoleur(Voleur voleur) {
        this.voleur = voleur;
    }
}
