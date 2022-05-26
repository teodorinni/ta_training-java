public class LeastUniqueDigits {
//    4: Find a number with the lowest amount of unique characters
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments entered.");
        }
        else {
            int leastUniqueDigits = 0;
            int currUniqueDigits;
            int numberIndex = 0;
            for (int i = 0; i < args.length; i++) {
                if (i == 0) {
                    leastUniqueDigits = (int) args[i].chars().distinct().count();
                } else {
                    currUniqueDigits = (int) args[i].chars().distinct().count();
                    if (currUniqueDigits < leastUniqueDigits) {
                        leastUniqueDigits = currUniqueDigits;
                        numberIndex = i;
                    }
                }
            }
            System.out.println("The number with lowest amount of unique digits is: " + args[numberIndex]);
            System.out.println("The number's unique digits amount is: " + leastUniqueDigits);
        }
    }
}
