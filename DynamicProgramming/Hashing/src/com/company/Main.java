package com.company;

public class Main {

    public static void main(String[] args) {
	Employee janeJones=new Employee(123,"Jane","Jones");
        Employee johnDoe=new Employee(4567,"John","Doe");
        Employee marySmith=new Employee(22,"Mary","Smith");
        Employee mikeWilson=new Employee(3245,"Mike","Wilson");

       // HashTable hashTable=new HashTable(10);
        ChainingHashTable hashTable=new ChainingHashTable(10);

        hashTable.put("Jones",janeJones);
        hashTable.put("Doe",johnDoe);
        hashTable.put("Smith",marySmith);
        hashTable.put("Wilson",mikeWilson);

       // hashTable.print();

        System.out.println("Retrieve value:"+hashTable.get("Doe"));
        //System.out.println("Retrieve value:"+hashTable.get("Smith"));

        System.out.println("Remove value:"+hashTable.remove("Jones"));
        hashTable.print();
        //hashTable.print();
        //System.out.println("Retrieve value:"+hashTable.get("Jones"));


    }
}
