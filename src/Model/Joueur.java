package Model;

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
    private Map<String,List<Ressource>> mainRessource;
    private List<Developpement> mainDeveloppement;


    public Joueur(String nomJoueur, Color couleurJoueur) {
        this.setNomJoueur(nomJoueur);
        this.setCouleurJoueur(couleurJoueur);
        mainRessource = new HashMap<String,List<Ressource>>();
        mainDeveloppement=new ArrayList<Developpement>();
    }

    public void obtenirCarte(Ressource r)
    {

    }
    public void obtenirCarte(Developpement d)
    {

    }

    public Ressource retirerCarte(String s)
    {
        return null;
    }
    public int getPointJoueur() {
        return pointJoueur;
    }

    public void setPointJoueur(int pointJoueur) {
        this.pointJoueur = pointJoueur;
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

	public void setMainRessource(Map<String,List<Ressource>> mainRessource) {
		this.mainRessource = mainRessource;
	}

	public List<Developpement> getMainDeveloppement() {
		return mainDeveloppement;
	}

	public void setMainDeveloppement(List<Developpement> mainDeveloppement) {
		this.mainDeveloppement = mainDeveloppement;
	}
    


}
