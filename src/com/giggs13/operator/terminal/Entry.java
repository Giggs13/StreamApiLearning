package com.giggs13.operator.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Entry {
    public static void main(String[] args) {
        runForEach​();
        runForEach​Ordered();
        runCount​();
        runCollect();
        runToArray();
        runReduce();
        runMinAndMax();
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
        List<Integer> list1 = Stream.of(1, 2, 3)
                .collect(Collectors.toList());
        System.out.println(list1);

        String s = Stream.of(1, 2, 3)
                .map(String::valueOf)
                .collect(Collectors.joining("-", "<", ">"));
        System.out.println(s);

        // R collect​(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)
        List<String> list2 = Stream.of("a", "b", "c", "d")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list2);

        String concat = Stream.of("a", "b", "c", "d")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        System.out.println(concat);
    }

    static void runToArray() {
        // Object[] toArray​()
        // A[] toArray​(IntFunction<A[]> generator)
        Object[] elements1 = Stream.of("a", "b", "c", "d")
                .toArray();
        System.out.println(Arrays.toString(elements1));

        String[] elements2 = Stream.of("a1", "b1", "c1", "d1")
                .toArray(String[]::new);
        System.out.println(Arrays.toString(elements2));
    }

    static void runReduce() {
        // T reduce​(T identity, BinaryOperator accumulator)
        // U reduce​(U identity, BiFunction accumulator, BinaryOperator combiner)
        int sum1 = Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (acc, x) -> acc * x);
        System.out.println(sum1);

        Integer sum2 = IntStream.of(1, 2, 3, 4)
                .reduce(100, (a, b) -> a + b);
        System.out.println(sum2);

        Integer sum3 = IntStream.of(1, 2, 3, 4)
                .reduce(100, Integer::sum);
        System.out.println(sum3);

        // Optional reduce​(BinaryOperator accumulator)
        Optional<Integer> result = Stream.<Integer>empty()
                .reduce((acc, x) -> acc + x);
        System.out.println(result);
        System.out.println(result.isPresent());

        Optional<Integer> sum = Stream.of(1, 2, 3, 4, 5)
                .reduce((acc, x) -> acc + x);
        System.out.println(sum);
        System.out.println(sum.isPresent());
        System.out.println(sum.get());

        int product = IntStream.range(0, 10)
                .filter(x -> x++ % 4 == 0)
                .reduce((acc, x) -> acc * x)
                .getAsInt();
        System.out.println(product);
    }

    static void runMinAndMax() {
        // Optional min​(Comparator comparator)
        int min = Stream.of(20, 11, 45, 78, 13)
                .min(Integer::compare).get();
        System.out.println(min);

        // Optional max​(Comparator comparator)
        int max = Stream.of(20, 11, 45, 78, 13)
                .max(Integer::compare).get();
        System.out.println(max);
    }
}
