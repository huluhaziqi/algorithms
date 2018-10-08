package lin.java.test.algorithms.algorithm.jianzhioffer;

public class InversePairs {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] array = {6,5,4,9,1};
        int result = solution.InversePairs(array);
        System.out.println(result);

    }

    public static class Solution {
        public int InversePairs(int [] array) {
            if(array == null || array.length <= 1){
                return 0;
            }
            int len = array.length;
            int gap = 1;
            int result = 0;
            while(gap < len){
                for(int i = 0; i < len && i + gap < len ;i = i + 2 * gap ){
                    result += mergeSort(array,i,i + gap - 1,i + gap,i + 2 * gap - 1 >= len ? len - 1 : i + 2 * gap - 1);
                }
                gap *= 2;
            }
            return result;
        }

        public int mergeSort(int[] array,int s1, int e1, int s2,int e2){
            if(s1 > e1 || s2 > e2 ||s2 >= array.length || s1 >= array.length ||e1 >= array.length || e2 >= array.length){
                return 0 ;
            }
            int[] tem = new int[e2 - s1 + 1];
            int i = 0;
            int start1 = s1,start2 = s2,end1 = e1,end2 = e2;
            int result = 0;
            while(start1 <= end1 && start2 <= end2){
                if(array[start1] > array[start2]){
                    tem[i++] = array[start2++];
                    result += end1 - start1 + 1;
                }else{
                    tem[i++] = array[start1++];
                }
            }
            while(start1 <= end1){
                tem[i++] = array[start1++];
            }
            while(start2 <= end2){
                tem[i++] = array[start2++];
            }
            for(int j = s1; j <= e2; j++ ){
                array[j] = tem[j - s1];
            }
            return result;
        }

    }

    public static class Solution2 {
        public static int InversePairs(int[] array) {
            if(array == null || array.length == 0)
                return -1;
            if(array.length == 1)
                return 0;
            int[] copy = new int[array.length];
            for (int i = 0; i < copy.length; i++)
                copy[i] = array[i];
            int count = solve(array, copy, 0, array.length - 1);
            return count % 1000000007;

        }

        public static int solve(int[] array, int[] copy, int start, int end) {
            if (start == end) {
                copy[start] = array[start];
                return 0;
            }
            int mid = (end + start) / 2;
            int left = solve(array, copy, start, mid);
            int right = solve(array, copy, mid + 1, end);
            int i = mid;
            int j = end;
            int count = 0;
            int endCopy = end;
            while (i >= start && j >= mid + 1) {
                if (array[i] > array[j]) {
                    copy[endCopy--] = array[i];
                    count = (count + j - mid) % 1000000007;

                    i--;
                } else {
                    copy[endCopy--] = array[j];
                    j--;
                }
            }
            while (j >= mid + 1) {
                copy[endCopy--] = array[j];
                j--;
            }
            while (i >= start) {
                copy[endCopy--] = array[i];
                i--;
            }
            for(int s=start;s<=end;s++)
            {
                array[s] = copy[s];
            }
            return (left + right + count ) % 1000000007;
        }

    }
    public static class Solution3 {
        public int InversePairs(int [] array) {
            if(array == null || array.length <= 1){
                return 0;
            }
            int len = array.length;
            int[] copy = new int[len];
            for(int i = 0; i < len; i++){
                copy[i] = array[i];
            }
            int result = solve(array,copy,0,len - 1);
            return result;
        }

        public int solve(int[] array, int[] copy,int start ,int end){
            if(start >= end){
                return 0;
            }
            int mid = (start + end ) / 2;
            int left = solve(array,copy,start,mid);
            int right = solve(array,copy,mid + 1,end);
            int i = mid;
            int j = end;
            int count = 0;
            int indexOfCopyEnd = end;
            while(i>=0 && j >= mid + 1){
                if(array[i] > array[j]){
                    count = (count + j - mid) % 1000000007;
                    copy[indexOfCopyEnd--] = array[i--];
                }else{
                    copy[indexOfCopyEnd--] = array[j--];
                }
            }
            while(i >= start){
                copy[indexOfCopyEnd--] = array[i--];
            }
            while(j >= mid + 1){
                copy[indexOfCopyEnd--] = array[j--];
            }
            return (left + right + count ) % 1000000007;
        }


    }
}
