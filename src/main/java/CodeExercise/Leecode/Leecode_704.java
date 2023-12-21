package CodeExercise.Leecode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/11 22:30
 * @description: 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回-1
 * <p>
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 提示：
 *      你可以假设 nums 中的所有元素是不重复的。
 *      n 将在 [1, 10000]之间。
 *      nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class Leecode_704 {
    public int search(int[] nums, int target) {
        // 二分查找基础版
        int i = 0, j = nums.length - 1;
        while (i <=j){
            int m = (i + j) >>> 1;
            if (target < nums[m]){
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;

//        // 二分查找改动版
//        int i = 0, j = nums.length;     // 改动1
//        while (i < j){                  // 改动2
//            int m = (i + j) >>> 1;
//            if (target < nums[m]){
//                j = m;                  //改动3
//            } else if (nums[m] < target) {
//                i = m + 1;
//            } else {
//                return m;
//            }
//        }
//        return -1;

//        // 二分查找平衡版
//        int i = 0, j = nums.length;
//        while (i + 1 < j){
//            int m = (i + j) >>> 1;
//            if (target < nums[m]){      //向左找
//                j = m;
//            } else {                    // 向右找，或者m
//                i = m;
//            }
//        }
//        return (nums[i] == target) ? i : -1;
    }
}
