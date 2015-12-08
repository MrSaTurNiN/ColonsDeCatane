package controllers;

import Exceptions.ColoniePositionException;
import Exceptions.NoColonieException;
import Model.Batiments.Colonie;
import Exceptions.ColoniePositionException;
import Exceptions.RoutePositionException;
import Model.Batiments.Colonie;
import Model.Joueur;
import Model.Partie;
import Model.graph.Edge;
import Model.graph.Vertex;
import com.sun.org.apache.xpath.internal.SourceTree;
import views.panels.PanelGame;
import controllers.MainController;

import java.awt.event.*;

/**
 * Created by jpabegg on 03/12/15.
 */
public class ClickListener extends MainController implements MouseListener, MouseMotionListener {

    private Partie partie;
    private PanelGame panel;
    private boolean placecolo1;
    private Vertex rout1;
    private Vertex rout2;


    public ClickListener(Partie partie){
        this.partie = partie;
        currentWindow.getPanel().setControler(this);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int X = e.getX();
        int Y = e.getY();
        Vertex v = partie.getPlateau().getGraph().converstionXY(X,Y);
        int xu = v.getX();
        int xv = v.getY() ;
        if(v.getBatiment() instanceof Colonie)
        {
            try {
                partie.getPlateau().creerVille(v);
            } catch (NoColonieException e1) {
                e1.printStackTrace();
            }
        }
        else
        {
            try {
                partie.getPlateau().creerColonie(partie.getJoueurActif(), v);
            } catch (ColoniePositionException e1) {
                e1.printStackTrace();
            }
        }

        System.out.println(v.getBatiment());

        if (partie.getNbTour()<=partie.getNbJoueur()-1){
            phaseinit(v);
        }

        partie.setJoueurclick(true);
        partie.setVertexclique(v);
        System.out.println(X + " " + Y + "SOURIS ");
        currentWindow.getPanel().repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {


    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e){
        final int X = e.getX();
        final int Y = e.getY();

        Vertex v = partie.getPlateau().getGraph().converstionXY(X,Y);

        for (int i = 0; i < partie.getPlateau().getGraph().getVertices().length; i++) {
            partie.getPlateau().getGraph().getVertices()[i].setHoverFalse();
        }
        if(v != null) {
            v.setHoverTrue();
        }


        currentWindow.getPanel().repaint();
    }

    public void phaseinit(Vertex v){
        Joueur joueur;


        joueur=partie.getJoueurActif();
        if (placecolo1==true){
            if (rout1!=null){
                rout2=v;
                try {
                    partie.getPlateau().creerRoute(joueur,partie.getPlateau().getGraph().convertEdge(rout1,rout2));

                    joueurSuivant();
                    placecolo1 = false;


                }catch (RoutePositionException r){
                    r.printStackTrace();
                }
            }
            else {
                rout1=v;
            }

        }
        else {
            try {
                partie.getPlateau().creerColonie(joueur,v);
                placecolo1=true;


            } catch (ColoniePositionException e) {
                e.printStackTrace();
            }

        }


    }
    public void joueurSuivant(){
        partie.setJoueurActif(partie.getListeJoueur().get((partie.getNbTour()+1)%partie.getNbJoueur()));
        partie.setNbTour(partie.getNbTour()+1);


    }


}
