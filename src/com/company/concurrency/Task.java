package com.company.concurrency;

public class Task {
    void perform(int number){
        System.out.println("Multiplication table of number:"+ number);

        try{
            for(int i=1; i<=10; i++){
                System.out.println(i + " * "+ number+ " = "+i*number);
                Thread.sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
