package algorithms;

import models.Edge;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {


    private final double[][] initialCosts;


    public FloydWarshall(List<Edge>[] adjList) {

        int n = adjList.length;
        initialCosts = new double[n][n];

        // Initialize the costs matrix with positive infinity
        for (double[] row : initialCosts) {
            Arrays.fill(row, Double.POSITIVE_INFINITY);
        }

        // Set the costs of the edges
        for (int i = 0; i < n; i++) {
            initialCosts[i][i] = 0; // The cost of the path from a node to itself is 0

            // Set the costs of the edges
            for (Edge edge : adjList[i]) {
                initialCosts[i][edge.getDest()] = edge.getCost();
            }
        }
    }


    public void init(double[][] costs, int[][] predecessors) {
        for(int i = 0; i < costs.length; i++) {
            for(int j = 0; j < costs.length; j++) {
                costs[i][j] = initialCosts[i][j];
                predecessors[i][j] = i;
            }
        }
    }
    public boolean solve(double[][] costs, int[][] predecessors) {

        init(costs, predecessors);
        int n = costs.length;

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {

                    if(costs[i][k] != Double.POSITIVE_INFINITY && costs[k][j] != Double.POSITIVE_INFINITY) {
                        double newCost = costs[i][k] + costs[k][j];
                        if(newCost < costs[i][j]) {
                            costs[i][j] = newCost;  // Update the cost
                            predecessors[i][j] = predecessors[k][j];  // Update the predecessor
                        }
                    }
                }
            }

//            //printing the steps for debugging
//            System.out.println("Iteration " + k);
//            for (int i = 0; i < costs.length; i++) {
//                for (int j = 0; j < costs.length; j++) {
//                    System.out.print(costs[i][j] + " ");
//                }
//                System.out.println();
//            }
        }

        return !containsNegativeCycle(costs);
    }

    public boolean containsNegativeCycle(double[][] solvedCosts) {

        for (int i = 0; i < solvedCosts.length; i++) {
            if (solvedCosts[i][i] < 0) {
                return true;
            }
        }
        return false;
    }

    public void printShortestPath(int src, int dest, int[][] predecessors, double[][] solvedCosts) {
        List<Integer> path = new ArrayList<>();
        List<Double> edgeCosts = new ArrayList<>();
        for (int at = dest; at != src; at = predecessors[src][at]) {
            if (at == -1) {
                System.out.println("There is no path from node " + src + " to node " + dest);
                return;
            }
            path.add(at);
            edgeCosts.add(initialCosts[predecessors[src][at]][at]);
        }
        path.add(src);
        // reverse the path
        for(int i = 0; i < path.size() / 2; i++) {
            int temp = path.get(i);
            path.set(i, path.get(path.size() - i - 1));
            path.set(path.size() - i - 1, temp);
        }

        System.out.println("Shortest path is: " + path);
        System.out.println("Cost of the path is: " + edgeCosts);
        double sum = 0;
        for (double cost : edgeCosts) {
            sum += cost;
        }
        System.out.println("Total cost is: " + sum + " while the calculated cost is: " + solvedCosts[src][dest]);

        if(sum != solvedCosts[src][dest]) {
            System.out.println("The calculated cost is not equal to the sum of the edge costs. Perhaps there is a negative cycle.");
        }

    }



    public static void main(String[] args) {
// Test the Floyd-Warshall algorithm
        List<Edge>[] adjList = new List[5];
        for (int i = 0; i < 5; i++) {
            adjList[i] = new ArrayList<>();
        }
        adjList[0].add(new Edge(1, 1));
        adjList[1].add(new Edge(2, 1));
        adjList[2].add(new Edge(3, -1));
        adjList[3].add(new Edge(4, -10));
        adjList[4].add(new Edge(0, 1));

        FloydWarshall floydWarshall = new FloydWarshall(adjList);
        double[][] costs = new double[5][5];
        int[][] predecessors = new int[5][5];
        floydWarshall.solve(costs, predecessors);


        System.out.println("Calculated Costs:");
        for (double[] cost : costs) {
            for (int j = 0; j < costs.length; j++) {
                System.out.print(cost[j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Predecessors:");
        for (int[] predecessor : predecessors) {
            for (int j = 0; j < predecessors.length; j++) {
                System.out.print(predecessor[j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < costs.length; i++) {
            for(int j = 0; j < costs.length; j++) {
                System.out.println("Shortest path from " + i + " to " + j);
                floydWarshall.printShortestPath(i, j, predecessors, costs);
                System.out.println();
            }
        }

        System.out.println(floydWarshall.containsNegativeCycle(costs) ? "The graph contains a negative cycle" : "The graph does not contain a negative cycle");
    }



}