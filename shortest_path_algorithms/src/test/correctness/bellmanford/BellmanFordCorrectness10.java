package test.correctness.bellmanford;

import models.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BellmanFordCorrectness10 {
    Graph graph = new Graph("src/test/graphs/negative_cycle2.txt");

    @Test
    void has_negative_cycle() {
        assertTrue(graph.containsCycles("1"));
    }
}
