package Model;

import Exceptions.RootNullException;
import Model.Batiments.Batiment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jip on 22/11/2015.
 */
public class Graph {
    Vertex root;
    Vertex[] vertices = new Vertex[54];

    public Graph(Vertex root) throws RootNullException {
        this.root = root;
        if(root == null)throw new RootNullException();
        initVerticesAndEdges();
    }

    public void initVerticesAndEdges()
    {
        vertices[0]= root;
        //On cr�e les noeuds et on les range dans une liste.
        for(int i = 1;i<54;i++) {
           vertices[i] = new Vertex();
        }
        initSetTopEges(vertices);
        initSetLeftEdges(vertices);
        initSetRightEdges(vertices);

    }

    private void initSetRightEdges(Vertex[] toDo)
    {
        Edge edgeA;
        Edge edgeB;
        Vertex topA;
        Vertex topB;
        Vertex bottomA;
        Vertex bottomB;

        for(int i=0;i<3;i++)
        {
            topA = toDo[0+i];
            topB = toDo[47 + i];
            bottomA = toDo[4+i];
            bottomB = toDo[51 + i];

            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
        for(int i=0;i<4;i++)
        {
            topA = toDo[7+i];
            topB = toDo[38 + i];
            bottomA = toDo[12+i];
            bottomB = toDo[43 + i];
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
        for(int i=0;i<5;i++)
        {
            topA = toDo[16+i];
            topB = toDo[27 + i];
            bottomA = toDo[22+i];
            bottomB = toDo[33 + i];
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
        }


    }

    private void initSetLeftEdges(Vertex[] toDo)
    {
        Edge edgeA;
        Edge edgeB;
        Vertex topA;
        Vertex topB;
        Vertex bottomA;
        Vertex bottomB;

        for(int i=0;i<3;i++)
        {
            topA = toDo[0+i];
            topB = toDo[48 + i];
            bottomA = toDo[3+i];;
            bottomB = toDo[51 + i];

            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
        for(int i=0;i<4;i++)
        {
            topA = toDo[7+i];
            topB = toDo[39 + i];
            bottomA = toDo[11+i];;
            bottomB = toDo[43 + i];
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
        for(int i=0;i<5;i++)
        {
            topA = toDo[16+i];
            topB = toDo[28 + i];
            bottomA = toDo[21+i];;
            bottomB = toDo[33 + i];
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
    }


    private void initSetTopEges(Vertex[] toDo)
    {
        for(int i=0;i<4;i++)
        {
            Vertex topA = toDo[3+i];
            Vertex topB = toDo[43 + i];
            Vertex bottomA = toDo[7+i];;
            Vertex bottomB = toDo[47 + i];

            Edge edgeA = new Edge(topA,bottomA);
            Edge edgeB = new Edge(topB,bottomB);
            edgeA.setTop();
            edgeB.setTop();
        }
        for(int i=0;i<5;i++)
        {
            Vertex topA = toDo[11+i];
            Vertex topB = toDo[33 + i];
            Vertex bottomA = toDo[16+i];;
            Vertex bottomB = toDo[38 + i];
            Edge edgeA = new Edge(topA,bottomA);
            Edge edgeB = new Edge(topB,bottomB);
            edgeA.setTop();
            edgeB.setTop();
        }
        for(int i=0;i<6;i++)
        {
            Vertex topA = toDo[21+i];
            Vertex bottomA = toDo[27+i];
            Edge edgeA = new Edge(topA,bottomA);
            edgeA.setTop();
        }
    }

    public Vertex getVertexIndex(int index)
    {
        return vertices[index];
    }

    public void addBatiment(Batiment batiment, Vertex vertex)
    {
        vertex.setBatiment(batiment);
    }

    public void addBatiment(Batiment batiment,int index)
    {
        vertices[index].setBatiment(batiment);
    }
}
