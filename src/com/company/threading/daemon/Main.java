package com.company.threading.daemon;

public class Main {
    public static void main(String[] args){
        DaemonDemo thread = new DaemonDemo();
        DaemonDemo thread2 = new DaemonDemo();
        DaemonDemo thread3 = new DaemonDemo();

        thread.setName("closable");
        thread.setDaemon(true);

        thread2.setName("daemon");
        thread2.setDaemon(true);

        thread3.setName("nonDaemon");

        thread.start();
        thread2.start();
        thread3.start();
    }
}
