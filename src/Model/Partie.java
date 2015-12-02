
package Model;

import Exceptions.RootNullException;
import Model.graph.Vertex;
import Model.Tuile.Tuile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by jpabegg on 13/11/15.
 */
public class Partie {
	private List<Joueur> listeJoueur;
	private Des des;
	private DeckRessource deckRessource;
	private DeckDeveloppement deckDeveloppement;
	private Joueur joueurActif;
	private Plateau plateau;

	public Partie() {
		listeJoueur = new ArrayList<Joueur>();
		Vertex racine = new Vertex();
		racine.setX(300);
		racine.setY(100);

		try {
			plateau = new Plateau(racine);
		} catch (RootNullException e) {
			e.printStackTrace();
			System.exit(1);
		}

		deckRessource=new DeckRessource();
		deckDeveloppement=new DeckDeveloppement();
	}
	public void initMainJoueur(Joueur j)
	{
		//TODO récupérer les cartes dans le deck ressource et ajouter le bon nombre de carte dans la main du joueur j
	}
	public DeckRessource getDeckRessource() {
		return deckRessource;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public DeckDeveloppement getDeckDeveloppement() {
		return deckDeveloppement;
	}

	public List<Joueur> getListeJoueur(){
		return listeJoueur;
	}
	
	public void setListeJoueur(List<Joueur> listeJoueur){
		this.listeJoueur=listeJoueur;
	}

	public Joueur getJoueurActif() {
		return joueurActif;
	}

	public void setJoueurActif(Joueur joueurActif) {
		this.joueurActif = joueurActif;
	}
	
	public void creerJoueur(String nomJoueur, Color couleurJoueur ){
		listeJoueur.add(new Joueur(nomJoueur, couleurJoueur));
		if (joueurActif==null) {
			setJoueurActif(listeJoueur.get(0));
		}
	}


	public void setOrdreJoueur(){
		//TODO définir l'ordre dans lequel les joueurs vont jouer
	}
}
