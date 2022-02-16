import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer number = Integer.valueOf(in.nextLine());
        for (int i = 1; i <= number; i++){
            System.out.println(ThreadLocalRandom.current().nextInt());
        }
        for (int i = 1; i <= number; i++){
            if (i < number) {
                System.out.print(ThreadLocalRandom.current().nextInt() + " ");
            } else {
                System.out.print(ThreadLocalRandom.current().nextInt());
            }
        }
    }
}
