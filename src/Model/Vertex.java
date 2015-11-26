package Model;

import Model.Batiments.Batiment;

/**
 * Created by Jip on 22/11/2015.
 */
public class Vertex {
    private Batiment batiment = null;
    private Edge upEdge = null;
    private Edge leftEdge = null;
    private Edge rightEdge = null;

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

    public boolean isConnectToRoad(Joueur j)
    {
        boolean left = false;
        boolean right = false;
        boolean up = false;
        if(leftEdge != null)
        {
            if(leftEdge.getRoute() != null)
            left = leftEdge.getRoute().getJoueur()==j;
        }
        if(rightEdge != null)
        {
            if(rightEdge.getRoute() != null)
                right = rightEdge.getRoute().getJoueur()==j;
        }
        if(upEdge != null)
        {
            if(upEdge.getRoute() != null)
                up  = upEdge.getRoute().getJoueur()==j;
        }
        return up || left ||right;
    }

    public boolean isFreeToBuild()
    {
        boolean left = true;
        boolean right = true;
        boolean up = true;
        if(leftEdge != null)
        {
            left = leftEdge.isLibreColonie(this);
        }
        if(rightEdge != null)
        {
            right = rightEdge.isLibreColonie(this);
        }
        if(upEdge != null)
        {
            up = upEdge.isLibreColonie(this);
        }
        return left && right  && up;
    }
}
