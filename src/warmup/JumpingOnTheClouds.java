package warmup;

public class JumpingOnTheClouds {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0; //3
        int currentIndex = c[0]; //4
        while (currentIndex < (c.length - 1)) {
            if ((currentIndex < (c.length - 2)) && c[currentIndex + 2] == 0) {
                currentIndex += 2;
            } else {
                currentIndex += 1;
            }
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] input1 = {0, 0, 1, 0, 0, 1, 0};
        int[] input2 = {0, 1, 0, 0, 0, 1, 0};
        int[] input3 = {0, 0, 0, 1, 0, 0};
        int[] input4 = {0, 1, 0, 0, 0, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(input1));
        System.out.println(jumpingOnClouds(input2));
        System.out.println(jumpingOnClouds(input3));
    }
}
