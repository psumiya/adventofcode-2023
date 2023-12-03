package puzzle.solutions.day.one;

import java.util.Map;

import static puzzle.solutions.utils.Utils.isNullOrBlank;

public class P1 {

    private static Map<Character, Integer> CHAR_TO_DIGIT = Map.of(
            '0', 0,
            '1', 1,
            '2', 2,
            '3', 3,
            '4', 4,
            '5', 5,
            '6', 6,
            '7', 7,
            '8', 8,
            '9', 9
    );

    public static long solve(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }
        return process(input);
    }

    private static long process(String input) {
        String[] lines = input.split("\n");
        long sum = 0;
        for (String line : lines) {
            int firstDigit = findFirstDigit(line);
            int lastDigit = findLastDigit(line);
            int number = (firstDigit * 10) + lastDigit;
            sum += number;
        }
        return sum;
    }

    private static int findFirstDigit(String line) {
        if (isNullOrBlank(line)) {
            return 0;
        }
        char[] chars = line.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if (CHAR_TO_DIGIT.containsKey(ch)) {
                return CHAR_TO_DIGIT.get(ch);
            }
        }
        return 0;
    }

    private static int findLastDigit(String line) {
        if (isNullOrBlank(line)) {
            return 0;
        }
        char[] chars = line.toCharArray();
        int length = chars.length;
        for (int i = length - 1; i >= 0; i--) {
            char ch = chars[i];
            if (CHAR_TO_DIGIT.containsKey(ch)) {
                return CHAR_TO_DIGIT.get(ch);
            }
        }
        return 0;
    }

}
