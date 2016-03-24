package Exceptions.batiment;

/**
 * Created by Victor on 12/13/2015.
 */
public class nbBatimentTooHigh extends SuperExceptionBatiment {
    public String name;
    public nbBatimentTooHigh(String name){
        this.name=name;
    }
    public String getMessage() {
        return "Vous avez atteint le nombre maximal de "+name+" placées sur le plateau";
    }
}
