package com.company.threading;

public class Thread1 extends Thread {
    @Override
    public  void  run(){
        try{
            System.out.println("Valens is a genius.");
        }catch (Exception e){
            System.out.println("Exception raised " + e);
        }
    }

}
