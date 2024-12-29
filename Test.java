import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String s = "Avinash";
        Map<String,List<String>> wlRules= new HashMap<>();
        wlRules.put(s, Arrays.asList(s, "Megha"));

        System.out.println(wlRules.get(s));
        System.out.println("substring: "+s.substring(0,0));
        
    }
    
}
