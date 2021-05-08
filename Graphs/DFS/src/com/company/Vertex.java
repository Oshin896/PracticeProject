package com.company;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    String name;
    boolean visited;
    List<Vertex> adjacentVertices;

    public Vertex(String name) {
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
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void addAdjacentVertices(Vertex vertex) {
        this.adjacentVertices.add(vertex);
    }

    @Override
    public String toString() {
        return name;
    }
}
