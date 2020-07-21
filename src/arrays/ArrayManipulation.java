package arrays;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        long max = 0;
        long[] array = new long[n];
        for(int i=0;i<queries.length;++i){
            for(int j = queries[i][0]-1; j<queries[i][1]; ++j) {
                long new_val = array[j] + queries[i][2];
                max = Math.max(max, new_val);
                array[j] = new_val;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(arrayManipulation(5, new int[][]{
                {1,2,100},
                {2,5,100},
                {3,4,100}
        }));
    }
}
