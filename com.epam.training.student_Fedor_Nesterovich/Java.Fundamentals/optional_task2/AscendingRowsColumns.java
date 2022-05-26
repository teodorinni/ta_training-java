import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class AscendingRowsColumns {
//    1: Sort matrix by k row(column) in ascending order
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Not enough arguments entered (expected 3: n, M, k).");
        }
        else {
            int n = Integer.parseInt(args[0]);
            int M = Integer.parseInt(args[1]);
            int k = Integer.parseInt(args[2]) - 1;
            int[][] array = new int[n][n];
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array.length; col++) {
                    array[row][col] = ThreadLocalRandom.current().nextInt(-M, M + 1);
                }
            }
            System.out.println("Initial matrix:\n" + Arrays.deepToString(array).replace("], ", "]\n")
                    .replace("[[", "[").replace("]]", "]"));
            int[][] arrRowsAsc = new int[array.length][];
            int[][] arrColsAsc = new int[array.length][];
            for (int i = 0; i < array.length; i++) {
                arrRowsAsc[i] = array[i].clone();
                arrColsAsc[i] = array[i].clone();
            }
            boolean isSortedRow = false;
            while (!isSortedRow) {
                isSortedRow = true;
                for (int col = 1; col < arrRowsAsc.length; col++) {
                    if (arrRowsAsc[k][col] < arrRowsAsc[k][col - 1]) {
                        for (int row = 0; row < arrRowsAsc.length; row++) {
                            int swapVar = arrRowsAsc[row][col];
                            arrRowsAsc[row][col] = arrRowsAsc[row][col - 1];
                            arrRowsAsc[row][col - 1] = swapVar;
                        }
                        isSortedRow = false;
                    }
                }
            }
            boolean isSortedCol = false;
            while (!isSortedCol) {
                isSortedCol = true;
                for (int row = 1; row < arrColsAsc.length; row++) {
                    if (arrColsAsc[row][k] < arrColsAsc[row - 1][k]) {
                        for (int col = 0; col < arrColsAsc.length; col++) {
                            int swapVar = arrColsAsc[row][col];
                            arrColsAsc[row][col] = arrColsAsc[row - 1][col];
                            arrColsAsc[row - 1][col] = swapVar;
                        }
                        isSortedCol = false;
                    }
                }
            }
            System.out.println("Matrix with rows sorted by " + args[2] + " row:\n" + Arrays.deepToString(arrRowsAsc).replace
                    ("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            System.out.println("Matrix with rows sorted by " + args[2] + " column:\n" + Arrays.deepToString(arrColsAsc).replace
                    ("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        }
    }
}
