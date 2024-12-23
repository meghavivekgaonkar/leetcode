public class MergeStringsAlternatively {
    public static String mergeAlternately(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int totalLen =word1.length() + word2.length();
        char[] result = new char[totalLen];
        int i = 0, j = 0, k=0;
        while(i < arr1.length && j < arr2.length){
            result[k] = arr1[i];
            result[++k]= arr2[j];
            i++;
            j++;
            k++;
        }
        while (i < arr1.length && k < totalLen) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length && k < totalLen) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return String.valueOf(result);
        
    }
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pqr"));
    }
    
}
