package com.eclipseoptions.javatest.majority.api;

public class Child extends Parent {
    public static void main(String [] args)
    {
        System.out.println(Child.str);
        Child.str = "Child";

        System.out.println(Parent.str);
    }
}