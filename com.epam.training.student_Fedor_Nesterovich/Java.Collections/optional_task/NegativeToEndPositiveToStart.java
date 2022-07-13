import java.util.*;

// 5. Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные — в начало списка.
public class NegativeToEndPositiveToStart {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, 7, -11, -5, 10));
        NumbersCompare numbersCompare = new NumbersCompare();
        numbers.sort(numbersCompare);
        System.out.println(numbers);
    }

    static class NumbersCompare implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if ((o1 > 0 && o2 < 0) || (o1 < 0 && o2 > 0) || (o1 != 0 && o2 == 0) || (o1 == 0 && o2 != 0)) {
                return o1.compareTo(o2);
            }
            else return 0;
        }
    }
}
