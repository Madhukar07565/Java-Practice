/**
 * 
 */
package com.madhu;

import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author madhukar
 *
 */
public class PredicateTest {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Predicate<String> matchPredicate = new Predicate<String>() {

            @Override
            public boolean apply(String str) {
                return str.startsWith("Ma");
            }
        };

        List<String> list = Lists.newArrayList(Iterables.filter(getNames(), matchPredicate));

        long end = System.currentTimeMillis();

        System.out.println("New list with filter " + list);
        System.out.println("time taken is " + (end - start));

        List<String> sb = new ArrayList<>();

        getNames().forEach(a -> {
            if (a.startsWith("Ma")) {
                sb.add(a);
            }
        });

        System.out.println("using java8 " + sb);

        List<String> ltr = getNames();

        ltr.removeIf(a -> a.startsWith("Ma"));

        System.out.println("ltr >> " + ltr);
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        names.add("Madhukar");
        names.add("Maddy");
        names.add("Krishna");
        return names;
    }

}
