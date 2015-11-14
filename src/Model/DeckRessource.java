package Model;

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

        for (int i = 0; i < 18; i++) {
            bois.add(Ressource.Bois);
            laine.add(Ressource.Laine);
            ble.add(Ressource.Ble);
            argile.add(Ressource.Argile);
            minerai.add(Ressource.Minerai);
        }
        carteRessource.put("Bois", bois);
        carteRessource.put("Laine", laine);
        carteRessource.put("Ble", ble);
        carteRessource.put("Argile", argile);
        carteRessource.put("Minerai", minerai);

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
}
