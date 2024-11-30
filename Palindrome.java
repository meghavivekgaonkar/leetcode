import java.util.Scanner;

public class Palindrome {

    public static boolean checkPalindrome(String s){
        char[] array = s.toCharArray();
        int left = 0, right = array.length-1;
        while(left < right){
            if(array[left]==array[right]){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        while(true){
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            System.out.println(checkPalindrome(input));
        }
        
    }
    
}
