package com.company.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {

    void traverse(Vertex root){
        root.setDistance(0);
        PriorityQueue<Vertex> vertexPriorityQueue=new PriorityQueue<>();
        vertexPriorityQueue.add(root);
        while (!vertexPriorityQueue.isEmpty()){
            Vertex startVertex=vertexPriorityQueue.poll();
            for(Edge edge:startVertex.getListOfEdges()){
                Vertex endVertex= edge.getEndVertex();
                double newDistance= edge.getWeight()+ startVertex.getDistance();
                if(newDistance<endVertex.getDistance()){
                    vertexPriorityQueue.remove(endVertex);
                    endVertex.setDistance(newDistance);
                    endVertex.setPredecessor(startVertex);
                    vertexPriorityQueue.add(endVertex);
                }
            }
        }
    }

    List<Vertex> shortestPath(Vertex endVertex){
        List<Vertex> shortestPathVertices=new ArrayList<>();
        while(endVertex.getPredecessor()!=null){
            shortestPathVertices.add(endVertex);
            endVertex=endVertex.getPredecessor();
        }
        shortestPathVertices.add(endVertex);
        Collections.reverse(shortestPathVertices);
        return shortestPathVertices;
    }
}
