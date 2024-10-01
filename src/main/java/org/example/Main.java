package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
    priorityQueue()

 */
public class Main {
    public static void main(String[] args) {

    }

    private static void map(){
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        HashMap<String,Integer> map = new HashMap<>();

        // compute method to create a frequency map of a list of words. very short compared to if else.
        for(String each : words){
            map.compute(each, (key,value) -> (value == null?  1 : value + 1));
        }

        // iterating over a map
        for(Map.Entry<String,Integer> each : map.entrySet()){ // VERRRRY IRRITATING here we can do directly entrySet
            System.out.println(each.getKey() + ":" + each.getValue()); // but each entry we need to do getKey and getValue;
        }
    }


    /**
     * comes OOTB, and support comparator.
     * poll(), peek(), add(), offer() and size();
     * poll is pop, peek just peeks. add and offer as same for PQ.

     * It implements two interfaces, queue and collection.
     * queue gives offer method and collection gives add method
     * capacity-constrained queues' add throws error if it cannot add. but here in PQ both are same.

     * It also doesn't hold any limit what you can add.

     * Observation: I have seen people using custom heaps and it is faster.
     *
     */
    private static void priorityQueue(){



        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        PriorityQueue<Integer> priorityQueueWithCustomComparator = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2) * -1);
        /*
            two objects o1 and o2. How to think about the comparator:
            o1 is the new object and o2 is the existing object in the structure. Does it matter? no.
            Think COMPARE method as REVERSE.
            And the current order of the of objects is o1 first then o2.
            Do you want to reverse the order? then return 1
            Do you want to keep the  order then return -1.
          */
        PriorityQueue<Integer> pqWithReverseOrder = new PriorityQueue<>(Comparator.reverseOrder());

        /*
        Understanding the compareTo in same way. We want our object on which we are calling the compareTo to be greater
        So if its smaller we return -1 and if its greater we return 1.

        clubbing comparator of collection and compareTo. if you take ascending order as natural order. then
        compareTo is also a REVERSE function?
        we want to reverse => o1 is greater than o2 => reverse hence return 1.

        IF YOU NEED EXACTLY kth element FROM PQ YOU CANNOT ACHIEVE THAT HERE.
        because you cannot fix the size of the queue. if you could, then you could have just added all the elements
        and get the top using POLL.

        TO GET THE Kth element you need to Poll k times with this k.

        */

        /*
        Priority Queue example with a map entry and custom comparator
        sorted by the frequency from highest to lowest.
        words with the same frequency by their lexicographical order
         */
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a, b) -> {
            if(a.getValue() > b.getValue())
                return -1;
            else if(a.getValue().equals(b.getValue())){
                return a.getKey().compareTo(b.getKey());
            }
            return 1;
        });


    }

}