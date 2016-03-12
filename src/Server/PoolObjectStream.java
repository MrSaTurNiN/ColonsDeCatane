package Server;

import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 12/03/16.
 */
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
}
