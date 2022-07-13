import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//  2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
public class ReverseNumberThroughStack {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please, enter a number to transform: ");
        int numberInput = input.nextInt();
        reverseNumberThroughStack(numberInput);
    }

    public static int reverseNumberThroughStack(int number) {
        String numberString = Integer.toString(number);
        CharacterIterator iterator = new StringCharacterIterator(numberString);
        Deque<Character> digitsStack = new ArrayDeque<>();
        StringBuilder reverseNumberString = new StringBuilder();
        while (iterator.current() != CharacterIterator.DONE) {
            digitsStack.push(iterator.current());
            iterator.next();
        }
        while (!digitsStack.isEmpty()) {
            reverseNumberString.append(digitsStack.pop());
        }
        System.out.println("The number with digits in reverse order: " + reverseNumberString);
        return Integer.parseInt(String.valueOf(reverseNumberString));
    }
}
