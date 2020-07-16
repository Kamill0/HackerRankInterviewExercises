package arrays;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeftRotation {

    static int[] rotLeft(int[] a, int d) {
        return Stream.of(Arrays.copyOfRange(a, d, a.length), Arrays.copyOfRange(a, 0, d))
                .flatMapToInt(IntStream::of).toArray();
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotLeft(input, 4)));
    }
}
