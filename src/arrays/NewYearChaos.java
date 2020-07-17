package arrays;

public class NewYearChaos {
    static void minimumBribes(int[] q) {
        long minimumBribes = 0;
        for (int i = (q.length - 1); i >= 0; --i) {
            if (q[i] > (i + 3)) {
                System.out.println("Too chaotic");
                return;
            }
            /*if (q[i]  == i) {
                minimumBribes += 1;
            }

            if (q[i]  == (i-1)) {
                minimumBribes += 2;
            }*/

            if (q[i] < (i+1)) {
                minimumBribes += ((i+1) - q[i]);
            }

/*            if (i > 0) {
                long diff = q[i-1] - q[i];

                if (diff > 1) {
                    minimumBribes += diff - 1;
                }
            }*/

        }
        System.out.println(minimumBribes);
    }


    public static void main(String[] args) {
        int[] input1 = {2,1,5,3,4};
        int[] input2 = {2,5,1,3,4};
        int[] input3 = {1, 2, 5, 3, 4, 7, 8, 6};
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
