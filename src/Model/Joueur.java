package Model;

import Exceptions.OutOfCardException;
import Exceptions.UnKnownRessource;
import Model.Batiments.Colonie;
import Model.ressource.DeckRessource;
import Model.ressource.Ressource;

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
    private DeckRessource mainRessource;
    private List<Developpement> mainDeveloppement;
    private List<Colonie> listeDeColonie = new ArrayList<Colonie>();

    public Joueur(String nomJoueur, Color couleurJoueur) {
        this.setNomJoueur(nomJoueur);
        this.setCouleurJoueur(couleurJoueur);
        mainRessource = new DeckRessource();
        mainDeveloppement=new ArrayList<Developpement>();
        setColonieDispo(5);
        setVilleDispo(4);
        setRouteDispo(15);
    }

    public void obtenirCarte(Ressource r)
    {
        mainRessource.obtenirRessource(r);
    }
    public void obtenirCarte(Developpement d)
    {
        this.mainDeveloppement.add(d);
    }

    public Ressource retirerCarte(String s) throws OutOfCardException, UnKnownRessource {
        return mainRessource.piocherRessource(s);
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

	public DeckRessource getMainRessource() {
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


    public void retireRessource(DeckRessource deckRessource) throws OutOfCardException, UnKnownRessource {
        mainRessource.retirerAleatoirement(deckRessource);
    }

    public int nombreCarteRessource(){
        return mainRessource.nombreCarteRessource();
    }

    public boolean hasRessourceRoute(){
        boolean hasArgile = false;
        boolean hasBois = false;
        if(mainRessource.size(Ressource.Argile.name()) >= 1){
            hasArgile = true;
        }
        if(mainRessource.size(Ressource.Bois.name()) >= 1){
            hasBois = true;
        }
        return hasBois && hasArgile;
    }

    public boolean hasRessourceVille(){
        boolean hasBle = false;
        boolean hasMinerai = false;
        if(mainRessource.size(Ressource.Ble.name()) >= 2){
            hasBle = true;
        }
        if(mainRessource.size(Ressource.Minerai.name()) >= 3){
            hasMinerai = true;
        }
        return hasBle && hasMinerai;
    }
    public boolean hasRessourceColonie(){
        boolean hasArgile = false;
        boolean hasBois = false;
        boolean hasLaine = false;
        boolean hasBle = false;
        if(mainRessource.size(Ressource.Argile.name()) >= 1){
            hasArgile = true;
        }
        if(mainRessource.size(Ressource.Bois.name()) >= 1){
            hasBois = true;
        }
        if(mainRessource.size(Ressource.Ble.name()) >= 1){
            hasBle = true;
        }
        if(mainRessource.size(Ressource.Laine.name()) >= 1){
            hasLaine= true;
        }
        return hasLaine && hasArgile && hasBle && hasBois;
    }

    public void retireRessourceColonie(DeckRessource deck) throws OutOfCardException, UnKnownRessource {
        deck.obtenirRessource(retirerCarte(Ressource.Argile.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Bois.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Ble.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Laine.name()));
    }

    public void retireRessourceRoute(DeckRessource deck)throws OutOfCardException, UnKnownRessource{
        deck.obtenirRessource(retirerCarte(Ressource.Argile.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Bois.name()));
    }

    public void retireRessourceVille(DeckRessource deck)throws OutOfCardException, UnKnownRessource{
        deck.obtenirRessource(retirerCarte(Ressource.Ble.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Ble.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Minerai.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Minerai.name()));
        deck.obtenirRessource(retirerCarte(Ressource.Minerai.name()));
    }
}
