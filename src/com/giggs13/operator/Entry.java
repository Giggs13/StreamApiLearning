package com.giggs13.operator;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Entry {
    private static final Random random = new SecureRandom();

    public static void main(String[] args) {
        // empty()
        Stream.empty()
                .forEach(System.out::println);

        // of(T value)
        // of(T... values)
        Stream.of(7)
                .forEach((item) -> System.out.print(item + " "));
        System.out.println();
        Stream.of(1, 2, 3)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        // ofNullable(T t)
        /*String str = Math.random() > 0.5 ? "I'm feeling lucky" : null;
        Stream.ofNullable(str)
                .forEach(System.out::println);*/

        // generate(Supplier s)
        Stream.generate(() -> random.nextInt(10))
                .limit(11)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        // iterate​(T seed, UnaryOperator f)
        // iterate​(T seed, Predicate hasNext, UnaryOperator f)
        Stream.iterate(2, item -> item *= 2)
                .limit(11)
                .forEach(item -> System.out.print(item + " "));
        /*Stream.iterate(2, x -> x < 25, x -> x + 6)
                .forEach(System.out::println);*/
        System.out.println();

        // concat(Stream a, Stream b)
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5, 6, 7))
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        // builder()
        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
                .add(0)
                .add(1);
        for (int i = 2; i <= 8; i += 2) {
            streamBuider.accept(i);
        }
        streamBuider
                .add(9)
                .add(10)
                .build()
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        // IntStream.range​(int startInclusive, int endExclusive)
        // IntStream.rangeClosed​(int startInclusive, int endInclusive)
        // LongStream.range​(long startInclusive, long endExclusive)
        // LongStream.range​Closed(long startInclusive, long endInclusive)
        IntStream.range(0, 13)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        IntStream.rangeClosed(0, 13)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        LongStream.range(-13L, 2)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();

        LongStream.rangeClosed(-13L, 2)
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
}
