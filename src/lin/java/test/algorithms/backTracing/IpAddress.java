package lin.java.test.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class IpAddress {

    public static void main(String[] args) {

    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        combine(new StringBuilder(), 0, s, result);
        return result;
    }

    public void combine(StringBuilder prefix, int level, String s, List<String> ret) {
        if(prefix.length() == s.length() && level == 4){
            ret.add(prefix.substring(1,prefix.length()));
            return;
        }
        if(level == 4){
            return;
        }
        for(int i = 1,index = prefix.length() - level; i < 3 && index + i <= s.length(); i++){
            if(i != 1 && s.charAt(index) == '0'){
                break;
            }
            String tem = s.substring(index,index + i);
            int next = Integer.parseInt(tem);
            if(next <= 255){
                prefix.append("." + tem);
                combine(prefix,++level,s,ret);
                prefix.deleteCharAt(prefix.length() - tem.length() - 1);
            }
        }
    }
}
