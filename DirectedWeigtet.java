import api.DirectedWeightedGraph;
import api.EdgeData;
import api.NodeData;

import java.util.*;

public class DirectedWeigtet implements DirectedWeightedGraph {
    HashMap<Integer, NodeData> node;
    int w;
    int MC;
    HashMap<NodeData, HashMap<NodeData, EdgeData>> edge;
    HashMap<NodeData, HashMap<NodeData, EdgeData>> edgein;
    int edgeSize;

    public DirectedWeigtet() {
        this.edgeSize = 0;
        this.edge = new HashMap<>();
        this.edgein = new HashMap<>();
        this.node = new HashMap<>();

        this.MC = 0;
    }

    public DirectedWeigtet(HashMap mynode, HashMap<NodeData, HashMap<NodeData, EdgeData>> edge) {
        this.edge = edge;
        this.edgein = new HashMap<>();
        this.node = mynode;
    }

    @Override
    public NodeData getNode(int key) {
        return node.get(key);


    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        NodeData N1 = getNode(src);
        NodeData N2 = getNode(dest);
        //HashMap<NodeData,NodeData> t=new HashMap<>();
        //t.put(N1,N2);
        if (edge.get(N1) != null) {
            if (edge.get(N1).get(N2) != null) {
                return this.edge.get(N1).get(N2);
            }
        }
        return null;
    }

    @Override
    public void addNode(NodeData n) {
        node.put(n.getKey(), n);
        this.MC++;

    }

    @Override
    public void connect(int src, int dest, double w) {
        NodeData dest1 = getNode(dest);
        NodeData src1 = getNode(src);
        EdgeData e = new EdgeDatas(src, w, dest);
        HashMap<NodeData, EdgeData> t = new HashMap<>();
        t.put(dest1, e);
        if (this.edge.get(src1) != null) {
            if (this.edge.get(src1).get(dest1) != null) {
                //   removeEdge(src,dest);
            }
            this.edge.get(src1).put(dest1, e);
        } else {
            this.edge.put(src1, t);
        }
        this.MC++;
        this.edgeSize++;
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        Iterator<NodeData> ie = null;
        NodeData d[] = this.node.values().toArray(new NodeData[0]);
        ie = Arrays.stream(d).iterator();
        return ie;

    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        try {


            ArrayList<EdgeData> ADATA = new ArrayList<>();
            for (int i = 0; i < node.size(); i++) {
                NodeData n = node.get(i);
                if (edgeIter(i) != null) {
                    Iterator<EdgeData> t = edgeIter(i);
                    while (t.hasNext()) {
                        EdgeData thisedge = (EdgeData) t.next();
                        ADATA.add(thisedge);
                    }
                }
            }
            Iterator<EdgeData> t = ADATA.iterator();
            return t;
        } catch (RuntimeException e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        Iterator<EdgeData> ie = null;

        try {
            {
                NodeData N = getNode(node_id);
                if (this.edge.get(N) != null) {
                    EdgeData[] t = this.edge.get(N).values().toArray(new EdgeData[0]);
                    ie = Arrays.stream(t).iterator();
                }

            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        return ie;

    }

    @Override
    public NodeData removeNode(int key) {
        NodeData n = getNode(key);
        int t = this.edge.get(n).size();
        System.out.println("t=" + key);
        this.edgeSize -= t;
        removeEdge(key);
        node.remove(key);
        this.MC++;
        return n;
    }

    private void removeEdge(int key) {
        NodeData N = getNode(key);
        this.edge.remove(N);
        for (int i = 0; i < this.node.size(); i++) {
            if (i != key) {
               // System.out.println(key);
                removeEdge(i, key);
            }
        }
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        EdgeData e = null;
        NodeData dest1 = getNode(dest);
        NodeData src1 = getNode(src);
        if (this.edge.get(src1) != null) {
            if (this.edge.get(src1).get(dest1) != null) {
                e = this.edge.get(src1).get(dest1);
                this.edgeSize--;
             //   System.out.println(src + "," + dest);
                this.edge.get(src1).remove(dest1);
                this.MC++;

            }
        }

        return e;
    }

    @Override
    public int nodeSize() {
        return this.node.size();
    }

    @Override
    public int edgeSize() {
        return this.edgeSize;
    }

    @Override
    public int getMC() {
        return this.MC;
    }
}
