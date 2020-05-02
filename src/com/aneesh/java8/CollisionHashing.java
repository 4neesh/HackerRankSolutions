package com.aneesh.java8;

import java.util.Hashtable;

public class CollisionHashing {


    public static void main(String[] args) {

        Hashtable<String, String> ht = new Hashtable<>();


    }
}

class Person{

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}