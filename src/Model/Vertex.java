package Model;

import Model.Batiments.Batiment;
import Model.Batiments.Colonie;
import Model.Batiments.Ville;

/**
 * Created by Jip on 22/11/2015.
 */
public class Vertex {
    private Batiment batiment = null;
    private Edge upEdge = null;
    private Edge leftEdge = null;
    private Edge rightEdge = null;
    private int x;
    private int y;
    public Vertex()
    {

    }

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }


    public void setUpEdge(Edge upEdge) {
        this.upEdge = upEdge;
    }


    public void setLeftEdge(Edge leftEdge) {
        this.leftEdge = leftEdge;
    }


    public void setRightEdge(Edge rightEdge) {
        this.rightEdge = rightEdge;
    }

    /*
        retour vrai si ce point est connecté à une route du joueur J
     */
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

    /*
        retourne vrai si on peut construire une colonie sur ce point
     */
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

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void nouveauBatiment(Joueur j) {
        batiment = new Colonie(j,this);
    }
    public void ameliorerBatiment(Joueur j)
    {
        batiment = new Ville(j,this);
    }
}
