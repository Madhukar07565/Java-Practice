package com.madhu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;


/**
 * Created By Madhukar Reddy On Jun 25, 2016
 *
 */

class Dept {

    public Dept() {
        System.out.println("Dept");
    }
}

class SubDept extends Dept {

    public SubDept() {
        System.out.println("SubDept");
    }
}

class B extends A {
    protected SubDept readValue() throws RuntimeException {
        return new SubDept();
    }
}
class A {

    private Dept readValue() throws IOException {
        return new Dept();
    }
}

class C {
 public static void main(String[] args) throws Exception {
     
     A a = new A();
     B b = new B();
     b.readValue();
     
     HashSet<Employee> set = new HashSet<>();
     Employee e1 = new Employee();
     e1.setEname("x");
     e1.setEmpno(1);
     
     Employee e2 = new Employee();
     e2.setEname("y");
     e2.setEmpno(2);
     
     Employee e3 = new Employee();
     e3.setEname("x");
     e3.setEmpno(2);
     
     set.add(e1);
     set.add(e2);
     set.add(e3);
     
     System.out.println(set.size());
     
    }
}
