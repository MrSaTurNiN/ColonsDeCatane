package Model;

import Model.Batiments.Colonie;
import sun.security.util.Resources_zh_CN;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by jpabegg on 13/11/15.
 */
public class Joueur
{
    private Color couleurJoueur;
    private String nomJoueur;
    private int pointJoueur = 0;
    private int colonieDispo;
    private int villeDispo;
    private int routeDispo;
    private Map<String,List<Ressource>> mainRessource;
    private List<Developpement> mainDeveloppement;
    private List<Colonie> listeDeColonie = new ArrayList<Colonie>();

    public Joueur(String nomJoueur, Color couleurJoueur) {
        this.setNomJoueur(nomJoueur);
        this.setCouleurJoueur(couleurJoueur);
        mainRessource = new HashMap<String,List<Ressource>>();
        mainDeveloppement=new ArrayList<Developpement>();
        initMainRessource();
        setColonieDispo(5);
        setVilleDispo(4);
        setRouteDispo(15);
    }

    public void obtenirCarte(Ressource r)
    {
        if(mainRessource.containsKey(r.name()))
        {
            this.mainRessource.get(r.name()).add(r);
        }
        else
        {
            this.mainRessource.put(r.name(), new ArrayList<Ressource>());
            this.mainRessource.get(r.name()).add(r);
        }

    }
    public void obtenirCarte(Developpement d)
    {
        this.mainDeveloppement.add(d);
    }

    public Ressource retirerCarte(String s)
    {
        if(mainRessource.containsKey(s) && !mainRessource.get(s).isEmpty())
        {
            int size = mainRessource.get(s).size();
            Ressource tmp = mainRessource.get(s).get(size-1);
            mainRessource.get(s).remove(size-1);
            return tmp;
        }
        return null;
    }
    public void initMainRessource(){
        this.mainRessource.put(Ressource.Argile.name(), new ArrayList<Ressource>());
        this.mainRessource.put(Ressource.Bois.name(), new ArrayList<Ressource>());
        this.mainRessource.put(Ressource.Ble.name(), new ArrayList<Ressource>());
        this.mainRessource.put(Ressource.Laine.name(), new ArrayList<Ressource>());
        this.mainRessource.put(Ressource.Minerai.name(), new ArrayList<Ressource>());

    }
    public int getPointJoueur() {
        return pointJoueur;
    }

    public void setPointJoueur(int pointJoueur) {
        this.pointJoueur += pointJoueur;
    }

	public Color getCouleurJoueur() {
		return couleurJoueur;
	}

	public void setCouleurJoueur(Color couleurJoueur) {
		this.couleurJoueur = couleurJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public Map<String,List<Ressource>> getMainRessource() {
		return mainRessource;
	}


	public List<Developpement> getMainDeveloppement() {
		return mainDeveloppement;
	}


    public List<Colonie> getListeDeColonie() {
        return listeDeColonie;
    }

    public void placerColonie(Colonie colo){
        listeDeColonie.add(colo);
        setPointJoueur(1);
    }

	public int getColonieDispo() {
		return colonieDispo;
	}

	public void setColonieDispo(int colonieDispo) {
		this.colonieDispo = colonieDispo;
	}

	public int getVilleDispo() {
		return villeDispo;
	}

	public void setVilleDispo(int villeDispo) {
		this.villeDispo = villeDispo;
	}

	public int getRouteDispo() {
		return routeDispo;
	}

	public void setRouteDispo(int routeDispo) {
		this.routeDispo = routeDispo;
	}

    public int nombreCarteRessource(){
        int i = 0;
        Set<String> clef = mainRessource.keySet();
        Iterator<String> iterator = clef.iterator();
        while(iterator.hasNext()){
            i = i + mainRessource.get(iterator.next()).size();
        }
        return i;
    }

    public void retireRessource(DeckRessource deckRessource){
        int i = 0;
        int nbRetire;
        int nb = nombreCarteRessource()/2;
        Random random = new Random();
        String[] clefs = new String[mainRessource.size()];
        Set<String> clef = mainRessource.keySet();
        Iterator<String> iterator = clef.iterator();

        while(iterator.hasNext()){
            clefs[i] = iterator.next();
            i++;
        }
        while (nb>=0){
            //On sélectionne aléatoirement un type de ressource
            i = random.nextInt(clefs.length);
            List<Ressource> ressource = mainRessource.get(clefs[i]);
            //On vérifie qu'on peut retirer des ressources de ce type
            if(ressource.size()>0){
                //Sélection du nombre de carte à enlever
                nbRetire = random.nextInt(ressource.size());
                if(nbRetire <= nb){
                    nb-=nbRetire;
                    //On retire les cartes et on les ajoute à la banque
                    for(int j = 0;j<nbRetire;j++){
                        Ressource r = retirerCarte(clefs[i]);
                        deckRessource.obtenirRessource(r);
                    }
                }
            }
        }
    }

    public boolean hasRessourceRoute(){
        boolean hasArgile = false;
        boolean hasBois = false;
        if(mainRessource.get(Ressource.Argile.name()).size() >= 1){
            hasArgile = true;
        }
        if(mainRessource.get(Ressource.Bois.name()).size() >= 1){
            hasBois = true;
        }
        return hasBois && hasArgile;
    }

    public boolean hasRessourceVille(){
        boolean hasBle = false;
        boolean hasMinerai = false;
        if(mainRessource.get(Ressource.Ble.name()).size() >= 2){
            hasBle = true;
        }
        if(mainRessource.get(Ressource.Minerai.name()).size() >= 3){
            hasMinerai = true;
        }
        return hasBle && hasMinerai;
    }
    public boolean hasRessourceColonie(){
        boolean hasArgile = false;
        boolean hasBois = false;
        boolean hasLaine = false;
        boolean hasBle = false;
        if(mainRessource.get(Ressource.Argile.name()).size() >= 1){
            hasArgile = true;
        }
        if(mainRessource.get(Ressource.Bois.name()).size() >= 1){
            hasBois = true;
        }
        if(mainRessource.get(Ressource.Ble.name()).size() >= 1){
            hasBle = true;
        }
        if(mainRessource.get(Ressource.Laine.name()).size() >= 1){
            hasLaine= true;
        }
        return hasLaine && hasArgile && hasBle && hasBois;
    }

    public void retireRessourceColonie(DeckRessource deck) {
        deck.obtenirRessource(retirerCarte(Ressource.Argile.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Bois.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Ble.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Laine.name()));
    }

    public void retireRessourceRoute(DeckRessource deck){
        deck.obtenirRessource(retirerCarte(Ressource.Argile.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Bois.name()));
    }

    public void retireRessourceVille(DeckRessource deck){
        deck.obtenirRessource(retirerCarte(Ressource.Ble.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Ble.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Minerai.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Minerai.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Minerai.name()));
    }
}
