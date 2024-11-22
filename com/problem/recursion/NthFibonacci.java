import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

    public static int getNthFibonacciR(int n, Map<Integer,Integer> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if (n <= 2) { 
            memo.put(n, 1);
            return 1;
        } 
        memo.put(n, getNthFibonacciR(n-1, memo)+ getNthFibonacciR(n-2, memo));
        return memo.get(n);
        
    }


    public static void main(String[] args) {
        Map<Integer,Integer> memo = new HashMap<>(); //Memoization : Dynamic Problem
        System.out.println(getNthFibonacciR(5,memo));
        System.out.println(getNthFibonacciR(6,memo));
        System.out.println(getNthFibonacciR(7,memo));
        System.out.println(getNthFibonacciR(8,memo));
        
    }
    
}
