import models.Edge;
import models.Graph;


public class Main {
    public static void main(String[] args)  {
        String s = "D:\\gra.txt";
        Graph g = new Graph(s);
        g.print();
        g.solveForOne(0,"2");
//        if(g.getDistance(5,1)== Double.MAX_VALUE)
//            System.out.println("no path");
         System.out.println(g.getDistance(3));
        System.out.println(g.getParents(0,3));




    }
}