package com.company.bellmanFord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BellmanFord {
    List<Edge> edges;
    List<Vertex> vertices;

    public BellmanFord(List<Edge> edges, List<Vertex> vertices) {
        this.edges = edges;
        this.vertices = vertices;
    }

    void shortestPathAlogorithm(Vertex root) {
        root.setDistance(0);
        for (int i = 0; i < vertices.size() - 1; i++) {
            for (Edge edge : edges) {
                Vertex u = edge.getStartVertex();
                Vertex v = edge.getEndVertex();
                if (u.getDistance() == Double.MAX_VALUE)
                    continue;
                if (u.getDistance() + edge.getWeight() < v.getDistance()) {
                    v.setDistance(u.getDistance() + edge.getWeight());
                    v.setPredecessor(u);
                }
            }
        }

        for (Edge edge : edges) {
            Vertex u = edge.getStartVertex();
            Vertex v = edge.getEndVertex();
            if (u.getDistance() == Double.MAX_VALUE)
                continue;
            if (u.getDistance() + edge.getWeight() < v.getDistance()) {
                System.out.println("Negative cycle exists...");
                return;
            }
        }
    }
        void printShortestPath(Vertex v){
        if(v.getDistance() == Double.MAX_VALUE)
            System.out.println("No path");
            System.out.println("Minimum distance:"+v.getDistance());
        List<Vertex> vertexList=new ArrayList<>();
            while(v.getPredecessor()!=null) {
                vertexList.add(v);
                v=v.getPredecessor();
            }
            vertexList.add(v);
            Collections.reverse(vertexList);

            for(Vertex vertex:vertexList){
                System.out.print(vertex+"->");
            }
    }
}
