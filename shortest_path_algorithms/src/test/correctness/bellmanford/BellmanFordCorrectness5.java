package test.correctness.bellmanford;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BellmanFordCorrectness5 {

    Graph graph = new Graph("src/test/graphs/small_negative.txt");

    @Test
    void src_dst_cost1() {
        graph.solveForOne(1, "2");
        assertEquals(-4, graph.getDistance( 3));
    }

    @Test
    void src_dst_cost2() {
        graph.solveForOne(1, "2");
        assertEquals(2, graph.getDistance( 2));
    }

    @Test
    void src_dst_cost3() {
        graph.solveForOne(0, "2");
        assertEquals(-1, graph.getDistance( 3));
    }

    @Test
    void src_dst_cost4() {
        graph.solveForOne(0, "2");
        assertEquals(0, graph.getDistance( 0));
    }

    @Test
    void src_dst_cost5() {
        graph.solveForOne(0, "2");
        assertEquals(5, graph.getDistance( 2));
    }

    @Test
    void src_dst_cost6() {
        graph.solveForOne(3, "2");
        assertEquals(Double.MAX_VALUE, graph.getDistance( 0));
    }

    @Test
    void src_to_all_dst1() {
        graph.solveForOne(0, "2");
        double[] expected = {0, 3, 5, -1};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst2() {
        graph.solveForOne(1, "2");
        double[] expected = {Double.MAX_VALUE, 0, 2, -4};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst3() {
        graph.solveForOne(2, "2");
        double[] expected = {Double.MAX_VALUE, Double.MAX_VALUE, 0, 1};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst4() {
        graph.solveForOne(3, "2");
        double[] expected = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveForAll("2");
        double[][] expected = {
                {0, 3, 5, -1},
                {Double.MAX_VALUE, 0, 2, -4},
                {Double.MAX_VALUE, Double.MAX_VALUE, 0, 1},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0}
        };
        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }

    @Test
    void path_src_dst() {
        graph.solveForOne(0, "2");
        assertEquals("0-1-2", graph.getParents(0, 2));
    }

    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCycles("1"));
    }
}
