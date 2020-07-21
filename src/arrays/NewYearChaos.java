package arrays;

public class NewYearChaos {
    static void minimumBribes(int[] q) {
        long minimumBribes = 0;
        for (int i = (q.length - 1); i >= 0; --i) {
            if (q[i] > (i + 3)) {
                System.out.println("Too chaotic");
                return;
            }
        }

        boolean swapped = false;

        for (int i = 0; i < q.length; ++i) {
            for (int j = 0; j < q.length - 1; ++j) {
                if (q[j] > q[j+1]) {
                    int tmp = q[j];
                    q[j] = q[j+1];
                    q[j+1] = tmp;
                    minimumBribes ++;
                    swapped = true;
                }
            }
            if (swapped)
                swapped = false;
            else
                break;
        }
        System.out.println(minimumBribes);
    }


    public static void main(String[] args) {
        int[] input1 = {2,1,5,3,4}; //3
        int[] input2 = {2,5,1,3,4}; // Too chaotic
        int[] input3 = {1, 2, 5, 3, 4, 7, 8, 6}; // 4
        int[] input4 = {1, 2, 5, 3, 7, 8, 6, 4};

        // 1 2 3 4 5 6 7 8
        // 1 2 3 4 5 7 6 8
        // 1 2 5 3 4 7 8 6


        minimumBribes(input1); // 3
        minimumBribes(input2); // Too chaotic
        minimumBribes(input3); // 4
        minimumBribes(input4);


    }
}
