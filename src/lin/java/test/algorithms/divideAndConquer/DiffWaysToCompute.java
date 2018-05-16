package lin.java.test.algorithms.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {

    public static void main(String[] args) {
        String input = "2-1-1";
        List<Integer> result = new DiffWaysToCompute().diffWaysToCompute(input);
        result.forEach(o -> {
            System.out.println(o);
        });
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char temI = input.charAt(i);
            if (temI == '+' || temI == '-' || temI == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (input.charAt(i)) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}
