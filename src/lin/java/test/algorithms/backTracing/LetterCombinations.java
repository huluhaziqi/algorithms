package lin.java.test.algorithms.backTracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.sun.org.apache.regexp.internal.recompile;

public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        List<String> ret = new LetterCombinations().letterCombinations(digits);
        for(String string : ret){
            System.out.println(string);
        }
    }

    // private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // public List<String> letterCombinations(String digits) {
    //     Set<String> result = new HashSet<>();
    //     combination(new StringBuilder(), digits, result);
    //     return result.stream().collect(Collectors.toList());
    // }

    // public void combination(StringBuilder prefix, String digits, Set<String> ret) {
    //     if (prefix.length() == digits.length()) {
    //         ret.add(prefix.toString());
    //         return;
    //     }
    //     int index = digits.charAt(prefix.length()) - '0';
    //     for (Character c : KEYS[index].toCharArray()) {
    //         prefix.append(c);
    //         combination(prefix, digits, ret);
    //         prefix.deleteCharAt(prefix.length() - 1);
    //     }
    // }
    private static final String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> ret = new ArrayList<>();
        backtracing(new StringBuilder(), 0, digits, ret);
        return ret;
    }

    public void backtracing(StringBuilder prefix,int level,String digits,List<String> ret){
        if(level == digits.length()){
            ret.add(prefix.toString());
            return;
        }
        int index = digits.charAt(level) - '0';
        String curString = keys[index];
        for(char c : curString.toCharArray()){
            prefix.append(c);
            backtracing(prefix, level + 1, digits, ret);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
    
}
