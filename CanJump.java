public class CanJump {

    public static boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        if(nums.length == 1){
            return true;
        }
        int i = nums.length - 2; int dist = 1;
        while( i >= 0){
            if( nums[i] >= dist){
                dist = 1;
            }else{
                dist++;
            }
            i--;
        }
        return dist==1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2};
        System.out.println(canJump(nums));
    }
    
}
