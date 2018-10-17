package method_references;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class Entry {

    public static void main(String[] args) {
        // Reference to a Static Method --> ContainingClass::methodName
        Stream.of("andrej", ",", "kira", ",", "lija").forEach(item -> System.out.print(item));
        System.out.println();
        Stream.of("andrej", ",", "kira", ",", "lija").forEach(System.out::print);
        System.out.println();

        // Reference to an Instance Method --> containingInstance::methodName
        LocalDateTime date1 = LocalDateTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime date2 = LocalDateTime.now();
        PrintStream out = System.out;
        Stream.of(date1, date2).forEach(item -> out.println(item));
        Stream.of(date1, date2).forEach(out::println);

        // Reference to an Instance Method of an Object of a Particular Type --> ContainingType::methodName
        long count = Stream.of("andrej", "", "kira", "", "lija").filter(String::isEmpty).count();
        System.out.println("Count of empty strings is " + count);

        // Reference to a Constructor (ClassName::new)
        Stream<String> result = Stream.of("andrej", ",", "kira", ",", "lija").map(String::new);
        result.forEach(out::print);
    }
}
