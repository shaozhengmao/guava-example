/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.TreeMultimap;
import com.google.common.primitives.Ints;

/**
 * <P>
 * Description:guava集合工具类
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月13日下午10:57:19
 */
public class TestGuavaCollections {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        Map<String, String> map = Maps.newLinkedHashMap();
        Maps.newHashMap();
        Set<Integer> copySet = Sets.newHashSet(1, 2, 3, 4);
        List<String> theseElements = Lists.newArrayList("alpha", "beta", "gamma", "gamma");
        Set<String> approx100Set = Sets.newHashSetWithExpectedSize(100);
        Multiset<String> multiset = HashMultiset.create();
        Person<Integer> person = Person.Create();
        Person<Integer> person2 = Person.Create();
        List<Person<Integer>> theseElements2 = Lists.newArrayList(person, person, person2, person2);
        System.out.println(Collections.frequency(theseElements, "gamma"));
        System.out.println(Collections.frequency(theseElements2, person));
        List<List<String>> resList = Lists.partition(theseElements, 3);
        System.out.println(resList);
        System.out.println("===================================");
        Iterable<Integer> concatenated = Iterables.concat(
                Ints.asList(1, 2, 3),
                Ints.asList(4, 5, 6)); // concatenated包括元素 1, 2, 3, 4, 5, 6
        System.out.println(concatenated);
        System.out.println(Iterables.getLast(copySet));
        System.out.println(Iterables.getFirst(copySet, 0));

        List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
        List<Integer> countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}
        List<List<Integer>> parts = Lists.partition(countUp, 2);// {{1,2},
                                                                // {3,4}, {5}}
        System.out.println("===================================");
        Set<String> wordsWithPrimeLength = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
        Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");
        SetView<String> intersection = Sets.intersection(primes, wordsWithPrimeLength);
        // intersection包含"two", "three", "seven"
        // 首先匹配set1 返回在set1里但是不在set2里的
        System.out.println(Sets.difference(wordsWithPrimeLength, primes));
        // 返回不同时在两个集合中的元素
        System.out.println(Sets.symmetricDifference(primes, wordsWithPrimeLength));
        System.out.println(intersection);
        System.out.println(intersection.immutableCopy());// 可以使用交集，但不可变拷贝的读取效率更高

        Set<String> animals = ImmutableSet.of("gerbil", "hamster");
        Set<String> fruits = ImmutableSet.of("apple", "orange", "banana");
        Set<List<String>> product = Sets.cartesianProduct(animals, fruits);
        // {{"gerbil", "apple"}, {"gerbil", "orange"}, {"gerbil", "banana"},
        // {"hamster", "apple"}, {"hamster", "orange"}, {"hamster", "banana"}}
        Set<Set<String>> animalSets = Sets.powerSet(animals);
        System.out.println(product);
        System.out.println(animalSets);
        System.out.println("===========================================");

        // 使用LinkedHashMaps替代HashMaps
        Table<String, Character, Integer> table = Tables.newCustomTable(
                Maps.<String, Map<Character, Integer>> newLinkedHashMap(),
                new Supplier<Map<Character, Integer>>() {
                    public Map<Character, Integer> get() {
                        return Maps.newLinkedHashMap();
                    }
                });
        System.out.println(Tables.transpose(table));
        System.out.println("===========================================");
        ImmutableList<String> immutableList = ImmutableList.of("1", "asdas", "4545", "ddfdfadafsad");

        ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(immutableList,
                new Function<String, Integer>() {
                    public Integer apply(String string) {
                        return string.length();
                    }
                });

        System.out.println(stringsByIndex);
        System.out.println("=========================================");
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 5, "d", 4);
        Map<String, Integer> right = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        MapDifference<String, Integer> diff = Maps.difference(left, right);
        System.out.println(diff.entriesInCommon());
        System.out.println(diff.entriesDiffering());
        System.out.println(diff.entriesDiffering().get("c").rightValue());
        System.out.println(diff.entriesOnlyOnLeft());
        System.out.println(diff.entriesOnlyOnRight());

        System.out.println("===========================================");
        BiMap<String, Integer> biMap = HashBiMap.create();
        Maps.synchronizedBiMap(biMap);
        Maps.unmodifiableBiMap(biMap);
        System.out.println("==========================================");

        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 2);
        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 5);
        System.out.println(Multisets.intersection(multiset1, multiset2));
        System.out.println(multiset1.containsAll(multiset2)); // 返回true；因为包含了所有不重复元素，
        // 虽然multiset1实际上包含2个"a"，而multiset2包含5个"a"
        System.out.println(Multisets.containsOccurrences(multiset1, multiset2)); // returns
                                                                                 // false
        System.out.println(Multisets.removeOccurrences(multiset2, multiset1)); // multiset2
                                                                               // 现在包含3个"a"
        System.out.println(multiset2.removeAll(multiset1));// multiset2移除所有"a"，虽然multiset1只有2个"a"
        System.out.println(multiset2.isEmpty()); // returns true

        Multiset<String> multiset3 = HashMultiset.create();
        multiset3.add("a", 3);
        multiset3.add("b", 5);
        multiset3.add("c", 1);
        ImmutableMultiset highestCountFirst = Multisets.copyHighestCountFirst(multiset3);
        // highestCountFirst，包括它的entrySet和elementSet，按{"b", "a", "c"}排列元素
        System.out.println(highestCountFirst);
        System.out.println("==========================================");

        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };
        ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);
        System.out.println(digitsByLength);
        System.out.println("=============================================");
        ArrayListMultimap<String, Integer> multimap3 = ArrayListMultimap.create();
        multimap3.putAll("b", Ints.asList(2, 4, 6));
        multimap3.putAll("a", Ints.asList(4, 2, 1));
        multimap3.putAll("c", Ints.asList(2, 5, 3));
        multimap3.put("a", 99);
        System.out.println(multimap3);
        TreeMultimap<Integer, String> treeMultimap = TreeMultimap.create();
        TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap3, treeMultimap);
        System.out.println(inverse);
        // 注意我们选择的实现，因为选了TreeMultimap，得到的反转结果是有序的
        /*
         * inverse maps: 1 => {"a"} 2 => {"a", "b", "c"} 3 => {"c"} 4 => {"a",
         * "b"} 5 => {"c"} 6 => {"b"}
         */
        System.out.println("=============================");
        Map<String, Integer> map4 = ImmutableMap.of("a", 1, "b", 1, "c", 2);
        System.out.println(map4);
        SetMultimap<String, Integer> multimap = Multimaps.forMap(map4);
        System.out.println(multimap);
        // multimap：["a" => {1}, "b" => {1}, "c" => {2}]
        HashMultimap<Integer, String> hashMultimap = HashMultimap.create();
        Multimap<Integer, String> inverse2 = Multimaps.invertFrom(multimap, hashMultimap);
        // inverse：[1 => {"a","b"}, 2 => {"c"}]
        System.out.println(inverse2);
    }

    static class Person<E> {
        public static <E> Person<E> Create() {
            return new Person<E>();
        }
    }
}
