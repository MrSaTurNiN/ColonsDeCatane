package Model;

import Exceptions.*;
import Model.graph.Edge;
import Model.graph.Graph;
import Model.graph.Vertex;
import Model.Tuile.*;

import java.util.*;

/**
 * Created by jpabegg on 25/11/15.
 */
public class Plateau {
    private Graph graph;
    private Tuile[] tuiles = new Tuile[19];

    public Plateau () throws RootNullException
    {
        Vertex v = new Vertex();
        graph = new Graph(v);
        initTuiles();
        initVerticesTuiles();
    }

    public void creerColonie(Joueur j,Vertex v) throws ColoniePositionException {
        if (!v.isFreeToBuild()) throw new ColoniePositionException();

        v.nouveauBatiment(j);
    }

    public void creerRoute(Joueur j,Edge e) throws RoutePositionException
    {
        if(!e.isLibreRoute(j))throw new RoutePositionException();

        e.creerRoute(j);
    }

    public void creerVille(Vertex v) throws NoColonieException
    {
        if(v.getBatiment() == null)throw new NoColonieException();

        Joueur j = v.getBatiment().getJoueur();
        v.ameliorerBatiment(j);
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
    private void initTuiles()
    {
        List<Tuile> toDo = initToDo();
        List<Integer> numbersLeft = initNumbersLeft();
        Random random = new Random();
        int i = 0;
        while(!toDo.isEmpty())
        {
            Tuile t = toDo.remove(random.nextInt(toDo.size()));
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
            tuileA.addSommet(graph.getVertexIndex(4 + i));
            tuileA.addSommet(graph.getVertexIndex(7 + i));
            tuileA.addSommet(graph.getVertexIndex(8 + i));
            tuileA.addSommet(graph.getVertexIndex(12 + i));

            tuileB.addSommet(graph.getVertexIndex(39 + i));
            tuileB.addSommet(graph.getVertexIndex(43 + i));
            tuileB.addSommet(graph.getVertexIndex(44 + i));
            tuileB.addSommet(graph.getVertexIndex(47 + i));
            tuileB.addSommet(graph.getVertexIndex(48 + i));
            tuileB.addSommet(graph.getVertexIndex(51 + i));
        }
        for(int i=0;i<4;i++)
        {
            tuileA = tuiles[3 + i];
            tuileB = tuiles[12 + i];
            tuileA.addSommet(graph.getVertexIndex(7 + i));
            tuileA.addSommet(graph.getVertexIndex(11 + i));
            tuileA.addSommet(graph.getVertexIndex(12 + i));
            tuileA.addSommet(graph.getVertexIndex(16 + i));
            tuileA.addSommet(graph.getVertexIndex(17 + i));
            tuileA.addSommet(graph.getVertexIndex(22 + i));

            tuileB.addSommet(graph.getVertexIndex(28 + i));
            tuileB.addSommet(graph.getVertexIndex(33 + i));
            tuileB.addSommet(graph.getVertexIndex(34 + i));
            tuileB.addSommet(graph.getVertexIndex(38 + i));
            tuileB.addSommet(graph.getVertexIndex(39 + i));
            tuileB.addSommet(graph.getVertexIndex(43 + i));
        }
        for(int i=0;i<5;i++)
        {
            tuileA = tuiles[3 + i];
            tuileA.addSommet(graph.getVertexIndex(16 + i));
            tuileA.addSommet(graph.getVertexIndex(21 + i));
            tuileA.addSommet(graph.getVertexIndex(22 + i));
            tuileA.addSommet(graph.getVertexIndex(27 + i));
            tuileA.addSommet(graph.getVertexIndex(28 + i));
            tuileA.addSommet(graph.getVertexIndex(33 + i));
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
            if(tuiles[i].hasVertex(v))retour.add(tuiles[i]);
        }
        return retour;
    }
}
