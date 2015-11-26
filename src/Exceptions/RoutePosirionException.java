package Exceptions;

/**
 * Created by Jip on 26/11/2015.
 */
public class RoutePosirionException extends Exception {
    public String getMessage()
    {
        return "La postion de la route n'est pas valide";
    }
}
