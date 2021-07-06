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

    /*
        gridTraveler: A function that determines the number of ways to get from the upper left corner
        to the lower right corner.
        Complexity: 
                    Time: O(m * n);
                    Space: O(m * n);
    */
    public static int gridTraveler(int m, int n){
        int[][] table = new int[m + 1][n + 1];
        table[1][1] = 1;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                int current = table[i][j];
                if(j + 1 <= n) table [i][j + 1] += current; //add current to the right
                if(i + 1 <= m) table [i + 1][j] += current; //add current to the left
            }
        }
        return table[m][n];
    }

    public static void main(String[] args){
        System.out.println(fib(6)); //should return 8
        System.out.println(gridTraveler(3,3)); //should return 6
    }
}
