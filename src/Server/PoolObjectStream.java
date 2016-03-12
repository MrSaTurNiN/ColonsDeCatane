package Server;

import Model.Joueur;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class PoolObjectStream {
    private Map<Integer,ObjectOutputStream> pool;
    public PoolObjectStream() {
        pool = new HashMap<Integer, ObjectOutputStream>();
    }

    public synchronized void addStream(int id,ObjectOutputStream stream){
        pool.put(id,stream);
    }

    public synchronized void removeStream(int id){
        pool.remove(id);
    }

    public synchronized void sendJoueur(int id, Joueur joueur){
        Set<Integer> keyset = pool.keySet();
        Iterator<Integer> iterator = keyset.iterator();
        while(iterator.hasNext()){
            int i = iterator.next();
            if(i != id){
                ObjectOutputStream oos = pool.get(i);
                try {
                    oos.writeObject(Protocole.ENVOIE_JOUEUR);
                    oos.writeInt(id);
                    oos.writeObject(joueur);
                    oos.flush();
                } catch (IOException e) {

                }
            }
        }
    }
}
