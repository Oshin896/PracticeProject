package com.company.dag;

import java.util.*;

public class TopologicalOrdering {

    List<Vertex> vertices;
    Deque<Vertex> stack;

    public TopologicalOrdering(List<Vertex> vertices) {
        this.vertices = vertices;
        this.stack = new LinkedList<>();
    }

    void topologicalOrdering(){
        for(Vertex v:vertices){
            if(!v.isVisited())
                dfs(v);
        }
    }

    private void dfs(Vertex u) {
        u.setVisited(true);
        for(Edge edge:u.getAdjacentEdges()){
            Vertex v= edge.getEndVertex();
            if(!v.isVisited()){
                v.setVisited(true);
                dfs(v);
            }
        }
        stack.push(u);
    }

    Deque<Vertex> printVertices(){
        return this.stack;
    }
}
