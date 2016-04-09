/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.util.Arrays;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月10日上午12:25:28
 */
public class TestGuavaString {
    public static void main(String[] args) {
        //连接器
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
        Joiner joiner2 = Joiner.on("; ").useForNull("mary");
        System.out.println(joiner2.join("Harry", null, "Ron", "Hermione"));
        System.out.println(Joiner.on("|").join(Arrays.asList(1, 5, 7)));
        //拆分器
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux")
                );
        Lists.newArrayList(Splitter.on(',').split(""));
        //字符匹配器
        String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(""); //移除control字符
        System.out.println(noControl);
        String theDigits = CharMatcher.DIGIT.retainFrom(" dafasdf,1"); //只保留数字字符
        System.out.println(theDigits);
        //去除两端的空格，并把中间的连续空格替换成单个空格
        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(" ad  dsf ", ' ');
        System.out.println("trimAndCollapseFrom:"+spaced);
        //用*号替换所有数字
        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom("123aaa888dafdfk", "*"); 
        System.out.println(noDigits);
        // 只保留数字和小写字母
        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("ADFKAJD98dddf");
        System.out.println(lowerAndDigit);
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"));
        System.out.println("我的".getBytes(Charsets.UTF_8));
        System.out.println(CharMatcher.anyOf("aeiou").retainFrom("123addfds"));
        System.out.println(CharMatcher.anyOf("aeiou").trimFrom("b123addfdsu"));
        
        
        
        int compare = Ints.compare(2, 3);
        System.out.println(compare);
        String string = CharMatcher.DIGIT.retainFrom("some text 89983 and more");
        System.out.println(string);
        String string2 = CharMatcher.DIGIT.removeFrom("some text 89983 and more");
        System.out.println(string2);
        String[] subdirs = {"usr", "local", "lib"};
        String directory = Joiner.on("/").join(subdirs);
        System.out.println(directory);
        int[] numbers = {1, 2, 3, 4, 5};
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
        System.out.println(numbersAsString);
        String numbersAsStringDirectly = Ints.join(";", numbers);
        System.out.println(numbersAsStringDirectly);
        ImmutableList<String> of2 = ImmutableList.of("a", "b", "a", "d", "a");
        HashMultiset<String> multiSet = HashMultiset.create();
        multiSet.addAll(of2);
        System.out.println(multiSet.count("a"));

    }

}

