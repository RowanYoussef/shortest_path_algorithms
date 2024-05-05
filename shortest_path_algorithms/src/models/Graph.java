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
    private int [] predecessor1;
    private double[][] costs;
    private double[] costs1;

    public Graph(String file){
        init(file);
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

    private void initArrays1(){
        costs1 = new double[v];
        predecessor1 = new int[v];
    }

    public int getSize(){
        return v;
    }

    public int getEdges() {
        return e;
    }

    //solve for one node
    public boolean solveForOne(int src,String algorithm){
        switch(algorithm){
            case "1"-> {
                initArrays1();
                Dijkstra d = new Dijkstra(adjList);
                d.solveDijkstra(src,predecessor1,costs1);
                return true;
            }
            case "2"-> {
                initArrays1();
                BellmanFord b = new BellmanFord(adjList);
                return b.solveBellmanFord(src,predecessor1,costs1);
            }
            case "3"-> {
                initArrays();
                FloydWarshall f = new FloydWarshall(adjList);
                return f.solve(costs,predecessor);
            }
        }
        return true;
    }
    //solve for all nodes
    public boolean solveForAll(String algorithm) {
        initArrays();
        switch (algorithm) {
            case "1" -> {
                Dijkstra d = new Dijkstra(adjList);
                for (int i = 0; i < v; i++)
                    d.solveDijkstraAll(i, predecessor, costs);
                return true;
            }
            case "2" -> {
                boolean notCycle = true;
                BellmanFord b = new BellmanFord(adjList);
                notCycle = b.solveBellmanFordAll(0,predecessor,costs);
                for(int i =1;i < v;i++)
                    b.solveBellmanFordAll(i,predecessor,costs);
                return notCycle;
            }
            case "3"-> {
                FloydWarshall f = new FloydWarshall(adjList);
                return f.solve(costs,predecessor);
            }
        }
        return true;
    }

    //check if the graph contains negative cycles
    public boolean containsCycles(String algorithm){
        if(algorithm.equals("1")) {
            initArrays1();
            BellmanFord b = new BellmanFord(adjList);
            for(int i=0;i < v;i++)
                if(!(b.solveBellmanFord(i,predecessor1,costs1))) return true;
            return false;
        }
        else  {
            initArrays();
            FloydWarshall f = new FloydWarshall(adjList);
            return !(f.solve(costs,predecessor));
        }
    }

    //get the cost from one node to another
    public double getDistance(int src,int dest) {
        return costs[src][dest];
    }

    public double getDistance(int dest) {
        return costs1[dest];
    }

    public double[] getDistanceToAllDest(int src) {
        return costs[src];
    }

    public double[] getDistanceToAllDest() {
        return costs1;
    }


    public double[][] getAllCosts() {
        return costs;
    }

    //get the parents of a node
    public String getParentsAll(int src,int dest){
        String s = "",reversed = "";
        int x = dest;
        while(x != -1){
            s += x;
            if(x != src) s+= "-";
            x = predecessor[src][x];
        }
        for(int i=s.length()-1;i >= 0;i--)
            reversed += s.charAt(i);
        return reversed;
    }

    public String getParents(int src,int dest){
        String s = "",reversed = "";
        int x = dest;
        while(x != -1) {
            s += x;
            if (x != src) s += "-";
            x = predecessor1[x];
        }
        for(int i=s.length()-1;i >= 0;i--)
            reversed += s.charAt(i);
        return reversed;
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



