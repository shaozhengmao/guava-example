package guava.example;

import java.awt.Color;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;

public class TestGuavaCollection {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 不可变集合
        ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d","e","e");
        ImmutableSet.of("a", "b", "c", "d");
        System.out.println(of);
        ImmutableSortedMap<String, String> map = ImmutableSortedMap.of("key3", "value3", "key2", "value2");
        System.out.println(map);
        
        ImmutableMap<String, String> map2 = ImmutableMap.of("key1", "value1", "key2", "value2");
        System.out.println(map2);
        
        ImmutableSet<Color> GOOGLE_COLORS =
                        ImmutableSet.<Color>builder()
                            .add(new Color(0, 191, 255))
                            .build();
        //有序不可变集合
        ImmutableSortedSet<String> sortedSet = ImmutableSortedSet.of("a", "b", "c", "e", "d", "f");
        System.out.println(sortedSet.asList().get(0));
        System.out.println("==========================================");
        //新集合类型
        ImmutableList<String> of3 = ImmutableList.of("a", "b", "c", "d","e","e");
        Multiset<String> multiset = HashMultiset.create();
        multiset.addAll(of3);
        System.out.println(multiset.size());
        System.out.println(multiset.setCount("e", 10));
        System.out.println(multiset.count("e"));
        System.out.println(multiset.entrySet().size());
        System.out.println(multiset.elementSet());
        
        ConcurrentHashMultiset.create();
        LinkedHashMultiset.create();
        ImmutableMultiset.of();
        
        System.out.println("==================================================");
       // SortedMultiset<String> sortedMultiset = HashMultiset.create();
        Multimap<String,Map<String, Integer>> scoreMultimap = ArrayListMultimap.create(); 
        
        for(int i=10;i<20;i++){
            ImmutableMap<String, Integer> of2 = ImmutableMap.of(i+"_key", i);
            scoreMultimap.put(i+"_key",of2);
        }
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
        System.out.println("scoreMultimap:"+scoreMultimap.get("14_key"));
        System.out.println("scoreMultimap:"+scoreMultimap.put("14_key", ImmutableMap.of("14_key",100)));
        System.out.println("scoreMultimap:"+scoreMultimap.get("14_key"));
        System.out.println("scoreMultimap:"+scoreMultimap.remove("10_key", ImmutableMap.of("10_key",10)));
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
        System.out.println("scoreMultimap:"+scoreMultimap.removeAll("14_key"));
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
        System.out.println(scoreMultimap.asMap());
        
        System.out.println("===============================================");
        
        Multimap<String,Integer> multimap = HashMultimap.create();
        for(int i=10;i<20;i++){
            multimap.put(i+"_key",i);
        }
        System.out.println(multimap.size());
        System.out.println(multimap.keys());
        System.out.println(multimap.keySet());
        System.out.println(multimap.put("10_key", 1100));
        System.out.println(multimap.keys());
        System.out.println(multimap.keySet());
        System.out.println(multimap.asMap());
        System.out.println(multimap.asMap().entrySet());
        System.out.println(multimap.entries());
        System.out.println(multimap.values());
        System.out.println(multimap.size());
        
        System.out.println("======================================");
        
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.putAll(ImmutableMap.of("k1", "v1", "k2", "v2"));
        System.out.println(biMap.keySet());
        System.out.println(biMap);
       
        System.out.println(biMap.inverse());
        System.out.println(biMap.keySet());
        biMap.forcePut("k2", "v3");
        System.out.println(biMap);
        
        System.out.println("==========================================");
        
        Table<String,Integer,String> aTable = HashBasedTable.create();
        
        
        for (char a = 'A'; a <= 'C'; ++a) {  
            for (Integer b = 1; b <= 3; ++b) {   
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));  
            }  
        }  
        Table<String,Integer,String> aTable2 = ArrayTable.create(aTable);
        System.out.println(aTable.column(2));  
        System.out.println(aTable.row("B"));   
        System.out.println(aTable.get("B", 2));  

        System.out.println(aTable.contains("D", 1));   
        System.out.println(aTable.containsColumn(3));   
        System.out.println(aTable.containsRow("C"));  
        System.out.println(aTable.columnMap()); 
        System.out.println(aTable.rowMap());   

        System.out.println(aTable.remove("B", 3)); 
        System.out.println(aTable.columnMap()); 
        System.out.println(aTable.rowMap()); 
        
        System.out.println("=============================================");
        
        ClassToInstanceMap<String> classToInstanceMapString =MutableClassToInstanceMap.create();
        ClassToInstanceMap<Person> classToInstanceMap =MutableClassToInstanceMap.create();
        ClassToInstanceMap<Number> classToInstanceMapNum =MutableClassToInstanceMap.create();
        Person person= new Person("peida",20);
        System.out.println("person name :"+person.name+" age:"+person.age);
        classToInstanceMapString.put(String.class, "peida");
        System.out.println("string:"+classToInstanceMapString.getInstance(String.class));
        
        classToInstanceMap.putInstance(Person.class,person);
        Person person1=classToInstanceMap.getInstance(Person.class);
        System.out.println("person1 name :"+person1.name+" age:"+person1.age);
        
        classToInstanceMapNum.put(Integer.class, 10);
        classToInstanceMapNum.put(Long.class, 100L);
        classToInstanceMapNum.put(long.class, 1000L);
        
        System.out.println(classToInstanceMapNum.getInstance(Integer.class));
        System.out.println(classToInstanceMapNum.getInstance(Long.class));
        System.out.println(classToInstanceMapNum.getInstance(long.class));
        
        System.out.println("============================================");
        
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.closedOpen(11, 15)); 
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.open(15, 20));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.openClosed(0, 0)); 
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.remove(Range.open(5, 10)); 
        System.out.println("rangeSet:"+rangeSet);
        System.out.println(rangeSet.complement());
        System.out.println(rangeSet.contains(4));
        System.out.println(rangeSet.rangeContaining(10));
        System.out.println(rangeSet.encloses(Range.closed(1, 9)));
        System.out.println(rangeSet.span());
        
        System.out.println("==========================================");
        
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); 
        System.out.println("rangeMap:"+rangeMap);
        rangeMap.put(Range.open(3, 6), "bar"); 
        System.out.println("rangeMap:"+rangeMap);
        rangeMap.put(Range.open(10, 20), "foo"); 
        System.out.println("rangeMap:"+rangeMap);
        rangeMap.remove(Range.closed(5, 11)); 
        System.out.println("rangeMap:"+rangeMap);
        System.out.println(rangeMap.asMapOfRanges());
        System.out.println(rangeMap.getEntry(15));
        System.out.println(rangeMap.getEntry(15).getValue());
        
    }
    static class Person {
        public String name;
        public int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    } 
}
