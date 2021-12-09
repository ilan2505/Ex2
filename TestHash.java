import java.awt.geom.Point2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import api.DirectedWeightedGraph;
import api.DirectedWeightedGraphAlgorithms;
import api.EdgeData;
import api.NodeData;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestHash {
    //public static void   Myload(DirectedWeightedGraph g, String File) throws IOException {
    public static void main(String[] args) throws IOException, InterruptedException {

    }

    public static DirectedWeigtet graph() throws IOException {
        DirectedWeightedGraphAlgorithms alg = new Algo();
        DirectedWeigtet g = new DirectedWeigtet();
        String file = "c:/G1.json";
        String content = new String(Files.readAllBytes(Paths.get(file)));
        JSONObject obj = new JSONObject(content);


        JSONArray objArr1 = obj.getJSONArray("Nodes".trim());
        for (int i = 0; i < objArr1.length(); i++) {
            JSONObject x1 = objArr1.getJSONObject(i);
            int id = (int) x1.get("id");
            String pos = (String) x1.get("pos");
            String xyz = new String();
            double loc[] = new double[3];
            int count = 0;
            for (int j = 0; j < pos.length(); j++) {
                if (pos.charAt(j) != ',') {
                    xyz += pos.charAt(j);
                } else {
                    loc[count] = Double.parseDouble(xyz);
                    xyz = new String();
                    count++;
                }
            }

            MyLoc c = new MyLoc(loc[0], loc[1], loc[2]);
            ND N = new ND(c, id);
            g.addNode(N);

        }

        JSONArray objArr = obj.getJSONArray("Edges".trim());
        for (int i = 0; i < objArr.length(); i++) {


            JSONObject edge1 = objArr.getJSONObject(i);

            int src = (int) edge1.get("src");
            int dest = (int) edge1.get("dest");
            Object y2 = (Object) edge1.get("w");
            String s2 = y2.toString();
            Double s3 = Double.parseDouble(s2);
            //Float y21 = (Float) y2;
            EdgeDatas s = new EdgeDatas(src, s3, dest);
            g.connect(src, dest, s3);
        }
        //   g.removeEdge(0,1);
        //g.removeEdge(1,0);
        // g.removeNode(0);
        DirectedWeightedGraphAlgorithms al = new Algo();
        al.init(g);
        System.out.println(al.isConnected());

        //System.out.println(al.center().getKey());
        // System.out.println("dist=" + al.shortestPath(0, 7));

        //System.out.println(al.center().getKey());
        //System.out.println(al.shortestPath(0,22));
        // List<NodeData> AL = al.tsp(al.shortestPath(0, 7));
        //  System.out.println(AL.size());
        // for (int i = 0; i < AL.size(); i++) {
        //   System.out.print(AL.get(i).getKey() + ",");

        //   }
        //  al.save("D:/10000nodes.json");
        //  System.out.println(al.tsp(al.shortestPath(0,9)));
        //
        pp(g);
        //RunGUiTest.test(al,g);

        return g;
    }

    public static List<Point2D> pp(DirectedWeigtet g) {
        ArrayList<java.awt.geom.Point2D> p = new ArrayList<>();
        Iterator<NodeData> N = g.nodeIter();
        while (N.hasNext()) {
            NodeData n = N.next();
            double x = n.getLocation().x();
            double y = n.getLocation().y();

            java.awt.geom.Point2D pp = new java.awt.geom.Point2D() {
                @Override
                public double getX() {
                    return x;
                }

                @Override
                public double getY() {
                    return y;
                }

                @Override
                public void setLocation(double x, double y) {

                }
            };
            p.add(pp);
        }
        return p;
    }

    public static ArrayList<Point2D> ed(DirectedWeigtet t) {
        ArrayList<Point2D> p = new ArrayList<>();

        Iterator<EdgeData> itNode = t.edgeIter();

        while (itNode.hasNext()) {
            EdgeDatas ed = (EdgeDatas) itNode.next();
            NodeData src = t.getNode(ed.src);
            double x1 = (src.getLocation().x());
            double y1 = (src.getLocation().y());
            Point2D src1 = new Point2D() {
                @Override
                public double getX() {
                    return x1;
                }

                @Override
                public double getY() {
                    return y1;
                }

                @Override
                public void setLocation(double x, double y) {

                }
            };
            NodeData dest = t.getNode(ed.dest);

            double x2 = (dest.getLocation().x());
            double y2 = (dest.getLocation().y());
            Point2D dest1=new Point2D() {
                @Override
                public double getX() {
                    return x2;
                }

                @Override
                public double getY() {
                    return y2;
                }

                @Override
                public void setLocation(double x, double y) {

                }
            };
            p.add(src1);
            p.add(dest1);
        }
        return p;
    }
}
