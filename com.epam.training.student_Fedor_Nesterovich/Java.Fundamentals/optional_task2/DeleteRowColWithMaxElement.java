import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class DeleteRowColWithMaxElement {
//    4: Delete row and column containing max element
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Not enough arguments entered (expected 2: n, M).");
        }
        else {
            int n = Integer.parseInt(args[0]);
            int M = Integer.parseInt(args[1]);
            int[][] array = new int[n][n];
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array.length; col++) {
                    array[row][col] = ThreadLocalRandom.current().nextInt(-M, M + 1);
                }
            }
            System.out.println("Initial matrix:\n" + Arrays.deepToString(array).replace("], ", "]\n")
                    .replace("[[", "[").replace("]]", "]"));
            int[][] updArray = new int[n - 1][n - 1];
            int maxElement = array[0][0];
            int maxElementRow = 0;
            int maxElementCol = 0;
            boolean rowDeduction = false;
            boolean colDeduction = false;
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array.length; col++) {
                    if (array[row][col] > maxElement) {
                        maxElement = array[row][col];
                        maxElementRow = row;
                        maxElementCol = col;
                    }
                }
            }
            for (int row = 0; row < array.length; row++) {
                if (row == maxElementRow) {
                    rowDeduction = true;
                } else {
                    colDeduction = false;
                    for (int col = 0; col < array.length; col++) {
                        if (col == maxElementCol) {
                            colDeduction = true;
                        } else {
                            if (!rowDeduction && !colDeduction) {
                                updArray[row][col] = array[row][col];
                            } else if (rowDeduction && !colDeduction) {
                                updArray[row - 1][col] = array[row][col];
                            } else if (!rowDeduction && colDeduction) {
                                updArray[row][col - 1] = array[row][col];
                            } else {
                                updArray[row - 1][col - 1] = array[row][col];
                            }
                        }
                    }
                }
            }
            System.out.println("Matrix without row and column containing max number:\n" + Arrays.deepToString(updArray)
                    .replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        }
    }
}
