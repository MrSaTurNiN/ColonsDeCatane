package Exceptions.ressource;

/**
 * Created by jpabegg on 17/12/15.
 */
public class RessourceIndisponibleException extends OutOfCardException {
    public RessourceIndisponibleException(String s){
        super(s);
    }

    public RessourceIndisponibleException(){
        super("Il ne possède pas les ressources pour construire le batiment.");
    }
}
