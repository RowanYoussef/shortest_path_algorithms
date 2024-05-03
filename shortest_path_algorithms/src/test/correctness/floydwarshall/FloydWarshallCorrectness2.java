package test.correctness.floydwarshall;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FloydWarshallCorrectness2 {
    Graph graph = new Graph("src/test/graphs/medium_positive.txt");

    @Test
    void src_dst_cost1() {
        graph.solveFloydWarshall();
        assertEquals(6, graph.getDistance(0, 2));
    }

    @Test
    void src_dst_cost2() {
        graph.solveFloydWarshall();
        assertEquals(9, graph.getDistance(0, 4));
    }

    @Test
    void src_dst_cost3() {
        graph.solveFloydWarshall();
        assertEquals(4, graph.getDistance(3, 4));
    }

    @Test
    void src_dst_cost4() {
        graph.solveFloydWarshall();
        assertEquals(5, graph.getDistance(5, 1));
    }
    @Test
    void src_to_all_dst1() {
        graph.solveFloydWarshall();
        double[] expected = {0.0, 2.0, 6.0, 5.0, 9.0, 11.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(0));
    }

    @Test
    void src_to_all_dst2() {
        graph.solveFloydWarshall();
        double[] expected = {5.0, 0.0, 4.0, 3.0, 7.0, 9.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(1));
    }

    @Test
    void src_to_all_dst3() {
        graph.solveFloydWarshall();
        double[] expected = {1.0, 3.0, 0.0, 6.0, 7.0, 5.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(2));
    }

    @Test
    void src_to_all_dst4() {
        graph.solveFloydWarshall();
        double[] expected = {2.0, 4.0, 1.0, 0.0, 4.0, 6.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(3));
    }

    @Test
    void src_to_all_dst5() {
        graph.solveFloydWarshall();
        double[] expected = {8.0, 3.0, 7.0, 6.0, 0.0, 2.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(4));
    }

    @Test
    void src_to_all_dst6() {
        graph.solveFloydWarshall();
        double[] expected = {8.0, 5.0, 7.0, 6.0, 2.0, 0.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(5));
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveFloydWarshall();
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


/*
    @Test
    void path_src_dst1() {
        graph.solveFloydWarshall(0);
        assertEquals("2->3->1->0", graph.getParents(0, 2));
    }

    @Test
    void path_src_dst2() {
        graph.solveFloydWarshall(3);
        assertEquals("5->4->3", graph.getParents(3, 5));
    }

    @Test
    void path_src_dst3() {
        graph.solveFloydWarshall(1);
        assertEquals("4->3->1", graph.getParents(1, 4));
    }

    @Test
    void path_src_dst4() {
        graph.solveFloydWarshall(4);
        assertEquals("0->2->3->1->4", graph.getParents(4, 0));
    }
*/

    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCyclesBellmanFord());
    }
}
