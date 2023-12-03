package puzzle.solutions;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class Dec_1_P2 {

    Map<String, Integer> VALID_DIGITS = Map.ofEntries(
            entry("0", 0),
            entry("1", 1),
            entry("2", 2),
            entry("3", 3),
            entry("4", 4),
            entry("5", 5),
            entry("6", 6),
            entry("7", 7),
            entry("8", 8),
            entry("9", 9),
            entry("one", 1),
            entry("two", 2),
            entry("three", 3),
            entry("four", 4),
            entry("five", 5),
            entry("six", 6),
            entry("seven", 7),
            entry("eight", 8),
            entry("nine", 9)
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
            Set<String> matches = new HashSet<>();
            for (Map.Entry<String, Integer> entry : VALID_DIGITS.entrySet()) {
                String key = entry.getKey();
                boolean hasKey = line.contains(key);
                if (hasKey) {
                    matches.add(key);
                }
            }
            int firstDigit = findFirstDigit(line, matches);
            int lastDigit = findLastDigit(line, matches);
            int number = (firstDigit * 10) + lastDigit;
            sum += number;
        }
        return sum;
    }

    private int findFirstDigit(String line, Set<String> matches) {
        if (isNullOrBlank(line)) {
            return 0;
        }
        int index = line.length();
        int result = 0;
        for (String digit : matches) {
            int currIndex = line.indexOf(digit);
            if (currIndex < index) {
                index = currIndex;
                result = VALID_DIGITS.get(digit);
            }
        }
        return result;
    }

    private int findLastDigit(String line, Set<String> matches) {
        if (isNullOrBlank(line)) {
            return 0;
        }
        int index = -1;
        int result = 0;
        for (String digit : matches) {
            int currIndex = line.lastIndexOf(digit);
            if (currIndex > index) {
                index = currIndex;
                result = VALID_DIGITS.get(digit);
            }
        }
        return result;
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

}
