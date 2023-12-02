package puzzle.solutions;

import java.util.Map;

public class Dec_1_P1 {

    Map<Character, Integer> CHAR_TO_DIGIT = Map.of(
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

    public long solve(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }
        return process(input);
    }

    private long process(String input) {
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

    private int findFirstDigit(String line) {
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

    private int findLastDigit(String line) {
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

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

}
