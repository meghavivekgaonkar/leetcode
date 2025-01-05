public class MaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0; i < k; i++)
            sum += nums[i];
        double res = sum;
        for(int i = k, j=0; i < nums.length; i++){
            sum += nums[i] - nums[j];
            res=Math.max(res,sum);
            j++;
        }
        return res/k;
        
    }
    public static void main(String[] args) {                    
        int nums[] = {1,12,-5,-6,50,3}, k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
