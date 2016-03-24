package Exceptions.batiment;

/**
 * Created by Jip on 26/11/2015.
 */
public class ColoniePositionException extends SuperExceptionBatiment {
    public String getMessage()
    {
        return "Les croisements adjacents � la colonie ne sont pas vides";
    }
}
