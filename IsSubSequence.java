public class IsSubSequence {
    
    public static boolean isSubsequence(String s, String t) {
        if(s.equals(null)|| s.equals("")){
            return true;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int i = 0, j = 0;
        while( i < sArray.length && j < tArray.length){
            if(sArray[i] == tArray[j]) {
                i++;
                j++;   
            }else{
                j++;
            }
        }
        return i==sArray.length;

    }
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
}
