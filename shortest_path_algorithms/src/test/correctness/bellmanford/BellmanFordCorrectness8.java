package test.correctness.bellmanford;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BellmanFordCorrectness8 {

    Graph graph = new Graph("src/test/graphs/big_negative.txt");

    @Test
    void src_dst_cost1() {
        graph.solveForOne(0, "2");
        assertEquals(15, graph.getDistance( 6));
    }

    @Test
    void src_dst_cost2() {
        graph.solveForOne(0, "2");
        assertEquals(27, graph.getDistance( 11));
    }

    @Test
    void src_dst_cost3() {
        graph.solveForOne(5, "2");
        assertEquals(13, graph.getDistance( 1));
    }

    @Test
    void src_dst_cost4() {
        graph.solveForOne(4, "2");
        assertEquals(6, graph.getDistance( 0));
    }
    @Test
    void src_to_all_dst1() {
        graph.solveForOne(0, "2");
        double[] expected = {0.0, -4.0, 34.0, 12.0, 22.0, 6.0, 15.0, 26.0, 8.0, 25.0, 46.0, 27.0, 3.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst2() {
        graph.solveForOne(1, "2");
        double[] expected = {32.0, 0.0, 38.0, 44.0, 54.0, 16.0, 47.0, 30.0, 17.0, 57.0, 53.0, 34.0, 12.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst3() {
        graph.solveForOne(2, "2");
        double[] expected = {36.0, 26.0, 0.0, 48.0, 30.0, 19.0, 51.0, 56.0, 21.0, 61.0, 59.0, 40.0, 16.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst4() {
        graph.solveForOne(3, "2");
        double[] expected = {11.0, 7.0, 31.0, 0.0, 33.0, -6.0, 26.0, 37.0, -4.0, 36.0, 34.0, 15.0, -9.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst5() {
        graph.solveForOne(5, "2");
        double[] expected = {17.0, 13.0, 37.0, 29.0, 39.0, 0.0, 32.0, 43.0, 2.0, 42.0, 40.0, 21.0, -3.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst6() {
        graph.solveForOne(7, "2");
        double[] expected = {2.0, -2.0, 8.0, 14.0, 24.0, -14.0, 17.0, 0.0, -13.0, 27.0, 23.0, 4.0, -18.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst7() {
        graph.solveForOne(9, "2");
        double[] expected = {30.0, 26.0, 54.0, 42.0, 52.0, 20.0, 45.0, 56.0, 21.0, 0.0, 51.0, 38.0, 16.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst8() {
        graph.solveForOne(10, "2");
        double[] expected = {-15.0, -19.0, 3.0, -3.0, 7.0, -31.0, 0.0, 11.0, -30.0, 10.0, 0.0, -13.0, -35.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void src_to_all_dst9() {
        graph.solveForOne(11, "2");
        double[] expected = {-2.0, -6.0, 16.0, 10.0, 20.0, -18.0, 13.0, 24.0, -17.0, 23.0, 19.0, 0.0, -22.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest());
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveForAll("2");
        double[][] expected = {
                {0.0, -4.0, 34.0, 12.0, 22.0, 6.0, 15.0, 26.0, 8.0, 25.0, 46.0, 27.0, 3.0},
                {32.0, 0.0, 38.0, 44.0, 54.0, 16.0, 47.0, 30.0, 17.0, 57.0, 53.0, 34.0, 12.0},
                {36.0, 26.0, 0.0, 48.0, 30.0, 19.0, 51.0, 56.0, 21.0, 61.0, 59.0, 40.0, 16.0},
                {11.0, 7.0, 31.0, 0.0, 33.0, -6.0, 26.0, 37.0, -4.0, 36.0, 34.0, 15.0, -9.0},
                {6.0, 2.0, 26.0, 18.0, 0.0, -11.0, 21.0, 32.0, -9.0, 31.0, 29.0, 10.0, -14.0},
                {17.0, 13.0, 37.0, 29.0, 39.0, 0.0, 32.0, 43.0, 2.0, 42.0, 40.0, 21.0, -3.0},
                {13.0, -19.0, 19.0, 25.0, 35.0, -3.0, 0.0, 11.0, -2.0, 10.0, 34.0, 15.0, -7.0},
                {2.0, -2.0, 8.0, 14.0, 24.0, -14.0, 17.0, 0.0, -13.0, 27.0, 23.0, 4.0, -18.0},
                {15.0, 11.0, 35.0, 27.0, 37.0, -1.0, 30.0, 41.0, 0.0, 40.0, 38.0, 19.0, -5.0},
                {30.0, 26.0, 54.0, 42.0, 52.0, 20.0, 45.0, 56.0, 21.0, 0.0, 51.0, 38.0, 16.0},
                {-15.0, -19.0, 3.0, -3.0, 7.0, -31.0, 0.0, 11.0, -30.0, 10.0, 0.0, -13.0, -35.0},
                {-2.0, -6.0, 16.0, 10.0, 20.0, -18.0, 13.0, 24.0, -17.0, 23.0, 19.0, 0.0, -22.0},
                {20.0, 16.0, 54.0, 32.0, 42.0, 26.0, 35.0, 46.0, 28.0, 45.0, 66.0, 47.0, 0.0}
        };

        assert Arrays.deepEquals(expected, graph.getAllCosts());
    }

    @Test
    void path_src_dst1() {
        graph.solveForOne(0, "2");
        assertEquals("0-3-5-8-11", graph.getParents(0, 11));
    }

    @Test
    void path_src_dst2() {
        graph.solveForOne(3, "2");
        assertEquals("3-5-8-21-0-6-1-7", graph.getParents(3, 7));
    }

    @Test
    void path_src_dst3() {
        graph.solveForOne(1, "2");
        assertEquals("1-7-2", graph.getParents(1, 2));
    }

    @Test
    void path_src_dst4() {
        graph.solveForOne(4, "2");
        assertEquals("4-5-8-21-0", graph.getParents(4, 0));
    }

    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCycles("1"));
    }
}
