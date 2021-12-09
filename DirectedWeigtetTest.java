import api.DirectedWeightedGraph;
import api.EdgeData;
import api.GeoLocation;
import api.NodeData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.FileSystemSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


class DirectedWeigtetTest extends test {
    ArrayList< NodeData> mynode;
    HashMap<NodeData,HashMap<NodeData, EdgeData>> edge;
    DirectedWeightedGraph g=new DirectedWeigtet();
    GeoLocation l1=new MyLoc(1,2,4);
/**
    @Test
    void testNode(){
        ND bb=new ND(1,l1);
        g.addNode(bb);
        ND y=new ND(2,l1);
        g.addNode(y);
        ND x1=new ND(3,l1);
        g.addNode(x1);
        ND y1=new ND(4,l1);
        g.addNode(y1);
        ND x2=new ND(5,l1);
        g.addNode(x2);
        ND y2=new ND(6,l1);
        g.addNode(y2);
        ND x3=new ND(7,l1);
        g.addNode(x3);
        ND y3=new ND(8,l1);
        g.addNode(y3);
        ND x4=new ND(9,l1);
        g.addNode(x4);
        ND y4=new ND(10,l1);
        g.addNode(y4);
        ND x5=new ND(11,l1);
        g.addNode(x5);
        ND y5=new ND(12,l1);
        g.addNode(y5);

        Assertions.assertEquals(g.nodeSize(),12);
        Assertions.assertEquals(g.getNode(0).getKey(),1);

    }
    @Test
    void TestEdge(){
        ND bb=new ND(1,l1);
        g.addNode(bb);
        ND y=new ND(2,l1);
        g.addNode(y);
        ND x1=new ND(3,l1);
        g.addNode(x1);
        ND y1=new ND(4,l1);
        g.addNode(y1);
        ND x2=new ND(5,l1);
        g.addNode(x2);
        ND y2=new ND(6,l1);
        g.addNode(y2);
        ND x3=new ND(7,l1);
        g.addNode(x3);
        ND y3=new ND(8,l1);
        g.addNode(y3);
        ND x4=new ND(9,l1);
        g.addNode(x4);
        ND y4=new ND(10,l1);
        g.addNode(y4);
        ND x5=new ND(11,l1);
        g.addNode(x5);
        ND y5=new ND(12,l1);
        g.addNode(y5);
        g.connect(1,2,3);
        g.connect(1,4,2);
        g.connect(1,3,4);
        g.connect(4,5,3);
        g.connect(5,1,2);
        g.connect(5,6,2);
        g.connect(2,4,3);
        g.connect(11,7,2);
        g.connect(3,8,2);
        g.connect(11,8,3);
        g.connect(5,9,2);
        g.connect(2,11,2);
        g.connect(7,10,3);
        g.connect(3,11,2);
        g.connect(3,11,3);
        g.connect(8,3,2);
        System.out.println(g.nodeSize());
        System.out.println(g.getEdge(3,11).getWeight());
        g.removeNode(1);
        Iterator<EdgeData>it= g.edgeIter();
        System.out.println(g.nodeSize());
        while (it.hasNext()) {
           EdgeData mapElement = (EdgeData) it.next();
            System.out.println(mapElement.getSrc() + " : "+mapElement.getDest()+ " weight= "+mapElement.getWeight() );
        }


        //Assertions.assertEquals(g.getEdge(1,2).getWeight(),);

    }

*/
}
