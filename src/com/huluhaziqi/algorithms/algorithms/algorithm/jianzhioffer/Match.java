package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class Match {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.match("".toCharArray(),".*".toCharArray());
        System.out.println(result);
    }

    public static class Solution {
        public boolean match(char[] str, char[] pattern)
        {
            if(str == null || pattern == null){
                return false;
            }
            return  matchJudge(str,pattern,0,0);
        }

        public boolean matchJudge(char[] str, char[] pattern, int start1, int start2 ){
            if(start1 == str.length && start2 == pattern.length){
                return true;
            }
            if(start1 != str.length && start2 == pattern.length){
                return false;
            }
            if(start2 + 1 < pattern.length && pattern[start2 + 1] == '*'){
                if((start1 < str.length && pattern[start2] == str[start1]) || pattern[start2] == '.'){
                    return matchJudge(str,pattern,start1 + 1,start2 + 2) ||
                            matchJudge(str,pattern,start1 + 1,start2) ||
                            matchJudge(str,pattern,start1,start2 + 2);
                }else {
                    return matchJudge(str,pattern,start1,start2 + 2);
                }
            }

            if(start1 < str.length && (str[start1] == pattern[start2] || pattern[start2] == '.')){
                return matchJudge(str,pattern,start1 + 1,start2 + 1);
            }
            return false;
        }
    }
}
