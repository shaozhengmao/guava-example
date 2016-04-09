/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ComparisonChain;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015-6-25上午12:37:00
 */
public class TestGuavaOptional {

    /**
     * <P>
     * Description:TODO
     * </p>
     * @author zhengmiao
     * @version 1.0
     * @Date 2015-6-25上午12:37:00
     * @param args
     */
    public static void main(String[] args) {
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());

        Optional<Object> res = Optional.absent();
        System.out.println(res.isPresent());

        Optional<Integer> res2 = Optional.fromNullable(null);
        System.out.println(res2.isPresent());
        System.out.println(res2.orNull());
        System.out.println(res2.or(5));

        System.out.println(Optional.of(6).or(5));
        
        //常见的objects方法
        System.out.println(Objects.equal(5, 5));
        System.out.println(Objects.hashCode(1,2,3));
        System.out.println(MoreObjects.toStringHelper("MyObject").add("x", 1).add("y", 1).toString());

    }



    static class Apple{
        String name;
        String age;

        public int compareTo(Apple that) {
            return ComparisonChain.start()
                    .compare(this.name, that.name)
                    .compare(this.age, that.age).result();
                    //.compare(this.anEnum, that.anEnum, Ordering.natural().nullsLast())

        }
    }


}

