public class EvenNumbersCount {
//    5: Count numbers with only even characters and numbers with equal amount of even and odd characters
    public static void main(String[] args) {
        int evenCharsCount = 0;
        int oddCharsCount = 0;
        int onlyEvenCount = 0;
        int equalEvenOddCount = 0;
        for (String arg: args) {
            String[] stringArray = arg.split("");
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            for (int digit: intArray) {
                if (digit % 2 == 0) {
                    evenCharsCount += 1;
                } else {
                    oddCharsCount += 1;
                }
            }
            if (evenCharsCount > 0 && oddCharsCount == 0) {
                onlyEvenCount += 1;
            } else if (evenCharsCount == oddCharsCount) {
                equalEvenOddCount += 1;
            }
            evenCharsCount = 0;
            oddCharsCount = 0;
        }
        System.out.println("Numbers with only even digits count: " + onlyEvenCount);
        System.out.println("Numbers with equal amount of even and odd digits: " + equalEvenOddCount);
    }
}
