package controllers;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * Created by Victor on 08/03/2016.
 */
public class controlHover extends MainControl implements EventHandler<MouseEvent> {
    ImageView iv;
    double x;
    double y;

    public controlHover() {
        actualWindow.getGamePanel().getInfoJoueur().setControlHover(this);
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getEventType()==MouseEvent.MOUSE_ENTERED){
            iv= (ImageView)event.getTarget();
            x=event.getX();
            y=event.getY();
            System.out.println(iv.getId()+" x="+x+"  y="+y);
            event.consume();
        }
    }
}
