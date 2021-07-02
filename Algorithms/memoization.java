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
    public static void main (String[] args){
        HashMap <Integer, Long> computed = new HashMap<Integer,Long>();
        long result = fib(50, computed);

        System.out.println(result); //should be 12586269025
    }
}
