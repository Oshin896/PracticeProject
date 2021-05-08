package com.company;

import java.util.ArrayList;
import java.util.List;

public class VertexCycleDetection {

    String name;
    boolean isVisited;
    boolean beingVisited;
    List<VertexCycleDetection> adjacentVertices;

    public VertexCycleDetection(String name) {
        this.name = name;
        this.adjacentVertices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public List<VertexCycleDetection> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void addAdjacentVertices(VertexCycleDetection v){
        adjacentVertices.add(v);
    }

    @Override
    public String toString() {
        return name;
    }
}
