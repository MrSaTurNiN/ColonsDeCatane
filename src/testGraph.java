import Exceptions.RootNullException;
import Model.Graph;
import Model.Partie;
import Model.Vertex;
import controllers.MainController;

/**
 * Created by jpabegg on 25/11/15.
 */
public class testGraph {
    public static void main(String[] args){
        try {
            Vertex v = new Vertex();
            Graph g = new Graph(v);
            try
            {
                g.getVertexIndex(2).getUpEdge().getRoute();
            }catch(NullPointerException e)
            {
                System.out.println("OK");
            }
        } catch (RootNullException e) {
            e.printStackTrace();
        }
    }
}
