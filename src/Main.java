import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        findMinMax(Stream.of("test", "t", "tes", "testtest"),
                Comparator.comparingInt(String::length),
                (min, max) -> System.out.println("min = " + min + ", max = " + max));

        task1Stream();

    }
    private static void task1Stream() {
        Random r = new Random();
        IntStream stream = r.ints(10L, 0,100);
        stream.filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }


    private static <T> void findMinMax(Stream<? extends T> stream,
                                       Comparator<? super T> comparator,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(comparator).collect(Collectors.toList());
        minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
    }
}