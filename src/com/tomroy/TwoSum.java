package com.tomroy;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tom_th_lin on 2015/5/26.
 */
public class TwoSum {
    /**
     * Example:
     * Input: numbers={2, 7, 11, 15}, target=9
     *
     * Output: index1=1, index2=2
     *
     */

    public static int[] twoSum(int[] nums, int target) {

        for(int i = 0;i < nums.length - 1;i++) {
            for(int j = i + 1;j < nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    int[] ans = {++i,++j};
                    return ans;
                }
            }
        }

        return nums;
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        //FAILED......
        //int[] numbers = {0, 4, 3, 0};
        //int target = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++) {
            map.put(nums[i],i);
        }
        for(int i = 0;i < nums.length-1;i++) {
            if(map.containsKey(target - nums[i]) && (target - nums[i]) != nums[i]) {
                int[] ans = {i+1, map.get(target-nums[i]) + 1};
                return ans;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] ans = twoSum(numbers,target);
        int[] ansHashMap = twoSumHashMap(numbers,target);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(ansHashMap));
    }
}
