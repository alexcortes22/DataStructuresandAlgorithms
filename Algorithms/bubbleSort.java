public class bubbleSort {
    public static int[] BubbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args){
        int[] nums = {2,8,5,3,9,4,1};
        int[] sorted = BubbleSort(nums);

        for(int i = 0; i < sorted.length; i++){
            System.out.println(sorted[i]);
        }
    }
}
