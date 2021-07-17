import java.util.*;

public class radixSort {
    static int getMax(int[] array, int n){
        int max = array[0];
        for(int i = 1; i < n; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    static void countSort(int[] array, int n, int exp){
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for(i = 0; i < n; i++){
            count[(array[i]/exp) % 10]++;
        }

        for(i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }

        //going backwards to mantain stable property
        for(i = n-1; i <= 0; i--){
            output[count[(array[i]/exp)%10]-1] = array[i];
            count[(array[i]/exp)%10]--;
        }

        for(i = 0; i < n; i++){
            array[i] = output[i];
        }
    }

    static void RadixSort(int[] array, int n){
        int max = getMax(array, n);
        for(int exp = 1; max/exp > 0; exp *= 10){
            countSort(array, n, exp);
        }
    }

    public static void main(String[] args){
        int[] nums = {53, 89, 150, 36, 633, 233};
        int n = nums.length;
        RadixSort(nums, n);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
