package lin.java.test.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> result = new ArrayList<>();
        result = Permutation1(str);
    }
    public static ArrayList<String> Permutation1(String str) {
        if(str == null || str.length() == 0){
            return new ArrayList<>();
        }
        char[]  chars  = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> result = new ArrayList<String>();
        backTracing(result,0,chars,new StringBuilder());
        return result;
    }

    public static void backTracing(ArrayList<String> ret, int cur,char[] chars,StringBuilder sb){
        if(cur > chars.length){
            return;
        }
        if(sb.length() == chars.length){
            ret.add(sb.toString());
            return;
        }
        for(int i = cur; i < chars.length; i++){
            if( i != cur && chars[i] == chars[i - 1]){
                continue;
            }
            sb.append(chars[i]);
            backTracing(ret,i + 1,chars,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
