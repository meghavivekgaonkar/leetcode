import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KNearestPoints {

    public static double calculateDistance(int x, int y){
        double result  = Math.sqrt((x * x) + (y * y));
        return result;
   }
   
   public static int[][] kClosest(int[][] points, int k) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < points.length;i++ ){
            int x = points[i][0];
            int y = points[i][1];
            List<Integer> array = new ArrayList<>();
            array.add(x);
            array.add(y);
            map.put((x*x)+(y*y), array);
        }
        List<Integer> list2 = new ArrayList<>(map.keySet());
        Collections.sort(list2);

        for(int i=0; i < k; i++){
            map.get(list2.get(i));
        }
       
   }
    
    public static void main(String[] args) {
        int[][] points = { {1,3} , { -2, 2 }};
        int k =1;
       // int[][] result = kClosest(points, k);
       List<Double> dist = new ArrayList<>();
       for(int i = 0; i < points.length; i++){   
            dist.add(calculateDistance(points[i][0], points[i][1]));               
       }
       System.out.println(Arrays.toString(dist.toArray()));
        
    }
}
