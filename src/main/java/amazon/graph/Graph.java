package amazon.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 2/2/18
 */
public class Graph<T> {

    public String name;

    public List<GraphNode<T>> nodes = new LinkedList<>();

}
