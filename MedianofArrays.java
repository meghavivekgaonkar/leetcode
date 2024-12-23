public class MedianofArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;
        if(nums1 == null && nums2 == null) return median;
        int totalLen = nums1.length+ nums2.length;
        if (totalLen == 0)  return median;
        int[] merged = new int[totalLen];
        int targetIndex = totalLen/2; 
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length && k <=targetIndex){
            if( nums1[i] <= nums2[j]){
                merged[k] = nums1[i];
                i++;
            }else{
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length && k <=targetIndex) {
            merged[k] = nums1[i];
            i++;
            k++;  
        }
        while (j < nums2.length && k <=targetIndex) {
            merged[k] = nums2[j];
            j++;
            k++;  
        }
        if(1 == totalLen % 2){ 
            median = merged[targetIndex];
        }else{
            median = (merged[targetIndex] + merged[targetIndex -1]) / 2;
        }

        return median;

    }
    public static void main(String[] args) {
        int nums1[] = { 1, 2}; // 1, 2, 3, 
        int nums2[] = {3};     // 4, 5
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    
}
