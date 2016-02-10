package controllers;

import Exceptions.click.PositionsInvalidesException;
import Model.graph.Edge;
import Model.graph.Vertex;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;

/**
 * Created by Mahel Sif on 31/01/2016.
 */
public class ControlGame extends MainControl implements ChangeListener<Number>, EventHandler<MouseEvent>{


    public ControlGame() { actualWindow.getGamePanel().setGameController(this);}



    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        actualWindow.getGamePanel().draw();
    }


    @Override
    public void handle(MouseEvent e) {
        final double X = e.getX();
        final double Y = e.getY();
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
