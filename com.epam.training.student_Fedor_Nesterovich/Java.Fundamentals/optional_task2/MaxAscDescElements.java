import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MaxAscDescElements {
    //    2: Max amount of elements going in ascending/descending order.
    public static void main(String[] args) {
        if (args.length < 2) {  // check for arguments input.
            System.out.println("Not enough arguments entered (expected 2: n, M).");
        }
        else {
            int n = Integer.parseInt(args[0]);
            int M = Integer.parseInt(args[1]);
            int[][] array = new int[n][n];
            ArrayList<Integer> oneDimArray = new ArrayList<Integer>();
            int maxAsc = 1;
            int maxDesc = 1;
            int curAsc = 1;
            int curDesc = 1;
            for (int row = 0; row < array.length; row++) { // fill in the array with random numbers.
                for (int col = 0; col < array.length; col++) {
                    array[row][col] = ThreadLocalRandom.current().nextInt(-M, M + 1);
                }
            }
            System.out.println("Initial matrix:\n" + Arrays.deepToString(array).replace("], ", "]\n") // print the initial array.
                    .replace("[[", "[").replace("]]", "]"));
            for (int row = 0; row < array.length; row++) { // convert 2d array to 1d arraylist.
                for (int col = 0; col < array.length; col++) {
                    oneDimArray.add(array[row][col]);
                }
            }
            int lastNum = oneDimArray.get(0);
            for (int i = 1; i < oneDimArray.size(); i++) { // iterate through arraylist
                int curNum = oneDimArray.get(i);
                if (curNum > lastNum) { // check if current number is higher than previous
                    curAsc++;
                    if (curDesc > maxDesc) {    // check if current amount in descending order is higher than max
                        maxDesc = curDesc;
                    }
                    curDesc = 1;
                }
                else if (curNum < lastNum) {    // check if current number is lower than previous
                    curDesc++;
                    if (curAsc > maxAsc) {  // check if current amount in ascending order is higher than max
                        maxAsc = curAsc;
                    }
                    curAsc = 1;
                }
                else {
                    if (curAsc > maxAsc) {  // check if current amount in ascending order is higher than max
                        maxAsc = curAsc;
                    }
                    else if (curDesc > maxDesc) {   // check if current amount in descending order is higher than max
                        maxDesc = curDesc;
                    }
                    curAsc = 1;
                    curDesc = 1;
                }
                lastNum = curNum;   // change previous number to current
            }
            System.out.println("Max amount of elements going in ASCENDING order: " + maxAsc);
            System.out.println("Max amount of elements going in DESCENDING order: " + maxDesc);
        }
    }
}