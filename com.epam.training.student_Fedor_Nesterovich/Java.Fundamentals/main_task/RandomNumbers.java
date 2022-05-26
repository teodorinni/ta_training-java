import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumbers {
    public static void main(String[] args) {
        System.out.print("Enter numbers amount: ");
        Scanner in = new Scanner(System.in);
        Integer number = Integer.valueOf(in.nextLine());
        int[] nums = new int[number];
        for (int i = 0; i < number; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt();
        }
        for (int i : nums) {
            System.out.println(i);
        }
        for (int i = 0; i < number; i++) {
            if (i < number - 1) {
                System.out.print(nums[i] + " ");
            } else {
                System.out.print(nums[i]);
            }
        }
    }
}
