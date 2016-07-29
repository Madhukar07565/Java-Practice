package com.madhu.lamdas;

import java.util.Comparator;

/**
 * Created By Madhukar Reddy On Jul 15, 2015
 *
 */
public class UserDefinedComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getMarks() > o2.getMarks()) {
            return -1;
        } else {
            return 1;
        }
    }
}
