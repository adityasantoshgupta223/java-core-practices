package com.aditya.javacore.multithreading;

class ThreadTask extends Thread{
 private String msg;

  ThreadTask(String msg){
    this.msg = msg;
  }
   public void run(){
    for(int i=0;i<100;i++){
      System.out.println(msg + " From " + Thread.currentThread().getName());
    }
   }

}
class RunnableTask implements Runnable{
  private String msg;

   public RunnableTask(String msg) {
    this.msg = msg;
   }
  
   public void print(){
    System.out.println(msg + " From Runnable by " + Thread.currentThread().getName());
   }

   public void run(){
         for(int i=0;i<100;i++){
          print();
         }
   }
}
public class ThreadVsRunnableDemo {
   public static void main(String[] args) {
    
  ThreadTask t1 = new ThreadTask("Hi");
  ThreadTask t2 = new ThreadTask("Hello");


  t1.start();
  t2.start();

  RunnableTask runTsk = new RunnableTask("Hi ");

  Thread t3 = new Thread(runTsk);
  Thread t4 = new Thread(runTsk);

  t3.start();
  t4.start();

   }
}