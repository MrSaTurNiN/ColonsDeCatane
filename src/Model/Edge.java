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

    public void setRight(){
        vertexA.setRightEdge(this);
        vertexB.setRightEdge(this);
    }
}
