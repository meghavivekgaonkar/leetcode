public class GreatestCommonString {
    public static String gcdOfStrings(String str1, String str2) {
        if(str1.equals(str2)){
            return str1;
        }
        String result = "",temp;
        int len1 = str1.length();  
        int len2 = str2.length(); 
        if(len1 > len2){
            temp = str1.replace(str2, ""); 
            if(temp.length() > 0){
               result = temp; 
               temp = str2.replace(temp, ""); 
               if(temp.length() >  0) return result = ""; 
            }else{
                result = str2;
            }
        }else{
            temp = str2.replace(str1, "");
            if(temp.length() > 0){
                result = temp; 
                temp = str1.replace(temp, ""); 
                if(temp.length() >  0) return result = ""; 
             }else{
                result = str1;
            }
        } 
       return result; 
    }
    
    public static void main(String[] args) {
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(gcdOfStrings(str1, str2));
    }
    
}
