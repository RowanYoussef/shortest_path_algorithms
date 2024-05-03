package test.correctness.floydwarshall;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FloydWarshallCorrectness7 {

    Graph graph = new Graph("src/test/graphs/medium_negative2.txt");

    @Test
    void src_dst_cost1() {
        graph.solveFloydWarshall();
        assertEquals(-70, graph.getDistance(0, 6));
    }

    @Test
    void src_dst_cost2() {
        graph.solveFloydWarshall();
        assertEquals(-80, graph.getDistance(0, 4));
    }

    @Test
    void src_dst_cost3() {
        graph.solveFloydWarshall();
        assertEquals(270, graph.getDistance(5, 1));
    }

    @Test
    void src_dst_cost4() {
        graph.solveFloydWarshall();
        assertEquals(540, graph.getDistance(4, 0));
    }

    @Test
    void src_to_all_dst1() {
        graph.solveFloydWarshall();
        double[] expected = {0.0, 30.0, 40.0, -20.0, -80.0, 140.0, -70.0, Double.POSITIVE_INFINITY};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(0));
    }

    @Test
    void src_to_all_dst2() {
        graph.solveFloydWarshall();
        double[] expected = {-10.0, 0.0, 30.0, -50.0, -110.0, 130.0, -100.0, Double.POSITIVE_INFINITY};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(1));
    }

    @Test
    void src_to_all_dst3() {
        graph.solveFloydWarshall();
        double[] expected = {20.0, 50.0, 0.0, -20.0, -80.0, 100.0, -70.0, Double.POSITIVE_INFINITY};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(2));
    }

    @Test
    void src_to_all_dst4() {
        graph.solveFloydWarshall();
        double[] expected = {40.0, 70.0, 80.0, 0.0, -60.0, 180.0, -50.0, Double.POSITIVE_INFINITY};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(3));
    }

    @Test
    void src_to_all_dst5() {
        graph.solveFloydWarshall();
        double[] expected = {240.0, 270.0, 280.0, 200.0, 140.0, 0.0, 150.0, Double.POSITIVE_INFINITY};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(5));
    }

    @Test
    void src_to_all_dst6() {
        graph.solveFloydWarshall();
        double[] expected = {360.0, 390.0, 400.0, 320.0, 260.0, 120.0, 270.0, 0.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(7));
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveFloydWarshall();
        double[][] expected = {
                {0.0, 30.0, 40.0, -20.0, -80.0, 140.0, -70.0, Double.POSITIVE_INFINITY},
                {-10.0, 0.0, 30.0, -50.0, -110.0, 130.0, -100.0, Double.POSITIVE_INFINITY},
                {20.0, 50.0, 0.0, -20.0, -80.0, 100.0, -70.0, Double.POSITIVE_INFINITY},
                {40.0, 70.0, 80.0, 0.0, -60.0, 180.0, -50.0, Double.POSITIVE_INFINITY},
                {540.0, 570.0, 580.0, 500.0, 0.0, 300.0, 450.0, Double.POSITIVE_INFINITY},
                {240.0, 270.0, 280.0, 200.0, 140.0, 0.0, 150.0, Double.POSITIVE_INFINITY},
                {580.0, 610.0, 620.0, 540.0, 40.0, 340.0, 0.0, Double.POSITIVE_INFINITY},
                {360.0, 390.0, 400.0, 320.0, 260.0, 120.0, 270.0, 0.0}
        };

        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }

/*
    @Test
    void path_src_dst1() {
        graph.solveFloydWarshall();
        assertEquals("6->3->1->0", graph.getParents(0, 6));
    }

    @Test
    void path_src_dst2() {
        graph.solveFloydWarshall();
        assertEquals("5->2->0->3", graph.getParents(3, 5));
    }

    @Test
    void path_src_dst3() {
        graph.solveFloydWarshall();
        assertEquals("2->0->3->1", graph.getParents(1, 2));
    }

    @Test
    void path_src_dst4() {
        graph.solveFloydWarshall();
        assertEquals("0->3->5->4", graph.getParents(4, 0));
    }
*/
    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCyclesFloydWarshall());
    }
}
