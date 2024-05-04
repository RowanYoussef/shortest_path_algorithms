package test.correctness.dijkstra;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraCorrectness6 {

    Graph graph = new Graph("src/test/graphs/large.txt");

    @Test
    void src_dst_cost1() {
        graph.solveForOne(1, "1");
        assertEquals(3, graph.getDistance(3));
    }

    @Test
    void src_dst_cost2() {
        graph.solveForOne(1, "1");
        assertEquals(2, graph.getDistance(2));
    }

    @Test
    void src_dst_cost3() {
        graph.solveForOne(0, "1");
        assertEquals(5, graph.getDistance(3));
    }

    @Test
    void src_dst_cost4() {
        graph.solveForOne(0, "1");
        assertEquals(0, graph.getDistance(0));
    }

    @Test
    void src_dst_cost5() {
        graph.solveForOne(0, "1");
        assertEquals(5, graph.getDistance(2));
    }

    @Test
    void src_dst_cost6() {
        graph.solveForOne(3, "1");
        assertEquals(Double.MAX_VALUE, graph.getDistance(0));
    }

    @Test
    void path_src_dst() {
        graph.solveForOne(0, "1");
        assertEquals("0-1-2", graph.getParents(0, 2));
    }
}
