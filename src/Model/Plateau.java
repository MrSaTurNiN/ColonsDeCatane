package Model;

import Exceptions.NumberSevenException;
import Exceptions.batiment.*;
import Exceptions.graph.RootNullException;
import Exceptions.ressource.RessourceIndisponibleException;
import Exceptions.ressource.SuperExceptionRessource;
import Model.Batiments.Batiment;
import Model.Batiments.Ville;
import Model.Tuile.*;
import Model.graph.Edge;
import Model.graph.Graph;
import Model.graph.Vertex;
import Model.ressource.DeckRessource;

import java.io.Serializable;
import java.util.*;

/**
 * Created by jpabegg on 25/11/15.
 */
public class Plateau implements Serializable{
    private Graph graph;
    private Tuile[] tuiles = new Tuile[19];

    public Plateau (Vertex v) throws RootNullException
    {
        graph = new Graph(v);
        initTuiles();
        initVerticesTuiles();
    }

    public Batiment creerColonie(Joueur j,Vertex v,DeckRessource deck)
            throws ColoniePositionException, NoColonieDispoException,SuperExceptionRessource {
        if (!v.isFreeToBuild()) throw new ColoniePositionException();
        if(j.getColonieDispo()==0) throw new NoColonieDispoException();
        if(deck != null){
            if(!j.hasRessourceColonie())throw new RessourceIndisponibleException();
            j.retireRessourceColonie(deck);
        }
        Batiment b=v.nouveauBatiment(j);
        return b;

    }
    public void creerRoute(Joueur j,Edge e,DeckRessource deck)
            throws RoutePositionException, NoRouteDispoException, SuperExceptionRessource
    {
        if(e==null||!e.isLibreRoute(j))throw new RoutePositionException();
        if(j.getRouteDispo()==0) throw new NoRouteDispoException();
        if(deck != null){
            System.out.println("je suis dans creerRoute je cree la route");
            if(!j.hasRessourceRoute())throw new RessourceIndisponibleException();
            j.retireRessourceRoute(deck);
        }
        e.creerRoute(j);
        j.setRouteDispo(j.getRouteDispo()-1);
    }

    public void creerVille(Vertex v,DeckRessource deck)
            throws SuperExceptionBatiment,SuperExceptionRessource
    {
        if(v.getBatiment() == null)throw new NoColonieException();
        
        System.out.println(v.getBatiment() instanceof Ville);
        Joueur j = v.getBatiment().getJoueur();
        if(j.getRouteDispo()==0) throw new NoVilleDispoException();
        if(deck != null){
            if(!j.hasRessourceVille())throw new RessourceIndisponibleException();
            j.retireRessourceVille(deck);
        }
        v.ameliorerBatiment(j);
        System.out.println(v.getBatiment() instanceof Ville);
        j.setVilleDispo(j.getVilleDispo()-1);
    }
    /*
        retourne les tuiles avec le num�ro number
     */
    public Set<Tuile> setTuileNumber(int number) throws NumberSevenException {
        if(number == 7)throw new NumberSevenException();
        Set<Tuile> result = new HashSet<Tuile>();
        for(int i = 0;i<tuiles.length;i++)
        {
            if(tuiles[i].getNumero() == number)result.add(tuiles[i]);
        }
        return result;
    }

    public Tuile[] getTuiles() {
        return tuiles;
    }

