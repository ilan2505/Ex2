package api;

import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;

public class MyDirectedWeightedGraph implements DirectedWeightedGraph {
    private HashMap<Integer, NodeData> nodes;
    private HashMap<Integer, HashMap<Integer, EdgeData>> edges;
    private int cnt;
    private int MC;

    /** Constructor */
    public MyDirectedWeightedGraph() {
        edges = new HashMap<Integer, HashMap<Integer, EdgeData>>();
        nodes = new HashMap<Integer, NodeData>();
        cnt = 0;
        MC = 0;
    }

    /** Copy DirectedWeightedGraph Constructor*/
    public MyDirectedWeightedGraph(DirectedWeightedGraph graph) {
        Iterator<NodeData> e = graph.nodeIter();
        while (e.hasNext()) {
            NodeData temp = e.next();
            NodeData n = new MyNodeData(temp);
            this.addNode(n);
        }
    }


    @Override
    public NodeData getNode(int key) {
        return nodes.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        return edges.get(src).get(dest);
    }

    @Override
    public void addNode(NodeData n) {
        nodes.put(n.getKey(), n);
        HashMap<Integer, EdgeData> neighbours = new HashMap<Integer, EdgeData>();
        edges.put(n.getKey(), neighbours);
    }

    @Override
    public void connect(int src, int dest, double w) {
        if (src != dest) {
            if (this.getNode(src) != null && this.getNode(dest) != null) {
                EdgeData edge = new MyEdgeData(src, dest, w);
                if (edges.get(src).get(dest) == null) {
                    edges.get(src).put(dest, edge);
                    cnt++;
                    this.MC++;
                } else if (edges.get(src).get(dest).getWeight() != w) {
                    edges.get(src).replace(dest, edge);
                    MC++;
                }
            }
        }
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        return this.nodes.values().iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        if (edges.isEmpty())
            return null;
        return edgeIter(0);
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return edges.get(node_id).values().iterator();
    }

    @Override
    public NodeData removeNode(int key) {
        NodeData node = nodes.get(key);
        if (node != null) {
            Iterator<NodeData> k = nodeIter();
            while (k.hasNext()) {
                NodeData temp = k.next();
                if (edges.get(temp.getKey()).get(key) != null)
                    this.removeEdge(temp.getKey(), key);
            }
            Iterator<EdgeData> edge = edgeIter(key);
            while (edge.hasNext()) {
                EdgeData temp = edge.next();
                this.removeEdge(key, temp.getDest());
                edge = edgeIter(key);
            }
            edges.remove(key, edges.get(key));
            nodes.remove(key, node);
            MC++;
        }
        return node;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        EdgeData edge = this.getEdge(src, dest);
        if (edge != null) {
            edges.get(src).remove(dest, edge);
            cnt--;
            MC++;
        }
        return edge;
    }

    @Override
    public int nodeSize() {
        return nodes.size();
    }

    @Override
    public int edgeSize() {
        return cnt;
    }

    @Override
    public int getMC() {
        return MC;
    }
}
