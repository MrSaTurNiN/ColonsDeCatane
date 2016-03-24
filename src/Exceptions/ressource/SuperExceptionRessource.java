package Exceptions.ressource;

/**
 * Created by Jip on 22/12/2015.
 */
public class SuperExceptionRessource extends Exception {
    String s;
    SuperExceptionRessource(){

    }
    SuperExceptionRessource(String s){
      this.s = s;
    }

    public String getMessage(){
        return s;
    }
}
