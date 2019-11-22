package lin.java.test.algorithms.twosum;

public class LeetCode680 {

    class Solution {
        public boolean validPalindrome(String s) {
            if(s == null || s.length() == 0) {
                return false;
            }
            int i = 0;
            int j = s.length() - 1;
            char[] chars = s.toCharArray();
            while(i < j){
                if(chars[i] != chars[j]){
                    return judge(chars,i + 1, j) || judge(chars,i, j - 1);
                }
                i++;
                j--;
            }
            return true;
        }

        public boolean judge(char[] chars, int i, int j){
            if(i > j){
                return false;
            }
            if(chars == null || chars.length == 0){
                return false;
            }
            while(i <= j) {
                if(chars[i] != chars[j]){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
