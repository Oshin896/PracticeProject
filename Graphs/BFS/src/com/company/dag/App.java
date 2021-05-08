package com.company.dag;



import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String args[]) {
        List<Vertex> vertexList = new ArrayList<>();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");

        vertexList.add(a);
        vertexList.add(b);
        vertexList.add(c);

        a.addAdjacentEdges(new Edge(1,a,b));
        a.addAdjacentEdges(new Edge(1,a,c));
        b.addAdjacentEdges(new Edge(1,b,c));

        DagAlgorithm dagAlgorithm=new DagAlgorithm();
        dagAlgorithm.dag(vertexList,a,c);
        dagAlgorithm.printShortestPath(c);
    }
}