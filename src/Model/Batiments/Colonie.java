package Model.Batiments;

import Model.Joueur;
import Model.graph.Vertex;

/**
 * Created by jpabegg on 25/11/15.
 */
public class Colonie extends Batiment {
    protected Vertex position;
    public Colonie(Joueur joueur,Vertex position) {
        super(joueur);
        this.position = position;
        position.setBatiment(this);
    }

    public Vertex getPosition() {
        return position;
    }
}
