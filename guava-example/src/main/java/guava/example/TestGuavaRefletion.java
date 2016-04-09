/*
 * Copyright (c) 2015 Sohu TV. All rights reserved.
 */
package guava.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

/**
 * <P>
 * Description:TODO
 * </p>
 * @author zhengmiao
 * @version 1.0
 * @Date 2015年7月16日上午12:25:25
 */
public class TestGuavaRefletion {
    public static void main(String[] args) {
        TypeToken<ArrayList<String>> typeToken = new TypeToken<ArrayList<String>>() {};
        TypeToken<?> genericTypeToken = typeToken.resolveType(ArrayList.class.getTypeParameters()[0]);
        System.out.println(genericTypeToken.getType());
        System.out.println(genericTypeToken.getRawType());
        TypeToken<String> stringTok = TypeToken.of(String.class);
        System.out.println(stringTok);
        TypeToken<List<String>> stringListTok = new TypeToken<List<String>>() {};
        System.out.println(stringListTok);
        
        TypeToken<Map<String, BigInteger>> mapToken = mapToken(
                TypeToken.of(String.class),
                TypeToken.of(BigInteger.class)
                );
        System.out.println(mapToken);
        TypeToken<Map<Integer, Queue<String>>> complexToken = mapToken(
                TypeToken.of(Integer.class),
                new TypeToken<Queue<String>>() {}
                );
        System.out.println(complexToken);
        
    }

    static <K, V> TypeToken<Map<K, V>> mapToken(TypeToken<K> keyToken, TypeToken<V> valueToken) {
        return new TypeToken<Map<K, V>>() {}
                .where(new TypeParameter<K>() {
                }, keyToken)
                .where(new TypeParameter<V>() {
                }, valueToken);
    }
}
