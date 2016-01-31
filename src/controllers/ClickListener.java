package controllers;

import Exceptions.*;
import Exceptions.batiment.*;
import Exceptions.click.PositionsInvalidesException;
import Exceptions.ressource.RessourceIndisponibleException;
import Exceptions.ressource.SuperExceptionRessource;
import Model.Batiments.Batiment;
import Model.Batiments.Colonie;
import Model.Joueur;
import Model.Partie;
import Model.graph.Edge;
import Model.graph.Vertex;
import views.panels.PanelGame;

import java.awt.event.*;
import java.sql.SQLOutput;

/**
 * Created by jpabegg on 03/12/15.
 */
public class ClickListener extends MainController implements MouseListener, MouseMotionListener,ActionListener{

    private Partie partie;
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

            if (!placecolo1 && partie.getNbTour()<=(partie.getNbJoueur())*2-1) {
                v = partie.getPlateau().getGraph().converstionXY(X, Y);

            }
            else if(partie.getNbTour()<=(partie.getNbJoueur())*2-1) {
                e1=partie.getPlateau().getGraph().getEdgeFromPoint(X,Y);
            }
            if (partie.getNbTour()<=(partie.getNbJoueur())*2-1){

                phaseinit(v, e1);

            }
        }catch (PositionsInvalidesException exc){
            System.out.println(exc.getMessage());
        }

            if (partie.getNbTour()>(partie.getNbJoueur())*2-1){
                try {
                    v = partie.getPlateau().getGraph().converstionXY(X, Y);
                }
                catch (Exceptions.click.PositionsInvalidesException exc){
                   // System.out.println(exc.getMessage());
                }
                try {
                    e1 = partie.getPlateau().getGraph().getEdgeFromPoint(X, Y);
                }catch (Exceptions.click.PositionsInvalidesException exc){
                    System.out.println(exc.getMessage()+"     qqq");
                }
                phaseJeu(v, e1);
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
                }catch (SuperExceptionRessource r){

                    r.getMessage();
                }catch(SuperExceptionBatiment r){
                    r.getMessage();
                }
        }
        else {
            try {
                Batiment b=partie.getPlateau().creerColonie(joueur,v,null);
                joueur.placerColonie((Colonie) b);
                if (partie.getNbTour()>partie.getNbJoueur()-1){
                    partie.initMainJoueur(joueur);
                }
                placecolo1=true;
            } catch (SuperExceptionRessource e) {
                e.getMessage();
            }
            catch (SuperExceptionBatiment e){
                e.getMessage();
            }

        }


    }
    public void phaseJeu(Vertex v,Edge e1){
        Joueur joueur;
        joueur=partie.getJoueurActif();
        if (lancementDes()){
        }
        else{
            if (skiper()) {
                return;
            }
            if (v!=null){
                System.out.println("yolo");
                if (v.getBatiment()!=null && v.getBatiment().getJoueur()==joueur){
                    try {
                        v.ameliorerBatiment(joueur);
                    } catch (SuperExceptionRessource e) {
                        System.out.println(e.getMessage());
                        e.getMessage();
                    }
                }
                else {
                    try {

                        Batiment b = partie.getPlateau().creerColonie(joueur, v, joueur.getMainRessource());
                        joueur.placerColonie((Colonie) b);
                    } catch (SuperExceptionRessource e) {
                        System.out.println(e.getMessage());
                        e.getMessage();
                    } catch (SuperExceptionBatiment e) {
                        System.out.println(e.getMessage());
                        e.getMessage();
                    }
                }
            }
            else if (e1!=null){
                try {
                    System.out.println("je vais creer une route: ");
                    partie.getPlateau().creerRoute(joueur, e1, joueur.getMainRessource());
                }catch(SuperExceptionRessource r){
                    r.getMessage();
                } catch (SuperExceptionBatiment e) {
                    e.printStackTrace();
                }
            }
        }
        currentWindow.repaint();

    }
    public boolean lancementDes(){
        if(!partie.isPhaseConstruction()) {
            // if (!phaseCommerce) {
            if (partie.isDes()) {
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
            partie.lanceDes();
            lancementDes();
            currentWindow.getPanel().switchButton();
        }
        if (e.getSource()==currentWindow.getPanel().getSkip()&&partie.getNbTour()>(partie.getNbJoueur())*2-1&&!partie.isSkip()){
            partie.skip();
            skiper();
            currentWindow.getPanel().switchButton();
            joueurSuivant();
            currentWindow.repaint();
        }

    }
}
