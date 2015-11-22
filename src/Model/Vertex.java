package Model;

/**
 * Created by Jip on 22/11/2015.
 */
public class Vertex {
    Batiment batiment = null;
    Edge up= null;
    Edge left = null;
    Edge right = null;
    public Vertex()
    {

    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    public Edge getUp() {
        return up;
    }

    public void setUp(Edge up) {
        this.up = up;
    }

    public Edge getLeft() {
        return left;
    }

    public void setLeft(Edge left) {
        this.left = left;
    }

    public Edge getRight() {
        return right;
    }

    public void setRight(Edge right) {
        this.right = right;
    }
}
