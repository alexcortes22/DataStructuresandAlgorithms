public class MergeSort {
    public static void mergeSort(int[] array){
        int arrayLength = array.length;
        if(arrayLength < 2)
            return;
        int middle = arrayLength/2;
        int left[] = new int[middle];
        int right[] = new int [arrayLength - middle];

        //copy array items into left array
        for(int i = 0; i < middle; i++){
            left[i] = array[i];
        }

        //copy array items into right array
        for(int i = middle; i < arrayLength; i++){
            right[i - middle] = array[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] array){
        int leftLength = left.length;
        int rightLength = right.length;
        //These are pointers that point to the next items in their respective arrays
        int r, l, a;
        r = l = a = 0; 
        //check for the smallest elements in each sub array and push to original array
        while(l < leftLength && r < rightLength){
            if(left[l] <= right[r]){
                array[a] = left[l];
                l++;
            }else{
                array[a] = right[r];
                r++;
            }
            a++;
        }

        //if there are remaining elements in the left array, add it to the original array
        while(l < leftLength){
            array[a] = left[l];
            l++;
            a++;
        }

        //if there are remaining elements in the right array, add it to the original array
        while(r < rightLength){
            array[a] = right[r];
            r++;
            a++;
        }
    }

    public static void main(String[] args){
        int[] nums = {2,8,5,3,9,4,1,7};
        mergeSort(nums);
        for(int num: nums){
            System.out.println(num);
        }
        
    }
}
