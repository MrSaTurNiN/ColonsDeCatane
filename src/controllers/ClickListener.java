package controllers;

import Exceptions.*;
import Model.Batiments.Batiment;
import Model.Batiments.Colonie;
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
public class ClickListener extends MainController implements MouseListener, MouseMotionListener,ActionListener{

    private Partie partie;
    private PanelGame panel;
    private boolean placecolo1;

    private int X;
    private int Y;

    public ClickListener(Partie partie){
        this.partie = partie;
        currentWindow.getPanel().setControler(this);


    }
    @Override
    public void mouseClicked(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
        Vertex v=null;
        Edge e1=null;

        try{

            if (!placecolo1) {
                v = partie.getPlateau().getGraph().converstionXY(X, Y);

            }
            else {
                e1=partie.getPlateau().getGraph().getEdgeFromPoint(X,Y);
            }
            if (partie.getNbTour()<=(partie.getNbJoueur())*2-1){

                phaseinit(v, e1);

            }
            else{
                //if (v!=null||e1!=null){
                    phaseJeu(v,e1);

                //}

            }
        }catch (PositionsInvalidesException exc){

        }

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
        Vertex v;
        Edge e2;
        for (int i = 0; i < partie.getPlateau().getGraph().getVertices().length; i++) {
            partie.getPlateau().getGraph().getVertices()[i].setHoverFalse();
        }
       try {
            v =partie.getPlateau().getGraph().converstionXY(X,Y);

            v.setHoverTrue();

        } catch (PositionsInvalidesException e1) {
            //e1.printStackTrace();
        }

        for (int i = 0; i < partie.getPlateau().getGraph().getEdges().size(); i++) {
            partie.getPlateau().getGraph().getEdges().get(i).setHoverFalse();
        }
        try {
            e2=partie.getPlateau().getGraph().getEdgeFromPoint(X,Y);
            e2.setHoverTrue();
        } catch (PositionsInvalidesException e1) {
            //e1.printStackTrace();

        }

        currentWindow.getPanel().repaint();
    }

    public void phaseinit(Vertex v,Edge e1){
        Joueur joueur;

        joueur=partie.getJoueurActif();
        if (placecolo1==true){
                try {
                    partie.getPlateau().creerRoute(joueur, e1,null);
                    if (joueur.equals(partie.getListeJoueur().get(partie.getListeJoueur().size()-1))&&partie.getNbTour()<(partie.getNbJoueur())*2-2){
                        partie.inversOrdre();
                    }
                    else if(joueur.equals(partie.getListeJoueur().get(partie.getListeJoueur().size()-1))&&partie.getNbTour()==(partie.getNbJoueur())*2-2){
                        partie.reinitOrdre();
                    }
                    joueurSuivant();
                    placecolo1 = false;
                }catch (RoutePositionException r){

                    r.getMessage();
                }catch(NoRouteDispoException r){
                    r.getMessage();
                } catch (RessourceIndisponibleException e) {
                    e.printStackTrace();
                }
        }
        else {
            System.out.println("lol");
            try {
                Batiment b=partie.getPlateau().creerColonie(joueur,v,null);
                joueur.placerColonie((Colonie) b);
                if (partie.getNbTour()>partie.getNbJoueur()-1){
                    partie.initMainJoueur(joueur);
                }
                placecolo1=true;
            } catch (ColoniePositionException  e) {
                e.getMessage();
            }
            catch (NoColonieDispoException e){
                e.getMessage();
            } catch (RessourceIndisponibleException e) {
                e.printStackTrace();
            }

        }


    }
    public void phaseJeu(Vertex v,Edge e1){
        Joueur joueur;
        joueur=partie.getJoueurActif();
       /* if(!partie.isPhaseConstruction()) {
        // if (!phaseCommerce) {
        if (partie.isDes()) {
            System.out.println("Le joueur a lancé les dés");
            int result = partie.getDes().lancerDes();
            try {
                partie.getRessource(result);
                partie.setPhaseConstruction(true);
            } catch (NumberSevenException nb7) {
                nb7.getMessage();
            }
        }
        } */
        if (lancementDes()){

        }
        else{
            if (skiper()) {
                return;
            }
            if (v!=null){
                if (joueur.hasRessourceColonie()) {
                    try {

                        Batiment b = partie.getPlateau().creerColonie(joueur, v, null);
                        joueur.placerColonie((Colonie) b);
                    } catch (ColoniePositionException e) {
                        e.getMessage();
                    } catch (NoColonieDispoException e) {
                        e.getMessage();
                    } catch (RessourceIndisponibleException e) {
                        e.getMessage();
                    }
                }
            }
            else if (e1!=null){
                try {
                    partie.getPlateau().creerRoute(joueur, e1, null);
                }catch (RoutePositionException r){

                    r.getMessage();
                }catch(NoRouteDispoException r){
                    r.getMessage();
                } catch (RessourceIndisponibleException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public boolean lancementDes(){
        if(!partie.isPhaseConstruction()) {
            // if (!phaseCommerce) {
            if (partie.isDes()) {
                System.out.println("Le joueur a lancé les dés");
                int result = partie.getDes().lancerDes();
                try {
                    partie.getRessource(result);

                } catch (NumberSevenException nb7) {
                    nb7.getMessage();
                }
                partie.setPhaseConstruction(true);
            }
            return true;
        }
            return false;
    }
    public boolean skiper(){
        if (partie.isSkip()) {
            System.out.println();
            partie.setPhaseConstruction(false);
            partie.annuleDeslances();
            partie.annuleSkip();
            return true;
        }
        return false;
    }
    public void joueurSuivant() {
        partie.setJoueurActif(partie.getListeJoueur().get((partie.getNbTour() + 1) % partie.getNbJoueur()));

        partie.setNbTour(partie.getNbTour() + 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==currentWindow.getPanel().getDes()&&partie.getNbTour()>(partie.getNbJoueur())*2-1&&!partie.isDes()){
            System.out.println("le joueur lance les dés");
            partie.lanceDes();
            lancementDes();
        }
        if (e.getSource()==currentWindow.getPanel().getSkip()&&partie.getNbTour()>(partie.getNbJoueur())*2-1&&!partie.isSkip()){
            partie.skip();
            skiper();
            joueurSuivant();
            currentWindow.repaint();
        }

    }
}
