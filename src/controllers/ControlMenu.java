package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class ControlMenu extends MainControl implements EventHandler<MouseEvent> {

    Text txt;

    public ControlMenu(){

        actualWindow.getMenuPanel().setMenuController(this);
        actualWindow.getMenuPanel().setMenuController(this);
        actualModel.getMusic().getMusicMenu().play();
    }

    final Timer timer = new Timer(); // uses a timer to call your resize method
    TimerTask task = null; // task to execute after defined delay
    final long delayTime = 200; //

    @Override
    public void handle(MouseEvent event) {
        txt = (Text) event.getTarget();
        if (event.getEventType()==MouseEvent.MOUSE_ENTERED){
            actualWindow.setCursor(actualWindow.cursorHover);
            actualWindow.getMenuPanel().getModuleMenu().drawHover(txt);
        }
        if (event.getEventType()==MouseEvent.MOUSE_EXITED){
            actualWindow.setCursor(actualWindow.cursor);
            actualWindow.getMenuPanel().getModuleMenu().unHover(txt);
        }
        if (event.getEventType()==MouseEvent.MOUSE_CLICKED){
            if (txt!=null && txt.getId()=="newPart"){
                actualModel.getMusic().getMusicMenu().stop();
                actualModel.nouvellePartie();
                actualWindow.switchPanel(actualWindow.getGamePanel());
                actualModel.getMusic().playLoop();
            }
        }
    }
}
