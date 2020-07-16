package arrays;


public class Array2D {

    static int calcSingleHourglass(int middleX, int middleY, int[][] arr) {
        return arr[middleX-1][middleY-1] + arr[middleX-1][middleY] + arr[middleX-1][middleY+1] +
                                            arr[middleX][middleY] +
                arr[middleX+1][middleY-1] + arr[middleX+1][middleY] + arr[middleX+1][middleY+1];
    }

    static int hourglassSum(int[][] arr) {
        int max = -100;
        for(int i=1; i<5;++i) {
            for(int j=1; j<5;++j) {
                int sum = calcSingleHourglass(i, j, arr);
                max = Math.max(sum, max);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[][] arr2d =
                {{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};

        System.out.println(hourglassSum(arr2d));
    }
}
