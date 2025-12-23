package com.aditya.javacore.oops;

import java.util.ArrayList;
import java.util.List;

interface Payments{
   boolean makePayment(Person sendr, Person recvr, double amunt);
   boolean validation(Person p);
}

abstract class AbstractPayment implements Payments{
    protected final List<Person> network = new ArrayList<>();
    
     public void addAccunt(Person p){
        network.add(p);
     }

    @Override
    public boolean validation(Person p) {
        return network.contains(p);
    }

    public void successful(Person sender, Person recevier){
          System.out.println("Payment successful!!!");

    }
     
    public boolean startPayment(Person sendr, Person recevr, double amunt){
        if( amunt < 0 || amunt > sendr.getAccuntBal()) return false; 
           double credit = recevr.getAccuntBal() + amunt;
           double deduct = sendr.getAccuntBal() - amunt;
 
           sendr.setAccuntBal(deduct);
           recevr.setAccuntBal(credit);

           return true;
    }

    public boolean startTransaction(Person sendr, Person recevr, double amunt){
        if(validation(recevr) && validation(sendr)){

            if(startPayment(sendr, recevr, amunt)){
              successful(sendr, recevr);
              return true;
            }else{
                throw new IllegalArgumentException("Amount is Invalid");
            }  
        }
        return false;
    }
    
}

class UPIpayment extends AbstractPayment {
    
    @Override
    public boolean makePayment(Person sendr, Person recevr, double amunt) {
        System.out.println("----------- UPI Payment in Process-------------");
 
        boolean isSuccessful = startTransaction(sendr, recevr, amunt);

         if(!isSuccessful){
             System.out.println("Sender or Receiver Dont Have UPI Account");
         } 
        return isSuccessful;
    }  
}
class VisaPayment extends AbstractPayment {
    
       @Override
    public boolean makePayment(Person sendr, Person recevr, double amunt) {
        System.out.println("----------- Visa Payment in Process-------------");
  
        boolean isSuccessful = startTransaction(sendr, recevr, amunt);

         if(!isSuccessful){
             System.out.println("Sender or Receiver Dont Have Visa Account");
         } 
        return isSuccessful;
    }  
  
}
class MasterCardPayment extends AbstractPayment {

       @Override
    public boolean makePayment(Person sendr, Person recevr, double amunt) {
        System.out.println("----------- MasterCard Payment in Process-------------");
        
        boolean isSuccessful = startTransaction(sendr, recevr, amunt);

         if(!isSuccessful){
             System.out.println("Sender or Receiver Dont Have MasterCard Account");
         } 
        return isSuccessful;
    }  
  
}

class Person{
    private String name;
    private int phoneNo;
    private double accuntBal;
  
    Person(String name, int phoneNo, double accuntBal) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.accuntBal = accuntBal;
    }

    public String getName() {
        return name;
    }
    public int getPhoneNo() {
        return phoneNo;
    }

    public double getAccuntBal() {
        return accuntBal;
    }

    public void setAccuntBal(double amunt) {
         this.accuntBal = amunt;
    }
}
class Platform {
   private Payments pymntMethod;

   Platform(String pltfrm){
     switch(pltfrm){
        case "UPI" : pymntMethod = new UPIpayment(); 
                      break;
        case "Visa" : pymntMethod = new VisaPayment();
                      break;
        case "MasterCard" : pymntMethod = new MasterCardPayment();
                      break;
        default : throw  new IllegalArgumentException("Not on any Platform");
     }
   }

   public void addUser(Person p){
    ((AbstractPayment) pymntMethod).addAccunt(p);
   }

   public boolean pay(Person sendr, Person recevr, double amunt){
        return pymntMethod.makePayment(sendr, recevr, amunt);
   }
}
 

class InterfaceVsAbstractDemo{
    public static void main(String[] args) {
       
    
        Platform Visa = new Platform("Visa");
       
        Person p1 = new Person("Ash Ketum", 93423443, 5500);
        Person p2 = new Person("Brook Majetro", 934234431, 2500);

Visa.addUser(p1);
Visa.addUser(p2);

    
     System.out.println("-------------Payment Between " + p1.getName() + " & " + p2.getName() + " Via Visa-----------");

    System.out.println("------------Before Payment-------------");
   System.out.println(p1.getName() + "'s Account Balance(in Rs.) : " + p1.getAccuntBal());
   System.out.println(p2.getName() + "'s Account Balance(in Rs.) : " + p2.getAccuntBal());

       Visa.pay(p1, p2, 600);  

        System.out.println("------------After Payment-------------");
   System.out.println(p1.getName() + "'s Account Balance(in Rs.) : " + p1.getAccuntBal());
   System.out.println(p2.getName() + "'s Account Balance(in Rs.) : " + p2.getAccuntBal());
   
   
    }
}