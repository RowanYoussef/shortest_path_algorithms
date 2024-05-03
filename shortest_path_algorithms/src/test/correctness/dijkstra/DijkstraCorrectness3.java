package test.correctness.dijkstra;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraCorrectness3 {

    Graph graph = new Graph("src/test/graphs/medium_positive2.txt");

    @Test
    void src_dst_cost1() {
        graph.solveDijkstra(0);
        assertEquals(110, graph.getDistance(0, 6));
    }

    @Test
    void src_dst_cost2() {
        graph.solveDijkstra(0);
        assertEquals(50, graph.getDistance(0, 4));
    }

    @Test
    void src_dst_cost3() {
        graph.solveDijkstra(5);
        assertEquals(270, graph.getDistance(5, 1));
    }

    @Test
    void src_dst_cost4() {
        graph.solveDijkstra(4);
        assertEquals(540, graph.getDistance(4, 0));
    }

    @Test
    void src_to_all_dst1() {
        graph.solveDijkstra(0);
        double[] expected = {0.0, 30.0, 40.0, 60.0, 50.0, 140.0, 110.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(0));
    }

    @Test
    void src_to_all_dst2() {
        graph.solveDijkstra(1);
        double[] expected = {90.0, 0.0, 130.0, 50.0, 20.0, 230.0, 100.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(1));
    }

    @Test
    void src_to_all_dst3() {
        graph.solveDijkstra(2);
        double[] expected = {60.0, 90.0, 0.0, 20.0, 80.0, 100.0, 70.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(2));
    }

    @Test
    void src_to_all_dst4() {
        graph.solveDijkstra(3);
        double[] expected = {40.0, 70.0, 80.0, 0.0, 60.0, 180.0, 50.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(3));
    }

    @Test
    void src_to_all_dst5() {
        graph.solveDijkstra(5);
        double[] expected = {240.0, 270.0, 280.0, 200.0, 260.0, 0.0, 250.0, Double.MAX_VALUE};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(5));
    }

    @Test
    void src_to_all_dst6() {
        graph.solveDijkstra(7);
        double[] expected = {360.0, 390.0, 400.0, 320.0, 380.0, 120.0, 370.0, 0.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(7));
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveDijkstraAll();
        double[][] expected = {
                {0.0, 30.0, 40.0, 60.0, 50.0, 140.0, 110.0, Double.MAX_VALUE},
                {90.0, 0.0, 130.0, 50.0, 20.0, 230.0, 100.0, Double.MAX_VALUE},
                {60.0, 90.0, 0.0, 20.0, 80.0, 100.0, 70.0, Double.MAX_VALUE},
                {40.0, 70.0, 80.0, 0.0, 60.0, 180.0, 50.0, Double.MAX_VALUE},
                {540.0, 570.0, 580.0, 500.0, 0.0, 300.0, 550.0, Double.MAX_VALUE},
                {240.0, 270.0, 280.0, 200.0, 260.0, 0.0, 250.0, Double.MAX_VALUE},
                {580.0, 610.0, 620.0, 540.0, 40.0, 340.0, 0.0, Double.MAX_VALUE},
                {360.0, 390.0, 400.0, 320.0, 380.0, 120.0, 370.0, 0.0}
        };
        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }

    @Test
    void path_src_dst1() {
        graph.solveDijkstra(0);
        assertEquals("6->3->2->0", graph.getParents(0, 6));
    }

    @Test
    void path_src_dst2() {
        graph.solveDijkstra(3);
        assertEquals("5->2->0->3", graph.getParents(3, 5));
    }

    @Test
    void path_src_dst3() {
        graph.solveDijkstra(1);
        assertEquals("2->0->3->1", graph.getParents(1, 2));
    }

    @Test
    void path_src_dst4() {
        graph.solveDijkstra(4);
        assertEquals("0->3->5->4", graph.getParents(4, 0));

    }
}