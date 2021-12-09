import api.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;

import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Algo implements DirectedWeightedGraphAlgorithms {
    DirectedWeightedGraph e;

    public Algo() {

        //this.e = new DirectedWeigtet();
    }

    @Override
    public void init(DirectedWeightedGraph g) {
        this.e = g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.e;
    }

    @Override
    public DirectedWeightedGraph copy() {
        HashMap<Integer, NodeData> Node = new HashMap<>();
        Iterator<NodeData> no = e.nodeIter();
        while (no.hasNext()) {
            NodeData N = no.next();
            Node.put(N.getKey(), N);
        }
        HashMap<NodeData, HashMap<NodeData, EdgeData>> Edge = new HashMap<>();
        Iterator<EdgeData> ed = e.edgeIter();
        while (ed.hasNext()) {
            EdgeData e1 = ed.next();
            NodeData ns = e.getNode(e1.getSrc());
            NodeData nd = e.getNode(e1.getDest());
            HashMap<NodeData, EdgeData> t = new HashMap<>();
            t.put(ns, e1);
            Edge.put(ns, t);

        }
        DirectedWeightedGraph c = new DirectedWeigtet(Node, Edge);

        return c;
    }

    @Override
    public boolean isConnected() {
        boolean b = false;
        DirectedWeightedGraph g;
        DirectedWeightedGraph c = copy();
        int i = 0;
        while (c.getNode(i) == null) {
            i++;
        }
        if (DFS.dfs(c, c.getNode(i))) {

            g = DFS.Trans(c);
            b = DFS.dfs(g, g.getNode(i));
        }
        return b;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return MyShortedPath.minDist(this.e, shortestPath(src, dest));
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return MyShortedPath.path(this.e, src, dest);
    }

    @Override
    public NodeData center() {
        int size = e.nodeSize();
        NodeData center = e.getNode(0);
        double mat[][] = new double[size][size];
        for (int i = 0; i < e.nodeSize(); i++) {
            for (int j = 0; j < e.nodeSize(); j++) {
                if (e.getEdge(i, j) != null && e.getNode(i) != null && e.getNode(j) != null) {
                    mat[i][j] = e.getEdge(i, j).getWeight();
                } else {
                    mat[i][j] = Double.MAX_VALUE;
                    if (i == j && e.getNode(i) != null && e.getNode(j) != null) {
                        mat[i][j] = 0;
                    }
                }
            }
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (mat[i][j] > mat[i][k] + mat[k][j]) {
                        mat[i][j] = mat[i][k] + mat[k][j];
                    }
                }
            }
        }
        int center1 = 0;
        Double min = Double.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            double max = Double.MIN_VALUE;
            for (int j =0 ; j < size; j++) {
            //    System.out.print((int) mat[i][j] + ",");

                if (mat[i][j] > max&&mat[i][j]<Double.MAX_VALUE) {

                    max = mat[i][j];
                }

            }
            if (max < min) {

                min = max;
                center1 = i;

            }
        }

      //  System.out.println(center1);
        return e.getNode(center1);

    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return Mytsp.checktsp(this.e, cities);

    }

    @Override
    public boolean save(String file) {
        FileWriter file1;
        JSONObject obj = new JSONObject();
        e.nodeIter();
        HashMap<Integer, Integer> eee = new HashMap<>();
        obj.put("Edges", 100);
        try {
            file1 = new FileWriter(file);
            file1.write(obj.toString());
            file1.write(e.nodeIter().toString());
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean load(String file) throws IOException {
        //TestHash.Myload(e,file);
        return false;
    }
}
