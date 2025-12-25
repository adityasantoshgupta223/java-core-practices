package com.aditya.javacore.multithreading;

class RunnableTask implements Runnable{
  private  String msg;

  public RunnableTask(String msg) {
    this.msg = msg;
  }
    
  public void run(){
    for(int i=0;i<100;i++){
        System.out.println(msg + " By " + Thread.currentThread().getName());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
  }
        
}
public class JoinDemo {
  public static void main(String[] args) {
    
  RunnableTask runTsk1 = new RunnableTask("Hi");
  RunnableTask runTsk2 = new RunnableTask("Hello");

  Thread t1 = new Thread(runTsk1);
  Thread t2 = new Thread(runTsk2);
  
  System.out.println("-----------------------Going To Start(Without Join)..-------------------------");
  
  t1.start();
  t2.start();
  
  System.out.println("-----------------------Added Join..-------------------------");
  try {
    t1.join();
    t2.join();
} catch (InterruptedException e) { }

  System.out.println("-------------------------------Ended---------------------");
  


  }
}
