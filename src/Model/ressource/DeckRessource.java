package Model.ressource;

import Exceptions.OutOfCardException;
import Exceptions.UnKnownRessource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jpabegg on 13/11/15.
 */
public class DeckRessource {

    private Map<String,List<Ressource>> carteRessource;

    public DeckRessource()
    {
        carteRessource = new HashMap<String,List<Ressource>>();
        initRessource();
    }

    private void initRessource()
    {
        List<Ressource> bois=new ArrayList<Ressource>();
        List<Ressource> laine=new ArrayList<Ressource>();
        List<Ressource> ble=new ArrayList<Ressource>();
        List<Ressource> argile=new ArrayList<Ressource>();
        List<Ressource> minerai=new ArrayList<Ressource>();
        carteRessource.put(Ressource.Bois.name(), bois);
        carteRessource.put(Ressource.Laine.name(), laine);
        carteRessource.put(Ressource.Ble.name(), ble);
        carteRessource.put(Ressource.Argile.name(), argile);
        carteRessource.put(Ressource.Minerai.name(), minerai);

    }

    public Ressource piocherRessource(String clef) throws OutOfCardException, UnKnownRessource
    {
        Ressource carte;
        if (carteRessource.containsKey(clef)){
            if (carteRessource.get(clef).size()!=0){
                carte =carteRessource.get(clef).get(carteRessource.get(clef).size()-1);
                carteRessource.get(clef).remove(carteRessource.get(clef).size()-1);
                return carte;
            }
            else {
                throw new OutOfCardException(clef);
            }
        }
        else {
            throw  new UnKnownRessource(clef);
        }
    }

    public void obtenirRessource(Ressource r)
    {
        carteRessource.get(""+r.name()).add(r);
    }
    
    public Map<String,List<Ressource>> getCarteRessource(){
    	return this.carteRessource;
    }
}
