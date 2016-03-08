package controllers;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * Created by Victor on 08/03/2016.
 */
public class ControlHover extends MainControl implements EventHandler<MouseEvent> {
    ImageView iv;
    double x;
    double y;

    public ControlHover() {
        actualWindow.getGamePanel().setGameHoverController(this);
    }

    @Override
    public void handle(MouseEvent e) {

    }
}
