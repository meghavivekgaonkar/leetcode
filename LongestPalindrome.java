import java.util.Scanner;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        String result = "";    
        result = s.length() == 2 && s.charAt(0) != s.charAt(1) ? String.valueOf(s.charAt(0)) : s; 

        char[] input = s.toCharArray();
        int current = 1 , left, right;
                  
        while(current < input.length-1){  
            left = current - 1; 
            right = current + 1;
            while(  left >= 0 && right < input.length && input[left] == input[right]){
                left--; 
                right++;
            }
            left++;
            right--;
            if(result.length() < (right-left+1)){
                result = right == input.length-1 ?  s.substring(left) :  s.substring(left, right+1);
            }
            current++;
           
        }
        current = 0;
        while(current < input.length-1){  // b a a b c
            left = current;
            right = current + 1;
            while(  left >= 0 && right < input.length && input[left] == input[right]){
                left--; 
                right++;
            }
            left++;
            right--;
            if(result.length() < (right-left+1)){
                result = right == input.length-1 ?  s.substring(left) :  s.substring(left, right+1);
            }
            current++;

        }
        return result;
    }

    public static void main(String[] args) {
        // while(true){
        //     try(Scanner sc = new Scanner(System.in)){    
        //        String input = sc.nextLine();
                String input = "babad";
                System.out.println(longestPalindrome(input));
        //     }catch(Exception e){
        //         System.out.println(e.getMessage());
        //     }
        // }
    }

}
