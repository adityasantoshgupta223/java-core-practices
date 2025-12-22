package com.aditya.javacore.oops;

class Person{
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [ name = " + name + ", age = " + age + "]";
    }  
    
}
class Employee extends Person{
    String deprt;
    int empyId;

    public Employee(String name, int age, String deprt, int empyId) {
        super(name, age);
        this.deprt = deprt;
        this.empyId = empyId;
    }

    public String getDeprt() {
        return deprt;
    }

    public int getEmpyId() {
        return empyId;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Employee [ deprt = " + deprt + ", empyId = " + empyId + "]";
    }
}
class Manager extends Employee{
    String projName;

    public Manager(String name, int age, String deprt, int empyId, String projName) {
        super(name, age, deprt, empyId);
        this.projName = projName;
    }

    public String getProjName() {
        return projName;
    }

    @Override
    public String toString() {  
        return  super.toString() + "\n Manager [ projName = " + projName + "]";
    }
}
class InheritanceDemo { 
    public static void main(String[] args) {
        
 Manager m1 = new Manager("Rohoan Dixit", 22, "Neuroscience", 23, "Neurotics");
 System.out.println(m1);
    }
}
