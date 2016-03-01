package controllers.Timer;

import controllers.MainControl;
import lib.GameTickCounter;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer extends MainControl implements ActionListener {
    private final GameTickCounter beforeEnd;


    public GameTimer() {
        this.beforeEnd = new GameTickCounter(15);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actualWindow.getGamePanel().draw();
    }
}