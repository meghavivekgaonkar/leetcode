import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for(int num : nums){
            queue.offer(num);
        }
        while( k > 1 ){ 
            queue.poll();
            k--;
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4}, k = 2;
        System.out.println(findKthLargest(nums, k));
    }
    
}
