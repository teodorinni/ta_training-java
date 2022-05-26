public class SumMultArgs {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments entered.");
        }
        else {
            int argsSum = 0;
            int argsProduct = 1;
            for (String arg : args) {
                argsSum += Integer.valueOf(arg);
                argsProduct *= Integer.valueOf(arg);
            }
            System.out.println("Sum of arguments is: " + argsSum);
            System.out.println("Product of arguments is: " + argsProduct);
        }
    }
}
