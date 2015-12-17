import Model.graph.Edge;
import Model.graph.Vertex;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Created by jpabegg on 17/12/15.
 */
public class EdgeUnitTest {
    @Test
    public void testMiddleOfTheEdge()
    {
            Vertex v1 = new Vertex();
            v1.setX(10);
            v1.setY(20);
            Vertex v2 = new Vertex();
            v2.setX(50);
            v2.setY(30);
            Edge e = new Edge(v1,v2);
            Point p = e.middleOfTheEdge();

            Assert.assertEquals(p.getX(),(10+50)/2,0);
            Assert.assertEquals(p.getY(),(20+30)/2,0);
    }

    @Test
    public void testGetOther()
    {
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Edge e = new Edge(v1,v2);
        Vertex v3 = e.getOther(v1);
        Assert.assertEquals(v2,v3);
    }

    @Test
    public void testGetOhterFail()
    {
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Edge e = new Edge(v1,v2);
        Vertex v4 = e.getOther(v3);
        Assert.assertEquals(v4,null);
    }
}
