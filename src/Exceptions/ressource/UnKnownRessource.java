package Exceptions.ressource;

/**
 * Created by FRANCOIS on 14/11/2015.
 */
public class UnKnownRessource extends SuperExceptionRessource{
    public UnKnownRessource(String clef){
        System.out.println("Ressource "+clef+" inconnue");
    }
}
