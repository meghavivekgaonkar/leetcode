import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxOperations {
    public static int maxOperations(int[] nums, int k) {
        int result = 0;
        // Map<Integer,Integer> hashMap = new HashMap<>();
        // for(int i = 0; i < nums.length; i++){
        //     int temp = k - nums[i];
        //     if(hashMap.containsKey(temp)){
        //         if(hashMap.get(temp)== 1) { hashMap.remove(temp);}
        //         else{ hashMap.put(temp, hashMap.get(temp)-1);}
        //         result++;
        //     }else{
        //         hashMap.put(nums[i],hashMap.getOrDefault(nums[i], 0)+1);
        //     }

        // }
        Arrays.sort(nums);//  1 1 1 1 2 2 2 2 2 2 3 3 4 4 4 4 4 4 4 5
        int i = 0, j = nums.length -1;
        while(i < j){
            int temp = nums[i] + nums[j];
            if(temp == k){
                result++;
                i++;
                j--;
            }else if( temp > k){
                j--;
            }else if( temp < k){
                i++;
            }
        }
        return result; 
    }

    public static void main(String[] args) {
        int[] nums = { 2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        System.out.println(maxOperations(nums, 3));
    }
    
}
