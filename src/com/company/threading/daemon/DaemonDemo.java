package com.company.threading.daemon;

public class DaemonDemo extends Thread{
    @Override
    public void run(){
        try{
            String name = Thread.currentThread().getName();
            System.out.println("Executing "+ name);

            if(Thread.currentThread().isDaemon()){
                if(name.equals("closable")){
                    Thread.currentThread().stop();
                }

                System.out.println("Executing");
                Thread.currentThread().stop();
                System.out.println("Completed");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
