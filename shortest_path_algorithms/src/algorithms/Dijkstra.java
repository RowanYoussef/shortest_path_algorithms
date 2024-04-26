package algorithms;

import models.Edge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    private boolean[] visited;
    public void solveDijkstra(int src, int[][] parent, double[][] cost, List<Edge>[] adjList){
       init(cost,adjList.length,parent,src);
       cost[src][src] = 0;
        //minHeap to reduce complexity
        PriorityQueue<Edge> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p1.getCost(), p2.getCost()));
        pq.add(new Edge(src,0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int node = e.getDest();
            double nodeCost = e.getCost();
            visited[node] = true;
            if(nodeCost > cost[src][node]) continue;
            for(int i = 0;i < adjList[node].size(); i++){
                int x = adjList[node].get(i).getDest();
                double dis = adjList[node].get(i).getCost();
                if(!visited[x] && (dis+cost[src][node]) < cost[src][x]){
                   cost[src][x] = dis+cost[src][node];
                   parent[src][x] = node;
                   pq.add(new Edge(x,dis+cost[src][node]));
                }
            }

        }
    }

    //initialize arrays
    private void init(double[][] cost,int n,int[][] parent,int src){
        Arrays.fill(cost[src],Double.MAX_VALUE);
        Arrays.fill(parent[src],-1);
        visited = new boolean[n];
        Arrays.fill(visited,false);
    }
}
