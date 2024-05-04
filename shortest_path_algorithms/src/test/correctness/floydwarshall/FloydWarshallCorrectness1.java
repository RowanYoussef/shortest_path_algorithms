package test.correctness.floydwarshall;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FloydWarshallCorrectness1 {

    Graph graph = new Graph("src/test/graphs/small_positive.txt");

    @Test
    void src_dst_cost1() {
        graph.solveForOne(1, "3");
        assertEquals(3, graph.getDistance(1, 3));
    }

    @Test
    void src_dst_cost2() {
        graph.solveForOne(1, "3");
        assertEquals(2, graph.getDistance(1, 2));
    }

    @Test
    void src_dst_cost3() {
        graph.solveForOne(0, "3");
        assertEquals(5, graph.getDistance(0, 3));
    }

    @Test
    void src_dst_cost4() {
        graph.solveForOne(0, "3");
        assertEquals(0, graph.getDistance(0, 0));
    }

    @Test
    void src_dst_cost5() {
        graph.solveForOne(0, "3");
        assertEquals(5, graph.getDistance(0, 2));
    }

    @Test
    void src_dst_cost6() {
        graph.solveForOne(3, "3");
        assertEquals(Double.POSITIVE_INFINITY, graph.getDistance(3, 0));
    }

    @Test
    void src_to_all_dst1() {
        graph.solveForOne(0, "3");
        double[] expected = {0, 3, 5, 5};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(0));
    }

    @Test
    void src_to_all_dst2() {
        graph.solveForOne(1, "3");
        double[] expected = {Double.POSITIVE_INFINITY, 0, 2, 3};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(1));
    }

    @Test
    void src_to_all_dst3() {
        graph.solveForOne(2, "3");
        double[] expected = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, 1};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(2));
    }

    @Test
    void src_to_all_dst4() {
        graph.solveForOne(3, "3");
        double[] expected = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(3));
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveForAll("3");
        double[][] expected = {
                {0, 3, 5, 5},
                {Double.POSITIVE_INFINITY, 0, 2, 3},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, 1},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0}
        };
        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }
/*
    @Test
    void path_src_dst() {
        graph.solveForOne(0, "3");
        assertEquals("2->1->0", graph.getParents(0, 2));
    }
*/
    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCycles("2"));
    }
}
