package lin.java.test.algorithms.algorithm.jianzhioffer;

public class MoreThanHalf {
    public static void main(String[] args) {
        int[] array = {2,3,2,2,4};
        Solution solution = new Solution();
        int result = solution.MoreThanHalfNum_Solution(array);
        System.out.println(result);

    }

    public static class Solution {
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array == null || array.length == 0){
                return 0;
            }
            int length = array.length;
            int l = 0; int h = array.length - 1;
            int mid = length / 2;
            int index = partion(array,0,length - 1);
            while(mid != index){
                if(mid > index){
                    index = partion(array,index + 1,length - 1);
                }else{
                    index = partion(array,0,index - 1);
                }
            }
            return check(array,array[mid]) ? array[mid] : 0;
        }

        public int partion(int[] array,int start, int end){
            if(start >= end){
                return start;
            }
            int l = start + 1;
            int r = end;
            while(l < r){
                while(l<=r && l < array[start]){
                    l++;
                }
                while(l <= r&& r >= array[start]){
                    r--;
                }
                if(l <= r){
                    swap(array,l,r);
                    l++;
                    r--;
                }
            }
            swap(array,r,start);
            return r;
        }
        public void swap(int[] array,int i,int j){
            int tem = array[i];
            array[i] = array[j];
            array[j] = tem;
        }
        public boolean check(int[] array, int target){
            int result = 0;
            for(int i = 0; i < array.length; i++){
                if(array[i] == target){
                    result++;
                    if(result > array.length / 2){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public class Solution2 {
        public int MoreThanHalfNum_Solution(int [] array) {
            if(array == null || array.length ==0){
                return 0;
            }
            int result = array[0];
            int times = 1;
            for(int i = 0; i < array.length; i++){
                if(times == 0){
                    times++;
                    result = array[i];
                }else if(array[i] == result){
                    times++;
                }else{
                    times--;
                }
            }
            return  check(array,result) ? result: 0;

        }

        public boolean check(int[] array,int target){
            int result = 0;
            for(int i = 0; i < array.length;i++){
                if(target == array[i]){
                    result++;
                    if(result > array.length / 2){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
