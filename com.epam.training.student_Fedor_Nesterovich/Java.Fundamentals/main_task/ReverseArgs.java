public class ReverseArgs {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments entered.");
        }
        else {
            for (int i = args.length; i > 0; i--) {
                if (i != 1) {
                    System.out.print(args[i - 1] + " ");
                } else {
                    System.out.print(args[i - 1]);
                }
            }
        }
    }
}
