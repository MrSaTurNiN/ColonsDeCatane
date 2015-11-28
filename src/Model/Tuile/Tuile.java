package Model.Tuile;

import Model.graph.Vertex;
import Model.Voleur;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jpabegg on 25/11/15.
 */
public class Tuile {
    protected Voleur voleur = null;
    protected Set<Vertex> sommets = new HashSet<Vertex>();
    protected int numero;

    public Voleur getVoleur() {
        return voleur;
    }

    public void setVoleur(Voleur voleur) {
        this.voleur = voleur;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void addSommet(Vertex v)
    {
       sommets.add(v);
    }

    public Set<Vertex> getSommets() {
        return sommets;
    }

    public boolean hasVertex(Vertex v)
    {
        return sommets.contains(v);
    }
}
