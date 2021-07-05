import java.util.*;

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

    /*
        CanSum: Write a function canSum(targetSum, numbers) that takes in a targetSum
        and an array of numbers as arguments. The function should return a boolean
        indicating whether or not its possible to generate the target sum using numbers
        from the array. You may use an element of the array as many times as needed.
        You may assume that all input numbers are non-negative.
    */
    public static boolean canSum(int targetSum, int[] numbers, HashMap<Integer, Boolean> canResults){
        //base cases
        if(canResults.containsKey(targetSum)) return canResults.get(targetSum);
        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for(int num: numbers){
            int remainder = targetSum - num;
            if(canSum(remainder, numbers, canResults)){
                canResults.put(targetSum, true);
                return true;
            } 
        }
        canResults.put(targetSum, false);
        return false;
    }

    /*
        howSum: Write a function howSUm(targetSum, numbers) that takes in a targetSum and an array of 
        numbers as arguments. The function should return an array containing any combination of elements
        that add up to exactly the targetSum. If there is no combination that adds up to the target sum,
        then return null. If there are are multiple combinations possible, you may return any single
        one.
    */
    public static ArrayList<Integer> howSum(int targetSum, int[] numbers, ArrayList<Integer> result, 
                                            HashMap<Integer, ArrayList<Integer>>memo){
        //base cases
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0){
            return result;
        }

        if(targetSum < 0) return null;

        for(int num: numbers){
            int remainder = targetSum - num;
            ArrayList<Integer> remainderResult = howSum(remainder, numbers, result, memo);
            if(remainderResult != null){
                //if the array isnt null, add the number that equals to target sum to the array
                remainderResult.add(num);
                //make the result equal to returned array
                result = remainderResult;
                //put it in the memo object
                memo.put(targetSum, result);
                return result;
            }
        }

        memo.put(targetSum, null);
        return null;
<<<<<<< HEAD
    }
    /*
        Test: To show on Repo
    */
=======
    } 

    /*
        bestSum: Write a function that takes in a targetSum and an array of numbers as arguments.
        The function should return an array containing the shortest combination of numbers that
        add up to exactly the targetSum. If there is a tie, you may return any one of the shortest
    */
    public static ArrayList<Integer> bestSum(int targetSum, int[] numbers, ArrayList<Integer> result, 
                                            HashMap<Integer, ArrayList<Integer>>memo){
        //base cases
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0){
            return result;
        }

        if(targetSum < 0) return null;

        ArrayList<Integer> shortestArray = new ArrayList<Integer>();

        for(int num: numbers){
            int remainder = targetSum - num;
            ArrayList<Integer> remainderResult = new ArrayList<Integer>();
            remainderResult = howSum(remainder, numbers, remainderResult, memo);
            if(remainderResult != null){
                //if the array isnt null, add the number that equals to target sum to the array
                remainderResult.add(num);
                //result = remainderResult;
            
                if(shortestArray == null || remainderResult.size() < shortestArray.size()){
                    shortestArray = remainderResult;
                }
                
            }
        }

        memo.put(targetSum, shortestArray);
        return shortestArray;
    } 
>>>>>>> af05b20cb81a7400dbe1eaa606cf288473591058
    public static void main (String[] args){
        //HashMap for Fib memoization
        HashMap <Integer, Long> computed = new HashMap<Integer,Long>();
        long result = fib(50, computed);
        System.out.println(result); //should be 12586269025|

        //HashMap for gridTraveler Memoization
        HashMap<String,Long> computedPaths = new HashMap<String,Long>();
        long paths = gridTraveler(18, 18, computedPaths);
        System.out.println(paths); // should be 2333606220
 
        //HashMap for CanSum memoization
        HashMap<Integer, Boolean> canResults = new HashMap<Integer, Boolean>();
        int[] nums = {7,14};
        boolean sumResult = canSum(300, nums, canResults);
        System.out.println(sumResult); //should print false

        //We have to use a dynamic array and pass it to howSum
        ArrayList<Integer> answer = new ArrayList<Integer>();
        //HashMap for howSum memoization
        HashMap<Integer, ArrayList<Integer>> memo = new HashMap<Integer, ArrayList<Integer>>();
        int[] nums1 = {7, 14};
        answer = howSum(300, nums1, answer, memo);
        System.out.println(answer);

        //We have to use a dynamic array and pass it to howSum
        ArrayList<Integer> bestMemo = new ArrayList<Integer>();
        //HashMap for howSum memoization
        HashMap<Integer, ArrayList<Integer>> memo1 = new HashMap<Integer, ArrayList<Integer>>();
        int[] nums2 = {1,4,5};
        bestMemo = howSum(8, nums2, bestMemo, memo1);
        System.out.println(bestMemo);

       

    }
}
