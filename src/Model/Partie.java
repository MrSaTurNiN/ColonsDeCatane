
package Model;

import Exceptions.OutOfCardException;
import Exceptions.RootNullException;
import Exceptions.UnKnownRessource;
import Model.Batiments.Colonie;
import Model.Tuile.*;
import Model.*;
import Model.graph.Vertex;

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


	private Vertex vertexclique;
	private Boolean joueurclick;



	private Boolean actionDone;



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
		joueurclick=false;
		vertexclique=null;
		actionDone=false;
	}
	/*
		Initialise les ressources du joueur j à partir des Colonies qu'il possède.
		Il faut appeler cette fonction qu'une seule fois par partie.
	 */
	public void initMainJoueur(Joueur j)
	{
		List<Colonie> listDeColonie =  j.getListeDeColonie();
        for(Colonie c : listDeColonie) {
			Set<Tuile> setTuile = plateau.getTuileFromVertex(c.getPosition());
			for (Tuile t : setTuile) {
				if (t.getVoleur() == null) {
					try {
						obtenirRessourceTuile(t,j);
					} catch (OutOfCardException e) {
						e.printStackTrace();
					} catch (UnKnownRessource unKnownRessource) {
						unKnownRessource.printStackTrace();
					}
				}
			}
		}
    }
	/*
		Ajoute les ressources au joueur j en fonction du type de la tuile t
	 */
	public void obtenirRessourceTuile (Tuile t,Joueur j) throws OutOfCardException, UnKnownRessource{
		Ressource r = null;
		if (t instanceof Colline) {
			r = deckRessource.piocherRessource(Ressource.Argile.name());
		} else if (t instanceof Paturage) {
			r = deckRessource.piocherRessource(Ressource.Laine.name());
		} else if (t instanceof Montagne) {
			r = deckRessource.piocherRessource(Ressource.Minerai.name());
		} else if (t instanceof TerreCultivable) {
			r = deckRessource.piocherRessource(Ressource.Ble.name());
		} else if (t instanceof Foret) {
			r = deckRessource.piocherRessource(Ressource.Bois.name());
		}
		if(r != null)j.obtenirCarte(r);
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
		//on peut améliorer
	}
	public void initFicheConstruct(Joueur joueur){
		//TODO initialiser une fiche de construction pour chaque joueur
	}
	public Boolean isJoueurclick() {
		return joueurclick;
	}

	public void setJoueurclick(Boolean joueurclick) {
		this.joueurclick = joueurclick;
	}
	public Vertex getVertexclique() {
		return vertexclique;
	}

	public void setVertexclique(Vertex vertexclique) {
		this.vertexclique = vertexclique;
	}

	public Boolean getActionDone() {
		return actionDone;
	}

	public void setActionDone(Boolean actionDone) {
		this.actionDone = actionDone;
	}
}
