/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月12日下午5:09:59
 */
public class TestGuavaIO {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        File file = new File("D:/");
        File newFile = new File("D:/test.txt");
        String contents = "fasdfsaf";
        // Read the lines of a UTF-8 text file
        ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        // Count distinct word occurrences in a file
        Multiset<String> wordOccurrences = HashMultiset.create(
                Splitter.on(CharMatcher.WHITESPACE)
                        .trimResults()
                        .omitEmptyStrings()
                        .split(Files.asCharSource(file, Charsets.UTF_8).read()));
        Files.write(contents.getBytes(), newFile);
        // SHA-1 a file
        HashCode hash = Files.asByteSource(file).hash(Hashing.sha1());

        // Copy the data from a URL to a file
        Resources.asByteSource(url).copyTo(Files.asByteSink(file));

        // 普通文件
        String testFilePath = "d:\\test.txt";
        File testFile = new File(testFilePath);
        List<String> lines2 = Files.readLines(testFile, Charsets.UTF_16);
        for (String line : lines2) {
            System.out.println(line);
        }

        // 大文件读取
        String testFilePath2 = "d:\\test.txt";
        File testFile2 = new File(testFilePath2);
        CounterLine counter = new CounterLine();
        Files.readLines(testFile2, Charsets.UTF_16, counter);
        System.out.println(counter.getResult());

    }

    static class CounterLine implements LineProcessor<Integer> {
        private int rowNum = 0;

        @Override
        public boolean processLine(String line) throws IOException {
            rowNum++;
            return true;
        }

        @Override
        public Integer getResult() {
            return rowNum;
        }
    }
}
