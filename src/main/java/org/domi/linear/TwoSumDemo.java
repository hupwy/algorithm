package org.domi.linear;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: <a href="mailto:hupeng@neuedu.com">hupeng</a>
 * @Date: 2022-03-10 12:57
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 解题思路：
 * 1, 两数和为9，那么只要枚举出9减去其中一个数字在数组能就可以。
 * 例如 9 - x = y， 只要枚举x，判断y是否在数据即可
 * 2, 通过HashMap存放查找过得值进行比较，因为时间复杂度为O(1)。
 */
public class TwoSumDemo {


    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash_map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash_map.get(target - nums[i]) != null) {
                return new int[]{hash_map.get(target - nums[i]), i};
            }
            hash_map.put(nums[i], i);
        }
        return nums;
    }

    private static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }
}
