package controllers;

import Model.Joueur;
import Model.Partie;
import Model.graph.Vertex;
import views.panels.PanelGame;
import controllers.MainController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jpabegg on 03/12/15.
 */
public class ClickListener extends MainController implements MouseListener{

    private Partie partie;
    private PanelGame panel;

    public ClickListener(Partie partie){
        this.partie = partie;
        currentWindow.getPanel().setControler(this);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int X = e.getX();
        int Y = e.getY();
        Vertex v = partie.getPlateau().getGraph().converstionXY(X,Y);
        int xu = v.getX();
        int xv = v.getY() ;
        v.nouveauBatiment(partie.getJoueurActif());
        System.out.println(v.getBatiment());
        partie.setJoueurclick(true);
        partie.setVertexclique(v);
        System.out.println(X + " " + Y + "SOURIS ");
        currentWindow.getPanel().repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
