package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ChainingHashTable {
    LinkedList<EmployeeNode> chainedHashMap[];
    int size;

    public ChainingHashTable(int size) {
        this.size=size;
        this.chainedHashMap = new LinkedList[size];
    }

    int hashCode(String key){
        return key.length()%size;
    }
    void put(String key,Employee employee){
        int hashedKey=hashCode(key);
        if(chainedHashMap[hashedKey]!=null)
            chainedHashMap[hashedKey].add(new EmployeeNode(employee,key));
        else{
            chainedHashMap[hashedKey]=new LinkedList<>();
            chainedHashMap[hashedKey].add(new EmployeeNode(employee,key));}}

            void print(){
        for(int i=0;i<size;i++){
            if(chainedHashMap[i]==null)
                System.out.println("Position "+i+":empty");
            else{
            ListIterator<EmployeeNode> listIterator=chainedHashMap[i].listIterator();
            int j=0;
            System.out.print("Position "+i+":");
            while (listIterator.hasNext()){
                System.out.print(listIterator.next().employee+"->");
            }
            System.out.println("null");
        }}
            }

            Employee remove(String key){
        int hashedKey=hashCode(key);
        if(hashedKey==-1)
            return null;
        ListIterator<EmployeeNode> iterator=chainedHashMap[hashedKey].listIterator();
        int j=0;Employee employee=null;
        while (iterator.hasNext()){
            if(iterator.next().key.equalsIgnoreCase(key)) {
                employee=iterator.next().employee;
                break;
            }j++;
                }
        if(employee==null)
            return null;
                chainedHashMap[hashedKey].remove(j);
                return employee;
            }
            Employee get(String key){
        int hashedKey=hashCode(key);
        if(hashedKey==-1)
            return null;
        EmployeeNode employeeNode1=chainedHashMap[hashedKey].stream().filter(employeeNode -> employeeNode.key.equalsIgnoreCase(key)).findFirst().orElse(null);
        return employeeNode1.employee;
            }
}
