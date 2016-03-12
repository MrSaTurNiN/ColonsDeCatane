package Server;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ThreadClient {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private PoolObjectStream pool;
    private int numJoueur;
    public ThreadClient(Socket socket,PoolObjectStream pool,int numJoueur){
        this.socket = socket;
        this.pool = pool;
        this.numJoueur = numJoueur;
    }

    public void run(){
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            pool.addStream(numJoueur,oos);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
