import api.DirectedWeightedGraphAlgorithms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlgoTest {
        DirectedWeightedGraphAlgorithms algo=new Algo();



    @Test
    void isConnected() throws IOException {
        algo.load("c:/10000nodes.json");
        Assertions.assertTrue(algo.isConnected());
    }

    @Test
    void shortestPathDist() {

    }

    @Test
    void shortestPath() {
    }

    @Test
    void center() throws IOException {
          algo.load("c:/10000nodes.json");
        Assertions.assertEquals(algo.center().getKey(),362);
    }

    @Test
    void tsp() {
    }
}