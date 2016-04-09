/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月10日上午12:41:53
 */
public class TestGuavaRange {
    public static void main(String[] args) {
        System.out.println(Range.lessThan(4.0));
        System.out.println(Range.closed("left", "right"));
        System.out.println(Range.closed(1, 3).contains(2));//return true
        System.out.println(Range.closed(1, 3).contains(4));//return false
        System.out.println(Range.lessThan(5).contains(5)); //return false
        System.out.println(Range.closed(1, 4).containsAll(Ints.asList(1, 2, 3))); //return true
        System.out.println(Range.closedOpen(4, 4).isEmpty()); // returns true
        System.out.println(Range.openClosed(4, 4).isEmpty()); // returns true
        System.out.println(Range.closed(4, 4).isEmpty()); // returns false
        System.out.println(Range.closed(3, 10).lowerEndpoint()); // returns 3
        System.out.println(Range.open(3, 10).lowerEndpoint()); // returns 3
        System.out.println(Range.closed(3, 10).lowerBoundType()); // returns CLOSED
        System.out.println(Range.open(3, 10).upperBoundType()); // returns OPEN
        System.out.println(Range.open(3, 10).hasUpperBound());
        System.out.println(Range.closed(3, 5).isConnected(Range.open(5, 10)));
        System.out.println(Range.open(3, 5).isConnected(Range.open(5, 10)));
        System.out.println(Range.closed(0, 5).intersection(Range.closed(3, 9)));
        System.out.println(Range.closed(1, 5).span(Range.closed(6, 10)));

    }

}

