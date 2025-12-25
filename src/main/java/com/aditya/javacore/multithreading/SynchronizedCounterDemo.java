package com.aditya.javacore.multithreading;

class Counter {
    private int count;      // Shared data

    public synchronized void increment(){
        count++;
        System.out.println("Count is incremented by " + Thread.currentThread().getName() + " --> Count is : " + count);
    }
    public int getCount(){
        return count;
    }
}
public class SynchronizedCounterDemo {
  public static void main(String[] args) {
    
     // Shared Object
    Counter cuntr = new Counter();     
    int n = 10000;


    Runnable runnable1 = new Runnable() {
        public void run(){
            for(int i=0;i<n;i++) {
                cuntr.increment();
            }
        }
    };

    Runnable runnable2 = new Runnable() {
        public void run(){
            for(int i=0;i<n;i++) {
                cuntr.increment();
            }
        }
    };
 
    Thread t1 = new Thread(runnable1);
    Thread t2 = new Thread(runnable2);

    t1.start();
    t2.start();

    try {
    t1.join();
    t2.join();
} catch (InterruptedException e) { }

 System.out.println("Final Count : " + cuntr.getCount());

  }
}
