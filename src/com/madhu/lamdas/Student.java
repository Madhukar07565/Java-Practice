package com.madhu.lamdas;

import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created By Madhukar Reddy On Jul 14, 2015
 *
 */
@Data
@Getter
@Setter
public class Student {

    private String name;
    private int passoutYear;
    private double marks;

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = numbers.stream()
                            .filter(number -> number > 5)
                            .filter(number -> isEven(number))
                            .filter(number -> number < 9)
                            .filter(number -> number * 2 > 15)
                            .findFirst()
                            .get();
        System.out.println(result);
    }

    private static boolean isEven(Integer number) {
        if(number %2 == 0) {
            return true;
        }
        return false;
    }
}
