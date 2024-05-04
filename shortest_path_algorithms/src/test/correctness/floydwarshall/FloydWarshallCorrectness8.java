package test.correctness.floydwarshall;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FloydWarshallCorrectness8 {


    Graph graph = new Graph("src/test/graphs/big_negative.txt");

    @Test
    void src_dst_cost1() {
        graph.solveForOne(0, "3");
        assertEquals(15, graph.getDistance(0, 6));
    }

    @Test
    void src_dst_cost2() {
        graph.solveForOne(0, "3");
        assertEquals(27, graph.getDistance(0, 11));
    }

    @Test
    void src_dst_cost3() {
        graph.solveForOne(5, "3");
        assertEquals(13, graph.getDistance(5, 1));
    }

    @Test
    void src_dst_cost4() {
        graph.solveForOne(4, "3");
        assertEquals(6, graph.getDistance(4, 0));
    }
    @Test
    void src_to_all_dst1() {
        graph.solveForOne(0, "3");
        double[] expected = {0.0, -4.0, 34.0, 12.0, 22.0, 6.0, 15.0, 26.0, 8.0, 25.0, 46.0, 27.0, 3.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(0));
    }

    @Test
    void src_to_all_dst2() {
        graph.solveForOne(1, "3");
        double[] expected = {32.0, 0.0, 38.0, 44.0, 54.0, 16.0, 47.0, 30.0, 17.0, 57.0, 53.0, 34.0, 12.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(1));
    }

    @Test
    void src_to_all_dst3() {
        graph.solveForOne(2, "3");
        double[] expected = {36.0, 26.0, 0.0, 48.0, 30.0, 19.0, 51.0, 56.0, 21.0, 61.0, 59.0, 40.0, 16.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(2));
    }

    @Test
    void src_to_all_dst4() {
        graph.solveForOne(3, "3");
        double[] expected = {11.0, 7.0, 31.0, 0.0, 33.0, -6.0, 26.0, 37.0, -4.0, 36.0, 34.0, 15.0, -9.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(3));
    }

    @Test
    void src_to_all_dst5() {
        graph.solveForOne(5, "3");
        double[] expected = {17.0, 13.0, 37.0, 29.0, 39.0, 0.0, 32.0, 43.0, 2.0, 42.0, 40.0, 21.0, -3.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(5));
    }

    @Test
    void src_to_all_dst6() {
        graph.solveForOne(7, "3");
        double[] expected = {2.0, -2.0, 8.0, 14.0, 24.0, -14.0, 17.0, 0.0, -13.0, 27.0, 23.0, 4.0, -18.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(7));
    }

    @Test
    void src_to_all_dst7() {
        graph.solveForOne(9, "3");
        double[] expected = {30.0, 26.0, 54.0, 42.0, 52.0, 20.0, 45.0, 56.0, 21.0, 0.0, 51.0, 38.0, 16.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(9));
    }

    @Test
    void src_to_all_dst8() {
        graph.solveForOne(10, "3");
        double[] expected = {-15.0, -19.0, 3.0, -3.0, 7.0, -31.0, 0.0, 11.0, -30.0, 10.0, 0.0, -13.0, -35.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(10));
    }

    @Test
    void src_to_all_dst9() {
        graph.solveForOne(11, "3");
        double[] expected = {-2.0, -6.0, 16.0, 10.0, 20.0, -18.0, 13.0, 24.0, -17.0, 23.0, 19.0, 0.0, -22.0};
        assert Arrays.equals(expected, graph.getDistanceToAllDest(11));
    }

    @Test
    void all_nodes_to_all_nodes() {
        graph.solveForAll("3");
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
/*
    @Test
    void path_src_dst1() {
        graph.solveForOne(0, "3");
        assertEquals("11->8->5->3->0", graph.getParents(0, 11));
    }

    @Test
    void path_src_dst2() {
        graph.solveForOne(3, "3");
        assertEquals("7->1->6->0->12->8->5->3", graph.getParents(3, 7));
    }

    @Test
    void path_src_dst3() {
        graph.solveForOne(1, "3");
        assertEquals("2->7->1", graph.getParents(1, 2));
    }

    @Test
    void path_src_dst4() {
        graph.solveForOne(4, "3");
        assertEquals("0->12->8->5->4", graph.getParents(4, 0));
    }
*/
    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCycles("2"));
    }

}
