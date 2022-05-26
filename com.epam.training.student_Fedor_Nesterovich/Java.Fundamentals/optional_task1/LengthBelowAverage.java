public class LengthBelowAverage {
//    3: Numbers with length below average
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments entered.");
        }
        else {
            double averageLength = 0;
            double sumLength = 0;
            for (String arg : args) {
                sumLength += Double.valueOf(arg.length());
            }
            averageLength = sumLength / args.length;
            System.out.println("Average numbers length: " + averageLength);
            for (String arg : args) {
                if (arg.length() < averageLength) {
                    System.out.println("Number " + arg + " with a length of " + arg.length() + " digits.");
                }
            }
        }
    }
}
