import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SumBetweenPositiveElements {
//    3: Sum of elements between 1st and 2nd positive element in each row
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        int[][] array = new int[n][n];
        for (int row = 0; row < array.length; row++){
            for (int col = 0; col < array.length; col++){
                array[row][col] = ThreadLocalRandom.current().nextInt(-M, M+1);
            }
        }
        System.out.println("Initial matrix:\n" + Arrays.deepToString(array).replace("], ", "]\n")
                .replace("[[", "[").replace("]]", "]"));
        String[] sumRowsArray = new String[n];
        Arrays.fill(sumRowsArray, "N/A");
        for (int row = 0; row < array.length; row++) {
            int firstPositiveCol = -1;
            int secondPositiveCol = -1;
            for (int col = 0; col < array.length; col++) {
                if (array[row][col] > 0 && firstPositiveCol == -1) {
                    firstPositiveCol = col;
                } else if (array[row][col] > 0) {
                    secondPositiveCol = col;
                    int numbersSum = 0;
                    for (int i = firstPositiveCol + 1; i < secondPositiveCol; i++) {
                        numbersSum += array[row][i];
                    }
                    sumRowsArray[row] = String.valueOf(numbersSum);
                    break;
                }
            }
        }
        System.out.println("Sums of numbers between 1st and 2nd positive number by rows:");
        for (int k = 0; k < sumRowsArray.length; k++) {
            System.out.println(k+1 + ": "+ sumRowsArray[k]);
        }
    }
}
