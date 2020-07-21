package arrays;

public class MinimumSwaps2 {
    static int minimumSwaps(int[] arr) {
        int count = 0;

        for(int i=0; i<arr.length; ++i) {
            while (arr[i] != (i + 1)) {
                int tmp = arr[i];
                arr[i] = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{4, 3, 1, 2})); //3
        System.out.println(minimumSwaps(new int[]{2, 3, 4, 1, 5})); //3
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7})); //3
    }
}
