public class AscendingDigitsOnly {
//    6: Number with digits strictly in ascending order
    public static void main(String[] args) {
        for (String arg : args) {
            int prevDigit = -1;
            boolean isAscendingOnly = true;
            String[] stringArray = arg.split("");
            int[] intArray = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }
            for (int digit: intArray) {
                if (digit <= prevDigit) {
                    isAscendingOnly = false;
                } else {
                    prevDigit = digit;
                }
            }
            if (isAscendingOnly) {
                System.out.println("Number with digits strictly in ascending order: " + arg);
                break;
            }
        }
    }
}
