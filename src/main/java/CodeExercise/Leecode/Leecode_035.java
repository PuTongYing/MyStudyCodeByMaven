package CodeExercise.Leecode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/11 22:24
 * @description: 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 提示:
 *      1 <= nums.length <= 10⁴
 *      -10⁴ <= nums[i] <= 10⁴
 *      nums 为 无重复元素 的 升序 排列数组
 *      -10⁴ <= target <= 10⁴
 */
public class Leecode_035 {
    public int searchInsert(int[] nums, int target) {
//        // 基础版
//        int low = 0;
//        int high = nums.length - 1;
//        while (low <= high){
//            int mid = (low + high) >>> 1;
//            long midVal = nums[mid];
//            if (midVal < target){
//                low = mid + 1;
//            } else if (midVal > target) {
//                high = mid - 1;
//            } else {
//                return mid;
//            }
//        }
//        return low;

        // Leftmost版本
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (target <= nums[m]){
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
