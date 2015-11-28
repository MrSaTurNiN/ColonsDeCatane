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
            v =g.getVertexIndex(34);
            if(v.getY() == 170)System.out.println("Hello");
        } catch (RootNullException e) {
            e.printStackTrace();
        }
    }
}
