import java.util.Scanner;

class HelloUser {
    public static void main(String[] args) {
        System.out.print("Please, enter username: ");
        Scanner in = new Scanner(System.in);
        String username = in.nextLine();
        System.out.println("Hello " + username + "!");
        in.close();
    }
}