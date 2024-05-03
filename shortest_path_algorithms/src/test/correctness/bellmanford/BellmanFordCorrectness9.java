package test.correctness.bellmanford;

import models.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BellmanFordCorrectness9 {
    Graph graph = new Graph("src/test/graphs/negative_cycle.txt");

    @Test
    void has_negative_cycle() {
        assertTrue(graph.containsCyclesBellmanFord());
    }
}
