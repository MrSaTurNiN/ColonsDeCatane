package Model;

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
        vertexA.setUp(this);
        vertexB.setUp(this);
    }
    public void setLeft()
    {
        vertexA.setLeft(this);
        vertexB.setLeft(this);
    }

    public void setRight(){
        vertexA.setRight(this);
        vertexB.setRight(this);
    }
}
