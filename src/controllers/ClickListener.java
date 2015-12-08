package controllers;

import Model.Partie;
import Model.graph.Vertex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jpabegg on 03/12/15.
 */
public class ClickListener implements MouseListener{

    private Partie partie;
    public ClickListener(Partie partie){
        this.partie = partie;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int X = e.getX();
        int Y = e.getY() - 20; //plus 20 pour pas que la barre de titre soit prise en compte
        Vertex v = partie.getPlateau().getGraph().converstionXY(X,Y);
        int xu = v.getX();
        int xv = v.getY() ;
        System.out.println( xu + "  " + xv);
        partie.setJoueurclick(true);
        partie.setVertexclique(v);
        System.out.println(X + " " + Y + "SOURIS ");
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
