public class UniqueDigitsOnly {
//    7: Number with unique digits only
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments entered");
        }
        else {
            for (String arg : args) {
                if (arg.length() == (int) arg.chars().distinct().count()) {
                    System.out.println("The number with unique digits only is: " + arg);
                    break;
                }
            }
        }
    }
}
