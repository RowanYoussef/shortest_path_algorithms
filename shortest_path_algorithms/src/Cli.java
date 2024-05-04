import models.Graph;
import java.util.*;

public class Cli {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("enter the path of the file OR exit");
            String path = sc.nextLine();
            if(path.equals("exit")) break;
            else{
                Graph g = new Graph(path);
                while(true){
                    System.out.println("enter a command"+"\n"+"1->Find the shortest path from source node " +
                            "to all other nodes"+"\n"+"2-> Find the shortest path between all pairs of node" +
                            "\n"+"3->check if the class contains negative cycle"+"\n"+"4->exit");
                    String command = sc.nextLine();
                    if(command.equals("4")) break;
                    switch (command){
                        case "1" -> {
                            while(true) {
                                System.out.println("choose the algorithm:" + "\n" + "1->Dijkstra" + "\n" + "2->BellmanFord" +
                                        "\n" + "3->FloydWarshall" + "\n" + "4->exit");
                                String algorithm = sc.nextLine();
                                if (algorithm.equals("4")) break;
                                else if (algorithm.equals("1") || algorithm.equals("2") || algorithm.equals("3")) {
                                    System.out.println("enter the source node");
                                    int src = Integer.parseInt(sc.nextLine());
                                    if(src < g.getSize()) {
                                        boolean notCycle = g.solveForOne(src, algorithm);
                                        while(true) {
                                            System.out.println("do you want a path or a cost to a node?"+"\n"
                                                    +"1->path"+"\n"+"2->cost"+"\n"+"3->exit");
                                            String input = sc.nextLine();
                                            if(input.equals("3")) break;
                                            else {
                                                switch (input) {
                                                    case "1" -> {
                                                        System.out.println("enter the destination");
                                                        int dest = Integer.parseInt(sc.nextLine());
                                                        if(notCycle)
                                                        System.out.println("path from " + src + " to " + dest + " = " + g.getParents(src, dest));
                                                        else System.out.println("graph contains a negative cycle we couldn't find the right path");
                                                    }
                                                    case "2" -> {
                                                        System.out.println("enter the destination");
                                                        int dest = Integer.parseInt(sc.nextLine());
                                                        System.out.println("cost from " + src + " to " + dest + " = " + g.getDistance(dest));
                                                        break;
                                                    }
                                                    default -> System.out.println("invalid command");
                                                }
                                            }
                                        }
                                    }
                                    else System.out.println("this node is not found");
                                }
                            }


                        }
                        case "2" -> {
                            while(true) {
                                System.out.println("choose the algorithm:" + "\n" + "1->Dijkstra" + "\n" + "2->BellmanFord" +
                                        "\n" + "3->FloydWarshall" + "\n" + "4->exit");
                                String algorithm = sc.nextLine();
                                if (algorithm.equals("4")) break;
                                else if (algorithm.equals("1") || algorithm.equals("2") || algorithm.equals("3")) {
                                    boolean notCycle = g.solveForAll(algorithm);
                                    while(true) {
                                        System.out.println("do you want a path or a cost from one node to another?"+"\n"
                                                +"1->path"+"\n"+"2->cost"+"\n"+"3->exit");
                                        String input = sc.nextLine();
                                        if(input.equals("3")) break;
                                        else {
                                            switch (input) {
                                                case "1" -> {
                                                    System.out.println("enter the source");
                                                    int src = Integer.parseInt(sc.nextLine());
                                                    System.out.println("enter the destination");
                                                    int dest = Integer.parseInt(sc.nextLine());
                                                    if(src >= g.getSize() || dest >= g.getSize()){
                                                        System.out.println("node is not found");
                                                        break;
                                                    }
                                                    if(notCycle)
                                                    System.out.println("path from " + src + " to " + dest + " = " + g.getParentsAll(src, dest));
                                                    else System.out.println("graph contains a negative cycle we couldn't find the right path");
                                                }
                                                case "2" -> {
                                                    System.out.println("enter the source");
                                                    int src = Integer.parseInt(sc.nextLine());
                                                    System.out.println("enter the destination");
                                                    int dest = Integer.parseInt(sc.nextLine());
                                                    if(src >= g.getSize() || dest >= g.getSize()){
                                                        System.out.println("node is not found");
                                                        break;
                                                    }
                                                    System.out.println("cost from " + src + " to " + dest + " = " + g.getDistance(src,dest));
                                                }
                                                default -> System.out.println("invalid command");
                                            }
                                        }
                                    }
                                }
                            }


                        }
                        case "3"->{
                            while (true) {
                                System.out.println("1->BellmanFord" + "\n" + "2->FloydWarshall" + "\n" + "3->exit");
                                String algorithm = sc.nextLine();
                                if (algorithm.equals("3")) break;
                                if (algorithm.equals("1") || algorithm.equals("2")) {
                                    if (g.containsCycles(algorithm)) System.out.println("yes");
                                    else System.out.println("no");
                                } else System.out.println("invalid command");
                            }
                        }
                        default -> System.out.println("invalid command");
                    }
                }
            }
        }
    }

}