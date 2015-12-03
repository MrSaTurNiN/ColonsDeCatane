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
        int Y = e.getY();
        Vertex v = partie.getPlateau().getGraph().converstionXY(X,Y);
        System.out.println(v.getX()+"  "+v.getY());
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
