package test.correctness.dijkstra;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraCorrectness4 {

    Graph graph = new Graph("src/test/graphs/big_positive.txt");

    @Test
    void src_dst_cost1() {
        graph.solveDijkstra(0);
        assertEquals(15, graph.getDistance(0, 6));
    }

    @Test
    void src_dst_cost2() {
        graph.solveDijkstra(0);
        assertEquals(39, graph.getDistance(0, 11));
    }

    @Test
    void src_dst_cost3() {
        graph.solveDijkstra(5);
        assertEquals(61, graph.getDistance(5, 1));
    }

    @Test
    void src_dst_cost4() {
        graph.solveDijkstra(4);
        assertEquals(38, graph.getDistance(4, 0));
    }
    @Test
    void src_to_all_dst1() {
        graph.solveDijkstra(0);
        double[] expected = {0.0, 34.0, 35.0, 12.0, 22.0, 18.0, 15.0, 64.0, 20.0, 25.0, 58.0, 39.0, 10.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(0));
    }

    @Test
    void src_to_all_dst2() {
        graph.solveDijkstra(1);
        double[] expected = {76.0, 0.0, 38.0, 88.0, 68.0, 52.0, 91.0, 30.0, 51.0, 73.0, 53.0, 34.0, 56.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(1));
    }

    @Test
    void src_to_all_dst3() {
        graph.solveDijkstra(2);
        double[] expected = {68.0, 26.0, 0.0, 80.0, 30.0, 41.0, 63.0, 56.0, 43.0, 73.0, 79.0, 60.0, 48.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(2));
    }

    @Test
    void src_to_all_dst4() {
        graph.solveDijkstra(3);
        double[] expected = {33.0, 67.0, 43.0, 0.0, 55.0, 6.0, 48.0, 97.0, 8.0, 58.0, 46.0, 27.0, 13.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(3));
    }

    @Test
    void src_to_all_dst5() {
        graph.solveDijkstra(5);
        double[] expected = {27.0, 61.0, 37.0, 39.0, 49.0, 0.0, 42.0, 91.0, 2.0, 52.0, 40.0, 21.0, 7.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(5));
    }

    @Test
    void src_to_all_dst6() {
        graph.solveDijkstra(7);
        double[] expected = {46.0, 34.0, 8.0, 58.0, 38.0, 22.0, 61.0, 0.0, 21.0, 43.0, 23.0, 4.0, 26.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(7));
    }

    @Test
    void src_to_all_dst7() {
        graph.solveDijkstra(9);
        double[] expected = {30.0, 64.0, 65.0, 42.0, 52.0, 48.0, 45.0, 94.0, 50.0, 0.0, 51.0, 64.0, 40.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(9));
    }

    @Test
    void src_to_all_dst8() {
        graph.solveDijkstra(10);
        double[] expected = {50.0, 55.0, 29.0, 62.0, 59.0, 31.0, 65.0, 85.0, 30.0, 20.0, 0.0, 13.0, 35.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(10));
    }

    @Test
    void src_to_all_dst9() {
        graph.solveDijkstra(11);
        double[] expected = {42.0, 42.0, 16.0, 54.0, 46.0, 18.0, 57.0, 72.0, 17.0, 39.0, 19.0, 0.0, 22.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(11));
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveDijkstraAll();
        double[][] expected = {
                {0.0, 34.0, 35.0, 12.0, 22.0, 18.0, 15.0, 64.0, 20.0, 25.0, 58.0, 39.0, 10.0},
                {76.0, 0.0, 38.0, 88.0, 68.0, 52.0, 91.0, 30.0, 51.0, 73.0, 53.0, 34.0, 56.0},
                {68.0, 26.0, 0.0, 80.0, 30.0, 41.0, 63.0, 56.0, 43.0, 73.0, 79.0, 60.0, 48.0},
                {33.0, 67.0, 43.0, 0.0, 55.0, 6.0, 48.0, 97.0, 8.0, 58.0, 46.0, 27.0, 13.0},
                {38.0, 15.0, 48.0, 50.0, 0.0, 11.0, 33.0, 45.0, 13.0, 43.0, 51.0, 32.0, 18.0},
                {27.0, 61.0, 37.0, 39.0, 49.0, 0.0, 42.0, 91.0, 2.0, 52.0, 40.0, 21.0, 7.0},
                {40.0, 19.0, 20.0, 52.0, 50.0, 58.0, 0.0, 49.0, 60.0, 10.0, 61.0, 53.0, 50.0},
                {46.0, 34.0, 8.0, 58.0, 38.0, 22.0, 61.0, 0.0, 21.0, 43.0, 23.0, 4.0, 26.0},
                {25.0, 59.0, 35.0, 37.0, 47.0, 1.0, 40.0, 89.0, 0.0, 50.0, 38.0, 19.0, 5.0},
                {30.0, 64.0, 65.0, 42.0, 52.0, 48.0, 45.0, 94.0, 50.0, 0.0, 51.0, 64.0, 40.0},
                {50.0, 55.0, 29.0, 62.0, 59.0, 31.0, 65.0, 85.0, 30.0, 20.0, 0.0, 13.0, 35.0},
                {42.0, 42.0, 16.0, 54.0, 46.0, 18.0, 57.0, 72.0, 17.0, 39.0, 19.0, 0.0, 22.0},
                {20.0, 54.0, 55.0, 32.0, 42.0, 38.0, 35.0, 84.0, 40.0, 45.0, 78.0, 59.0, 0.0}
        };

        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }

    @Test
    void path_src_dst1() {
        graph.solveDijkstra(0);
        assertEquals("11->8->5->3->0", graph.getParents(0, 11));
    }

    @Test
    void path_src_dst2() {
        graph.solveDijkstra(3);
        assertEquals("7->1->6->0->12->8->5->3", graph.getParents(3, 7));
    }

    @Test
    void path_src_dst3() {
        graph.solveDijkstra(1);
        assertEquals("2->7->1", graph.getParents(1, 2));
    }

    @Test
    void path_src_dst4() {
        graph.solveDijkstra(4);
        assertEquals("0->12->8->5->4", graph.getParents(4, 0));
    }
}
