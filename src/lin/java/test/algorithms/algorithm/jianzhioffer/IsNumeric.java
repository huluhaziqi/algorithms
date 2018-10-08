package lin.java.test.algorithms.algorithm.jianzhioffer;

public class IsNumeric {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isNumeric("3.1415".toCharArray());
        System.out.println(result);
    }

    public static class Solution {
        public boolean isNumeric(char[] str) {
            if (str == null) {
                return false;
            }
            int len = str.length;
            boolean tag = true;
            boolean tag2 = true;
            int indexE = -1;
            int i = 0;
            for (; i < len; i++) {
                if (str[i] == 'e' || str[i] == 'E') {
                    indexE = i;
                    break;
                }
            }
            if (indexE == -1) {
                return judge(str, 0, str.length - 1, 1);
            } else {
                return judge(str, 0, indexE - 1, 1) && judge(str, indexE + 1, str.length - 1, 0);
            }

        }

        public boolean judge(char[] str, int start, int end, int numeric) {
            if (start < 0 || start >= str.length || end < 0 || end >= str.length || end < start) {
                return false;
            }
            int j = start;
            if (str[start] == '-' || str[start] == '+') {

                if (end - start + 1 <= 1 || str[start + 1] == '+' || str[start + 1] == '-') {
                    return false;
                }
                j = ++start;
            }
            int countPoint = 0;
            for (; j <= end; j++) {
                if (numeric == 0 && str[j] == '.') {
                    return false;
                }
                if ((str[j] >= '0' && str[j] <= '9') || str[j] == '.') {
                    if (str[j] == '.') {
                        countPoint++;
                        if (countPoint > 1) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
