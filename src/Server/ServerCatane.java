package Server;

import Model.Joueur;
import Model.Partie;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpabegg on 29/01/16.
 */
public class ServerCatane {
    private List<Socket> listSocket;
    private int nombreJoueur;
    private ServerSocket socketConn;
    private PoolObjectStream pool;

    public ServerCatane(int port, int nombreJoueur) throws IOException {
        this.nombreJoueur = nombreJoueur;
        pool = new PoolObjectStream();
        socketConn = new ServerSocket(port);

    }

    public void connLoop(){
        listSocket = new ArrayList<Socket>();
        while(listSocket.size()<nombreJoueur){
            try {
                Socket socket = socketConn.accept();
                listSocket.add(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        initJoueur();
    }

    private void initJoueur() {
        List<Joueur> list = new ArrayList<Joueur>();
        List<Thread> threads = new ArrayList<Thread>();
        for(int i = 0;i<listSocket.size();i++){
            Thread t = new ThreadClient(listSocket.get(i),pool,i);
            threads.add(t);
        }
        for(int i = 0;i<listSocket.size();i++){
            ThreadClient t = (ThreadClient)threads.get(i);
            t.handshake();
        }
    }
}
