package views.panels;

import Model.graph.Edge;
import javafx.scene.shape.Line;

/**
 * Created by Mahel Sif on 02/02/2016.
 */
public class LineEdge {
    Line line;
    Edge edge;


    public LineEdge(Line l, Edge e)
    {
        this.line = l;
        this.edge = e;
    }

    public Line getLine() {
        return line;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
