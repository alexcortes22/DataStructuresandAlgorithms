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

    /*
        canSum: Given a target sum and an array of numbers, is it possible to add numbers to get sum.
        Complexity:
                    Time: O(m * n);
                    Space: O(m);
    */
    public static boolean canSum(int targetSum, int[] numbers){
        Boolean[] table = new Boolean[targetSum + 1];
        Arrays.fill(table, false);
        table[0] = true; //base case. If its 0, you can add it with numbers.

        for(int i = 0; i < targetSum - 1; i++){
            if(table[i]){
                for(int j = 0; j < numbers.length; j++){
                    table[i + j] = true;
                }
            }
        }

        return table[targetSum];
    }

    /*
        howSum: Given a target sum and an array of numbers, return a combination of numbers that add up
        to target sum
        Complexity:
                    Time: O(m^2 * n);
                    Space: O(m^2);
        //still need to determine correct implementation
    */
    public static ArrayList<Integer> howSum(int targetSum, int[] numbers){
        HashMap<Integer, ArrayList<Integer>> table = new HashMap<Integer,ArrayList<Integer>>(targetSum + 1);
        for(int i = 1; i < table.size(); i++){
            table.put(i, null);
        }
        table.put(0, new ArrayList<Integer>());
        for(int i = 0; i < targetSum; i++){
            if(table.get(i) != null){
                ArrayList<Integer> previous = table.get(i);
                for(int j = 0; j < numbers.length; j++){
                    previous.add(j);
                    table.put(i + j, previous);
                }
            }
        }
        
        return table.get(targetSum);
    }

    public static void main(String[] args){
        System.out.println(fib(6)); //should return 8
        System.out.println(gridTraveler(3,3)); //should return 6
        int[] nums = {5,4,3};
        System.out.println(canSum(7, nums)); // should return true

        //Test for howSum
        
        System.out.println(howSum(7, nums));
    }
}
