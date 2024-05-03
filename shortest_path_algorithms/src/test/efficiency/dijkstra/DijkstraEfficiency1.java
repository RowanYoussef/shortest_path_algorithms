package test.efficiency.dijkstra;

import models.Graph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@RunWith(Parameterized.class)
public class DijkstraEfficiency1 {
    private final Graph graph;
    private final Random random = new Random();
    private long time;

    public DijkstraEfficiency1(String filepath) {
        graph = new Graph(filepath);
    }

    @Parameterized.Parameters(name = "Graph size = {0}")
    public static Collection<Object[]> data() throws FileNotFoundException {
        List<Object[]> paths = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/test/graphs/paths_positive.txt"));
        while (scanner.hasNextLine()) {
            paths.add(new Object[]{scanner.nextLine()});
        }
        return paths;
    }

    @Test(timeout = 1000)
    public void src_to_nodes1() {
        int src = random.nextInt(graph.getSize());
        graph.solveDijkstra(src);
    }

    @Test(timeout = 1000)
    public void src_to_nodes2() {
        int src = random.nextInt(graph.getSize());
        graph.solveDijkstra(src);
    }

    @Test(timeout = 1000)
    public void src_to_nodes3() {
        int src = random.nextInt(graph.getSize());
        graph.solveDijkstra(src);
    }

    @Test(timeout = 1000)
    public void src_to_nodes4() {
        int src = random.nextInt(graph.getSize());
        graph.solveDijkstra(src);
    }

    @Test(timeout = 1000)
    public void src_to_nodes5() {
        int src = random.nextInt(graph.getSize());
        graph.solveDijkstra(src);
    }

    @Before
    public void batchInsertAll() {
        time = System.nanoTime();
    }

    @After
    public void printAnalysis() {
        time = System.nanoTime() - time;
        try (FileWriter writer = new FileWriter("src/test/dijkstra_source.csv", true)) {
            String data = "";
            data += graph.getSize() + "," + graph.getEdges() + "," + time + "\n";
            writer.write(data.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
