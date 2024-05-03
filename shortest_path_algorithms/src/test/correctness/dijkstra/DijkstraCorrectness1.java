package test.correctness.dijkstra;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraCorrectness1 {

    Graph graph = new Graph("src/test/graphs/small_positive.txt");

    @Test
    void src_dst_cost1() {
        graph.solveDijkstra(1);
        assertEquals(3, graph.getDistance(1, 3));
    }

    @Test
    void src_dst_cost2() {
        graph.solveDijkstra(1);
        assertEquals(2, graph.getDistance(1, 2));
    }

    @Test
    void src_dst_cost3() {
        graph.solveDijkstra(0);
        assertEquals(5, graph.getDistance(0, 3));
    }

    @Test
    void src_dst_cost4() {
        graph.solveDijkstra(0);
        assertEquals(0, graph.getDistance(0, 0));
    }

    @Test
    void src_dst_cost5() {
        graph.solveDijkstra(0);
        assertEquals(5, graph.getDistance(0, 2));
    }

    @Test
    void src_dst_cost6() {
        graph.solveDijkstra(3);
        assertEquals(Double.MAX_VALUE, graph.getDistance(3, 0));
    }

    @Test
    void src_to_all_dst1() {
        graph.solveDijkstra(0);
        double[] expected = {0, 3, 5, 5};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(0));
    }

    @Test
    void src_to_all_dst2() {
        graph.solveDijkstra(1);
        double[] expected = {Double.MAX_VALUE, 0, 2, 3};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(1));
    }

    @Test
    void src_to_all_dst3() {
        graph.solveDijkstra(2);
        double[] expected = {Double.MAX_VALUE, Double.MAX_VALUE, 0, 1};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(2));
    }

    @Test
    void src_to_all_dst4() {
        graph.solveDijkstra(3);
        double[] expected = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(3));
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveDijkstraAll();
        double[][] expected = {
                {0, 3, 5, 5},
                {Double.MAX_VALUE, 0, 2, 3},
                {Double.MAX_VALUE, Double.MAX_VALUE, 0, 1},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0}
        };
        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }

    @Test
    void path_src_dst() {
        graph.solveDijkstra(0);
        assertEquals("2->1->0", graph.getParents(0, 2));
    }
}
