package com.company.concurrency;

public class SyncBlockDemo {

    public static void main(String[] args) throws Exception{
        Task task = new Task();
        Excutor excutor = new Excutor("User", task, 5);
        Excutor executor_1 = new Excutor("User 2", task, 6);

        excutor.start();
        executor_1.start();
    }

}
