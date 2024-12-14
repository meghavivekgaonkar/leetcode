import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
 * In this case, 6 units of rain water (blue section) are being trapped.
*/
public class TrappingRainWater42 {
    public static int trap(int[] heights) {
        int length = heights.length;               // 6
        if(length <= 2){
            return 0;
        }
        int water = 0;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        leftMax[0] = 0;                           //leftMax  0 4 4 
        rightMax[length-1] = 0;                   //rightMax 0
        int lmax=heights[0];                      // lmax = 4
        for(int i = 1; i < length ; i++){          // i = 2 
            lmax = Math.max(lmax, heights[i-1]);    // 4, 2 => 4
            leftMax[i] = lmax;                       // 
        }
        System.out.println(Arrays.toString(leftMax));
        int rmax=heights[length-1];
        int temp = Math.min(leftMax[length-1], rightMax[length-1]);
        if(temp > heights[length-1]){
            water = water + temp - heights[length-1];
        } 
        //System.out.println(water);
        for(int i = length-2; i >= 0 ; i--){
            rmax = Math.max(rmax, heights[i+1]);
            rightMax[i] =rmax;
            temp = Math.min(leftMax[i], rightMax[i]);
            if(temp > heights[i]){
                water = water + temp - heights[i];
                
            }
        }
        System.out.println(Arrays.toString(rightMax));
        return water;
       
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        int[] height1 = {4,2,0,3,2,5};
        System.out.println(trap(height1));
        
    }
    
}
