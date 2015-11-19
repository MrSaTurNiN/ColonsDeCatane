package Model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpabegg on 13/11/15.
 */
public class Partie {
	private List<Joueur> listeJoueur;
	private Des des;
	private DeckRessource deckRessource;
	private DeckDeveloppement deckDeveloppement;

	public Partie() {
		listeJoueur = new ArrayList<Joueur>();
		Joueur j1 = new Joueur("joueur 1", new Color(0, 0, 200));
		listeJoueur.add(j1);
		deckRessource=new DeckRessource();
		deckDeveloppement=new DeckDeveloppement();
	}

	public Des getDes() {
		return des;
	}

	public void setDes(Des des) {
		this.des = des;
	}

	public DeckRessource getDeckRessource() {
		return deckRessource;
	}

	public void setDeckRessource(DeckRessource deckRessource) {
		this.deckRessource = deckRessource;
	}

	public DeckDeveloppement getDeckDeveloppement() {
		return deckDeveloppement;
	}

	public void setDeckDeveloppement(DeckDeveloppement deckDeveloppement) {
		this.deckDeveloppement = deckDeveloppement;
	}
	public List<Joueur> getListeJoueur(){
		return listeJoueur;
	}
	
	public void setListeJoueur(List<Joueur> listeJoueur){
		this.listeJoueur=listeJoueur;
	}
}
