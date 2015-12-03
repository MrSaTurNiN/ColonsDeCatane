
package Model;

import Exceptions.RootNullException;
import Model.Batiments.Colonie;
import Model.Tuile.Colline;
import Model.graph.Vertex;
import Model.Tuile.Tuile;

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
	public void initMainJoueur(Joueur j)
	{
		List<Colonie> listDeColonie =  j.getListeDeColonie();
        Colonie c = listDeColonie.get(0);
        Set<Tuile> setTuile = plateau.getTuileFromVertex(c.getPosition());
        for(Tuile t : setTuile){

            if(t.getName() == "Colline") {
                j.obtenirCarte(Ressource.Argile);
            }
            else if (t.getName() == "Paturage") {
                j.obtenirCarte(Ressource.Laine);
            }
            else if (t.getName() == "Montagne") {
                j.obtenirCarte(Ressource.Minerai);
            }
            else if (t.getName() == "TerreCultivable") {
                j.obtenirCarte(Ressource.Ble);
            }
            else if (t.getName() == "Foret") {
                j.obtenirCarte(Ressource.Bois);
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
