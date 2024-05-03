package test.correctness.floydwarshall;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FloydWarshallCorrectness5 {

    Graph graph = new Graph("src/test/graphs/small_negative.txt");

    @Test
    void src_dst_cost1() {
        graph.solveFloydWarshall();
        assertEquals(-4, graph.getDistance(1, 3));
    }

    @Test
    void src_dst_cost2() {
        graph.solveFloydWarshall();
        assertEquals(2, graph.getDistance(1, 2));
    }

    @Test
    void src_dst_cost3() {
        graph.solveFloydWarshall();
        assertEquals(-1, graph.getDistance(0, 3));
    }

    @Test
    void src_dst_cost4() {
        graph.solveFloydWarshall();
        assertEquals(0, graph.getDistance(0, 0));
    }

    @Test
    void src_dst_cost5() {
        graph.solveFloydWarshall();
        assertEquals(5, graph.getDistance(0, 2));
    }

    @Test
    void src_dst_cost6() {
        graph.solveFloydWarshall();
        assertEquals(Double.POSITIVE_INFINITY, graph.getDistance(3, 0));
    }

    @Test
    void src_to_all_dst1() {
        graph.solveFloydWarshall();
        double[] expected = {0, 3, 5, -1};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(0));
    }

    @Test
    void src_to_all_dst2() {
        graph.solveFloydWarshall();
        double[] expected = {Double.POSITIVE_INFINITY, 0, 2, -4};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(1));
    }

    @Test
    void src_to_all_dst3() {
        graph.solveFloydWarshall();
        double[] expected = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, 1};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(2));
    }

    @Test
    void src_to_all_dst4() {
        graph.solveFloydWarshall();
        double[] expected = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(3));
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveFloydWarshall();
        double[][] expected = {
                {0, 3, 5, -1},
                {Double.POSITIVE_INFINITY, 0, 2, -4},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0, 1},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0}
        };
        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }
/*
    @Test
    void path_src_dst() {
        graph.solveFloydWarshall(0);
        assertEquals("2->1->0", graph.getParents(0, 2));
    }
*/
    
    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCyclesFloydWarshall());
    }
}
