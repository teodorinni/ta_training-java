import java.util.Objects;

public class ShortestLongestNumber {
//      1: Shortest and longest number
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments entered.");
        }
        else {
            int minNumber = 0;
            int maxNumber = 0;
            int minNumberLength = 0;
            int maxNumberLength = 0;
            for (String arg : args) {
                if (Objects.equals(arg, args[0])) {
                    minNumber = Integer.valueOf(arg);
                    maxNumber = Integer.valueOf(arg);
                    minNumberLength = arg.length();
                    maxNumberLength = arg.length();
                } else {
                    int curr_number_length = arg.length();
                    if (curr_number_length < minNumberLength) {
                        minNumberLength = curr_number_length;
                        minNumber = Integer.valueOf(arg);
                    } else if (curr_number_length > maxNumberLength) {
                        maxNumberLength = curr_number_length;
                        maxNumber = Integer.valueOf(arg);
                    }
                }
            }
            System.out.println("Max length number is " + maxNumber + " with length of " + maxNumberLength + " characters.");
            System.out.println("Min length number is " + minNumber + " with length of " + minNumberLength + " characters.");
        }
    }
}
