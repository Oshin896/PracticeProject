package com.company;


import java.util.*;

public class DepthFirstSearch {
    Deque<Vertex> stack;

    public DepthFirstSearch() {
        this.stack = new LinkedList<>();
    }

    void dfs(List<Vertex> vertices){
        for (Vertex v:vertices){
            if(!v.isVisited()) {
                v.setVisited(true);
                traverseWithRecursion(v);
            }
        }
    }

    void traverseWithRecursion(Vertex root){
        System.out.println("Actual vertex:"+root);
        for(Vertex v: root.getAdjacentVertices()){
            if(!v.isVisited()){
                v.setVisited(true);
                traverseWithRecursion(v);
            }
        }
    }

    void traverseWithStack(Vertex root){

        stack.push(root);
        root.setVisited(true);
        while (!stack.isEmpty()){
            Vertex visitedVertex=stack.pop();
            System.out.println(" Actual vertex : "+visitedVertex);
            for(Vertex v: visitedVertex.getAdjacentVertices()){
                if(!v.isVisited()) {
                    v.setVisited(true);
                    stack.push(v);
                }
            }
        }
    }
}
