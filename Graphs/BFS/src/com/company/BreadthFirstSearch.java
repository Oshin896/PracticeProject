package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void traverseVertex(Vertex root){
        Queue<Vertex> queue=new LinkedList<>();
        root.setVisited(true);
        queue.add(root);
        while(!queue.isEmpty()){
            Vertex visitedVertex=queue.remove();
            System.out.println("Actual vertex : "+visitedVertex.getName());
            for(Vertex vertex:visitedVertex.getAdjacentList()){
                if(!vertex.isVisited()){
                    vertex.setVisited(true);
                    queue.add(vertex);
                }
            }
        }
    }
}
