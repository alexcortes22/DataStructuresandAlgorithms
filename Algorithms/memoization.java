import java.util.HashMap;

public class memoization {

    public static long fib(int n, HashMap<Integer, Long> computed){
        if(computed.containsKey(n)){
            return computed.get(n);
        }
    
        if(n <= 2){
            return 1;
        }else{
            computed.put(n, (fib(n - 1, computed) + fib(n - 2, computed)));
            return computed.get(n);
        }
    }

    /*
        GridTraveler: Say that you're a traveler on a 2D grid. You begin in the 
        top left corner and your goal is to travel to the bottom right corner. 
        You may only move down or right. In how many ways can you travel to the 
        goal on a grid with dimensions m*n?

    */
    public static long gridTraveler(int n, int m, HashMap<String, Long> paths){
        String key = n + ", " + m;
        //if the tuple exists in the HashMap, return it
        if(paths.containsKey(key)){
            return paths.get(key);
        }
        //base cases
        if(m == 1 && n == 1) return 1;
        if(m == 0 || n == 0) return 0;

        paths.put(key, (gridTraveler(m - 1, n, paths) + gridTraveler(m, n - 1, paths)));
        return paths.get(key);
    }

    public static boolean canSum(int targetSum, int[] numbers){
        //base cases
        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for(int num: numbers){
            int remainder = targetSum - num;
            if(canSum(remainder, numbers)) return true;
        }

        return false;
    }
    public static void main (String[] args){
        //HashMap for Fib memoization
        HashMap <Integer, Long> computed = new HashMap<Integer,Long>();
        long result = fib(50, computed);
        System.out.println(result); //should be 12586269025|

        //HashMap for gridTraveler Memoization
        HashMap<String,Long> computedPaths = new HashMap<String,Long>();
        long paths = gridTraveler(18, 18, computedPaths);
        System.out.println(paths); // should be 2333606220

        int[] nums = {2,3};
        boolean sumResult = canSum(7, nums);

        System.out.println(sumResult); //should print true

    }
}
