// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the 
// number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
import java.util.*;

public class LC17 {
    public static void generatecombination(String current, String digits, int index, String[] map,
            List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            generatecombination(current + letters.charAt(i), digits, index + 1, map, result);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;

        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        generatecombination("", digits, 0, map, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.print(letterCombinations("23"));

    }
}
