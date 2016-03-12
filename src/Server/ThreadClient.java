package Server;

import java.net.Socket;

/**
 * Created by root on 12/03/16.
 */
public class ThreadClient {
    private Socket socket;
    public ThreadClient(Socket socket){
        this.socket = socket;

    }
}
