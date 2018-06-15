package lin.java.test.algorithms.algorithm.jianzhioffer;

public class ReplaceSpace {
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            if(str == null || str.length() == 0){
                return "";
            }
            int len = str.length();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len ;i++){
                if(str.charAt(i) == ' '){
                    sb.append("%20");
                } else {
                    sb.append(str.append(i));
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {

    }
}