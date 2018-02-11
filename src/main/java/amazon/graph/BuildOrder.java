package amazon.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Dauren Mussa
 * @since 2/2/18
 */
public class BuildOrder {

    public static void main(String[] args) {
        GraphNode<Integer> nodeA = new GraphNode<>("A");
        GraphNode<Integer> nodeB = new GraphNode<>("B");
        GraphNode<Integer> nodeC = new GraphNode<>("C");
        GraphNode<Integer> nodeD = new GraphNode<>("D");
        GraphNode<Integer> nodeE = new GraphNode<>("E");
        GraphNode<Integer> nodeF = new GraphNode<>("F");

        nodeF.makeConnection(nodeA, 0);
        nodeF.makeConnection(nodeB, 0);

        nodeB.makeConnection(nodeC, 0);

        nodeC.makeConnection(nodeA, 0);
        nodeC.makeConnection(nodeD, 0);
        //nodeD.makeConnection(nodeE, 0);


        Graph<Integer> graph = new Graph<>();
        graph.nodes.add(nodeA);
        graph.nodes.add(nodeB);
        graph.nodes.add(nodeC);
        graph.nodes.add(nodeD);
        graph.nodes.add(nodeE);
        graph.nodes.add(nodeF);

        System.out.println(buildList(graph));

    }

    public static Set<GraphNode> getList(GraphNode node) {
        Set<GraphNode> result = new LinkedHashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        result.add(node);
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode n = queue.poll();
            for (Object m : n.outerConnections.entrySet()) {
                Map.Entry<GraphNode, Integer> mm = (Map.Entry<GraphNode, Integer>) m;
                if (!result.contains(mm.getKey())) {
                    queue.add(mm.getKey());
                    result.add(mm.getKey());
                } else {
                    result.remove(mm.getKey());
                    result.add(mm.getKey());
                }
            }
        }

        return result;
    }

    public static Set<GraphNode> buildList(Graph<Integer> graph) {
        Set<GraphNode> r = new LinkedHashSet<>();
        Map<GraphNode, Boolean> startable = new HashMap<>();

        for (GraphNode node : graph.nodes) {
            if (node.innerConnections.isEmpty()) {
                startable.put(node, true);
            }
        }
        if (startable.isEmpty()) {
            return r;
        }

        for (Map.Entry<GraphNode, Boolean> entry : startable.entrySet()) {
            r.addAll(getList(entry.getKey()));
        }

        return r;
    }

}
