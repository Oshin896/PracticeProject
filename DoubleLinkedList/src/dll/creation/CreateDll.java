package dll.creation;

import dll.model.Node;

public class CreateDll {


    public Node addNodeInFront(Node head,int key){
        if(head==null){
            head=new Node(key);
        }else {
            Node node=new Node(key);
            node.rightNode=head;
            head.leftNode=node;
            head=node;
        }
        return head;
    }
    public Node addNodeAtEnd(Node head,int key){
        if(head==null){
            head=new Node(key);
        }
        else{
            Node node=new Node(key);
            Node node1=head;
            while(node1.rightNode!=null){
                node1=node1.rightNode;
            }
            node1.rightNode=node;
            node.leftNode=node1;
        }
        return head;
    }

    public Node deleteNodeFromBeginning(Node head){
        Node node;
        if(head!=null){
            node=head.rightNode;
            head.rightNode=null;
            node.leftNode=null;
            head=node;
        }
        return head;
    }

    public Node deleteNodeFromEnd(Node head){
        Node node=head;


        if (head!=null) {
            if(head.rightNode==null)
                return null;
            while (node.rightNode != null)
                node = node.rightNode;
            node.rightNode.leftNode = null;
            node.rightNode = null;
        }

        return head;
    }
    public Node insertAfterAnElement(Node head,int data1,int data2){
        Node node=head;
        int f=0;
        if(head!=null){
            while(node!=null){
                if(node.data==data1){
                    f=1;break;
                }
                node=node.rightNode;
            }
            if(f==1){
                Node node1=new Node(data2);
                if(head.rightNode==null){
                head.rightNode=node1;
                node1.leftNode=head;
                return head;
                }

                Node node2=node.rightNode;
                node.rightNode=node1;
                node1.leftNode=node;
                node1.rightNode=node2;
                node2.leftNode=node1;
            }
            else{
                System.out.println("Element not found");
            }
        }
        return head;
    }

    public Node insertBeforeAnElement(Node head,int data1,int data2){
        Node node=head;
        int f=0;
        if(head!=null){
                while (node!=null){
                    if(node.data==data1){
                        f=1;break;
                    }
                    node=node.rightNode;
                }
                if(f==1){
                    Node node2=new Node(data2);
                    if(node==head){
                        head.leftNode=node2;
                        node2.rightNode=head;
                        head=node;
                    }
                    Node node1=node.leftNode;
                    node.leftNode=node2;
                    node2.rightNode=node;
                    node1.rightNode=node2;
                    node.leftNode=node1;
                    return head;
                }
                System.out.println("Element not found");
        }
        return head;
    }

    public void printLinkedListForward(Node head){
        if(head==null)
            System.out.println("Nothing to print");
        else{
            Node node=head;
            while(node.rightNode!=null)
            {
                System.out.print(node.data+"->");
                node=node.rightNode;
            }
            System.out.println(node.data);
        }
    }

    public void printLinkedListBackward(Node head){
        if(head==null)
            System.out.println("Nothing to print");
        else{

        }
    }
}
