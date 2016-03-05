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

/**
 * Created by Mahel Sif on 31/01/2016.
 */
public class ControlGameButton extends MainControl implements EventHandler<ActionEvent>{


    public ControlGameButton() {
        actualWindow.getGamePanel().getModule("ModuleBarRaccourcis").setModuleController(this);
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("test");
    }
}
