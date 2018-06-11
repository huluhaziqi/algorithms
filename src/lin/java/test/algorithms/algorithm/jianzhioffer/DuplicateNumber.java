package lin.java.test.algorithms.algorithm.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNumber {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    public static void main(String[] args) {
        int[] m = {2,1,3,4,1};
        int length = 0;
        int[] du = null;
        boolean result = new DuplicateNumber().duplicate(m,length,du);
    }
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 1) {
            return false;
        }

        int max = 0;
        for (int n : numbers) {
            if (n > max) {
                max = n;
            }
        }
        duplication = new int[max + 1];
        int[] map = new int[max + 1];
        for (int num : numbers) {
            map[num]++;
        }
        boolean result = false;
        for (int i = 0; i <= max; i++) {
            if (map[i] >= 2) {
                result = true;
                duplication[length++] = i;
            }
        }

        return result;
    }

    public class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int numbers[],int length,int [] duplication) {
            if(numbers == null || numbers.length <= 1){
                return false;
            }
            Map<Integer,Integer> map = new HashMap<>();
            length = 0;
            for(int n : numbers){
                if(map.containsKey(n)){
                    map.put(n,map.get(n) + 1);
                }else{
                    map.put(n,1);
                }
            }
            boolean result = false;
            for(Map.Entry entry : map.entrySet()){
                if((int)entry.getValue() >= 2){
                    if(length == 0){
                        duplication[0] = (int)entry.getKey();
                        result = true;
                    }
                    length++;
                }
            }
            return result;
        }
    }
}
