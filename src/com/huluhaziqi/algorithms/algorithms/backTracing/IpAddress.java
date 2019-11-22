package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class IpAddress {

    public static void main(String[] args) {
        String s = "0000";
        List<String> ret = new IpAddress().restoreIpAddresses(s);
        for(String st : ret){
            System.out.println(st);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        List<String> ret = new ArrayList<>();
        backtracing(new StringBuilder(),0,s,ret);
        return ret;
    }
    
    public void backtracing(StringBuilder prefix,int level,String s,List<String> ret){
        if(prefix.length() == s.length() + 4 && level == 4){
            ret.add(prefix.substring(1,prefix.length()));
            return;
        }
        if(level >= 4){
            return;
        }
        
        for(int i = 1,index = prefix.length() - level; i <= 3 && index + i <= s.length(); i++){
//            if(i != 1 && s.charAt(index) == '0'){
//                break;
//            }
            String tem = s.substring(index,index + i);
            int next = Integer.parseInt(tem);
//            if(next <= 255){
            if(isValid(tem)){
                prefix.append("." + tem);
                level++;
                // System.out.println(prefix.toString());
                backtracing(prefix,level,s,ret);
                prefix.delete(prefix.length() - tem.length() - 1,prefix.length());
                level--;
            }
        }
    }

    public boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return s.equals("0");
        }
        int value = Integer.parseInt(s);
        if(value <= 255){
            return true;
        }
        else return false;
    }
    // public List<String> restoreIpAddresses(String s) {
    //     List<String> result = new ArrayList<>();
    //     combine(new StringBuilder(), 0, s, result);
    //     return result;
    // }

    // public void combine(StringBuilder prefix, int level, String s, List<String> ret) {
    //     if(prefix.length() == s.length() && level == 4){
    //         ret.add(prefix.substring(1,prefix.length()));
    //         return;
    //     }
    //     if(level == 4){
    //         return;
    //     }
    //     for(int i = 1,index = prefix.length() - level; i <= 3 && index + i <= s.length(); i++){
    //         if(i != 1 && s.charAt(index) == '0'){
    //             break;
    //         }
    //         String tem = s.substring(index,index + i);
    //         int next = Integer.parseInt(tem);
    //         if(next <= 255){
    //             prefix.append("." + tem);
    //             level++;
    //             combine(prefix,level,s,ret);
    //             level--;
    //             prefix.deleteCharAt(prefix.length() - tem.length() - 1);
    //         }
    //     }
    // }
}
