package controllers.Timer;

import controllers.MainController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer extends MainController implements ActionListener {

//PROJET POUR ANIMATION LASER
    public GameTimer() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

            partie.update();
        currentWindow.repaint();
    }
}
