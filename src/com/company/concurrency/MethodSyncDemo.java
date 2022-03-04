package com.company.concurrency;

public class MethodSyncDemo {
    public static void main(String[] args){
        MultiplicationTable multiplicationTable = new MultiplicationTable();
        FirstMultiplier firstMultiplier =  new FirstMultiplier("First",5 ,multiplicationTable);
        SecondMultiplier secondMultiplier = new SecondMultiplier("Second",6 ,multiplicationTable);
        firstMultiplier.start();
        secondMultiplier.start();
    }
}
