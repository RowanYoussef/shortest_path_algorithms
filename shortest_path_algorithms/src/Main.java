import models.Edge;
import models.Graph;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args)  {
        String s = "D:\\gra1.txt";
        Graph g = new Graph(s);
        g.print();
        g.solveBellmanFordAll();
//        if(g.getDistance(5,1)== Double.MAX_VALUE)
//            System.out.println("no path");
         System.out.println(g.getDistance(0,1));
        System.out.println(g.getParents(0,1));
        System.out.println(g.containsCycles());



    }
}