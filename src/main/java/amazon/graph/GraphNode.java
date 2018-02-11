package amazon.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Dauren Mussa
 * @since 2/2/18
 */
public class GraphNode<T> {

    public String id;
    public String name;

    public Map<GraphNode, T> outerConnections = new HashMap<>();
    public Map<GraphNode, T> innerConnections = new HashMap<>();

    public GraphNode(String name) {
        this.name = name;
    }

    public void makeConnection(GraphNode<T> graphNode, T value) {
        this.outerConnections.put(graphNode, value);
        graphNode.innerConnections.put(this, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode<?> graphNode = (GraphNode<?>) o;
        return Objects.equals(name, graphNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GraphNode{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
