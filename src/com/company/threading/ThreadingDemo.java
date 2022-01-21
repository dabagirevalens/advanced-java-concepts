package com.company.threading;

public class ThreadingDemo {
     public static void main(String[] args) {
          int n = 10;
          while (n > 0) {
               Thread1 t1 = new Thread1();
               t1.start();

               Thread t2 = new Thread(new Thread2());
               t2.start();

               n--;
          }
     }
}
