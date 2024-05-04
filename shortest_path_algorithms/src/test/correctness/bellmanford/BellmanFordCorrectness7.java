package test.correctness.bellmanford;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BellmanFordCorrectness7 {

    Graph graph = new Graph("src/test/graphs/medium_negative2.txt");

    @Test
    void src_dst_cost1() {
        graph.solveForOne(0, "2");
        assertEquals(-70, graph.getDistance( 6));
    }

    @Test
    void src_dst_cost2() {
        graph.solveForOne(0, "2");
        assertEquals(-80, graph.getDistance( 4));
    }

    @Test
    void src_dst_cost3() {
        graph.solveForOne(5, "2");
        assertEquals(270, graph.getDistance( 1));
    }

    @Test
    void src_dst_cost4() {
        graph.solveForOne(4, "2");
        assertEquals(540, graph.getDistance( 0));
    }

    @Test
    void src_to_all_dst1() {
        graph.solveForOne(0, "2");
        double[] expected = {0.0, 30.0, 40.0, -20.0, -80.0, 140.0, -70.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst2() {
        graph.solveForOne(1, "2");
        double[] expected = {-10.0, 0.0, 30.0, -50.0, -110.0, 130.0, -100.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst3() {
        graph.solveForOne(2, "2");
        double[] expected = {20.0, 50.0, 0.0, -20.0, -80.0, 100.0, -70.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst4() {
        graph.solveForOne(3, "2");
        double[] expected = {40.0, 70.0, 80.0, 0.0, -60.0, 180.0, -50.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst5() {
        graph.solveForOne(5, "2");
        double[] expected = {240.0, 270.0, 280.0, 200.0, 140.0, 0.0, 150.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst6() {
        graph.solveForOne(7, "2");
        double[] expected = {360.0, 390.0, 400.0, 320.0, 260.0, 120.0, 270.0, 0.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveForAll("2");
        double[][] expected = {
                {0.0, 30.0, 40.0, -20.0, -80.0, 140.0, -70.0, Double.MAX_VALUE},
                {-10.0, 0.0, 30.0, -50.0, -110.0, 130.0, -100.0, Double.MAX_VALUE},
                {20.0, 50.0, 0.0, -20.0, -80.0, 100.0, -70.0, Double.MAX_VALUE},
                {40.0, 70.0, 80.0, 0.0, -60.0, 180.0, -50.0, Double.MAX_VALUE},
                {540.0, 570.0, 580.0, 500.0, 0.0, 300.0, 450.0, Double.MAX_VALUE},
                {240.0, 270.0, 280.0, 200.0, 140.0, 0.0, 150.0, Double.MAX_VALUE},
                {580.0, 610.0, 620.0, 540.0, 40.0, 340.0, 0.0, Double.MAX_VALUE},
                {360.0, 390.0, 400.0, 320.0, 260.0, 120.0, 270.0, 0.0}
        };

        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }

    @Test
    void path_src_dst1() {
        graph.solveForOne(0, "2");
        assertEquals("0-1-3-6", graph.getParents(0, 6));
    }

    @Test
    void path_src_dst2() {
        graph.solveForOne(3, "2");
        assertEquals("3-0-2-5", graph.getParents(3, 5));
    }

    @Test
    void path_src_dst3() {
        graph.solveForOne(1, "2");
        assertEquals("1-3-0-2", graph.getParents(1, 2));
    }

    @Test
    void path_src_dst4() {
        graph.solveForOne(4, "2");
        assertEquals("4-5-3-0", graph.getParents(4, 0));
    }

    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCycles("1"));
    }
}
