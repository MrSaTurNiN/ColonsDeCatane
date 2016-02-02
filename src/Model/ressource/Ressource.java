package Model.ressource;

import java.io.Serializable;

/**
 * Created by jpabegg on 13/11/15.
 */
public enum Ressource implements Serializable
{

    Bois("Supraconducteur"),
    Laine("Cristaux"),
    Ble("Cellule Energetique"),
    Argile("Gas Tibanna"),
    Minerai("Duracier");
    private String nom;
    Ressource(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return nom;
    }
}
