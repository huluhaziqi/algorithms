package lin.java.test.algorithms.greedy;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "adfsffsdberrewcvvv";
        boolean result = new IsSubsequence().isSubsequence2(s, t);
        System.out.println(result);
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int j = 0;
        int k = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            while (j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            if (j < t.length() && s.charAt(i) == t.charAt(j)) {
                k++;
                j++;
            }
        }
        return k == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index == -1) {
                break;
            }
        }
        return index == -1 ? false : true;
    }
}
