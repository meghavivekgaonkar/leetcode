import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RoughWork {
    public static void main(String[] args) {
        System.out.println("Rough work");
        PriorityQueue<Map.Entry<Integer,Integer>> pq = 
            // new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
            new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 1);  // O(N)

        map.put(2, map.getOrDefault(2, 0)+1);
        System.out.println(map.get(2));
        pq.addAll(map.entrySet());  // O()
        Map.Entry<Integer,Integer> entry = pq.poll();
        System.out.println( "Key: "+ entry.getKey()+ " Value: "+entry.getValue());

        //  k
    }
}
