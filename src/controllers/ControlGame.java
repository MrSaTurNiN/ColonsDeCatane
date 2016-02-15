package controllers;

import Exceptions.click.PositionsInvalidesException;
import Model.graph.Edge;
import Model.graph.Vertex;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;

/**
 * Created by Mahel Sif on 31/01/2016.
 */
public class ControlGame extends MainControl implements ChangeListener<Number>, EventHandler<MouseEvent>{


    public ControlGame() { actualWindow.getGamePanel().setGameController(this);}
    private boolean placecolo1;


    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        actualWindow.getGamePanel().draw();
    }





    @Override
    public void handle(MouseEvent e) {
        final double X = e.getX();
        final double Y = e.getY();

        if(e.getEventType() == MouseEvent.MOUSE_CLICKED)
        {

            Vertex v=null;
            Edge e1=null;

            try{

                if (!placecolo1 && actualModel.getPartie().getNbTour()<=(actualModel.getPartie().getNbJoueur())*2-1) {
                    v = actualModel.getPartie().getPlateau().getGraph().converstionXY(X, Y);

                }
                else if(actualModel.getPartie().getNbTour()<=(actualModel.getPartie().getNbJoueur())*2-1) {
                    e1=actualModel.getPartie().getPlateau().getGraph().getEdgeFromPoint(X,Y);
                }
                if (actualModel.getPartie().getNbTour()<=(actualModel.getPartie().getNbJoueur())*2-1){

                    phaseinit(v, e1);

                }
            }catch (PositionsInvalidesException exc){
                System.out.println(exc.getMessage());
            }

            if (actualModel.getPartie().getNbTour()>(actualModel.getPartie().getNbJoueur())*2-1){
                try {
                    v = actualModel.getPartie().getPlateau().getGraph().converstionXY(X, Y);
                }
                catch (Exceptions.click.PositionsInvalidesException exc){
                    // System.out.println(exc.getMessage());
                }
                try {
                    e1 = actualModel.getPartie().getPlateau().getGraph().getEdgeFromPoint(X, Y);
                }catch (Exceptions.click.PositionsInvalidesException exc){
                    System.out.println(exc.getMessage()+"     qqq");
                }
                phaseJeu(v, e1);
            }
        }

        Vertex v;
        Edge e2;
        for (int i = 0; i < actualModel.getPartie().getPlateau().getGraph().getVertices().length; i++) {
            actualModel.getPartie().getPlateau().getGraph().getVertices()[i].setHoverFalse();
        }
        try {
            v =actualModel.getPartie().getPlateau().getGraph().converstionXY(X,Y);

            v.setHoverTrue();

        } catch (PositionsInvalidesException e1) {
            //e1.printStackTrace();
        }

        for (int i = 0; i < actualModel.getPartie().getPlateau().getGraph().getEdges().size(); i++) {
            actualModel.getPartie().getPlateau().getGraph().getEdges().get(i).setHoverFalse();
        }
        try {
            e2=actualModel.getPartie().getPlateau().getGraph().getEdgeFromPoint(X,Y);
            e2.setHoverTrue();
        } catch (PositionsInvalidesException e1) {
            //e1.printStackTrace();

        }
        actualWindow.getGamePanel().draw();

    }




}
