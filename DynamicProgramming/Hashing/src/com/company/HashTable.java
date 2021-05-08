package com.company;

public class HashTable {
   // Employee[] empHasTable;
    EmployeeNode[] empHasTable;
    int size;

    public HashTable(int size) {
        this.empHasTable = new EmployeeNode[size];
        this.size = size;
    }

    private int hashCode(String key){
        return key.length()%empHasTable.length;
    }

    private boolean isOccupied(int key){
        if(empHasTable[key]!=null)
            return true;
        return false;
    }

    public void put(String key,Employee emp){
        int hashedKey=hashCode(key);
        if(isOccupied(hashedKey)){
            int stopIndex=hashedKey;
            if(hashedKey==empHasTable.length-1)
                hashedKey=0;
            else
                hashedKey++;
            while (isOccupied(hashedKey) && hashedKey!=stopIndex){
                hashedKey=(hashedKey+1)%empHasTable.length;
            }
        }

        if(isOccupied(hashedKey))
            System.out.println("Sorry cannot insert in :"+hashedKey);
        else
            empHasTable[hashedKey]=new EmployeeNode(emp,key);
    }

    public Employee remove(String key){
        int hashedKey=findKey(key);
        if(hashedKey==-1)
            return null;
        Employee employee=empHasTable[hashedKey].employee;
        empHasTable[hashedKey]=null;
        EmployeeNode oldHashTable[]=empHasTable;
        empHasTable=new EmployeeNode[oldHashTable.length];
        for(int i=0;i< oldHashTable.length;i++){
            if(oldHashTable[i]!=null)
                put(oldHashTable[i].key,oldHashTable[i].employee);
        }
        return employee;
    }
    public Employee get(String key){
int hashedKey=findKey(key);
        if(hashedKey==-1 || empHasTable[hashedKey]==null)
            return null;
        return empHasTable[hashedKey].employee;
    }
    private int findKey(String key){
        int hashedKey=hashCode(key);
        if(empHasTable[hashedKey]!=null &&
            empHasTable[hashedKey].key.equalsIgnoreCase(key))
            return hashedKey;
        int stopIndex=hashedKey;
        if(hashedKey== empHasTable.length-1)
            hashedKey=0;
        else
            hashedKey++;

            while( hashedKey!=stopIndex &&
            empHasTable[hashedKey] != null &&
            !empHasTable[hashedKey].key.equalsIgnoreCase(key)){
                hashedKey=(hashedKey+1)%empHasTable.length;
            }
            if (stopIndex==hashedKey)
                return -1;
            else
                return hashedKey;

    }

    public void print(){
        for(int i=0;i< empHasTable.length;i++) {
            if(empHasTable[i]!=null)
                System.out.println("Position:"+i+" employee:"+empHasTable[i].employee);
            else
                System.out.println("empty");
        }
    }
}
