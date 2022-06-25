import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

//  7. Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}». Проверить правильность расстановки скобок. Использовать стек.
public class CheckParenthesesUsingStack {

    public static void main(String[] args) {
        String inputString = "{()[]([])}";
        checkParenthesesUsingStack(inputString);
    }

    public static boolean checkParenthesesUsingStack(String inputString) {
        CharacterIterator iterator = new StringCharacterIterator(inputString);
        Deque<String> charactersStack = new ArrayDeque<>();
        boolean parenthesesCorrectlyPlaced = true;
        try {
            while (iterator.current() != CharacterIterator.DONE) {
                String currentCharacter = String.valueOf(iterator.current());
                if (currentCharacter.equals(")") || currentCharacter.equals("]") || currentCharacter.equals("}")) {
                    String previousCharacter = charactersStack.pop();
                    if (!((previousCharacter.equals("(") && currentCharacter.equals(")")) || (previousCharacter.equals("[") && currentCharacter.equals("]")) || (previousCharacter.equals("{") && currentCharacter.equals("}")))){
                        parenthesesCorrectlyPlaced = false;
                        break;
                    }
                } else {
                    charactersStack.push(currentCharacter);
                }
                iterator.next();
                }
        } catch (NoSuchElementException exception) {
            parenthesesCorrectlyPlaced = false;
        }
        if (!charactersStack.isEmpty()){
            parenthesesCorrectlyPlaced = false;
        }
        if (parenthesesCorrectlyPlaced) {
            System.out.println("The parentheses in the string:" + inputString + "\n" + "Are placed correctly.");
        } else {
            System.out.println("The parentheses in the string:" + inputString + "\n" + "Are placed incorrectly.");
        }
        return parenthesesCorrectlyPlaced;
    }
}
