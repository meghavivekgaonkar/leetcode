public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if(height.length < 2){ return 0; }
        int result= Integer.MIN_VALUE;
        int i = 0, j = height.length -1;
        while( i < j){
            if(height[i] < height[j]){
                result = Math.max(result, (j - i) * height[i]);
                i++;  
            }else{
                result = Math.max(result, (j - i) * height[j]);
                j--;
            }  
        }
        return result;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    
}
