package com.company.bellmanFord;


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

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1,a,b));
        edgeList.add(new Edge(-1,b,c));
        edgeList.add(new Edge(-1,c,a));

        BellmanFord bellmanFord=new BellmanFord(edgeList,vertexList);
        bellmanFord.shortestPathAlogorithm(a);
      //  bellmanFord.printShortestPath(c);
    }
}
