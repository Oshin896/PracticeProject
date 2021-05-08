package com.company.dijkstra;



public class App {

    public static void main(String args[]){

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");

        a.addListOfEdges(new Edge(1,a,b));
        a.addListOfEdges(new Edge(3,a,c));
        b.addListOfEdges(new Edge(1,b,c));

        ShortestPath shortestPath=new ShortestPath();
        shortestPath.traverse(a);

        System.out.println(shortestPath.shortestPath(c));
    }
}
