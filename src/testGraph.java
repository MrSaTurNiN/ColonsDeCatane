import Exceptions.RootNullException;
import Model.graph.Graph;
import Model.graph.Vertex;

/**
 * Created by jpabegg on 25/11/15.
 */
public class testGraph {
    public static void main(String[] args){
        Vertex v = new Vertex();
        v.setX(0);
        v.setY(0);
        try {
            Graph g = new Graph(v);
            Vertex[] vertices = g.getVertices();
            for(int i =0;i<vertices.length;i++)
            {
                System.out.println("Vertex "+i+" X="+vertices[i].getX()+"  Y="+vertices[i].getY());
            }

        } catch (RootNullException e) {
            e.printStackTrace();
        }
    }
}
