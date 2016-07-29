package com.madhu.lamdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By Madhukar Reddy On Jul 14, 2015
 *
 */
// Functional Interface is an interface with only one abstract method. Example : Runnable, Comparable
interface Executable {
    void execute();
}

interface Executable1 {
    int execute();
}

interface Executable2 {
    int execute(int x, int y);
}

class Runner {
    void run(Executable e) {
        System.out.println("In Runner");
        e.execute();
    }
}

class Runner1 {
    void run(Executable1 e) {
        System.out.println("In Runner");
        int value = e.execute();
        System.out.println("Return value is : " + value);
    }
}

class Runner2 {
    void run(Executable2 e) {
        System.out.println("In Runner");
        int value = e.execute(2, 3);
        System.out.println("Return value is : " + value);
    }
}

public class LambdaTest {

    public int getString() {
        return 2;
    }

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("name1");
        student.setPassoutYear(2010);
        student.setMarks(90);

        Student student2 = new Student();
        student2.setName("name2");
        student2.setPassoutYear(2011);
        student2.setMarks(88);

        Student student3 = new Student();
        student3.setName("name3");
        student3.setPassoutYear(2011);
        student3.setMarks(90);

        Student student4 = new Student();
        student4.setName("name4");
        student4.setPassoutYear(2011);
        student4.setMarks(99);

        List<Student> students = new ArrayList<Student>();
        students.add(student);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println("before sorting >>> ");
        students.forEach(System.out::println);

      /*  Comparator<Student> comparator = (a, b) -> {
            if (a.getMarks() < b.getMarks()) {
                return 1;
            } else {
                return -1;
            }
        };*/

        // students.sort(comparator);

      /*  Collections.sort(students, (a, b) -> {
            if (a.getMarks() < b.getMarks()) {
                return 1;
            } else {
                return -1;
            }
        });
        */
        System.out.println("after sorting >>> ");
        students.stream().sorted((a, b) -> {
            if (a.getMarks() < b.getMarks()) {
                return 1;
            } else {
                return -1;
            }
        }).collect(Collectors.toList()).forEach(System.out::println);

        
       // students.forEach(System.out::println);

        // removeIf

        students.removeIf(p -> p.getName() == "name4");

        System.out.println("after removing >>> ");
        students.forEach(System.out::println);

        double highestMarks = 0.0;
        // Using normal for loop

        for (Student studen : students) {
            if (studen.getPassoutYear() == 2011) {
                if (studen.getMarks() > highestMarks) {
                    highestMarks = studen.getMarks();
                }
            }
        }
        
        System.out.println("Highest Marks >>> " + highestMarks);

        // using lambda expressions
        System.out.println("Highest Marks from Lambda >>>> "
                + students.stream().filter(p -> p.getPassoutYear() == 2011).peek(p -> System.out.println("Debug :: >>> "+p)).map(p -> p.getMarks()).max((x, y) -> {
                    if (x > y) {
                        return 1;
                    } else {
                        return -1;
                    }
                }).get());

        System.out.println("==========================");
        System.out.println("Without Lambda");

        Runner runner = new Runner();
        runner.run(new Executable() {
            @Override
            public void execute() {
                System.out.println("in Executable");
            }
        });

        System.out.println("======================");
        System.out.println("with Lambda");
        runner.run(() -> {
            int i = 10;
            System.out.println("i is >>> " + i);
            System.out.println("First line");
            System.out.println("in Executable");
        });

        /*
         * * Lambda Expressions Examples without return values 1.() -> System.out.println("First line");
         * 
         * 2. () -> { System.out.println("First line"); System.out.println("in Executable"); }
         * 
         * 
         * 
         * Lambda Expressions Examples with return values
         * 
         * 3. () -> { System.out.println("First line"); System.out.println("in Executable"); return 2; } 4. () -> 2; 5.
         * (int a, int b) -> a*b 6. (a,b) -> a*b
         */

        System.out.println("===================");

        Runner1 runner1 = new Runner1();
        runner1.run(new Executable1() {
            @Override
            public int execute() {
                System.out.println("in Executable");
                return 2;
            }
        });

        runner1.run(() -> 8);

        Runner2 runner2 = new Runner2();
        runner2.run((a, b) -> a * b);
    }
}
