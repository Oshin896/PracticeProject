package com.company.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    List<Edge> listOfEdges;
    double distance;
    boolean visited;
    String name;
    Vertex predecessor;

    public Vertex(String name) {
        this.listOfEdges=new ArrayList<>();
        this.distance = Double.MAX_VALUE;
        this.name = name;
    }

    public List<Edge> getListOfEdges() {
        return listOfEdges;
    }

    public void addListOfEdges(Edge edge) {
        this.listOfEdges.add(edge);
    }

    public void setListOfEdges(List<Edge> listOfEdges) {
        this.listOfEdges = listOfEdges;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(o.getDistance(),this.distance);
    }

    @Override
    public String toString() {
        return name;
    }
}
