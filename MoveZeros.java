import java.util.Arrays;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int i = 0, j = 0;

        while(i < nums.length){
           while( nums[i] == 0){
                i++;    
           }
           swap(nums, i, j);
           i++;
           j++;
        }
        
    }
    public static void swap (int nums[],int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
       
    }
    public static void main(String[] args) {
        int[] nums = { 0, 1, 3, 0, 4, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
}
