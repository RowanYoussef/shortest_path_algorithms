package test.correctness.floydwarshall;

import models.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FloydWarshallCorrectness11 {

    Graph graph = new Graph("src/test/graphs/large.txt");

    @Test
    void src_dst_cost1() {
        graph.solveForOne(1, "3");
        assertEquals(3, graph.getDistance(1, 3));
    }

    @Test
    void src_dst_cost2() {
        graph.solveForOne(1, "3");
        assertEquals(2, graph.getDistance(1, 2));
    }

    @Test
    void src_dst_cost3() {
        graph.solveForOne(0, "3");
        assertEquals(5, graph.getDistance(0, 3));
    }

    @Test
    void src_dst_cost4() {
        graph.solveForOne(0, "3");
        assertEquals(0, graph.getDistance(0, 0));
    }

    @Test
    void src_dst_cost5() {
        graph.solveForOne(0, "3");
        assertEquals(5, graph.getDistance(0, 2));
    }

    @Test
    void src_dst_cost6() {
        graph.solveForOne(3, "3");
        assertEquals(Double.POSITIVE_INFINITY, graph.getDistance(3, 0));
    }

    /*
        @Test
        void path_src_dst() {
            graph.solveForOne(0, "3");
            assertEquals("2->1->0", graph.getParents(0, 2));
        }
    */
    @Test
    void has_negative_cycle() {
        assertFalse(graph.containsCycles("2"));
    }
}
