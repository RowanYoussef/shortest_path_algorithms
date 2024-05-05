package algorithms;

import models.Edge;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    private List<Edge>[] adjList;

    public BellmanFord(List<Edge>[] adjList){
        this.adjList = adjList;
    }

    public boolean solveBellmanFordAll(int src, int[][] parent, double[][] cost) {
        int v = adjList.length;
        double [] previous = new double[v];
        init(cost,parent,src,previous);
        for (int i = 0; i < v - 1; i++) {
            for (int j = 0; j < v; j++) {
                for (Edge edge : adjList[j]) {
                    int node = edge.getDest();
                    double nodeCost = edge.getCost();
                    if (previous [j] != Double.MAX_VALUE && nodeCost + previous[j] < cost[src][node]) {
                        cost[src][node] = nodeCost + cost[src][j];
                        parent[src][node] = j;
                    }
                }
            }
            previous = cost[src].clone();
        }
        return !(negativeCycle(cost[src],parent[src]));
    }

    public boolean solveBellmanFord(int src, int[] parent, double[] cost) {
        int v = adjList.length;
        double [] previous = new double[v];
        init(cost,parent,src,previous);
        for (int i = 0; i < v - 1; i++) {
            for (int j = 0; j < v; j++) {
                for (Edge edge : adjList[j]) {
                    int node = edge.getDest();
                    double nodeCost = edge.getCost();
                    if (previous[j] != Double.MAX_VALUE && nodeCost + previous[j] < cost[node]) {
                        cost[node] = nodeCost + cost[j];
                        parent[node] = j;
                    }
                }
            }
            previous = cost.clone();
        }
        return !(negativeCycle(cost,parent));
    }

    //initialize arrays
    private void init(double[][] cost,int[][] parent,int src,double [] previous){
        Arrays.fill(previous,Double.MAX_VALUE);
        Arrays.fill(cost[src],Double.MAX_VALUE);
        Arrays.fill(parent[src],-1);
        previous[src] = 0;
        cost[src][src] = 0;
    }

    private void init(double[] cost,int[] parent,int src,double[] previous){
        Arrays.fill(previous,Double.MAX_VALUE);
        Arrays.fill(cost,Double.MAX_VALUE);
        Arrays.fill(parent,-1);
        previous[src] = 0;
        cost[src] = 0;
    }
    //check of the graph contains negative cycles
    public boolean negativeCycle(double[][] cost,int[][] parent){
        for (int i = 0; i < adjList.length ; i++) {
            for (Edge edge : adjList[i]) {
                if (cost[0][i] != Double.MAX_VALUE && cost[0][i] + edge.getCost() < cost[0][edge.getDest()])
                    return true;
            }
        }
        return false;
    }

    public boolean negativeCycle(double[] cost,int[] parent){
        for (int i = 0; i < adjList.length ; i++) {
            for (Edge edge : adjList[i]) {
                if (cost[i] != Double.MAX_VALUE && cost[i] + edge.getCost() < cost[edge.getDest()])
                    return true;
            }
        }
        return false;
    }
}
