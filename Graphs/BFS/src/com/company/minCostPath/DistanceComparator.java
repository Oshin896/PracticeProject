package com.company.minCostPath;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.dist, o2.dist);
    }
}
