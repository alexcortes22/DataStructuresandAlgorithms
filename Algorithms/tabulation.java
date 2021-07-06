import java.util.*;

public class tabulation {
    /*
        fib: Tabulation implementation of fibonacci. All values are stored in the array. Iteratively
        save the values of fibonacci by adding the previous two values.
        Complexity: 
                    Time: O(n);
                    Space: 0(n);
    */
    public static int fib(int n){
        int[] array = new int[n+1];
        Arrays.fill(array, 0);
        array[1] = 1;
        for(int i = 2; i <= n; i++){
            array[i] = array[i-1] + array[i-2];
        }

        return array[n];
    }

    public static void main(String[] args){
        System.out.println(fib(6)); //should return 8
    }
}
