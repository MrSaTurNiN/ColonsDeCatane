
package Model;

import Exceptions.OutOfCardException;
import Exceptions.RootNullException;
import Exceptions.UnKnownRessource;
import Model.Batiments.Colonie;
import Model.Tuile.*;
import Model.graph.Vertex;
import controllers.Timer.GameTimer;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
	private List<Color> listCouleur;
	private int nbTour;
	private int nbJoueur;
	private Timer timer;
	private List<Laser> listelaser;

	public Partie() {
		setNbTour(0);
		initListCouleur();
		listeJoueur = new ArrayList<Joueur>();
		Vertex racine = new Vertex();
		racine.setX(280);
		racine.setY(130);

		try {
			plateau = new Plateau(racine);
		} catch (RootNullException e) {
			e.printStackTrace();
			System.exit(1);
		}

		deckRessource=new DeckRessource();
		deckDeveloppement=new DeckDeveloppement();

		timer=new Timer(16, new GameTimer());
	}
	/*
		Initialise les ressources du joueur j à partir des Colonies qu'il possède.
		Il faut appeler cette fonction qu'une seule fois par partie.
	 */
	public void setLaunched(){
		timer.start();
	}
	public void initMainJoueur(Joueur j)
	{
		List<Colonie> listDeColonie =  j.getListeDeColonie();
        Colonie c=listDeColonie.get(listDeColonie.size()-1);
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
		setJoueurActif(listeJoueur.get(listeJoueur.size() - 1));
	}

	public void setOrdreJoueur(){
		List<Joueur> joueurtmp=new ArrayList<Joueur>();
		Random r = new Random();
        int ran;
        while (listeJoueur.size()!=0) {
            ran = r.nextInt(listeJoueur.size());
            joueurtmp.add(listeJoueur.get(ran));
            listeJoueur.remove(ran);
        }
        listeJoueur=joueurtmp;
	}
	public void initFicheConstruct(Joueur joueur){
		//TODO initialiser une fiche de construction pour chaque joueur
	}

	public int getNbJoueur() {
		return nbJoueur;
	}
	public void setNbJoueur(int nbJoueur) {
		this.nbJoueur = nbJoueur;
	}
	public List<Color> getListCouleur() {
		return listCouleur;
	}
	public void setListCouleur(List<Color> listCouleur) {
		this.listCouleur = listCouleur;
	}
	public void initListCouleur(){
		listCouleur = new ArrayList<Color>();
		listCouleur.add(Color.BLUE);
		listCouleur.add(Color.GREEN);
		listCouleur.add(Color.RED);
		listCouleur.add(Color.YELLOW);
	}
	public int getNbTour() {
		return nbTour;
	}
	public void setNbTour(int nbTour) {
		this.nbTour = nbTour;
	}
	public void inversOrdre(){
		List<Joueur> joueurtmp=new ArrayList<Joueur>();
		for (int i = listeJoueur.size()-1; i >=0; i--) {
			joueurtmp.add(listeJoueur.get(i));
		}
		listeJoueur=joueurtmp;
	}
	public void update(){

	}



}
