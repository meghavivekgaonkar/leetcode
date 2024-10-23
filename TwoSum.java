/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashMap =new HashMap<>();
        int result[] = new int[2];
        for(int i=0; i<nums.length;){
            int diff = target - nums[i];           
            if(hashMap.containsKey(diff)){
                result[0]= hashMap.get(diff);
                result[1]= i;
                return result; 
            }
            else{
                hashMap.put(nums[i],i);
                i++;
            }
            
        }
       
       return result; 
    }
}