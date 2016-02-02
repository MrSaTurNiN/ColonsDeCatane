package Model.graph;

import Model.Joueur;
import Model.Batiments.Route;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 * Created by Jip on 22/11/2015.
 */
public class Edge implements Serializable{
    Vertex vertexA;
    Vertex vertexB;
    boolean isHover;
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
    /*
        Retourne si le point opposé à v sur l'arrete ne possède pas de colonie
     */
    public boolean isLibreColonie(Vertex v)
    {
        return getOther(v).getBatiment() == null;
    }

    public Vertex getOther(Vertex v)
    {
        if(v == vertexA)return vertexB;
        if(v == vertexB)return  vertexA;
        return null;
    }

    public void creerRoute(Joueur j)
    {
        route = new Route(j);
    }

    /*
        retourne si on peut constuire une route pour le joueur J sur cette arrete.
     */
    public boolean isLibreRoute(Joueur j)
    {
        //Si il y a deja une route la position est invalide
        if(route != null)return false;
        //Sinon l'edge est connect� � une colonie ou une ville du joueur alors la position est valide
        if(vertexA.getBatiment() != null && vertexA.getBatiment().getJoueur() == j)return true;
        if(vertexB.getBatiment() != null && vertexB.getBatiment().getJoueur() == j)return true;
        //Sinon on regarde si les points sont connect� � des arretes poss�dant une route du joueur
        return vertexA.isConnectToRoad(j) || vertexB.isConnectToRoad(j);
    }

    public void setRight(){
        vertexA.setRightEdge(this);
        vertexB.setRightEdge(this);
    }

    public Vertex getVertexA() {
        return vertexA;
    }

    public Vertex getVertexB() {
        return vertexB;
    }

    public Point middleOfTheEdge(){
        Point p = new Point();
        double x1 = vertexA.getX();
        double y1 = vertexA.getY();
        double x2 = vertexB.getX();
        double y2 = vertexB.getY();
        p.setLocation((x1+x2)/2,(y1+y2)/2);
        return p;
    }

    public void setHoverTrue() {
        isHover = true;
    }

    public void setHoverFalse()
    {
        isHover = false;
    }

    public boolean isHover()
    {
        return isHover;
    }

}
