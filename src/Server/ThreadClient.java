package Server;

import Model.Joueur;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ThreadClient extends Thread{
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private PoolObjectStream pool;
    private int numJoueur;
    public ThreadClient(Socket socket,PoolObjectStream pool,int numJoueur){
        this.socket = socket;
        this.pool = pool;
        this.numJoueur = numJoueur;

        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            pool.addStream(numJoueur,oos);
        } catch (IOException e) {
            System.exit(1);
        }

    }
    public synchronized void handshake(){
        try {
            oos.writeInt(numJoueur);
            oos.flush();
            Joueur joueur = (Joueur)ois.readObject();
            pool.sendJoueur(numJoueur,joueur);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run(){
    }
}
