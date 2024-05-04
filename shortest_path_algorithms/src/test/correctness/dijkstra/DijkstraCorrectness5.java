package test.correctness.dijkstra;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraCorrectness5 {

    Graph graph = new Graph("src/test/graphs/two_comp.txt");

    @Test
    void src_dst_cost1() {
        graph.solveForOne(1, "1");
        assertEquals(3, graph.getDistance(3));
    }

    @Test
    void src_dst_cost2() {
        graph.solveForOne(1, "1");
        assertEquals(4, graph.getDistance(2));
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
        assertEquals(6, graph.getDistance(2));
    }

    @Test
    void src_dst_cost6() {
        graph.solveForOne(3, "1");
        assertEquals(2, graph.getDistance(0));
    }

    @Test
    void src_to_all_dst1() {
        graph.solveForOne(0, "1");
        double[] expected = {0.0, 2.0, 6.0, 5.0, 9.0, 11.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst2() {
        graph.solveForOne(6, "1");
        double[] expected = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.0, 3.0, 5.0, 5.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveForAll("1");
        double[][] expected = {
                {0.0, 2.0, 6.0, 5.0, 9.0, 11.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {5.0, 0.0, 4.0, 3.0, 7.0, 9.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {1.0, 3.0, 0.0, 6.0, 7.0, 5.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {2.0, 4.0, 1.0, 0.0, 4.0, 6.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {8.0, 3.0, 7.0, 6.0, 0.0, 2.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {8.0, 5.0, 7.0, 6.0, 2.0, 0.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.0, 3.0, 5.0, 5.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.0, 2.0, 3.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.0, 1.0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.0}

        };
         
        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }

    @Test
    void path_src_dst() {
        graph.solveForOne(0, "1");
        assertEquals("0-1-3-2", graph.getParents(0, 2));
    }
}
