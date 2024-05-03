package test.correctness.floydwarshall;

import models.Graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloydWarshallCorrectness10 {
    Graph graph = new Graph("src/test/graphs/negative_cycle2.txt");

    @Test
    void has_negative_cycle() {
        assertTrue(graph.containsCycles("3"));
    }
}
