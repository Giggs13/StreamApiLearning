package com.giggs13.operator.terminal;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Entry {
    public static void main(String[] args) {
        runForEach​();
        runForEach​Ordered();
        runCount​();
        runCollect();
    }

    static void runForEach​() {
        // void forEach​(Consumer action)
        Stream.of(120, 410, 85, 32, 314, 12)
                .forEach(x -> System.out.format("%s, ", x));
        System.out.println();
    }

    static void runForEach​Ordered() {
        // void forEachOrdered(Consumer action)
        IntStream.range(0, 100000)
                .parallel()
                .filter(x -> x % 10000 == 0)
                .map(x -> x / 10000)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        IntStream.range(0, 100000)
                .parallel()
                .filter(x -> x % 10000 == 0)
                .map(x -> x / 10000)
                .forEachOrdered(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void runCount​() {
        // long count​()
        long count = IntStream.range(0, 10)
                .flatMap(x -> IntStream.range(0, x))
                .count();
        System.out.println(count);

        count = IntStream.rangeClosed(-3, 6)
                .count();
        System.out.println(count);

        count = Stream.of(0, 2, 9, 13, 5, 11)
                .map(x -> x * 2)
                .filter(x -> x % 2 == 1)
                .count();
        System.out.println(count);
    }

    static void runCollect() {
        // R collect​(Collector collector)

    }
}
