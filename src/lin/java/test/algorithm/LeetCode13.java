package lin.java.test.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeetCode13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            int result = new Solution13().romanToInt(s);
            System.out.println(result);
        }
    }
}

class Solution13 {
    public int romanToInt(String s) {
        /**
         *
         基本字符
         I
         V
         X
         L
         C
         D
         M
         相应的阿拉伯数字表示为
         1
         5
         10
         50
         100
         500
         1000

         1、相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
         2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
         3、小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
         4、正常使用时，连写的数字重复不得超过三次。（表盘上的四点钟“IIII”例外）
         5、在一个数的上面画一条横线，表示这个数扩大1000倍。
         */
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int tem = map.get(s.charAt(i));
//            if ((i == s.length() - 1) || ((int) map.get(s.charAt(i + 1)) <= (int) map.get(s.charAt(i)))) {
//                result += map.get(s.charAt(i));
//            } else {
//                result -= map.get(s.charAt(i));
//            }
//        }
        for (int i = 0; i < s.length(); i++){
            int tem = map.get(s.charAt(i));
            if(i == 0 || map.get(s.charAt(i - 1)) >= tem) result += tem;
            else {
                result += tem - 2 * map.get(s.charAt(i - 1));
            }
        }
            return result;
    }
}