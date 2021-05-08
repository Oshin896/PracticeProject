package com.company.bellmanFord;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    String name;
    boolean visited;
    List<Edge> adjacentEdges;
    double distance;
    Vertex predecessor;

    public Vertex(String name) {
        this.name = name;
        this.distance=Double.MAX_VALUE;
        this.adjacentEdges = new ArrayList<>();
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

    public List<Edge> getAdjacentEdges() {
        return adjacentEdges;
    }

    public void setAdjacentEdges(List<Edge> adjacentEdges) {
        this.adjacentEdges = adjacentEdges;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }
    public void addAdjacentEdges(Edge edge) {
        this.adjacentEdges.add(edge);
    }

    @Override
    public String toString() {
        return name;
    }
}
