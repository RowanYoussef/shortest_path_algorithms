import models.Edge;
import models.Graph;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)  {
        String s = "D:\\gra.txt";
        Graph g = new Graph(s);
        g.print();
        g.solveDijkstraAll();
        if(g.getDistance(5,1)== Double.MAX_VALUE)
            System.out.println("no path");
        else System.out.println(g.getDistance(5,1));
        System.out.println(g.getParents(5,1));


    }
}