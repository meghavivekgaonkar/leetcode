/*Given an array of integers, return a new array such that each element at 
index i of the new array is the product of all the numbers in the original array except the one at i.


For example, if our input was [1, 2, 3, 4, 5],
 the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
public class ProductArray {
    public static int[] productArrayWithDivision(int[]arr){
        int product=1;
        int[] result = new int[arr.length];
        int zeroCount=0, index=-1;
        for (int i=0; i< arr.length;i++){
            if(arr[i]!=0){
                product *= arr[i];
            }
            else{  
                index=i;             
                zeroCount++;
            }
        }
        if(zeroCount==0){
            for(int i=0; i<arr.length;i++){
                result[i]=product/arr[i];
            }
        }
        if(zeroCount==1){
            result[index]=product;

        }
        return result;
    }
    public static int[] productArrayWithoutDivision(int[]arr){
        int product=1;
        int[] left = new int[arr.length];
        int[] result = new int[arr.length];
       for(int i=0;i<arr.length;i++){
        left[i] = product;
        product = product * arr[i];
       }
       product = 1;
       for(int i=arr.length-1;i>=0;i--){
        result[i]= product *left[i];
        product = product * arr[i];
       
       }
        return result;
    }
    public static void main(String[] args) {

        int[] arr = { 1,2,3,4,5};
        int[] result = productArrayWithoutDivision(arr); 

        for(int i : result){
            System.out.println(i);
        }  
    }
    
}
