
package Model;

import Exceptions.OutOfCardException;
import Exceptions.RootNullException;
import Model.Batiments.Colonie;
import Model.Tuile.*;
import Model.graph.Vertex;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

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
	public void initMainJoueur(Joueur j) {
		List<Colonie> listDeColonie =  j.getListeDeColonie();
        Colonie c = listDeColonie.get(0);
        Set<Tuile> setTuile = plateau.getTuileFromVertex(c.getPosition());
        for(Tuile t : setTuile){
			Ressource r;
			if(t.getVoleur() == null) {
				try {
					if (t instanceof Colline) {
						r = deckRessource.piocherRessource(Ressource.Argile.name());
						j.obtenirCarte(r);
					} else if (t instanceof Paturage) {
						r = deckRessource.piocherRessource(Ressource.Laine.name());
						j.obtenirCarte(r);
					} else if (t instanceof Montagne) {
						r = deckRessource.piocherRessource(Ressource.Minerai.name());
						j.obtenirCarte(r);
					} else if (t instanceof TerreCultivable) {
						r = deckRessource.piocherRessource(Ressource.Ble.name());
						j.obtenirCarte(r);
					} else if (t instanceof Foret) {
						r = deckRessource.piocherRessource(Ressource.Bois.name());
						j.obtenirCarte(r);
					}
				}
				catch(Exception e){
					System.exit(1);
				}
			}
        }
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
		List<Joueur> joueurtmp=new ArrayList<Joueur>();
		Random r=new Random();
		for (int i = 0; i <listeJoueur.size(); i++) {
			joueurtmp.add(listeJoueur.get(r.nextInt()*listeJoueur.size()));
		}
		listeJoueur=joueurtmp;
	}
	public void initFicheConstruct(Joueur joueur){
		//TODO initialiser une fiche de construction pour chaque joueur
	}
}
