/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a s
*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstring3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.equals("")|| s == null){
            return 0;
        }
        int maxlength=Integer.MIN_VALUE;
        char[] charArray = s.toCharArray();
        Set<Character> hashSet = new HashSet<>();
        int left=0, right=0;
        while( right < charArray.length){
            if(hashSet.contains(charArray[right])){
                hashSet.remove(charArray[left]);
                left++;

            }else{
                hashSet.add(charArray[right]);
                maxlength = Math.max(maxlength, right - left +1);
                right++;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(input));
        
    }


    
}
