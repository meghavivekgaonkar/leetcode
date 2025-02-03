public class MaxScore {
    public static int maxScore(String s) {
        int maxScore = 0, count=0, len =s.length();
        int[] zero_count = new int[len];
        int[] one_count = new int[len], arr = new int[len];
        for( int i = 0; i < len; i++){
            arr[i] = s.charAt(i) - '0'; 
            if(arr[i] == 0){
                count++;
            }
            zero_count[i] = count;
        }
        count = 0;
        for( int i = len -1 ; i >= 0; i--){
            if(arr[i] == 1){
                count++;
            }
            one_count[i] = count;

        }
        for( int i = 1; i < len-1; i++){
            maxScore = Math.max(maxScore, zero_count[i]+one_count[i]);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        String s = "1111";
        System.out.println(maxScore(s));
    }
    
}
