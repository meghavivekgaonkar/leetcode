/* A peak element is one that is greater than its neighbors.
 Given an array of integers, find any one peak element and return its index.
Input Example:
Array: [1, 2, 3, 1]

Expected Output:
Peak Index: 2
 */
public class PeakElement {
    public static int peak(int[] arr){
        for(int i=1, j=2; j<arr.length; j++){
            if(arr[i-1]<arr[i] && arr[i]>arr[j]){
                return i;
            }else{
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr ={1,3,20,14,11,10,21};
        System.out.println("Peak index: "+peak(arr));
    }
    
}
