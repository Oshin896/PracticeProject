package com.company;

public class Main {

    public static void main(String[] args) {

        BreadthFirstSearch bfs=new BreadthFirstSearch();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addVetex(b);
        a.addVetex(f);
        a.addVetex(g);

        b.addVetex(a);
        b.addVetex(c);
        b.addVetex(d);

        c.addVetex(b);

        d.addVetex(b);
        d.addVetex(e);

        f.addVetex(a);

        g.addVetex(a);
        g.addVetex(h);

        h.addVetex(g);

        bfs.traverseVertex(a);

    }
}
