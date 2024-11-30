public class ConsecutiveSum829 {
    public static int consecutiveNumbersSum(int n) {
        int i=0, j=1;
        int count=0;
        while(j<n && i!=j){
            if(i+j==n){
                count+=2;
                i++;
                j++;
            }
            i++;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(9));
        }
        
            
    
}
