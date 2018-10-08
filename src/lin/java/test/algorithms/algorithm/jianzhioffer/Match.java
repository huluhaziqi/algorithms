package lin.java.test.algorithms.algorithm.jianzhioffer;

public class Match {
    public static void main(String[] args) {

    }

    public class Solution {
        public boolean match(char[] str, char[] pattern) {
            return judge(str, pattern);
        }

        public boolean judge(char[] str, char[] pattern) {
            if (str == null && pattern == null) {
                return true;
            }
            if (str == null || pattern == null) {
                return false;
            }
            int lenP = pattern.length;
            int i = 0;
            int j = 0;
            while (i < str.length && j < pattern.length) {
                if (str[i] == pattern[j]) {
                    i++;
                    j++;
                } else if (str[i] != pattern[j]) {
                    if (pattern[j] == '.') {
                        i++;
                        j++;
                    } else if (pattern[j] == '*') {
                        if (j > 0 && (pattern[j - 1] == str[i] || pattern[j - 1] == '.')) {
                            i++;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            if (i == str.length && j == pattern.length) {
                return true;
            }
            if (i == str.length && j == pattern.length - 1) {
                if ((str[i - 1] == pattern[j - 1] || pattern[i - 1] == '.') && pattern[j] == '*') {
                    return true;
                }
            }

            return false;
        }
    }
}
