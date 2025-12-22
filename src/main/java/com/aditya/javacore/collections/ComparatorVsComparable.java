package com.aditya.javacore.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
   private String name;
   private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    
    public int compareTo(Student other) {
        return Integer.compare(other.getAge(), this.getAge());
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
    
    
 }
public class ComparatorVsComparable {
  public static void main(String[] args) {
   
    List<Student> list = new ArrayList<>();

list.add(new Student("Rohan", 25));
list.add(new Student("Arijit", 26));
list.add(new Student("Hritik", 23));
list.add(new Student("Rajesh", 24));
list.add(new Student("Hrishi", 22));

// Sorting in Descending order on the basis of Age of Student 
Comparator<Student> com = new Comparator<Student>() {
    public int compare(Student s1, Student s2){
        return Integer.compare(s2.getAge(), s1.getAge());
    }
};

System.out.println("---------------Before Sorting-------------");
for(Student s : list) System.out.println(s);


// Using Comparator
Collections.sort(list, com);

System.out.println("---------------After Sorting Using Comparator-------------");
for(Student s : list) System.out.println(s);

// Using Comparable
  Collections.sort(list);

System.out.println("---------------After Sorting Using Comparable-------------");
for(Student s : list) System.out.println(s);


  }
}
