import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

    public static List<List<String>> groupAnagram(List<String> list){
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0; i < list.size(); i++){
            char[] temp = list.get(i).toCharArray(); //eat
            Arrays.sort(temp); //aet

            if(map.containsKey(String.valueOf(temp))){
                List<String> existing = map.get(String.valueOf(temp));
                existing.add(list.get(i));
                map.put(String.valueOf(temp), existing);

            }else{
                List<String> newList = new ArrayList<>();
                newList.add(list.get(i));
                map.put(String.valueOf(temp), newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;


    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("eat");
        list.add("ate");
        list.add("rat");
        list.add("mat");
        list.add("pot");
        list.add("top");
        list.add("tea");
        List<List<String>> result = groupAnagram(list);
        System.out.println(result.toString());

    }
    
}
