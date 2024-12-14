import java.util.ArrayList;
import java.util.List;

public class Subset78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        createSubset(nums, 0, result, subset);
        return result;        
        
    }
    private static void createSubset(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            System.out.println(result);
            return;
        }

        subset.add(nums[index]);
        System.out.println(subset);
        createSubset(nums, index + 1, result, subset);

        subset.remove(subset.size() - 1);
        System.out.println(subset);
        createSubset(nums, index + 1, result, subset);
    }    


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
    
}
