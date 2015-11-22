package Exceptions;

/**
 * Created by Jip on 22/11/2015.
 */
public class RootNullException extends Exception {
    @Override
    public String getMessage() {
        return "La racine du Graph est null.";
    }
}
