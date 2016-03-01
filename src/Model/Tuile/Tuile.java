package Model.Tuile;

import Model.Voleur;
import Model.graph.Vertex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpabegg on 25/11/15.
 */
public class Tuile implements Serializable{
    protected Voleur voleur = null;
    protected List<Vertex> sommets = new ArrayList<Vertex>();
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

    public List<Vertex> getSommets() {
        return sommets;
    }

    public boolean hasVertex(Vertex v)
    {
        return sommets.contains(v);
    }

    public String getName()
    {
        return null;
    }
}
