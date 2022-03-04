package com.company.concurrency;

public class FirstMultiplier extends Thread {
    String name;
    int number;
    MultiplicationTable table;

    public FirstMultiplier(String name,int number,MultiplicationTable table){
        this.name=name;
        this.number=number;
        this.table=table;
    }

    @Override
    public void run(){
        table.perform(number);
    }
}
