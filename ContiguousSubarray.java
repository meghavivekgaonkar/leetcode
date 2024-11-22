/* Given an array of integers nums and an integer k, find the number of continuous subarrays whose sum equals k.

Input Example:
Array: [1, 1, 1]
k: 2

Expected Output:
Result: 2
 */



public class ContiguousSubarray {

    public static int subarray(int[] arr,int k){
        int temp=0;
        int count=0;
        int i=0,j=0;
        while(temp!=k){
            count+=1;
            temp +=arr[j];
            if(temp == k ){
                return count;
            }
            j++;
            if(temp > k){
                temp=0;
                count=0;
                i++;
                j=i;
            }
               
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr ={ 3,2,-3,1,4,2,-3};
        int k =7;
        int result = subarray(arr,k);
        System.out.println(result);
        
    }
    
}
