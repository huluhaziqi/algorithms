package lin.java.test.algorithms.backTracing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LetterCombinations {
    public static void main(String[] args) {

    }

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        Set<String> result = new HashSet<>();
        combination(new StringBuilder(), digits, result);
        return result.stream().collect(Collectors.toList());
    }

    public void combination(StringBuilder prefix, String digits, Set<String> ret) {
        if (prefix.length() == digits.length()) {
            ret.add(prefix.toString());
            return;
        }
        int index = digits.charAt(prefix.length()) - '0';
        for (Character c : KEYS[index].toCharArray()) {
            prefix.append(c);
            combination(prefix, digits, ret);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

}
