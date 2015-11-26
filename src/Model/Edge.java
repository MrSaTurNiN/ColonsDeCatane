package Model;

import Model.Batiments.Route;

/**
 * Created by Jip on 22/11/2015.
 */
public class Edge {
    Vertex vertexA;
    Vertex vertexB;
    Route route = null;
    public Edge(Vertex vertexA, Vertex vertexB) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setTop()
    {
        vertexA.setUpEdge(this);
        vertexB.setUpEdge(this);
    }
    public void setLeft()
    {
        vertexA.setLeftEdge(this);
        vertexB.setLeftEdge(this);
    }
    public boolean isLibreColonie(Vertex v)
    {
        if(v == vertexA)
        {
            return vertexB.getBatiment() == null;
        }
        if(v == vertexB)
        {
            return vertexA.getBatiment() == null;
        }
        /* Il serait mieux de faire une exception */
        return false;
    }
    public boolean isLibreRoute(Joueur j)
    {
        //Si il y a deja une route la position est invalide
        if(route != null)return false;
        //Sinon l'edge est connecté à une colonie ou une ville du joueur alors la position est valide
        if(vertexA.getBatiment() != null && vertexA.getBatiment().getJoueur() == j)return true;
        if(vertexB.getBatiment() != null && vertexB.getBatiment().getJoueur() == j)return true;
        //Sinon on regarde si les points sont connecté à des arretes possédant une route du joueur
        return vertexA.isConnectToRoad(j) || vertexB.isConnectToRoad(j);
    }

    public void setRight(){
        vertexA.setRightEdge(this);
        vertexB.setRightEdge(this);
    }
}
