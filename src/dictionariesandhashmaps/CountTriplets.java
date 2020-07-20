package dictionariesandhashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> candidate = new HashMap<>();
        Map<Long, Long> triplets = new HashMap<>();

        long count = 0L;

        for (int i=0; i < arr.size(); ++i) {
            long key = arr.get(i);
            long div = key/r;

            if (triplets.containsKey(div) && (key % r == 0)) {
                count += triplets.get(div);
            }

            if (candidate.containsKey(div) && (key % r == 0)) {
                Long value = candidate.get(div);
                triplets.put(key, triplets.getOrDefault(key, 0L) + value);
            }

            candidate.put(key, candidate.getOrDefault(key, 0L) + 1L);

        }

        return count;
    }



    public static void main(String[] args) {
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2)); //2
        System.out.println(countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3)); //6
        System.out.println(countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5)); //4
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 1L, 2L, 4L), 2)); //3
    }
}
