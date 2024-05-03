package algorithms;

import models.Edge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    private boolean[] visited;
    List<Edge>[] adjList;
    public Dijkstra(List<Edge>[] adjList){ this.adjList = adjList; }

    public void solveDijkstraAll(int src,int[][] parent,double[][] cost){
       initAll(cost,adjList.length,parent,src);
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
            for(Edge edge : adjList[node]){
                int x = edge.getDest();
                double dis = edge.getCost();
                if(!visited[x] && (dis+cost[src][node]) < cost[src][x]){
                   cost[src][x] = dis+cost[src][node];
                   parent[src][x] = node;
                   pq.add(new Edge(x,dis+cost[src][node]));
                }
            }

        }
    }

    public void solveDijkstra(int src,int[] parent,double[] cost){
        init(cost,adjList.length,parent,src);
        cost[src] = 0;
        //minHeap to reduce complexity
        PriorityQueue<Edge> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p1.getCost(), p2.getCost()));
        pq.add(new Edge(src,0));
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int node = e.getDest();
            double nodeCost = e.getCost();
            visited[node] = true;
            if(nodeCost > cost[node]) continue;
            for(Edge edge : adjList[node]){
                int x = edge.getDest();
                double dis = edge.getCost();
                if(!visited[x] && (dis+cost[node]) < cost[x]){
                    cost[x] = dis+cost[node];
                    parent[x] = node;
                    pq.add(new Edge(x,dis+cost[node]));
                }
            }

        }
    }

    //initialize arrays
    private void initAll(double[][] cost,int n,int[][] parent,int src){
        Arrays.fill(cost[src],Double.MAX_VALUE);
        Arrays.fill(parent[src],-1);
        visited = new boolean[n];
        Arrays.fill(visited,false);
    }

    private void init(double[] cost,int n,int[] parent,int src){
        Arrays.fill(cost,Double.MAX_VALUE);
        Arrays.fill(parent,-1);
        visited = new boolean[n];
        Arrays.fill(visited,false);
    }
}
