package Exceptions.batiment;

/**
 * Created by Jip on 26/11/2015.
 */
public class NoColonieException extends SuperExceptionBatiment{
    public String getMessage()
    {
        return "Le vertex n'a pas de colonie.";
    }
}
