package singleLinkedList.Main;

import singleLinkedList.Function.SingleLinkedListFunctions;
import singleLinkedList.model.Node;

import java.util.Scanner;

public class MainClass {
     static Scanner scanner;
     static Node head;


    static int getData(){
        return Integer.parseInt(scanner.next());
    }
    public static void main(String args[]){
        scanner=new Scanner(System.in);
        SingleLinkedListFunctions singleLinkedListFunctions=new SingleLinkedListFunctions();
        System.out.print("Enter any digit other than 0");
        int c=Integer.parseInt(scanner.next());
        while(c!=0){
        System.out.println("Enter a choice:");
        int ch=Integer.parseInt(scanner.next());
        switch (ch){
            case 1:
                System.out.println("Enter the data for the linked list:");
                head=singleLinkedListFunctions.createList(getData(),head);
                singleLinkedListFunctions.printList(head);
                break;
            case 2:
                System.out.println("Enter the data to be deleted:");
                singleLinkedListFunctions.deleteList(getData(),head);
                break;
                default:System.out.print("wrong choice");
        }
        System.out.println("Enter 0 to exit");
        c=Integer.parseInt(scanner.next());
    }}
}
