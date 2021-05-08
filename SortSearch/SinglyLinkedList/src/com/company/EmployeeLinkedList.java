package com.company;

public class EmployeeLinkedList {

    private Node head;

    public void addToFront(Employee employee){
        Node empNode=new Node(employee);
        empNode.setNext(head);
        head=empNode;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void printList(){
        Node current=head;
        System.out.print("HEAD ->");
        while (current != null){
            System.out.print(current + "->");
            current=current.getNext();
        }
        System.out.println("null");
    }
    public int getSize(){
        Node current=head;
        int i=0;
        while (current != null) {
            i++;
            current=current.getNext();
        }
        return i;
    }
}
