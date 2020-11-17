package com.example.enigma;


public class Student {
    private String name  = "";
    private int age = -1;

    public Student(String name, int age) {
        setName(name);
        setAge(age);
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
