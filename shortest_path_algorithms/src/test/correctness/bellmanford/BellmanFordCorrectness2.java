package test.correctness.bellmanford;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BellmanFordCorrectness2 {
    Graph graph = new Graph("src/test/graphs/medium_positive.txt");

    @Test
    void src_dst_cost1() {
        graph.solveForOne(0, "2");
        assertEquals(6, graph.getDistance( 2));
    }

    @Test
    void src_dst_cost2() {
        graph.solveForOne(0, "2");
        assertEquals(9, graph.getDistance( 4));
    }

    @Test
    void src_dst_cost3() {
        graph.solveForOne(3, "2");
        assertEquals(4, graph.getDistance( 4));
    }

    @Test
    void src_dst_cost4() {
        graph.solveForOne(5, "2");
        assertEquals(5, graph.getDistance( 1));
    }
    @Test
    void src_to_all_dst1() {
        graph.solveForOne(0, "2");
        double[] expected = {0.0, 2.0, 6.0, 5.0, 9.0, 11.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst2() {
        graph.solveForOne(1, "2");
        double[] expected = {5.0, 0.0, 4.0, 3.0, 7.0, 9.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst3() {
        graph.solveForOne(2, "2");
        double[] expected = {1.0, 3.0, 0.0, 6.0, 7.0, 5.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst4() {
        graph.solveForOne(3, "2");
        double[] expected = {2.0, 4.0, 1.0, 0.0, 4.0, 6.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst5() {
        graph.solveForOne(4, "2");
        double[] expected = {8.0, 3.0, 7.0, 6.0, 0.0, 2.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst6() {
        graph.solveForOne(5, "2");
        double[] expected = {8.0, 5.0, 7.0, 6.0, 2.0, 0.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveForAll("2");
        double[][] expected = {
                {0.0, 2.0, 6.0, 5.0, 9.0, 11.0},
                {5.0, 0.0, 4.0, 3.0, 7.0, 9.0},
                {1.0, 3.0, 0.0, 6.0, 7.0, 5.0},
                {2.0, 4.0, 1.0, 0.0, 4.0, 6.0},
                {8.0, 3.0, 7.0, 6.0, 0.0, 2.0},
                {8.0, 5.0, 7.0, 6.0, 2.0, 0.0}
        };
        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }



    @Test
    void path_src_dst1() {
        graph.solveForOne(0, "2");
        assertEquals("0-1-3-2", graph.getParents(0, 2));
    }

    @Test
    void path_src_dst2() {
        graph.solveForOne(3, "2");
        assertEquals("3-4-5", graph.getParents(3, 5));
    }

    @Test
    void path_src_dst3() {
        graph.solveForOne(1, "2");
        assertEquals("1-3-4", graph.getParents(1, 4));
    }

    @Test
    void path_src_dst4() {
        graph.solveForOne(4, "2");
        assertEquals("4-1-3-2-0", graph.getParents(4, 0));
    }


    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCycles("1"));
    }
}
