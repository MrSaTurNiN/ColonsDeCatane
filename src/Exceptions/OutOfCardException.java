package Exceptions;

/**
 * Created by FRANCOIS on 14/11/2015.
 */
public class OutOfCardException extends Exception {
    public OutOfCardException(String card){
        super("il n'y a plus de cartes "+card+" dans le deck.");
    }
}
