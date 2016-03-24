package Exceptions.click;

/**
 * Created by Jip on 13/12/2015.
 */
public class PositionsInvalidesException extends Exception {
    public String getMessage(){
        return "La position donné de correspond pas à la position d'un point";
    }
}
