package Exceptions;

import Model.Ressource;

import javax.annotation.Resource;

/**
 * Created by FRANCOIS on 14/11/2015.
 */
public class OutOfCardException extends Exception {
    public OutOfCardException(String card){
        System.out.println("il n'y a plus de cartes "+card+" dans la banque.");
    }
}
