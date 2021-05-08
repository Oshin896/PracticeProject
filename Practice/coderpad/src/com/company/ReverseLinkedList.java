package com.company;

public class ReverseLinkedList {
    public static Node reverse(Node node, int k)
    {
        Node current=node;
        Node prev=null;
        Node next=null;
        int c=0;

        while(c<k && current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            c++;
        }
        if(next!=null)
            node.next=reverse(next,k);

        return  prev;
    }
}
