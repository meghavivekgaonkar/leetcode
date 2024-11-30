public class SubArray {
        public static  int subarraySum(int[] nums, int k) {
            //if array has just one element and k = nums[0]
            if(nums.length==1 && nums[0]==k){
                return 1;
            }
            int count=0;
            int i=0, j=1;
            while(j < nums.length){
                if(nums[i]==k){
                    count++;
                    i++;
                    j++;
                    continue;
                }
                if(nums[j]==k){
                    count++;
                    i+=2;
                    j+=2;
                    continue;
                }
                if(nums[i]+nums[j]==k){
                            count++;
                            i++;
                            j++;
                            continue;

                }
                if(nums[i]+nums[j] > k){
                    i++;
                    j++;
                    continue;
                }else{
                    while(nums[i]+nums[j] < k && j < nums.length){
                        if(nums[i]+nums[j]==k){
                            count++;
                            continue;
                        }
                        j++;
                    }
                    i++;
                }
            }
            return count;
            
        }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1,-1,1}, 0));
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
        System.out.println(subarraySum(new int[]{3,3,3,3}, 3));
        System.out.println(subarraySum(new int[]{3,3,3,3, 0, 0}, 3));
    }
    
}
