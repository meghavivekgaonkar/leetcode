

public class ReverseWords {

    public static String reverseWords(String s) {
        if(s.length() == 1){ return s; }
        String[] arr =s.trim().split("\\s+");
        if(arr.length == 1){ return arr[0]; }
        int i = 0, j = arr.length-1;
        while( i < j){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp; 
            i++;
            j--;
        }
        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        String s = "t ";
        System.out.println("Reverse: "+reverseWords(s)+".");
    }
    
}
