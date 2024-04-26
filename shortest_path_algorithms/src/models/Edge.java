package models;

public class Edge {
    private int dest;
    private double cost;
    public Edge(int dest,double cost){
        this.dest = dest;
        this.cost = cost;
    }

    public int getDest() {
        return dest;
    }

    public double getCost() {
        return cost;
    }
}