    private void initTuiles()
    {
        List<Tuile> toDo = initToDo();
        List<Integer> numbersLeft = initNumbersLeft();
        Random random = new Random();
        int i = 0;
        while(!toDo.isEmpty())
        {
            Tuile t;
            if(toDo.size() == 1){
                t = toDo.remove(0);
            }
            else
            {
                t = toDo.remove(random.nextInt(toDo.size()));
            }

            int nombre;
            if(t instanceof Desert)
            {
                tuiles[i] = t;
                i++;
            }
            else
            {
                nombre = numbersLeft.remove(random.nextInt(numbersLeft.size()));
                t.setNumero(nombre);
                tuiles[i] = t;
                i++;
            }
        }
        System.out.println(toDo.size());
    }
    private void initVerticesTuiles()
    {
        Tuile tuileA;
        Tuile tuileB;
        for(int i=0;i<3;i++)
        {
            tuileA = tuiles[i];
            tuileB = tuiles[16 + i];
            tuileA.addSommet(graph.getVertexIndex(i));
            tuileA.addSommet(graph.getVertexIndex(3 + i));
            tuileA.addSommet(graph.getVertexIndex(7 + i));
            tuileA.addSommet(graph.getVertexIndex(12 + i));
            tuileA.addSommet(graph.getVertexIndex(8 + i));
            tuileA.addSommet(graph.getVertexIndex(4 + i));


            tuileB.addSommet(graph.getVertexIndex(39 + i));
            tuileB.addSommet(graph.getVertexIndex(43 + i));
            tuileB.addSommet(graph.getVertexIndex(47 + i));
            tuileB.addSommet(graph.getVertexIndex(51 + i));
            tuileB.addSommet(graph.getVertexIndex(48 + i));
            tuileB.addSommet(graph.getVertexIndex(44 + i));


        }
        for(int i=0;i<4;i++)
        {
            tuileA = tuiles[3 + i];
            tuileB = tuiles[12 + i];
            tuileA.addSommet(graph.getVertexIndex(7 + i));
            tuileA.addSommet(graph.getVertexIndex(11 + i));
            tuileA.addSommet(graph.getVertexIndex(16 + i));
            tuileA.addSommet(graph.getVertexIndex(22 + i));
            tuileA.addSommet(graph.getVertexIndex(17 + i));
            tuileA.addSommet(graph.getVertexIndex(12 + i));

            tuileB.addSommet(graph.getVertexIndex(28 + i));
            tuileB.addSommet(graph.getVertexIndex(33 + i));
            tuileB.addSommet(graph.getVertexIndex(38 + i));
            tuileB.addSommet(graph.getVertexIndex(43 + i));
            tuileB.addSommet(graph.getVertexIndex(39 + i));
            tuileB.addSommet(graph.getVertexIndex(34 + i));
        }
        for(int i=0;i<5;i++)
        {
            tuileA = tuiles[7 + i];
            tuileA.addSommet(graph.getVertexIndex(16 + i));
            tuileA.addSommet(graph.getVertexIndex(21 + i));
            tuileA.addSommet(graph.getVertexIndex(27 + i));
            tuileA.addSommet(graph.getVertexIndex(33 + i));
            tuileA.addSommet(graph.getVertexIndex(28 + i));
            tuileA.addSommet(graph.getVertexIndex(22 + i));
        }

    }

    private List<Tuile> initToDo()
    {
        List<Tuile> toDo = new ArrayList<Tuile>();
        toDo.add(new Desert());
        for(int i=0;i<4;i++)
        {
            toDo.add(new Foret());
            toDo.add(new TerreCultivable());
            toDo.add(new Paturage());
        }
        for(int i=0;i<3;i++)
        {
            toDo.add(new Colline());
            toDo.add(new Montagne());
        }
        return toDo;
    }
    private List<Integer> initNumbersLeft()
    {
        List<Integer> retour = new ArrayList<Integer>();
        retour.add(5);
        retour.add(2);
        retour.add(6);
        retour.add(3);
        retour.add(8);
        retour.add(10);
        retour.add(9);
        retour.add(12);
        retour.add(11);
        retour.add(4);
        retour.add(8);
        retour.add(10);
        retour.add(9);
        retour.add(4);
        retour.add(5);
        retour.add(6);
        retour.add(3);
        retour.add(11);
        return retour;
    }

    /*
        retour : les tuiles qui possèdent le Vertex v
     */
    public Set<Tuile> getTuileFromVertex(Vertex v)
    {
        Set<Tuile> retour = new HashSet<Tuile>();
        for(int i = 0 ; i<tuiles.length;i++)
        {
            if(tuiles[i].hasVertex(v)) retour.add(tuiles[i]);
        }
        return retour;
    }
    
    public Set<Tuile> getTuile(int numero){
    	Set<Tuile> retour = new HashSet<Tuile>();
    	for (int i = 0; i < tuiles.length; i++) {
			if(tuiles[i].getNumero()==numero) retour.add(tuiles[i]);
		}
    	return retour;
    }
    

    public void deplaceVoleur(){
        Voleur v = null;
        Random r = new Random();
        for(int i=0;i<tuiles.length;i++){
            if(tuiles[i].getVoleur() != null){
                v = tuiles[i].getVoleur();
                tuiles[i].setVoleur(null);
            }
        }
        int i = r.nextInt(tuiles.length);
        tuiles[i].setVoleur(v);
    }

    public Graph getGraph() {
        return graph;
    }
}
