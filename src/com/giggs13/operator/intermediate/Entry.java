package com.giggs13.operator.intermediate;

import java.util.Comparator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Entry {
    public static void main(String[] args) {
        runFiltering();
        runMapping();
        runFlatMap();
        runLimit();
        runSkip();
        runSorted();
        runDistinct();
        runPeek();
//        runTakeWhile();
//        runDropWhile();
        runBoxed();
    }

    static void runFiltering() {
        // filter​(Predicate predicate)
        Stream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x > 100)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void runMapping() {
        // map​(Function mapper)

        // Stream.mapToDouble​(ToDoubleFunction mapper)
        // Stream.mapToInt​(ToIntFunction mapper)
        // Stream.mapToLong​(ToLongFunction mapper)
        // IntStream.mapToObj(IntFunction mapper)
        // IntStream.mapToLong(IntToLongFunction mapper)
        // IntStream.mapToDouble(IntToDoubleFunction mapper)
        Stream.of("3", "4", "5")
                .map(Integer::parseInt)
                .map(x -> x + 10)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        Stream.of(120, 410, 85, 32, 314, 12)
                .map(x -> x + 11)
                .mapToDouble(x -> x / 100d)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void runFlatMap() {
        // flatMap​(Function<T, Stream<R>> mapper)

        // flatMapToDouble​(Function mapper)
        // flatMapToInt​(Function mapper)
        // flatMapToLong​(Function mapper)
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void runLimit() {
        // limit​(long maxSize)
        Stream.of(120, 410, 85, 32, 314, 12)
                .limit(2)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void runSkip() {
        // skip​(long n)
        Stream.of(120, 410, 85, 32, 314, 12)
                .skip(2)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void runSorted() {
        // sorted​()
        // sorted​(Comparator comparator)
        IntStream.range(0, 100)
                .sorted()
                .limit(5)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        IntStream.concat(
                IntStream.range(0, 100),
                IntStream.of(-1, -2))
                .sorted()
                .limit(5)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        Stream.of(120, 410, 85, 32, 314, 12)
                .sorted()
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        Stream.of(120, 410, 85, 32, 314, 12)
                .sorted(Comparator.naturalOrder())
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        Stream.of(120, 410, 85, 32, 314, 12)
                .sorted(Comparator.reverseOrder())
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void runDistinct() {
        // distinct​()
        Stream.of(2, 1, 8, 1, 3, 2)
                .distinct()
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        IntStream.concat(
                IntStream.range(2, 5),
                IntStream.range(0, 4))
                .distinct()
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void runPeek() {
        // peek​(Consumer action)
        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));
        System.out.println();
    }

    /*static void runTakeWhile() {
        // takeWhile​(Predicate predicate)
        Stream.of(1, 2, 3, 4, 2, 5)
                .takeWhile(x -> x < 3)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        IntStream.range(2, 7)
                .takeWhile(x -> x != 5)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }*/

    /*static void runDropWhile() {
        // dropWhile​(Predicate predicate)
        Stream.of(1, 2, 3, 4, 2, 5)
                .dropWhile(x -> x >= 3)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        Stream.of(1, 2, 3, 4, 2, 5)
                .dropWhile(x -> x < 3)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        IntStream.range(2, 7)
                .dropWhile(x -> x < 5)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        IntStream.of(1, 3, 2, 0, 5, 4)
                .dropWhile(x -> x % 2 == 1)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
        System.out.println();
    }*/

    static void runBoxed() {
        // boxed()
        DoubleStream.of(0.1, Math.PI)
                .boxed()
                .map(Object::getClass)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
}
