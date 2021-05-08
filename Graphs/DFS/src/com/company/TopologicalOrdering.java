package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class TopologicalOrdering {

    Deque<Vertex> listOfVertices;

    public TopologicalOrdering() {
        this.listOfVertices = new LinkedList<>();
    }

    void topologicalOrder(Vertex root){
        root.setVisited(true);
        for (Vertex v:root.getAdjacentVertices()){
            if(!v.isVisited()){
                topologicalOrder(v);
            }

        }listOfVertices.push(root);

    }

    public Deque<Vertex> getListOfVertices() {
        return listOfVertices;
    }
}
