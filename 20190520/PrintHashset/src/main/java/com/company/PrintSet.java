package com.company;

import java.util.HashSet;
import java.util.Iterator;

/**
 *  Program implement a HashSet and add these values to it: 5,1,2,1,4,1,5.
 *  printing all members of the HashSet using iterator.
 */
public class PrintSet {
    public static void main(String[] args) {
        //Creating HashSet and adding elements
        HashSet <Integer> set=new HashSet<>();
        //5,1,2,1,4,1,5
        set.add(5);
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(4);
        set.add(1);
        set.add(5);
        //Traversing elements
        Iterator<Integer> itr =set.iterator();
        System.out.println("Hash set: ");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

}
