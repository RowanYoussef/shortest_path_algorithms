import models.Graph;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        String s = "D:\\gra.txt";
        Graph g = new Graph(s);
        g.print();

    }
}