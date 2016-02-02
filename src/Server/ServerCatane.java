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

    public ServerCatane(int port, int nombreJoueur) throws IOException {
        this.nombreJoueur = nombreJoueur;
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
        for(int i = 0;i<listSocket.size();i++){
            Joueur j = new Joueur("test"+(i+1), Color.BLUE);
            list.add(j);
        }
        Partie p = new Partie(list);

    }
}
