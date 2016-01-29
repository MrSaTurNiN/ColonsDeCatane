package Server;

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
    }
}
