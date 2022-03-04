package com.company.concurrency;

import com.sun.source.tree.SynchronizedTree;

public class Excutor extends Thread{
    String name;
    int number;
    Thread t;
    Task task;

    public Excutor(String name, Task task, int number){
        this.name = name;
        this.task = task;
        this.number = number;
    }

    @Override
    public void run(){
        try {
            synchronized (task){
                System.out.println(name + " has started");
                task.perform(number);
                System.out.println(name + " has stopped");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void starter(){
        if(t==null){
            t = new Thread();
            t.start();
        }
    }

}
