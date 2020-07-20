package dictionariesandhashmaps;

import java.util.Arrays;
import java.util.List;

public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        long triplets = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if ((arr.get(i) * r) == arr.get(j)) {
                    triplets += findThird(arr.get(j), r, arr.subList(j + 1, arr.size()));
                }
            }
        }
        return triplets;
    }

    private static long findThird(Long middleValue, long commonRation, List<Long> remainingList) {
        return remainingList.stream()
                .filter(elem -> (middleValue * commonRation) == elem)
                .mapToLong(Long::longValue)
                .count();
    }


    public static void main(String[] args) {
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 2L, 4L), 2)); //2
        System.out.println(countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3)); //6
        System.out.println(countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5)); //4
        System.out.println(countTriplets(Arrays.asList(1L, 2L, 1L, 2L, 4L), 2)); //3
    }
}
