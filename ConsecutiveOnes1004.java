public class ConsecutiveOnes1004 {

    public static int longestOnes(int[] nums, int k) {

        int left = 0 ,  right = 0 , temp = k;
        int maxLen=0; 

        while(right < nums.length){
            if( nums[right] == 0){
                temp--;
            }
            right++;
            if(temp < 0){

                maxLen = Math.max(maxLen, right-left);
                left++;
                temp = k;

            }

        }
        return maxLen;
        
    }


    public static void main(String[] args) {

        // int nums[] = {1, 0 , 0 , 0};
        // int k = 2;
        int nums[] = {1, 1,1,0 , 0 , 0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }    
}
