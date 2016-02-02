package Model.ressource;

import Exceptions.ressource.OutOfCardException;
import Exceptions.ressource.UnKnownRessource;

import java.io.Serializable;
import java.util.*;

/**
 * Created by jpabegg on 13/11/15.
 */
public class DeckRessource implements Serializable{

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
                System.out.println(carteRessource.get(clef));
                carteRessource.get(clef).remove(carteRessource.get(clef).size() - 1);
                System.out.println(carteRessource.get(clef));
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
    public void retirerAleatoirement(DeckRessource deckRessource) throws OutOfCardException, UnKnownRessource {
        int i = 0;
        int nbRetire;
        int nb = nombreCarteRessource()/2;
        Random random = new Random();
        String[] clefs = new String[carteRessource.size()];
        Set<String> clef = carteRessource.keySet();
        Iterator<String> iterator = clef.iterator();

        while(iterator.hasNext()){
            clefs[i] = iterator.next();
            i++;
        }
        while (nb>=0){
            //On sélectionne aléatoirement un type de ressource
            i = random.nextInt(clefs.length);
            List<Ressource> ressource = carteRessource.get(clefs[i]);
            //On vérifie qu'on peut retirer des ressources de ce type
            if(ressource.size()>0){
                //Sélection du nombre de carte à enlever
                nbRetire = random.nextInt(ressource.size());
                if(nbRetire <= nb){
                    nb-=nbRetire;
                    //On retire les cartes et on les ajoute à la banque
                    for(int j = 0;j<nbRetire;j++){

                        Ressource r = piocherRessource(clefs[i]);
                        deckRessource.obtenirRessource(r);
                    }
                }
            }
        }
    }
    public void obtenirRessource(Ressource r)
    {
        carteRessource.get(""+r.name()).add(r);
    }
    
    public Map<String,List<Ressource>> getCarteRessource(){
    	return this.carteRessource;
    }

    public Set<Map.Entry<String,List<Ressource>>> entrySet(){
        return carteRessource.entrySet();
    }

    public Set<String> keySet(){
        return carteRessource.keySet();
    }
    public int size(){
        return carteRessource.size();
    }

    public int nombreCarteRessource(){
        int i = 0;
        Set<String> clef = carteRessource.keySet();
        Iterator<String> iterator = clef.iterator();
        while(iterator.hasNext()){
            i = i + carteRessource.get(iterator.next()).size();
        }
        return i;
    }

    public int size(String clef){
        return carteRessource.get(clef).size();
    }
}
