import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
     public static List<List<Integer>> threeSum(int[] nums) {  
        //3,0,-2,-1,1,2
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> twoSums = new HashSet<>();
        //  0   1  2  3  4  5
        // -2, -1, 0, 1, 2, 3
        int current = 0, left, right;
        while( current < nums.length-2){                    // current = 1 
            right = nums.length-1;                          // right = 5
            left = current+1;                               // left = 3
            int diff = 0 - nums[current];                   // 0 - -1 = 1
            while(left < right){                    
                int twoSum = nums[left] + nums[right];     // 0 + 3 = 3
                if( twoSum == diff){                       // [ -2, -1, 3] [ -2, 0 , 2]
                    if(!twoSums.contains(Arrays.asList(nums[left], nums[right]))){
                        twoSums.add(Arrays.asList(nums[left], nums[right]));
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[current], nums[left], nums[right]));
                        result.add(triplet);              
                    }
                    right--;                               
                    left++;
                    
                }
                if( twoSum > diff){
                    right--;
                }
                if(twoSum < diff){
                    left++;
                }
                
            }
            current++;

        }


        // List<List<Integer>> result = new ArrayList<>(); 
        // Set<List<Integer>> unique = new HashSet<>();
        // int j, diff;
        // for(int i = 0; i < nums.length-1; i++){
        //     j = i+1;
        //     diff = 0 - nums[i];  // -3
        //     //find two sum now
        //     Set<Integer> hashSet = new HashSet<>();
        //     while( j < nums.length){
        //         int temp = diff - nums[j];  //-3 - 1 = -4
        //         if(hashSet.contains(temp)){
        //             // 3, -1 , -2
        //             unique.add(new ArrayList<Integer>(Arrays.asList( nums[i] ,temp, nums[j])));
        //         }
        //         //else{
        //             hashSet.add(nums[j]); //0, -2, 1 
        //        // }
        //         j++;
        //     } 
            
        // }
        // result.addAll(unique);
         return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(nums));
    }
    
}
