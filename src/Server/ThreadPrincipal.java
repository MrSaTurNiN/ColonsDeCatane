package Server;

import Model.Joueur;
import Model.Partie;

import java.util.List;

/**
 * Created by jpabegg on 02/02/16.
 */
public class ThreadPrincipal extends Thread {

    private List<Joueur> list;
    private Thread[] threads;

    public ThreadPrincipal(List<Joueur> list, Partie p){
        this.list = list;
        threads = new Thread[list.size()];
    }

    @Override
    public void run() {
        boolean continuer = true;
        while(continuer){

        }
    }
}
