package dll.main;

import dll.creation.CreateDll;
import dll.model.Node;

import java.util.Scanner;

public class MainClass {

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number");
        int n=Integer.parseInt(scanner.next());
        CreateDll cd=new CreateDll();
        Node head=null;
        while(n!=0){
            System.out.println("Enter your choice:");
            int ch=Integer.parseInt(scanner.next());
            switch (ch){
                case 1:System.out.print("Enter data to add in front:");
                head=cd.addNodeInFront(head,Integer.parseInt(scanner.next()));
                break;
                case 2:System.out.print("Enter data to add at last:");
                head=cd.addNodeAtEnd(head,Integer.parseInt(scanner.next()));
                break;
                case 3:head=cd.deleteNodeFromBeginning(head);
                    System.out.print("Deletion from beginning has been done");
                    break;
                case 4:head=cd.deleteNodeFromEnd(head);
                System.out.print("Deletion from end has been done");
                break;
                case 5:System.out.print("Enter the data to be added:");
                int data1=Integer.parseInt(scanner.next());
                System.out.print("\nEnter the data after which the above data is to be added:");
                int data2=Integer.parseInt(scanner.next());
                head=cd.insertAfterAnElement(head,data1,data2);
                break;
                case 6:System.out.print("Enter the data to be added:");
                    data1 = Integer.parseInt(scanner.next());
                    System.out.print("\nEnter the data before which the above data is to be added:");
                    data2 = Integer.parseInt(scanner.next());
                    head=cd.insertBeforeAnElement(head,data1,data2);
                    break;
                case 7:System.out.print("The list is as follows:");
                cd.printLinkedListForward(head);
                break;
            }
            System.out.println("Enter 0 to exit");
            n=Integer.parseInt(scanner.next());
        }

    }
}
