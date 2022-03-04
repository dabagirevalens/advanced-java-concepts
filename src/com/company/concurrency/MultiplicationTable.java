package com.company.concurrency;

public class MultiplicationTable {
    public synchronized void perform(int number){
        System.out.println("Multiplication table for " + number);
        try{
            for(int i=1;i<=12;i++){
                System.out.println(i+" * "+number+" = "+(i*number));
                Thread.sleep(1000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}