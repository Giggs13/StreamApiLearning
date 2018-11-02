package com.giggs13.collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Entry {
    public static void main(String[] args) {
        runToList();
        runToSet();
        runToCollection();
        runToMap();
    }

    static void runToList() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    static void runToSet() {
        Set<Integer> set = Stream.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
                .collect(Collectors.toSet());
        System.out.println(set);
    }

    static void runToCollection() {
        Deque<Integer> deque = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println(deque);

        Set<Integer> set = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set);
    }

    static void runToMap() {
        // toMap​(Function keyMapper, Function valueMapper)
        Map<Integer, Integer> map1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        Function.identity(),
                        Function.identity()
                ));
        System.out.println(map1);

        Map<Integer, String> map2 = Stream.of(1, 2, 3)
                .collect(Collectors.toMap(
                        Function.identity(),
                        i -> String.format("%d * 2 = %d", i, i * 2)
                ));
        System.out.println(map2);

        Map<Character, String> map3 = Stream.of(50, 54, 55)
                .collect(Collectors.toMap(
                        i -> (char) i.intValue(),
                        i -> String.format("<%d>", i)
                ));
        System.out.println(map3);

        // toMap​(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
        Map<Integer, String> map4 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5,
                        i -> String.format("<%d>", i),
                        (a, b) -> String.join(", ", a, b)
                ));
        System.out.println(map4);

        // toMap​(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapFactory)
        Map<Integer, String> map5 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5,
                        i -> String.format("<%d>", i),
                        (a, b) -> String.join(", ", a, b),
                        LinkedHashMap::new
                ));
        System.out.println(map5);
        // toConcurrentMap​(Function keyMapper, Function valueMapper)
        // toConcurrentMap​(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
        // toConcurrentMap​(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapFactory)
    }
}
