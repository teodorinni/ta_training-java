import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByLength {
//    2: Sort by length increase(decrease)
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments entered.");
        }
        else {
            List<String> sortedNumbers = new ArrayList<String>();
            List<String> remainingNumbers = new ArrayList<String>(Arrays.asList(args));
            while (remainingNumbers.size() > 0) {
                int minNumberIndex = 0;
                for (int i = 0; i < remainingNumbers.size(); i++) {
                    if (remainingNumbers.get(i).length() < remainingNumbers.get(minNumberIndex).length()) {
                        minNumberIndex = i;
                    }
                    sortedNumbers.add(remainingNumbers.get(minNumberIndex));
                    remainingNumbers.remove(minNumberIndex);
                }
            }
            System.out.print("Numbers by length increase: ");
            for (String sortedNumber : sortedNumbers) {
                System.out.print(sortedNumber + " ");
            }
            System.out.print("\nNumbers by length decrease: ");
            for (int i = sortedNumbers.size() - 1; i >= 0; i--) {
                System.out.print(sortedNumbers.get(i) + " ");
            }
        }
    }
}
