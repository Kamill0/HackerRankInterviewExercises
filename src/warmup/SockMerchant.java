package warmup;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        return Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> entry.getValue() / 2)
                .filter(value -> value != 0)
                .mapToInt(Long::intValue)
                .sum();
    }

    public static void main(String[] args) {
        int[] input = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(input.length, input));
    }
}
