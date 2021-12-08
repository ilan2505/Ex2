package api;

import java.io.Serializable;
import java.util.HashMap;

public class MyNodeData implements NodeData, Serializable {
    private int key;
    private GeoLocation location;
    private HashMap<Integer, NodeData> neighbours;
    private double weight;
    private String info;
    private int tag;

    /** Constructor */
    public MyNodeData(int key, GeoLocation p){
        this.key = key;
        this.location = p;
        this.neighbours = new HashMap<>();
        this.info = "";
        this.tag = -1;
    }

    /** Copy Constructor */
    public MyNodeData(MyNodeData node){
        this.key = node.getKey();
        this.location = node.getLocation();
        this.neighbours = new HashMap<>();
        this.neighbours.putAll(node.neighbours);
        this.weight = node.getWeight();
        this.info = node.getInfo();
        this.tag = node.getTag();
    }

    /** Copy NodeData Constructor*/
    public MyNodeData(NodeData node){
        this.key = node.getKey();
        this.location = node.getLocation();
    }

    /** Getters & Setters */
    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.location = p;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight = w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }
}
