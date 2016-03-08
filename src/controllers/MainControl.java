package controllers;

import Model.MainModel;
import views.MainWindow;

/**
 * Created by Mahel Sif on 30/01/2016.
 */
public class MainControl {

    protected static MainWindow actualWindow;
    protected static MainModel actualModel;

    public static void initControl(MainModel model) {
        actualModel = model;
        actualWindow = new MainWindow(model);

        new ControlMenu();
        new ControlGame();
        new ControlHover();




    }
}
