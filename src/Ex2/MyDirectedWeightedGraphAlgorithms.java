package Ex2;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.NodeData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Iterator;
import java.util.List;
import java.io.*;

public class MyDirectedWeightedGraphAlgorithms implements DirectedWeightedGraphAlgorithms {
    DirectedWeightedGraph graph;


    @Override
    public void init(DirectedWeightedGraph g) {
        this.graph = g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.graph;
    }

    @Override
    public DirectedWeightedGraph copy() {
        DirectedWeightedGraph g1=new MyDirectedWeightedGraph(this.graph);
        return g1;
    }

    @Override
    public boolean isConnected() {
        if(this.graph==null)
            return true;
        if(graph.nodeSize()<=1)
            return true;
        if(graph.nodeSize()>graph.edgeSize())
            return false;
        return false;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        double a=0;
        int node =this.graph.nodeSize();
        double min=Double.MAX_VALUE;
        NodeData ans=null;
        Iterator<NodeData> it =this.graph.nodeIter();

        while (it.hasNext())
        {
            NodeData curr=it.next();
            Iterator<NodeData>it2=this.graph.nodeIter();
            while(it2.hasNext())
            {
                NodeData next=it2.next();
                a+=(shortestPathDist(curr.getKey(),next.getKey())/node);
            }
            if(a<min)
            {
                min=a;
                ans=curr;
            }

        }
        return ans;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {
        return false;
    }

    @Override
    public boolean load(String file) {
        try {
            GsonBuilder G_builde = new GsonBuilder();
            G_builde.registerTypeAdapter(DirectedWeightedGraph.class, new fromJson());
            Gson gson = Gçbuilde.create();
            FileReader fr = new FileReader(file);
            this.graph=gson.fromJson(fr,DirectedWeightedGraph.class);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
