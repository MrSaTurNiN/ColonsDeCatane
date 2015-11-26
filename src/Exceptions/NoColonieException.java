package Exceptions;

/**
 * Created by Jip on 26/11/2015.
 */
public class NoColonieException extends Exception{
    public String getMessage()
    {
        return "Le vertex n'a pas de colonie.";
    }
}
