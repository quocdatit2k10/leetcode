import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        //int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] intArray = new int[]{ 10,8,5,9,2,3,1,4,6,7 };

        int[] result = twoSum(intArray, target);
        System.out.println(Arrays.toString( result));
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i <= nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;

    }
}
