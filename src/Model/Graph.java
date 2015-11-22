package Model;

import Exceptions.RootNullException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jip on 22/11/2015.
 */
public class Graph {
    Vertex root;
    List<Edge> edges ;

    public Graph(Vertex root) throws RootNullException {
        this.root = root;
        edges = new ArrayList<Edge>();
        if(root == null)throw new RootNullException();
        initVerticesAndEdges();
    }

    public void initVerticesAndEdges()
    {
        List<Vertex> toDo = new ArrayList<Vertex>();
        toDo.add(root);
        //On crée les noeuds et on les range dans une liste.
        for(int i = 0;i<29;i++) {
            toDo.add(new Vertex());
        }
        initSetTopEges(toDo);
        initSetLeftEdges(toDo);
        initSetRightEdges(toDo);
        System.out.println(edges.size());

    }

    private void initSetRightEdges(List<Vertex>toDo)
    {
        Edge edgeA;
        Edge edgeB;
        Vertex topA;
        Vertex topB;
        Vertex bottomA;
        Vertex bottomB;
        topA = toDo.get(0);
        topB = toDo.get(27);
        bottomA = toDo.get(2);
        bottomB = toDo.get(29);
        edgeA = new Edge(topA,bottomA);
        edgeB = new Edge(topB,bottomB);
        edgeA.setRight();
        edgeB.setRight();
        edges.add(edgeA);
        edges.add(edgeB);

        for(int i=0;i<2;i++)
        {
            topA = toDo.get(3+i);
            topB = toDo.get(22 + i);
            bottomA = toDo.get(6+i);;
            bottomB = toDo.get(25 + i);

            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
            edges.add(edgeA);
            edges.add(edgeB);
        }
        for(int i=0;i<3;i++)
        {
            topA = toDo.get(8+i);
            topB = toDo.get(15 + i);
            bottomA = toDo.get(12+i);;
            bottomB = toDo.get(19 + i);
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
            edges.add(edgeA);
            edges.add(edgeB);
        }


    }

    private void initSetLeftEdges(List<Vertex>toDo)
    {
        Edge edgeA;
        Edge edgeB;
        Vertex topA;
        Vertex topB;
        Vertex bottomA;
        Vertex bottomB;
        topA = toDo.get(0);
        topB = toDo.get(28);
        bottomA = toDo.get(1);
        bottomB = toDo.get(29);
        edgeA = new Edge(topA,bottomA);
        edgeB = new Edge(topB,bottomB);
        edgeA.setLeft();
        edgeB.setLeft();
        edges.add(edgeA);
        edges.add(edgeB);

        for(int i=0;i<2;i++)
        {
            topA = toDo.get(3+i);
            topB = toDo.get(23 + i);
            bottomA = toDo.get(5+i);;
            bottomB = toDo.get(25 + i);

            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
            edges.add(edgeA);
            edges.add(edgeB);
        }
        for(int i=0;i<3;i++)
        {
            topA = toDo.get(8+i);
            topB = toDo.get(16 + i);
            bottomA = toDo.get(11+i);;
            bottomB = toDo.get(19 + i);
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
            edges.add(edgeA);
            edges.add(edgeB);
        }
    }


    private void initSetTopEges(List<Vertex> toDo)
    {
        for(int i=0;i<2;i++)
        {
            Vertex topA = toDo.get(1+i);
            Vertex topB = toDo.get(25 + i);
            Vertex bottomA = toDo.get(3+i);;
            Vertex bottomB = toDo.get(27 + i);

            Edge edgeA = new Edge(topA,bottomA);
            Edge edgeB = new Edge(topB,bottomB);
            edgeA.setTop();
            edgeB.setTop();
            edges.add(edgeA);
            edges.add(edgeB);
        }
        for(int i=0;i<3;i++)
        {
            Vertex topA = toDo.get(5+i);
            Vertex topB = toDo.get(19 + i);
            Vertex bottomA = toDo.get(8+i);;
            Vertex bottomB = toDo.get(22 + i);
            Edge edgeA = new Edge(topA,bottomA);
            Edge edgeB = new Edge(topB,bottomB);
            edgeA.setTop();
            edgeB.setTop();
            edges.add(edgeA);
            edges.add(edgeB);
        }
        for(int i=0;i<4;i++)
        {
            Vertex topA = toDo.get(11+i);
            Vertex bottomA = toDo.get(15+i);;
            Edge edgeA = new Edge(topA,bottomA);
            edgeA.setTop();
            edges.add(edgeA);
        }
    }
}
