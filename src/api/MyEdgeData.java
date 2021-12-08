package api;

public class MyEdgeData implements EdgeData {
    private final int src;
    private final int dst;
    private final double weight;
    private String info;
    private int tag;

    /** Constructor */
    public MyEdgeData(int Src, int Dest, double Weight){
        this.src = Src;
        this.weight = Weight;
        this.dst = Dest;
    }
    /** Copy Constructors */
    public MyEdgeData(MyEdgeData edge){
        this.src = edge.src;
        this.weight = edge.weight;
        this.dst = edge.dst;
        this.info = edge.info;
        this.tag = edge.tag;
    }

    /** Copy EdgeData Constructor*/
    public MyEdgeData(EdgeData edge){
        this.src = edge.getSrc();
        this.weight = edge.getWeight();
        this.dst = edge.getDest();
        this.info = edge.getInfo();
        this.tag = edge.getTag();
    }

    /** Getters & Setters */
    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public int getDest() {
        return this.dst;
    }

    @Override
    public double getWeight() {
        return this.weight;
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
