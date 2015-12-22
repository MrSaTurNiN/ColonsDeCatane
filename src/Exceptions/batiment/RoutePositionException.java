package Exceptions.batiment;

/**
 * Created by Jip on 26/11/2015.
 */
public class RoutePositionException extends SuperExceptionBatiment {
    public String getMessage()
    {
        return "La postion de la route n'est pas valide";
    }
}
