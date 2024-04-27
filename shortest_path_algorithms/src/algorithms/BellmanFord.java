package algorithms;

import models.Edge;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    private List<Edge>[] adjList;

    public BellmanFord(List<Edge>[] adjList){
        this.adjList = adjList;
    }

    public void solveBellmanFord(int src, int[][] parent, double[][] cost) {
        init(cost,parent,src);
        int v = adjList.length;
        for (int i = 0; i < v - 1; i++) {
            for (int j = 0; j < v; j++) {
                for (Edge edge : adjList[j]) {
                    int node = edge.getDest();
                    double nodeCost = edge.getCost();
                    if (cost[src][j] != Double.MAX_VALUE && nodeCost + cost[src][j] < cost[src][node]) {
                        cost[src][node] = nodeCost + cost[src][j];
                        parent[src][node] = j;
                    }
                }
            }
        }
    }

    //initialize arrays
    private void init(double[][] cost,int[][] parent,int src){
        Arrays.fill(cost[src],Double.MAX_VALUE);
        Arrays.fill(parent[src],-1);
        cost[src][src] = 0;
    }
    //check of the graph contains negative cycles
    public boolean negativeCycle(double[][] cost,int[][] parent){
        solveBellmanFord(0,parent,cost);
        for (int i = 0; i < adjList.length ; i++) {
            for (Edge edge : adjList[i]) {
                if (cost[0][i] != Double.MAX_VALUE && cost[0][i] + edge.getCost() < cost[0][edge.getDest()])
                    return true;
            }
        }
        return false;
    }
}
