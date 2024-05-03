package models;

import algorithms.BellmanFord;
import algorithms.Dijkstra;
import algorithms.FloydWarshall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
    private int v;
    private int e;
    private List<Edge>[] adjList;
    private int [][] predecessor;
    private double[][] costs;

    public Graph(String file){
       init(file);
       initArrays();
    }

    //read the input file
    private void init(String file)  {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] ve = reader.readLine().split(" ");
            v = Integer.parseInt(ve[0]);
            e = Integer.parseInt(ve[1]);
            //initialize the adjacency matrix
            adjList = new ArrayList[v];
            for (int i = 0; i < v; i++)
                adjList[i] = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                String[] edge = reader.readLine().split(" ");
                int source = Integer.parseInt(edge[0]);
                int dest = Integer.parseInt(edge[1]);
                double cost = Double.parseDouble(edge[2]);
                adjList[source].add(new Edge(dest, cost));
            }
        }catch (IOException e) {
                e.printStackTrace();
            }

        }

        private void initArrays(){
        costs = new double[v][v];
        predecessor = new int[v][v];
        }

        public int getSize(){
        return v;
        }

        //solve dijkstra for one node
        public void solveDijkstra(int src){
            Dijkstra d = new Dijkstra();
            d.solveDijkstra(src,predecessor,costs,adjList);
        }

        //solve bellmanFord for one node
        public void solveBellmanFord(int src){
            BellmanFord b = new BellmanFord(adjList);
            b.solveBellmanFord(src,predecessor,costs);
        }

        //solve dijkstra for all nodes
        public void solveDijkstraAll(){
            Dijkstra d = new Dijkstra();
            for(int i = 0;i < v;i++)
                d.solveDijkstra(i,predecessor,costs,adjList);
        }

        //solve bellmanFord for all nodes
        public void solveBellmanFordAll(){
            BellmanFord b = new BellmanFord(adjList);
            for(int i =0;i < v;i++)
             b.solveBellmanFord(i,predecessor,costs);
        }

        public void solveFloydWarshall() {
            FloydWarshall floydWarshall = new FloydWarshall(adjList);
            floydWarshall.solve(costs, predecessor);
        }

        //check if the graph contains negative cycles
        public boolean containsCyclesBellmanFord(){
          BellmanFord b = new BellmanFord(adjList);
          return b.negativeCycle(costs,predecessor);
        }

        public boolean containsCyclesFloydWarshall() {
            FloydWarshall f = new FloydWarshall(adjList);
            f.solve(costs, predecessor);
            return f.containsNegativeCycle(costs);
        }

        //get the cost from one node to another
        public double getDistance(int src,int dest) {
            return costs[src][dest];
        }

        public double[] getDistanceToAllDest(int src) {
            return costs[src];
        }

        public double[][] getAllCosts() {
            return costs;
        }

        //get the parents of a node
        public String getParents(int src,int dest){
        String s = "";
        int x = dest;
        while(x != -1){
            s += x;
            if(x != src) s+= "->";
            x = predecessor[src][x];
        }
            return s;
        }
        //print the graph
        public void print(){
        for(int i =0;i < v;i++){
            for(int j =0;j<adjList[i].size();j++){
                System.out.println(i+"->"+adjList[i].get(j).getDest()+","+adjList[i].get(j).getCost());
            }
        }
        }
    }

