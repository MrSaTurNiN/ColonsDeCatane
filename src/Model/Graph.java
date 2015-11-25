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
    Vertex[] vertices = new Vertex[30];

    public Graph(Vertex root) throws RootNullException {
        this.root = root;
        if(root == null)throw new RootNullException();
        initVerticesAndEdges();
    }

    public void initVerticesAndEdges()
    {
        vertices[0]= root;
        //On cr�e les noeuds et on les range dans une liste.
        for(int i = 1;i<30;i++) {
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
        topA = toDo[0];
        topB = toDo[27];
        bottomA = toDo[2];
        bottomB = toDo[29];
        edgeA = new Edge(topA,bottomA);
        edgeB = new Edge(topB,bottomB);
        edgeA.setRight();
        edgeB.setRight();

        for(int i=0;i<2;i++)
        {
            topA = toDo[3+i];
            topB = toDo[22 + i];
            bottomA = toDo[6+i];
            bottomB = toDo[25 + i];

            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
        for(int i=0;i<3;i++)
        {
            topA = toDo[8+i];
            topB = toDo[15 + i];
            bottomA = toDo[12+i];
            bottomB = toDo[19 + i];
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
        topA = toDo[0];
        topB = toDo[28];
        bottomA = toDo[1];
        bottomB = toDo[29];
        edgeA = new Edge(topA,bottomA);
        edgeB = new Edge(topB,bottomB);
        edgeA.setLeft();
        edgeB.setLeft();

        for(int i=0;i<2;i++)
        {
            topA = toDo[3+i];
            topB = toDo[23 + i];
            bottomA = toDo[5+i];;
            bottomB = toDo[25 + i];

            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
        for(int i=0;i<3;i++)
        {
            topA = toDo[8+i];
            topB = toDo[16 + i];
            bottomA = toDo[11+i];;
            bottomB = toDo[19 + i];
            edgeA = new Edge(topA,bottomA);
            edgeB = new Edge(topB,bottomB);
            edgeA.setLeft();
            edgeB.setLeft();
        }
    }


    private void initSetTopEges(Vertex[] toDo)
    {
        for(int i=0;i<2;i++)
        {
            Vertex topA = toDo[1+i];
            Vertex topB = toDo[25 + i];
            Vertex bottomA = toDo[3+i];;
            Vertex bottomB = toDo[27 + i];

            Edge edgeA = new Edge(topA,bottomA);
            Edge edgeB = new Edge(topB,bottomB);
            edgeA.setTop();
            edgeB.setTop();
        }
        for(int i=0;i<3;i++)
        {
            Vertex topA = toDo[5+i];
            Vertex topB = toDo[19 + i];
            Vertex bottomA = toDo[8+i];;
            Vertex bottomB = toDo[22 + i];
            Edge edgeA = new Edge(topA,bottomA);
            Edge edgeB = new Edge(topB,bottomB);
            edgeA.setTop();
            edgeB.setTop();
        }
        for(int i=0;i<4;i++)
        {
            Vertex topA = toDo[11+i];
            Vertex bottomA = toDo[15+i];
            Edge edgeA = new Edge(topA,bottomA);
            edgeA.setTop();
        }
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
