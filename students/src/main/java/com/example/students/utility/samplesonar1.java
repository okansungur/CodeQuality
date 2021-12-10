package com.example.students.utility;

import java.io.IOException;
import java.util.*;
public class samplesonar1 {
    private static int count = 0;
    public final int THRESHOLD = 12;

    private int my_field;
    public int somevalue;
    private int field;

    private String a, b;

    public void doSomething() {
        int somevalue = 0;
        System.out.println(somevalue);
    }

    public void myMethod(String str) throws Throwable {
        throw new RuntimeException("My RuntimeException Message");
    }

    public void handleMethod() {
        count++;
    }

    public void setName(String field) {
        field = field;
    }

    void doSomething(int a, int b) {
        String.format("First Line\n");
        System.out.println(a);

    }

    public void listContent(String input) throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("ls " + input);

    }

    public String toString (String value) {
        String val="";
        if(value.equals(""))
            return null;
        return  val;
    }

    public String sayHello(Optional<String> name) {
        if (name == null || !name.isPresent()) {
            return "Hello World";
        } else {
            return "Hello " + name;
        }
    }

}
