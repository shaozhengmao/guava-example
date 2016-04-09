/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;


import com.google.common.base.Charsets;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月12日上午10:30:09
 */
public class TestGuavaHash {
    public static void main(String[] args) {
        Person person = new Person();
        person.birthYear = 10;
        person.firstName="tom";
        person.lastName="c";
        person.id=10;
        
        Funnel<Person> personFunnel = new Funnel<Person>() {
                @Override
                public void funnel(Person person, PrimitiveSink into) {
                    into
                        .putInt(person.id)
                        .putString(person.firstName, Charsets.UTF_8)
                        .putString(person.lastName, Charsets.UTF_8)
                        .putInt(person.birthYear);
                }
            };
            
            Funnel<Person> personFunnel2 = new Funnel<Person>() {

                @Override
                public void funnel(Person person, PrimitiveSink into) {
                    into
                    .putInt(person.id)
                    .putString(person.firstName, Charsets.UTF_8)
                    .putString(person.lastName, Charsets.UTF_8)
                    .putInt(person.birthYear);
                    
                }
                
            };
            
            HashFunction hFunction = Hashing.md5();
            HashCode hashCode =  hFunction.newHasher().putLong(111L)
                  .putString("ddd", Charsets.UTF_8)
                  .putObject(person, personFunnel)
                  .hash();
            
            System.out.println(hashCode.asInt());
            HashFunction hashFunction = Hashing.md5();
            HashCode hashCode2 = hashFunction.newHasher().putInt(123).hash();
            System.out.println(hashCode2.asInt());
            System.out.println(hashCode2.asLong());
            
            HashCode hashCode3 = hashFunction.newHasher().putInt(234).hash();
            System.out.println(hashCode3.asInt());

    }
    
    static class Person{
                 int id;
                 String firstName;
                 String lastName;
                 int birthYear;
    }
}
