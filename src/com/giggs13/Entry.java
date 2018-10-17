package com.giggs13;

import java.util.*;
import java.util.stream.IntStream;

public class Entry {

    public static void main(String[] args) {
        /*streamFromArray();
        streamFromList();
        streamFromMap();
        streamFromElements();*/

        final List<Integer> ints = new ArrayList<>();
        IntStream.range(0, 1000000)
                //.parallel()
                .forEach(i -> ints.add(i));
        System.out.println(ints.size());
    }

    private static void streamFromArray() {
        String[] arguments = new String[]{"cat", "b", "caterpillar"};

        Arrays.stream(arguments)
                .filter(item -> item.length() <= 2)
                .forEach(System.out::println);
    }

    private static void streamFromList() {
        List<String> arguments = Arrays.asList("cat", "b", "caterpillar");

        arguments.stream().parallel()
                .filter(item -> item.length() == 3)
                .forEach(System.out::println);
    }

    private static void streamFromMap() {
        Map<Integer, String> arguments = new HashMap<>();
        arguments.put(1, "cat");
        arguments.put(2, "b");
        arguments.put(3, "caterpillar");

        arguments.entrySet().parallelStream()
                .filter(item -> item.getValue().length() > 1)
                .forEach(System.out::println);
    }

    private static void streamFromElements() {
        IntStream.of(120, 410, 85, 32, 314, 12).parallel()
                .filter(item -> item < 300)
                .map(item -> item + 11)
                .limit(3)
                .forEach(System.out::print);
    }
}
