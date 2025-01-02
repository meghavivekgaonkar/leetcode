public class ReverseVowels {
    public static String reverseVowels(String s) {
    /*
        0 1 2 3 4 5 6 7
        I c e C r e A m
        I   e     e A
        A   e     e I
        A c e C r e I m
    */
        if(s.length() < 2){
            return s;
        }
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length-1;
        while(i < j){
            /* check if the character is vowel */
            if(isVowel(arr[i])){
                while(!isVowel(arr[j])){
                    j--;
                }
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
            i++;
        }
        return String.valueOf(arr);

            
    }
    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    
    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }

}
