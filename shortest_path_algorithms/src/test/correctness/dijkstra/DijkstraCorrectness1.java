package test.correctness.ForOne;

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
    void src_to_all_dst1() {
        graph.solveForOne(0, "1");
        double[] expected = {0, 3, 5, 5};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst2() {
        graph.solveForOne(1, "1");
        double[] expected = {Double.MAX_VALUE, 0, 2, 3};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst3() {
        graph.solveForOne(2, "1");
        double[] expected = {Double.MAX_VALUE, Double.MAX_VALUE, 0, 1};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst4() {
        graph.solveForOne(3, "1");
        double[] expected = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveForAll("1");
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
        graph.solveForOne(0, "1");
        assertEquals("0-1-2", graph.getParents(0, 2));
    }
}
