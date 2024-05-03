package test.efficiency.bellmanford;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

@RunWith(Parameterized.class)
public class BellmanFordEfficiency4 {
    private final Graph graph;
    private long time = System.nanoTime();

    public BellmanFordEfficiency4(String filepath) {
        graph = new Graph(filepath);
    }

    @Parameterized.Parameters(name = "Graph size = {0}")
    public static Collection<Object[]> data() throws FileNotFoundException {
        List<Object[]> paths = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/test/graphs/paths_negative.txt"));
        while (scanner.hasNextLine()) {
            paths.add(new Object[]{scanner.nextLine()});
        }
        return paths;
    }

    @Test
    public void all_nodes() {
        graph.solveForAll("2");
    }

    @Before
    public void beforeEach() {
        time = System.nanoTime();
    }

    @After
    public void printAnalysis() {
        time = System.nanoTime() - time;
        try (FileWriter writer = new FileWriter("src/test/bellmanford_all_nodes_negative.csv", true)) {
            String data = "";
            data += graph.getSize() + "," + graph.getEdges() + "," + time + "\n";
            writer.write(data.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
