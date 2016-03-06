package controllers;

import Exceptions.NumberSevenException;
import Exceptions.batiment.SuperExceptionBatiment;
import Exceptions.click.PositionsInvalidesException;
import Exceptions.ressource.OutOfCardException;
import Exceptions.ressource.SuperExceptionRessource;
import Exceptions.ressource.UnKnownRessource;
import Model.Batiments.Batiment;
import Model.Batiments.Colonie;
import Model.Joueur;
import Model.graph.Edge;
import Model.graph.Vertex;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import views.panels.PanelGame;

import javax.xml.stream.EventFilter;
import javax.xml.stream.events.XMLEvent;

/**
 * Created by Mahel Sif on 31/01/2016.
 */
public class ControlGame extends MainControl implements EventHandler<MouseEvent> {


    public ControlGame() {
        actualWindow.getGamePanel().setGameController(this);
    }

    private boolean placecolo1;

    @Override
    public void handle(MouseEvent e) {
        final double X = e.getX();
        final double Y = e.getY();




        if (e.getEventType() == MouseEvent.MOUSE_CLICKED) {
            if(e.getTarget() instanceof ImageView)
            {
                ImageView Iv = (ImageView) e.getTarget();
                if(Iv.getId() == "button_de")
                {
                    System.out.println("Dé");
                    lancementDes();
                }
                if(Iv.getId() == "button_bank"){
                    actualWindow.getGamePanel().getBanque().changeSelected();
                }

            }

            Vertex v = null;
            Edge e1 = null;
            try {

                if (!placecolo1 && actualModel.getPartie().getNbTour() <= (actualModel.getPartie().getNbJoueur()) * 2 - 1) {
                    v = actualModel.getPartie().getPlateau().getGraph().converstionXY(X, Y);

                } else if (actualModel.getPartie().getNbTour() <= (actualModel.getPartie().getNbJoueur()) * 2 - 1) {
                    e1 = actualModel.getPartie().getPlateau().getGraph().getEdgeFromPoint(X, Y);
                }
                if (actualModel.getPartie().getNbTour() <= (actualModel.getPartie().getNbJoueur()) * 2 - 1) {

                    phaseinit(v, e1);

                }
            } catch (PositionsInvalidesException exc) {
                System.out.println(exc.getMessage());
            }

            if (actualModel.getPartie().getNbTour() > (actualModel.getPartie().getNbJoueur()) * 2 - 1) {
                try {
                    v = actualModel.getPartie().getPlateau().getGraph().converstionXY(X, Y);
                } catch (Exceptions.click.PositionsInvalidesException exc) {
                    // System.out.println(exc.getMessage());
                }
                try {
                    e1 = actualModel.getPartie().getPlateau().getGraph().getEdgeFromPoint(X, Y);
                } catch (Exceptions.click.PositionsInvalidesException exc) {
                    System.out.println(exc.getMessage() + "     qqq");
                }
                try {
                    phaseJeu(v, e1);
                } catch (OutOfCardException e2) {
                    e2.printStackTrace();
                } catch (UnKnownRessource unKnownRessource) {
                    unKnownRessource.printStackTrace();
                }
            }
        }

        Vertex v;
        Edge e2;
        for (int i = 0; i < actualModel.getPartie().getPlateau().getGraph().getVertices().length; i++) {
            actualModel.getPartie().getPlateau().getGraph().getVertices()[i].setHoverFalse();
        }
        try {
            v = actualModel.getPartie().getPlateau().getGraph().converstionXY(X, Y);

            v.setHoverTrue();

        } catch (PositionsInvalidesException e1) {
            //e1.printStackTrace();
        }

        for (int i = 0; i < actualModel.getPartie().getPlateau().getGraph().getEdges().size(); i++) {
            actualModel.getPartie().getPlateau().getGraph().getEdges().get(i).setHoverFalse();
        }
        try {
            e2 = actualModel.getPartie().getPlateau().getGraph().getEdgeFromPoint(X, Y);
            e2.setHoverTrue();
        } catch (PositionsInvalidesException e1) {
            //e1.printStackTrace();

        }
        actualWindow.getGamePanel().draw();

    }

    public void lancementDes() {
        if (!actualModel.getPartie().isPhaseConstruction() && actualModel.getPartie().getNbTour()>(actualModel.getPartie().getNbJoueur())*2-1) {
            // if (!phaseCommerce) {
            if (!actualModel.getPartie().isDes()) {

                int result = actualModel.getPartie().getDes().lancerDes();
                try {
                    actualModel.getPartie().getRessource(result);

                } catch (NumberSevenException nb7) {
                    nb7.getMessage();
                }
                actualModel.getPartie().setPhaseConstruction(true);
                actualModel.getPartie().lanceDes();
            }
        }
    }

    public void phaseinit(Vertex v, Edge e1) {
        Joueur joueur;

        joueur = actualModel.getPartie().getJoueurActif();
        if (placecolo1 == true) {
            try {
                actualModel.getPartie().getPlateau().creerRoute(joueur, e1, null);
                if (joueur.equals(actualModel.getPartie().getListeJoueur().get(actualModel.getPartie().getListeJoueur().size() - 1)) && actualModel.getPartie().getNbTour() < (actualModel.getPartie().getNbJoueur()) * 2 - 2) {
                    actualModel.getPartie().inversOrdre();
                } else if (joueur.equals(actualModel.getPartie().getListeJoueur().get(actualModel.getPartie().getListeJoueur().size() - 1)) && actualModel.getPartie().getNbTour() == (actualModel.getPartie().getNbJoueur()) * 2 - 2) {
                    actualModel.getPartie().reinitOrdre();
                }
                actualModel.getPartie().joueurSuivant();
                placecolo1 = false;
            } catch (SuperExceptionRessource r) {

                r.getMessage();
            } catch (SuperExceptionBatiment r) {
                r.getMessage();
            }
        } else {
            try {
                Batiment b = actualModel.getPartie().getPlateau().creerColonie(joueur, v, null);
                joueur.placerColonie((Colonie) b);
                if (actualModel.getPartie().getNbTour() > actualModel.getPartie().getNbJoueur() - 1) {
                    actualModel.getPartie().initMainJoueur(joueur);
                }
                placecolo1 = true;
            } catch (SuperExceptionRessource e) {
                e.getMessage();
            } catch (SuperExceptionBatiment e) {
                e.getMessage();
            }

        }


    }

    public void phaseJeu(Vertex v, Edge e1) throws OutOfCardException, UnKnownRessource {
        Joueur joueur;
        joueur = actualModel.getPartie().getJoueurActif();
        if (v != null) {
            if (v.getBatiment() != null && v.getBatiment().getJoueur() == joueur) {
                v.ameliorerBatiment(joueur);
            } else {
                try {

                    Batiment b = actualModel.getPartie().getPlateau().creerColonie(joueur, v, joueur.getMainRessource());
                    joueur.placerColonie((Colonie) b);
                } catch (SuperExceptionRessource e) {
                    System.out.println(e.getMessage());
                    e.getMessage();
                } catch (SuperExceptionBatiment e) {
                    System.out.println(e.getMessage());
                    e.getMessage();
                }
            }
        } else if (e1 != null) {
            try {
                System.out.println("je vais creer une route: ");
                actualModel.getPartie().getPlateau().creerRoute(joueur, e1, joueur.getMainRessource());
            } catch (SuperExceptionRessource r) {
                r.getMessage();
            } catch (SuperExceptionBatiment e) {
                e.printStackTrace();
            }
        }
    }

}