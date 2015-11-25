package Model;

import Model.Batiments.Batiment;

/**
 * Created by Jip on 22/11/2015.
 */
public class Vertex {
    Batiment batiment = null;
    Edge upEdge = null;
    Edge leftEdge = null;
    Edge rightEdge = null;

    public Vertex()
    {

    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    public Edge getUpEdge() {
        return upEdge;
    }

    public void setUpEdge(Edge upEdge) {
        this.upEdge = upEdge;
    }

    public Edge getLeftEdge() {
        return leftEdge;
    }

    public void setLeftEdge(Edge leftEdge) {
        this.leftEdge = leftEdge;
    }

    public Edge getRightEdge() {
        return rightEdge;
    }

    public void setRightEdge(Edge rightEdge) {
        this.rightEdge = rightEdge;
    }
}
