package singleLinkedList.Function;

import singleLinkedList.model.Node;

import java.util.List;

public class SingleLinkedListFunctions {


    public Node createList(int data, Node head){
        Node node=new Node(data);
        if(head==null){
            head=node;
        return head;
        }
        else{
            Node node1=head;
            while(node1.next!=null)
                node1=node1.next;

            node1.next=node;

        }
        return head;
    }

    public void deleteList(int data,Node head){

        Node node1=head;
        int t=0;
        if(head==null){
            System.out.println("Head null");
        }
        else if(head.data==data) {
        head=head.next;
        }
        else{
            Node node=node1;
            node1=node1.next;
            while(node1!=null){
                if(node1.data==data){
                node.next=node1.next;
                node1=node1.next;
                t=1;
                break;
               }
                else{
                    node=node1;
                    node1=node1.next;}

            }
            if (t==1)
                printList(head);
            else
                System.out.println("Data not found");
            }

        }


    public void printList(Node head){
        if(head==null)
            System.out.print("No data found");
        else{
            while(head.next!=null){
                System.out.print(head.data+"->");
                head=head.next;
            }
            System.out.print(head);
        }
    }
}
