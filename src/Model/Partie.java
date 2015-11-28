
package Model;

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

	public Partie() {
		listeJoueur = new ArrayList<Joueur>();
		
		
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
	/*
		Transforme la Tuile donnée en paramètre en un Polygon qu'on peut dessiner avec l'objet Graphics
	 */
	public Polygon transformTuile(Tuile t)
	{
		Set<Vertex> sommets = t.getSommets();
		int[] x = new int[sommets.size()];
		int[] y = new int[sommets.size()];
		Iterator<Vertex> iterator = sommets.iterator();
		int i = 0;
		while(iterator.hasNext())
		{
			Vertex v = iterator.next();
			x[i] = v.getX();
			y[i] = v.getY();
			i++;
		}
		return new Polygon(x,y,x.length);
	}

	public void setOrdreJoueur(){
		//TODO définir l'ordre dans lequel les joueurs vont jouer
	}
}
