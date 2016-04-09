/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.util.Arrays;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * <P>
 * Description:排序器
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月10日上午11:38:37
 */
public class TestGuavaOrdering {
    public static void main(String[] args) {
        // 自定义排序器
        Ordering<String> byLengthOrdering = new Ordering<String>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

        System.out.println(byLengthOrdering.min(Arrays.asList("11", "2dd", "322d", "455", "19")));
        // 自然排序
        Ordering<Integer> naturalOrdering = Ordering.natural();
        System.out.println(naturalOrdering.min(Arrays.asList(11, 2, 322, 455, 19)));
        // 字典排序
        Ordering<Object> dirOrdering = Ordering.usingToString();
        System.out.println(dirOrdering.min(Arrays.asList("11", "2dd", "322d", "455", "19")));

        Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo, String>() {
            public String apply(Foo foo) {
                return foo.sortedBy;
            }
        });
        Ordering<String> naturalOrdering2 = Ordering.natural();
        ImmutableList<String> of = ImmutableList.of("a", "b", "e", "o", "d");
        System.out.println(naturalOrdering2.greatestOf(of, 2));
        System.out.println(naturalOrdering2.isOrdered(of));
        System.out.println(naturalOrdering2.sortedCopy(of));
        System.out.println(naturalOrdering2.nullsFirst().min(of));

    }

    class Foo {
        String sortedBy;
        int notSortedBy;
    }

}
