package lin.java.test.algorithms.algorithm;

public class LeetCode605 {

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println(new LeetCode605().canPlaceFlowers(flowerbed,n));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0 || n > flowerbed.length || n < 0){
            return false;
        }
        if (n == 0){
            return true;
        }
        if(n == 1){
            return flowerbed[0] == 1 ? false : true;
        }
        int len = flowerbed.length;
        int origin = 0;
        for(int i = 0 ; i < len; i++){
            if(flowerbed[i] == 1){
                origin++;
            }
            if(i > 0 && i < len - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                flowerbed[i] = 1;
            } else if( i == 0 && i + 1 < len && flowerbed[i + 1] == 0){
                flowerbed[i] = 1;
            } else if( i == len - 1 && i - 1 >= 0 && flowerbed[i - 1] == 0){
                flowerbed[i] = 1;
            }
        }
        int count = 0;
        for(int i = 0 ; i < len; i++){
            if(flowerbed[i] == 1){
                count++;
            }
        }
        System.out.println(count);
        return n <= count - origin ? true : false;
    }
}
