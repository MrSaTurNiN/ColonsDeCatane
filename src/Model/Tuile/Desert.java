package Model.Tuile;

import Model.Voleur;

/**
 * Created by jpabegg on 25/11/15.
 */
public class Desert extends Tuile{
    public Desert()
    {
        voleur = new Voleur();
    }

    public String getName(){
        return "Desert";
    }
}
